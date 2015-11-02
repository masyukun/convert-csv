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
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.matthewroyal.marklogic.CreateTableParser.CreateTableLexer;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableListener;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.EvaluateContext;

/**
 * @author mroyal
 *
 */
public class RDBSchemaModel {
	
	// Class error/debug logger
	private static Logger logger = LogManager.getLogger( RDBSchemaModel.class.getClass() );

	// Useful data structures
	public static enum OUTPUT_TYPES {PLAINTEXT, SEMTRIPLES, SQLINSERT};
	public static List<RDBTable> tables = new ArrayList<RDBTable>();
	private static Integer columnCounter = 0;
	

	// Map the table and column name to its unique URI
	// "tablename/columname" --> "http://matthewroyal.com/ConvertRDB/dbname/tablename#columnumber"
	private static HashMap<String, String> columnUriMap = new HashMap<String, String>();
	

	// RDB namespaces
	public static String SEM = "sem";
	public static String SEM_TRIPLE_NAMESPACE = "http://marklogic.com/semantics";
	public static String RDB = "http://matthewroyal.com/ConvertRDB/rdb#";
	public static String DB = "http://matthewroyal.com/ConvertRDB/db#";
	public static String TABLE;
	public static String COLUMN;
	public static String FK = "http://matthewroyal.com/ConvertRDB/foreignKey#";
	

	// Command-line options
	private static Options options;
	private static String sqlFilename;
	private static OUTPUT_TYPES outputType;
	private static String outputFilename = "myfile.txt"; // Default filename
	private static String dbName;
	
	
	public RDBSchemaModel() {}

	
	/**
	 * Create MarkLogic-style sem:IRI
	 * @param URI
	 * @return
	 */
	private static String makeIRI(String newURI) {
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
	private static String getUniqueColumnURI(String key, String columnNamespace) {
		
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
	private static void writeTriple(
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
	
	
	@SuppressWarnings("unused")
	public static String printSchema(Collection<RDBTable> tables, OUTPUT_TYPES format) {

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
				outputFile = new File(outputFilename);
				if (!outputFile.exists()) { 
					outputFile.createNewFile();
				}

				// Fancy file-writing classes // TODO convert to stream?
				if (null != fw) {
					fw.close();
					fw = null;
				}
				fw = new FileWriter(outputFile.getAbsoluteFile());
				if (null != bw) {
					bw.close();
					bw = null;
				}
				bw = new BufferedWriter(fw);
				
				
				// Start a shiny new XML file!
				xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(bw);
		        xMLStreamWriter.writeStartDocument();
	        	xMLStreamWriter.setPrefix(SEM, SEM_TRIPLE_NAMESPACE);
	        	xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeStartElement(SEM, "triples", SEM_TRIPLE_NAMESPACE);
				
		        
		        // Print tables
				for (RDBTable table : tables) {
					logger.debug("\nTable: " + table.tableName);

					// Relate database to table
			        writeTriple(xMLStreamWriter, 
		        		makeIRI(DB + dbName), 
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
						// TODO: Refactor these three chunks into one big loop instead
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

		        if (null != xMLStreamWriter) {
					xMLStreamWriter.flush();
		        	xMLStreamWriter.close();
		        	xMLStreamWriter = null;
		        }
		    	

				
			} catch (XMLStreamException e) {
				logger.error("ERROR: Creating new SEM TRIPLE XML output file. "
					+ "Unable to write SEM TRIPLE XML file because it was not well-formed.", e
				);

			} catch (NullPointerException npe) {
				logger.error(
					String.format("ERROR: Failed creating Output filename '%s'!\n\n", outputFilename),
					npe
				);
								
			} catch (IOException e) {
				logger.error(String.format("ERROR: The output file '%s' exists, but \n"
					+ "  1) is a directory rather than a regular file, \n"
					+ "  2) does not exist but cannot be created, or \n"
					+ "  3) cannot be opened for some other reason", outputFilename), e);
			}
		}

		// Everything else
		else {
			logger.error("Unsupported format type: " + ((null != format) ? format.toString() : "null"));
		}
		return null;
		
	}
	
	
	
	
	/**
	 * Build the options accepted on the command line
	 */
	@SuppressWarnings("static-access")
	private static void buildCLIOptions() {
		// Define the command-line options
		options = new Options();
		options.addOption( OptionBuilder.withLongOpt( "sql-file" )
                .withDescription( "Filename of SQL file to ingest." )
                .hasArg().withArgName("SQLFILE").create() );
		options.addOption( OptionBuilder.withLongOpt( "output-type" )
                .withDescription( "Format of output schema: " + StringUtils.join(OUTPUT_TYPES.values(), ", ") )
                .hasArg().withArgName("FORMAT").create() );
		options.addOption( OptionBuilder.withLongOpt( "output-filename" )
                .withDescription( String.format("Filename for output schema. (Default=[%s])", outputFilename) )
                .hasArg().withArgName("OUTFILE").create() );
	}
	

	/**
	 * Load the options specified on the command line.
	 * @param args String[] command line options from main(String[] args) function
	 * @return String properties filename, if specified
	 */
	private static void loadCLIOptions(String[] args) {
		
		// Read in command-line options
		CommandLine cmd;
		CommandLineParser parser = new GnuParser();
		try {
			cmd = parser.parse( options, args);
		
		    if (cmd.hasOption( "sql-file" )) { sqlFilename = cmd.getOptionValue( "sql-file" ); }
		    if (cmd.hasOption( "output-type" )) { outputType = OUTPUT_TYPES.valueOf(cmd.getOptionValue( "output-type" )); }
		    if (cmd.hasOption( "output-filename" )) { outputFilename = cmd.getOptionValue( "output-filename" ); }
		    
		} catch (ParseException e1) {
			System.out.println("ERROR: Incoming arguments just aren't cutting the mustard!\n\n");
		}
		
	}

	private static String readFile(String path, Charset encoding) 
			  throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}

	private static void showHelp() {
		
		// generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( Class.class.getName(), options );
		System.exit(0);
	}
	
	
	
	

	/**
	 * @param args/
	 */
	public static void main(String[] args) {
		
		// Parse CLI options
		buildCLIOptions();
		if (null != args) 
			loadCLIOptions(args);

		if (null == sqlFilename || "".equals(sqlFilename)) {
			logger.error("No SQL filename specified!");
			
			// generate the help statement
			showHelp();
		} else if (null == outputType) {
			logger.error("No output-type specified!");
			
			// generate the help statement
			showHelp();
		}

		
		// Load SQL schema file
		String sql = "";
		try {
			sql = readFile(sqlFilename, Charset.defaultCharset());
		} catch (NoSuchFileException nsfe) {
			logger.error(String.format("Specified SQL filename %s does not exist.", sqlFilename));

			// generate the help statement
			showHelp();
			
		} catch (IOException e) {
			logger.error(String.format("Failed to read incoming SQL filename %s", sqlFilename), e);

			// generate the help statement
			showHelp();
		}

		
		// Assume that the database name is the incoming sqlfile minus extension 
		StringBuilder dbNameBuilder = new StringBuilder();
		String[] dbFilenamePieces = sqlFilename.split("/");
		dbFilenamePieces = dbFilenamePieces[dbFilenamePieces.length - 1].split("\\.");
		for (int ii = 0; ii < dbFilenamePieces.length - 1; ++ii)
			dbNameBuilder.append(dbFilenamePieces[ii]);
		dbName = dbNameBuilder.toString();
		TABLE = String.format("http://matthewroyal.com/ConvertRDB/%s/table#", dbName);
		COLUMN = String.format("http://matthewroyal.com/ConvertRDB/%s/column#", dbName);
		


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
	    SqlListener listener = new SqlListener();
	    walker.walk((CreateTableListener)listener, sqlContext);
	    
		// Print the schema
	    logger.debug("Printing schema as " + outputType.toString());
		RDBSchemaModel.printSchema(listener.tableMap.values(), outputType);
	}
	
}
