package com.matthewroyal.marklogic.semantics;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OutputXML extends OutputFormat {

	private static final Logger logger = LogManager.getLogger(OutputXML.class.getName()); 	

	private static final String DEFAULT_NAMESPACE_URI = "http://com.matthewroyal.marklogic.semantics/CSVParser/OutputXML";
	private static final String DEFAULT_NAMESPACE_PREFIX = "csv";
	private static final String DEFAULT_ROOT_ELEMENT_NAME = "csvFile";
	private static final String DEFAULT_RECORD_ELEMENT_NAME = "csvRecord";
	
	XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();	
	XMLStreamWriter xMLStreamWriter = null;    	

	private String namespace = DEFAULT_NAMESPACE_URI;
	private String ns = DEFAULT_NAMESPACE_PREFIX;
	private String rootName = DEFAULT_ROOT_ELEMENT_NAME;
	private String recordName = DEFAULT_RECORD_ELEMENT_NAME;
	
	
	
	public OutputXML() {
		super();
	}
	public OutputXML(String outputFilename) {
		super(outputFilename);
	}
	public OutputXML(String outputFilename, String namespace, String namespacePrefix, String rootElementName, String recordName) {
		super(outputFilename);
		if (null != namespace) this.namespace = namespace;
		if (null != namespacePrefix) this.ns = namespacePrefix;
		if (null != rootElementName) this.rootName = rootElementName;
		if (null != recordName) this.recordName = recordName;
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
    	
    	// Start a shiny new XML file!
    	try {
			xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(bw);
	        xMLStreamWriter.writeStartDocument();
	        xMLStreamWriter.setPrefix(ns, namespace);
	        xMLStreamWriter.writeCharacters("\n");
	        xMLStreamWriter.writeStartElement(rootName);
	        xMLStreamWriter.writeDefaultNamespace(namespace);
	        
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
	        xMLStreamWriter.writeEndElement();
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
	public Integer transformToFormat(CSVParser parser) throws IOException {

		try {
			// Transform the CSV file
	        HashMap<String,Integer> header = (HashMap<String, Integer>) parser.getHeaderMap();
			for (CSVRecord record : parser) {
	
		        write(null); // Trigger writing logic
		        xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeStartElement(recordName);
		        xMLStreamWriter.writeAttribute("number", numRecordsInCurrentFile.toString());

		        // Parse each value in header
				for (String h : header.keySet()) {
			        if (null != record.get(h) && record.get(h).length() > 0) {
			        	xMLStreamWriter.writeCharacters("\n    ");
				        xMLStreamWriter.writeStartElement(h);			
				        xMLStreamWriter.writeCharacters(record.get(h));
				        xMLStreamWriter.writeEndElement();
			        }
				}
	
	        	xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeEndElement();
		    }
	        
		} catch (XMLStreamException xse) {
			logger.error("ERROR: Unable to write XML file because it was not well-formed.");
			
		}
        
		return numRecordsInCurrentFile;
	}


}
