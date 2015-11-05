/**
 * 
 */
package com.matthewroyal.marklogic.RDBSchemaModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.matthewroyal.marklogic.CreateTableParser.CreateTableLexer;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableListener;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.EvaluateContext;

/**
 * This package represents a model of a Relational Database. 
 * It parses SQL schema information to populate the model.
 * It outputs the model as different things, like a pretty text table or MarkLogic sem:triples.
 *  
 * @author Matthew Royal
 * @see Golden Gate Bridge, at least once.
 */
public class RDBSchemaModel {
	
	// Class error/debug logger
	private static Logger logger = LogManager.getLogger( RDBSchemaModel.class.getClass() );

	// Useful data structures
	public static enum OUTPUT_TYPES {PLAINTEXT, SEMTRIPLES, SQLINSERT};
	public List<RDBTable> tables = new ArrayList<RDBTable>();
	private Integer columnCounter = 0;
	private CreateTableListener listener;	

	// Map the table and column name to its unique URI
	// "tablename/columname" --> "http://matthewroyal.com/ConvertRDB/dbname/tablename#columnumber"
	private HashMap<String, String> columnUriMap = new HashMap<String, String>();
	

	// RDB namespaces
	public static String SEM = "sem";
	public static String SEM_TRIPLE_NAMESPACE = "http://marklogic.com/semantics";
	public static String NAMESPACE_ROOT = "http://matthewroyal.com/ConvertRDB/";
	public static String RDB = NAMESPACE_ROOT + "rdb#";
	public static String DB = NAMESPACE_ROOT + "db#";
	public static String FK = NAMESPACE_ROOT + "foreignKey#";
	private String TABLE;
	private String COLUMN;
	

	// I/O options
	private String sqlFilename;
	private String schemaOutputFilename = "myfile.txt"; // Default filename
	private String dbName;
	
	
	public RDBSchemaModel() {}

	public RDBSchemaModel(String sqlFilename, String schemaOutputFilename, String dbName) {
		this.sqlFilename = sqlFilename;
		this.schemaOutputFilename = schemaOutputFilename;
		this.dbName = dbName;
	}

	
	/**
	 * Create MarkLogic-style sem:IRI
	 * @param URI
	 * @return
	 */
	private String makeIRI(String newURI) {
		StringBuilder sb = new StringBuilder();
	    URI uri;
		try {
			// Encode the URI into a valid sem:iri
			uri = new URI(newURI.replaceAll(" ", ""));
		    sb.append(uri.toURL());
			
		} catch (URISyntaxException e) {
			logger.error(String.format(
				"FAILED parsing URI [%s] as a URI reference. Try making it more URL-ish.", newURI), 
				e);
		} catch (MalformedURLException me) {
			logger.error(String.format(
				"Malformed URI [%s] has occurred. Either no legal protocol could be found "
				+ "or the string could not be parsed.", newURI), 
				me);
		}

		return sb.toString();
	}

	/**
	 * Given a column key of the format "tablename/columnname", generate or retrieve a unique
	 * URI for the column.
	 * 
	 * @param key
	 * @param columnNamespace
	 * @return
	 */
	private String getUniqueColumnURI(String key, String columnNamespace) {
		
		String uniqueURI;
		
		// Generate unique URI
		if (null == columnUriMap.get(key)) {
			uniqueURI = columnNamespace + ++columnCounter;
			columnUriMap.put(key, uniqueURI);
		} else { uniqueURI = columnUriMap.get(key); }

		return uniqueURI;
	}

	/**
	 * Write a triple to the incoming XMLStreamWriter
	 * 
	 * @param xMLStreamWriter
	 * @param subject
	 * @param predicate
	 * @param object
	 * @throws XMLStreamException
	 */
	private void writeTriple(
			XMLStreamWriter xMLStreamWriter, 
			String subject, String predicate, String object
	) throws XMLStreamException {

		// Opening sem:triple element
		xMLStreamWriter.writeCharacters("\n    ");
        xMLStreamWriter.writeStartElement(SEM, "triple", SEM_TRIPLE_NAMESPACE);
        
        // Body of subject, predicate, and object
        xMLStreamWriter.writeCharacters("\n      ");
        xMLStreamWriter.writeStartElement(SEM, "subject", SEM_TRIPLE_NAMESPACE);
        xMLStreamWriter.writeCharacters( subject );
        xMLStreamWriter.writeEndElement();
        xMLStreamWriter.writeCharacters("\n      ");
        xMLStreamWriter.writeStartElement(SEM, "predicate", SEM_TRIPLE_NAMESPACE);
        xMLStreamWriter.writeCharacters( predicate );
        xMLStreamWriter.writeEndElement();
        xMLStreamWriter.writeCharacters("\n      ");
        xMLStreamWriter.writeStartElement(SEM, "object", SEM_TRIPLE_NAMESPACE);
        xMLStreamWriter.writeCharacters( object );
        xMLStreamWriter.writeEndElement();

        // Closing sem:triple element
        xMLStreamWriter.writeCharacters("\n    ");
        xMLStreamWriter.writeEndElement();
	}

	/**
	 * <p>Print the schema out.</p> 
	 * <p>The model should already be built; otherwise this will output nothing.</p>
	 * @param format The format you want the schema output as. (Required)
	 * @param schemaOutputFilename Filename for the output schema file. (Optional)
	 * @return
	 */
	public String printSchema(OUTPUT_TYPES format, String schemaOutputFilename, String dbName
	) throws IllegalArgumentException {

		// Use the specified output filename, otherwise use the default
		if (null != schemaOutputFilename) this.schemaOutputFilename = schemaOutputFilename;
		if (null != dbName) this.dbName = dbName;
		if (null == format) {
			throw new IllegalArgumentException(
				String.format("--schema-output-type must specify a valid OUTPUT_TYPE! [%s]", StringUtils.join(OUTPUT_TYPES.values(), ", ")) 
			);
		}

		
		// Print the schema
		logger.debug("Printing schema as " + format.toString());
		

		// If it's not specified, assume that the database name should be the sqlfile minus extension 
		if (null == this.dbName) {
			StringBuilder dbNameBuilder = new StringBuilder();
			String[] dbFilenamePieces = this.sqlFilename.split("/");
			dbFilenamePieces = dbFilenamePieces[dbFilenamePieces.length - 1].split("\\.");
			for (int ii = 0; ii < dbFilenamePieces.length - 1; ++ii)
				dbNameBuilder.append(dbFilenamePieces[ii]);
			this.dbName = dbNameBuilder.toString();
		}

		// Build the TABLE and COLUMN namespaces, which depend on the database name to keep namespaces clean
		TABLE = String.format("%s%s/table#", NAMESPACE_ROOT, this.dbName);
		COLUMN = String.format("%s%s/column#", NAMESPACE_ROOT, this.dbName);

		
	    // Get the tables from the parse tree listener
	    Collection<RDBTable> tables = ((MySQLListener)listener).tableMap.values();
		
		// Listify that collection
		ArrayList<RDBTable> tableList = new ArrayList<RDBTable>(tables);
		
		// Output a pretty table
		if (format == OUTPUT_TYPES.PLAINTEXT) {
			for (RDBTable table : tableList) {
				System.out.println("\nTable: " + table.tableName);
				
				// Print primary keys
				for (RDBColumn pk : table.primary_keys) {
					System.out.printf("  PK%s : %s (%s)%s %s\n", 
						(table.foreign_keys.containsKey(pk)) ? ", FK" : "    ", 
						pk.name, pk.type.name(),
						(table.foreign_keys.containsKey(pk)) ? " --> " + table.foreign_keys.get(pk).table.tableName + "." + table.foreign_keys.get(pk).name: "",
						(table.indexed_columns.contains(pk) ? "*" : "") );
				}
				
				// Print foreign keys (which aren't primary keys)
				for (RDBColumn fk : table.foreign_keys.keySet()) {
					if (!table.primary_keys.contains(fk))
						System.out.printf("      FK : %s (%s)%s %s\n", 
						fk.name, fk.type.name(),
						(table.foreign_keys.containsKey(fk)) ? " --> " + table.foreign_keys.get(fk).table.tableName + "." + table.foreign_keys.get(fk).name: "",
						(table.indexed_columns.contains(fk) ? "*" : "") );
				}
				
				// Print the rest of the columns that aren't something special
				for (RDBColumn column : table.getColumns() ) {
					if (!table.primary_keys.contains(column) && !table.foreign_keys.containsKey(column))
						System.out.printf("         : %s (%s) %s\n", column.name, (null != column.type) ? column.type.name() : "null", (table.indexed_columns.contains(column) ? "*" : "")  );
				}
			}
		}
		
		
		// Output triples in MarkLogic's native sem:triple format
		else if (format == OUTPUT_TYPES.SEMTRIPLES) {
		
			// Reset absolute column counter
			columnCounter = 0;
			
			// Setup the new output file
			XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();	
			XMLStreamWriter xMLStreamWriter = null;    	
			File outputFile = null;
			FileWriter fw = null;
			BufferedWriter bw = null;


			// Create the output file, if it doesn't exist
			try {
				// Try creating the output file
				outputFile = new File(this.schemaOutputFilename);
				if (!outputFile.exists()) { 
					outputFile.createNewFile();
				}

				// Fancy file-writing classes
				fw = new FileWriter(outputFile.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(bw);
		        
				// Start a shiny new XML file!
				xMLStreamWriter.writeStartDocument();
	        	xMLStreamWriter.setPrefix(SEM, SEM_TRIPLE_NAMESPACE);
	        	xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeStartElement(SEM, "triples", SEM_TRIPLE_NAMESPACE);
				
		        
		        // Print tables
				for (RDBTable table : tables) {
					logger.debug("\nTable: " + table.tableName);

					// Relate database to table
			        writeTriple(xMLStreamWriter, 
		        		makeIRI(DB + this.dbName), 
		        		makeIRI(RDB + "hasTable"), 
		        		makeIRI(TABLE + table.tableName));
				
					// Print primary keys
					for (RDBColumn pk : table.primary_keys) {
						logger.debug(String.format("  PK%s : %s (%s)%s", "    ", pk.name, pk.type.name(), ""));

						// Generate unique URI
						String key = table.tableName + "/" + pk.name;
						String uniqueURI = getUniqueColumnURI(key, COLUMN);
						
						// Relate table to PK column
						writeTriple(xMLStreamWriter, 
							makeIRI(TABLE + table.tableName), 
							makeIRI(RDB + "hasPrimaryKey"), 
							makeIRI(uniqueURI));
					}


					// Print foreign keys
					logger.debug(String.format("Table [%s] contains [%d] foreign keys", table.tableName, table.foreign_keys.keySet().size()));
					for (RDBColumn fk : table.foreign_keys.keySet()) {
						logger.debug(String.format("      FK : %s (%s)%s", 
							fk.name, fk.type.name(),
							(table.foreign_keys.containsKey(fk)) 
								? " --> " + table.foreign_keys.get(fk).table.tableName + "." + table.foreign_keys.get(fk).name
								: ""
						));
				        
						// Generate unique local URI
						String localKey = table.tableName + "/" + fk.name;
						String uniqueLocalURI = getUniqueColumnURI(localKey, COLUMN);

						// Generate unique remote URI
						String remoteKey = table.foreign_keys.get(fk).table.tableName + "/" + table.foreign_keys.get(fk).name;
						String uniqueRemoteURI = getUniqueColumnURI(remoteKey, COLUMN);
						
						// Relate table to FK 
						writeTriple(xMLStreamWriter, 
							makeIRI(TABLE + table.tableName), 
							makeIRI(RDB + "hasForeignKey"), 
							makeIRI(uniqueLocalURI));
						
						// Relate local key to remote key
						writeTriple(xMLStreamWriter, 
							makeIRI(uniqueLocalURI), 
							makeIRI(RDB + "hasForeignKey"), 
							makeIRI(uniqueRemoteURI));
					}
					
					// Print the rest of the columns that aren't something special
					for (RDBColumn column : table.getColumns() ) {
						// TODO: Maybe Refactor these three chunks into one big loop instead
						logger.debug(String.format("         : %s (%s)", column.name, column.type.name() ));

						// Generate unique URI
						String key = table.tableName + "/" + column.name;
						String uniqueURI = getUniqueColumnURI(key, COLUMN);
						
						// Relate table to column
						writeTriple(xMLStreamWriter, 
							makeIRI(TABLE + table.tableName), 
							makeIRI(RDB + "hasColumn"), 
							makeIRI(uniqueURI));
						
						// Store name of column
						writeTriple(xMLStreamWriter, 
							makeIRI(uniqueURI), 
							makeIRI(RDB + "hasLabel"), 
							column.name);
					}
				}
			        
				
				// Finish off any remnant of the previous xml stream writer
		        xMLStreamWriter.writeCharacters("\n");
		        xMLStreamWriter.writeEndDocument();
		        xMLStreamWriter.flush();
		        xMLStreamWriter.close();
	        	xMLStreamWriter = null;

				
			} catch (XMLStreamException e) {
				logger.error("ERROR: Creating new SEM TRIPLE XML output file. "
					+ "Unable to write SEM TRIPLE XML file because it was not well-formed.", e
				);

			} catch (NullPointerException npe) {
				logger.error(
					String.format("ERROR: Failed creating Output filename '%s'!\n\n", this.schemaOutputFilename),
					npe
				);
								
			} catch (IOException e) {
				logger.error(String.format("ERROR: The output file '%s' exists, but \n"
					+ "  1) is a directory rather than a regular file, \n"
					+ "  2) does not exist but cannot be created, or \n"
					+ "  3) cannot be opened for some other reason", this.schemaOutputFilename), e);
			}
		}

		// Everything else
		else {
			logger.error("Unsupported format type: " + ((null != format) ? format.toString() : "null"));
		}
		
		return null;
	}

	/**
	 * Read in a file as a String. Use this only for relatively short files, 
	 * since Java Strings, like diamonds, are forever.
	 * 
	 * @param path Path and filename of file to read in
	 * @param encoding Whichever encoding you want to read the file using, e.g. Charset.defaultCharset()
	 * @return String of your file's contents
	 * @throws IOException Should something go horribly wrong.
	 */
	private String readFile(String path, Charset encoding) 
			  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}

	/**
	 * Parse the schema file and output according to user preferences
	 * 
	 * @param sqlFilename File name of the SQL schema file to parse.
	 * @param dbName
	 * @throws IllegalArgumentException A required argument was null or a stupid value was used.
	 * @throws NoSuchFileException Specified sqlFilename does not exist.
	 * @throws IOException Failed to read specified sqlFilename for some reason.
	 */
	public void parseSchema(
			String sqlFilename
	) throws IllegalArgumentException, NoSuchFileException, IOException {	
	
		// Use the incoming parameters
		if (null != sqlFilename) this.sqlFilename = sqlFilename;
		
		// Throw a tantrum if any of the required parameters weren't specified
		if (null == this.sqlFilename) throw new IllegalArgumentException("Parameter sqlFilename MUST be specified!");
		
		
		// Load SQL schema file
		String sql = "";
		try {
			sql = readFile(this.sqlFilename, Charset.defaultCharset());
		} catch (NoSuchFileException nsfe) {
			logger.error(String.format("Specified SQL filename %s does not exist.", this.sqlFilename));
			throw nsfe;
		} catch (IOException e) {
			logger.error(String.format("Failed to read incoming SQL filename %s", this.sqlFilename));
			throw e;
		}

		
		// Get our lexer
	    CreateTableLexer lexer = new CreateTableLexer(new ANTLRInputStream(sql));
	 
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    CreateTableParser parser = new CreateTableParser(tokens);
	 
	    // Specify our entry point
	    EvaluateContext sqlContext = parser.evaluate();
	 
	    // Attach the MySQL listener and walk the parse tree 
	    ParseTreeWalker walker = new ParseTreeWalker();
	    listener = new MySQLListener();
	    walker.walk(listener, sqlContext);
	    
	    logger.debug("Done mapping the parse tree of [%s] to the data model. ", this.sqlFilename);
	}
	
}
