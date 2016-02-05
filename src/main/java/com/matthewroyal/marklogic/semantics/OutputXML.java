package com.matthewroyal.marklogic.semantics;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.matthewroyal.marklogic.RDBSchemaModel.RDBColumn;
import com.matthewroyal.marklogic.RDBSchemaModel.RDBSchemaModel;


public class OutputXML extends OutputFormat {

	private static final Logger logger = LogManager.getLogger(OutputXML.class.getName()); 	

	private static final String DEFAULT_NAMESPACE_URI = "http://com.matthewroyal.marklogic.semantics/CSVParser/OutputXML";
	private static final String DEFAULT_NAMESPACE_PREFIX = "csv";
	private static final String DEFAULT_ROOT_ELEMENT_NAME = "csvFile";
	private static final String DEFAULT_RECORD_ELEMENT_NAME = "csvRecord";

	XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();	
	XMLStreamWriter xMLStreamWriter = null;    	

	private String namespace = null;
	private String ns = DEFAULT_NAMESPACE_PREFIX;
	private String rootName = DEFAULT_ROOT_ELEMENT_NAME;
	private String recordName = DEFAULT_RECORD_ELEMENT_NAME;

	private Boolean generateSemTriples = false; // Default value
	private RDBSchemaModel schema;
	
	
	
	public OutputXML() {
		super();
	}
	public OutputXML(String outputFilename, String outputPath) {
		super(outputFilename, outputPath, null);
	}
	public OutputXML(String outputFilename, String outputPath, String namespace, String namespacePrefix, String rootElementName, String recordName, Boolean generateSemTriples, Integer maxRecordsPerFile) {
		super(outputFilename, outputPath, maxRecordsPerFile);
		if (null != namespace) this.namespace = namespace;
		if (null != namespacePrefix) this.ns = namespacePrefix;
		if (null != rootElementName) this.rootName = rootElementName;
		if (null != recordName) this.recordName = recordName;
		if (null != generateSemTriples) this.generateSemTriples = generateSemTriples;
	}
	public OutputXML(String outputFilename, String outputPath, String namespace, String namespacePrefix, String rootElementName, String recordName, Boolean generateSemTriples, Integer maxRecordsPerFile, RDBSchemaModel schema) {
		super(outputFilename, outputPath, maxRecordsPerFile);
		if (null != namespace) this.namespace = namespace;
		if (null != namespacePrefix) this.ns = namespacePrefix;
		if (null != rootElementName) this.rootName = rootElementName;
		if (null != recordName) this.recordName = recordName;
		if (null != generateSemTriples) this.generateSemTriples = generateSemTriples;
		if (null != schema) this.schema = schema;
	}
	
	
	@Override
	protected String customFileBeginning() throws IOException {

		// Finish off any remnant of the previous xml stream writer
		try {
	        if (null != xMLStreamWriter) {
				xMLStreamWriter.flush();
	        	xMLStreamWriter.close();
	        	xMLStreamWriter = null;
	        }
		} catch (XMLStreamException e) {
			logger.error("ERROR: Closing off XML output file.", e);
		}

		// Attempt to figure out the table name from the outputFilename
		if (null == tableName) {
			for (String tName : schema.tableMap.keySet()) {
				if (outputFilename.replaceAll("/", "").replaceAll(" ", "").replaceAll("_", "").toUpperCase().contains( tName.replaceAll("_", "").replaceAll(" ", "").toUpperCase() )) {
					if (null == tableName || tName.length() > tableName.length()) {
						tableName = tName;
						namespace = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, tName);
					}
				}
			}
		}


    	// Start a shiny new XML file!
    	try {
			xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(bw);
	        xMLStreamWriter.writeStartDocument();
	        xMLStreamWriter.writeCharacters("\n");
	        xMLStreamWriter.writeStartElement(rootName);
	        xMLStreamWriter.setPrefix(ns, namespace);
	        xMLStreamWriter.writeDefaultNamespace(namespace);
	        if (generateSemTriples) { 
	        	xMLStreamWriter.setPrefix(SemTriple.SEM, SemTriple.SEM_TRIPLE_NAMESPACE);
	        	xMLStreamWriter.writeNamespace(SemTriple.SEM, SemTriple.SEM_TRIPLE_NAMESPACE);
	        }
	        
		} catch (XMLStreamException e) {
			logger.error("ERROR: Creating new XML output file.", e);
		}

		return "";
	}
	
	@Override
	protected String customFileEnding() throws IOException {

		// Finish document
		try {
	        xMLStreamWriter.writeCharacters("\n");
	        xMLStreamWriter.writeEndElement(); // root name
	        xMLStreamWriter.writeCharacters("\n");
	        xMLStreamWriter.writeEndDocument();
	        xMLStreamWriter.flush();
	        xMLStreamWriter.close();
        	xMLStreamWriter = null;

		} catch (XMLStreamException e) {
			logger.error("ERROR: Writing out the end of an XML output file.", e);
		}
        
        return "";
	}

	
	@Override
	public String getFileExtension() {
		return ".xml";
	}
	
	@Override
	public Integer transformToFormat(CSVParser parser) throws IOException {

		ArrayList<SemTriple> triples = null;
		if (generateSemTriples) 
			triples = new ArrayList<SemTriple>();
		
		
		try {
			// Transform the CSV file
	        HashMap<String,Integer> header = (HashMap<String, Integer>) parser.getHeaderMap();
			for (CSVRecord record : parser) {
	
		        write(null); // Trigger writing logic
		        xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeStartElement(recordName); //rowname
		        xMLStreamWriter.writeAttribute("number", totalProcessedRecordCount.toString());

		        // Parse each value in header
				for (String h : header.keySet()) {
			        if (null != record.get(h) && record.get(h).length() > 0) {
			        	xMLStreamWriter.writeCharacters("\n    ");
				        xMLStreamWriter.writeStartElement(h); // column name
				        xMLStreamWriter.writeCharacters(record.get(h).trim());
				        xMLStreamWriter.writeEndElement(); // column name
			        }
				}
				
				// Use the schema to generate triples, if that's what was given.
				if (generateSemTriples && null != schema) {

					// Attempt to figure out the table name from the outputFilename
					if (null == tableName) {
						for (String tName : schema.tableMap.keySet()) {
							if (outputFilename.replaceAll("/", "").replaceAll(" ", "").replaceAll("_", "").toUpperCase().contains( tName.replaceAll("_", "").replaceAll(" ", "").toUpperCase() )) {
								if (null == tableName || tName.length() > tableName.length()) {
									tableName = tName;
									namespace = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, tName);
								}
							}
						}
					}

					// Build triples for each PK-FK pair
					if (null == tableName)
						logger.error("This table doesn't have a name!");
					
					for (RDBColumn pk : schema.tableMap.get(tableName).primary_keys) {
						
						// Generate identifying triple
						SemTriple tableHasRow = new SemTriple();
						tableHasRow.subject = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, tableName) + "/" + record.get( header.get(pk.name.trim()) ).trim();
						tableHasRow.predicate = SemTriple.RDB + "instanceOf";
						tableHasRow.object = SemTriple.TABLE_NAMESPACE(schema.dbName, tableName);
						triples.add(tableHasRow);
						
						// Generate relational constraint triple
						for (RDBColumn fk : schema.tableMap.get(tableName).foreign_keys.keySet()) {
							SemTriple rowHasRelationship = new SemTriple();
							String fkName = fk.name.trim();
							
							rowHasRelationship.subject = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, tableName) + "/" + record.get( header.get(pk.name.trim()) ).trim();
							rowHasRelationship.predicate = SemTriple.FK + fkName;
							RDBColumn remoteKey = schema.tableMap.get(tableName).foreign_keys.get(fk);
							if (null == header.get(fkName))
								logger.error(String.format("This FK [%s] doesn't map to a header!", fkName));
							String fkValue = record.get( header.get(fkName) );
							rowHasRelationship.object = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, remoteKey.table.tableName) + "/" + fkValue.trim();
							
							if (null != fkValue && fkValue.trim().length() > 0)
								triples.add(rowHasRelationship);
						}
					}

					// Write the triples as a batch
					if (null != triples && triples.size() > 0) {
						SemTriple.writeTriple(xMLStreamWriter, triples, true);
						triples.clear();
					}
				}
	
	        	xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeEndElement(); //rowname
		    }
	        
		} catch (XMLStreamException xse) {
			logger.error("ERROR: Unable to write XML file because it was not well-formed.", xse);
			
		} catch (NullPointerException npe) {
			logger.error("ERROR: Failure writing to XMLStreamWriter.", npe);
			OutputMonitor.stopTimer();
		}
        
		endCurrentFile();
		
		return numRecordsInCurrentFile;
	}


	
	
	
	
	
	
	/**
	 * Accept a database ResultSet rather than a parser object
	 */
	   public Integer transformToFormat(ResultSet results) throws IOException {

	        ArrayList<SemTriple> triples = null;
	        if (generateSemTriples) 
	            triples = new ArrayList<SemTriple>();
	        
	        
	        try {	          
              // Loop through the whole database ResultSet
              while (results.next()) {
	    
                write(null); // Trigger writing logic
                xMLStreamWriter.writeCharacters("\n  ");
                xMLStreamWriter.writeStartElement(recordName); //rowname
                xMLStreamWriter.writeAttribute("number", totalProcessedRecordCount.toString());

                
                // Parse each value in header
                int numColumns = results.getMetaData().getColumnCount();
                for (Integer ii = 1; ii <= numColumns; ++ii) {
                    String columnName = results.getMetaData().getColumnLabel(ii);
                    Object columnData = results.getObject(ii);
                    
                    // Only print the element if the data isn't null
                    if (null != columnData) {
                      xMLStreamWriter.writeCharacters("\n    ");
                      xMLStreamWriter.writeStartElement(columnName); // column name
                      xMLStreamWriter.writeCharacters(columnData.toString().trim());
                      xMLStreamWriter.writeEndElement(); // column name
                    }
                }
	                
	                // Use the schema to generate triples, if that's what was given.
	                if (generateSemTriples && null != schema) {

                      // Get the table name from the metadata -- all columns should have same table name in this version.
	                  tableName = results.getMetaData().getTableName(1).trim();

	                    // Build triples for each PK-FK pair
	                    if (null == tableName)
	                        logger.error("This table doesn't have a name!");
	                    
	                    for (RDBColumn pk : schema.tableMap.get(tableName).primary_keys) {
	                        
	                        // Generate identifying triple
	                        SemTriple tableHasRow = new SemTriple();
	                        tableHasRow.subject = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, tableName) + "/" + results.getString( pk.name.trim() ).trim();
	                        tableHasRow.predicate = SemTriple.RDB + "instanceOf";
	                        tableHasRow.object = SemTriple.TABLE_NAMESPACE(schema.dbName, tableName);
	                        triples.add(tableHasRow);
	                        
	                        // Generate relational constraint triple
	                        for (RDBColumn fk : schema.tableMap.get(tableName).foreign_keys.keySet()) {
	                            SemTriple rowHasRelationship = new SemTriple();
	                            String fkName = fk.name.trim();
	                            
	                            rowHasRelationship.subject = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, tableName) + "/" + results.getString( pk.name.trim() ).trim();
	                            rowHasRelationship.predicate = SemTriple.FK + fkName;
	                            RDBColumn remoteKey = schema.tableMap.get(tableName).foreign_keys.get(fk);
	                            if (null == results.getString(fkName))
	                                logger.error(String.format("This FK [%s] doesn't map to a header!", fkName));
	                            String fkValue = results.getString(fkName);
	                            rowHasRelationship.object = SemTriple.TABLEDATA_NAMESPACE(schema.dbName, remoteKey.table.tableName) + "/" + fkValue.trim();
	                            
	                            if (null != fkValue && fkValue.trim().length() > 0)
	                                triples.add(rowHasRelationship);
	                        }
	                    }

	                    // Write the triples as a batch
	                    if (null != triples && triples.size() > 0) {
	                        SemTriple.writeTriple(xMLStreamWriter, triples, true);
	                        triples.clear();
	                    }
	                }
	    
	                xMLStreamWriter.writeCharacters("\n  ");
	                xMLStreamWriter.writeEndElement(); //rowname
	            }
	            
	        } catch (XMLStreamException xse) {
	            logger.error("ERROR: Unable to write XML file because it was not well-formed.", xse);
	            
	        } catch (NullPointerException npe) {
	            logger.error("ERROR: Failure writing to XMLStreamWriter.", npe);
	            OutputMonitor.stopTimer();
	        }
          catch (SQLException e) {
            logger.error("ERROR: Failed getting results from SQL table's ResultSet", e);
          }
	        
	        endCurrentFile();
	        
	        return numRecordsInCurrentFile;
	    }
// end resultset code

	   
	   
	
}
