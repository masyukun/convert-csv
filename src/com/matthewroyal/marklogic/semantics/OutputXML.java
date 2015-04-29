package com.matthewroyal.marklogic.semantics;

import java.io.IOException;
import java.util.ArrayList;
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

	private static final String SEM = "sem";
	private static final String SEM_TRIPLE_NAMESPACE = "http://marklogic.com/semantics";
	
	XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();	
	XMLStreamWriter xMLStreamWriter = null;    	

	private String namespace = DEFAULT_NAMESPACE_URI;
	private String ns = DEFAULT_NAMESPACE_PREFIX;
	private String rootName = DEFAULT_ROOT_ELEMENT_NAME;
	private String recordName = DEFAULT_RECORD_ELEMENT_NAME;

	private Boolean generateSemTriples = false; // Default value
	
	
	
	
	public OutputXML() {
		super();
	}
	public OutputXML(String outputFilename) {
		super(outputFilename);
	}
	public OutputXML(String outputFilename, String namespace, String namespacePrefix, String rootElementName, String recordName, Boolean generateSemTriples) {
		super(outputFilename);
		if (null != namespace) this.namespace = namespace;
		if (null != namespacePrefix) this.ns = namespacePrefix;
		if (null != rootElementName) this.rootName = rootElementName;
		if (null != recordName) this.recordName = recordName;
		if (null != generateSemTriples) this.generateSemTriples = generateSemTriples;
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
	        xMLStreamWriter.writeCharacters("\n");
	        xMLStreamWriter.writeStartElement(rootName);
	        xMLStreamWriter.writeDefaultNamespace(namespace);
	        xMLStreamWriter.setPrefix(ns, namespace);
	        if (generateSemTriples) { 
	        	xMLStreamWriter.setPrefix(SEM, SEM_TRIPLE_NAMESPACE);
	        	xMLStreamWriter.writeNamespace(SEM, SEM_TRIPLE_NAMESPACE);
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

		ArrayList<SemTriple> triples = null;
		if (generateSemTriples) 
			triples = new ArrayList<SemTriple>();
		
		
		try {
			// Transform the CSV file
	        HashMap<String,Integer> header = (HashMap<String, Integer>) parser.getHeaderMap();
			for (CSVRecord record : parser) {
	
		        write(null); // Trigger writing logic
		        xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeStartElement(recordName);
		        xMLStreamWriter.writeAttribute("number", numRecordsInCurrentFile.toString());

		        // Parse each value in header
		        String key = null;
				for (String h : header.keySet()) {
					
					if (generateSemTriples && null == key) {
						// Grab the first header as key
						key = h;
					}
					
			        if (null != record.get(h) && record.get(h).length() > 0) {
			        	xMLStreamWriter.writeCharacters("\n    ");
				        xMLStreamWriter.writeStartElement(h);			
				        xMLStreamWriter.writeCharacters(record.get(h));
				        xMLStreamWriter.writeEndElement();
				        
				        // write out sem:triples for each row
				        if (generateSemTriples && key != h) {
					        triples.add(new SemTriple(
					        		record.get(key), 
					        		namespace + "/" + h,
					        		record.get(h)
			        		));
				        }
				        
			        }
				}
	
	        	xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeEndElement();
		        
		        // write out sem:triples for each row
		        if (generateSemTriples && !triples.isEmpty()) {
		        	xMLStreamWriter.writeCharacters("\n  ");
			        xMLStreamWriter.writeStartElement(SEM, "triples", SEM_TRIPLE_NAMESPACE);
			        
		        	for (SemTriple triple : triples) {
			        	xMLStreamWriter.writeCharacters("\n    ");
				        xMLStreamWriter.writeStartElement(SEM, "triple", SEM_TRIPLE_NAMESPACE);
				        
				        xMLStreamWriter.writeCharacters("\n      ");
				        xMLStreamWriter.writeStartElement(SEM, "subject", SEM_TRIPLE_NAMESPACE);
				        xMLStreamWriter.writeCharacters(triple.subject);
				        xMLStreamWriter.writeEndElement();
				        xMLStreamWriter.writeCharacters("\n      ");
				        xMLStreamWriter.writeStartElement(SEM, "predicate", SEM_TRIPLE_NAMESPACE);
				        xMLStreamWriter.writeCharacters( triple.predicate );
				        xMLStreamWriter.writeEndElement();
				        xMLStreamWriter.writeCharacters("\n      ");
				        xMLStreamWriter.writeStartElement(SEM, "object", SEM_TRIPLE_NAMESPACE);
				        xMLStreamWriter.writeCharacters( triple.object );
				        xMLStreamWriter.writeEndElement();
				        
				        xMLStreamWriter.writeCharacters("\n    ");
				        xMLStreamWriter.writeEndElement();
		        	}
		        	
		        	xMLStreamWriter.writeCharacters("\n  ");
			        xMLStreamWriter.writeEndElement();
		        	
			        triples.clear();
		        }

		    }
	        
		} catch (XMLStreamException xse) {
			logger.error("ERROR: Unable to write XML file because it was not well-formed.");
			
		}
        
		return numRecordsInCurrentFile;
	}


}