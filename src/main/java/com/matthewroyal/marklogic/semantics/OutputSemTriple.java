package com.matthewroyal.marklogic.semantics;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OutputSemTriple extends OutputFormat {

	private static final Logger logger = LogManager.getLogger(OutputSemTriple.class.getName()); 	

	private static final String DEFAULT_NAMESPACE_URI = "http://com.matthewroyal.marklogic.semantics/CSVConvert/OutputXML";

	XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();	
	XMLStreamWriter xMLStreamWriter = null;    	

	private String namespace = DEFAULT_NAMESPACE_URI;

	
	
	
	
	public OutputSemTriple() {
		super();
	}
	public OutputSemTriple(String outputFilename, String outputPath) {
		super(outputFilename, outputPath, null);
	}
	public OutputSemTriple(String outputFilename, String outputPath, String namespace, Integer maxRecordsPerFile) {
		super(outputFilename, outputPath, maxRecordsPerFile);
		if (null != namespace) this.namespace = namespace;
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
			logger.error("ERROR: Closing off SEM TRIPLE XML output file.", e);
		}
    	
    	// Start a shiny new XML file!
    	try {
			xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(bw);
	        xMLStreamWriter.writeStartDocument();
	        xMLStreamWriter.writeCharacters("\n  ");
	        xMLStreamWriter.writeStartElement(SemTriple.SEM, "triples", SemTriple.SEM_TRIPLE_NAMESPACE);
	        xMLStreamWriter.setPrefix(SemTriple.SEM, SemTriple.SEM_TRIPLE_NAMESPACE);
	        xMLStreamWriter.writeNamespace(SemTriple.SEM, SemTriple.SEM_TRIPLE_NAMESPACE);
	        
		} catch (XMLStreamException e) {
			logger.error("ERROR: Creating new SEM TRIPLE XML output file.", e);
		}

		return "";
	}

	
	@Override
	protected String customFileEnding() throws IOException {

		// Finish document
		try {
	        xMLStreamWriter.writeCharacters("\n");
	        xMLStreamWriter.writeEndElement(); // triples
	        xMLStreamWriter.writeEndDocument();
	        xMLStreamWriter.flush();
	        xMLStreamWriter.close();
        	xMLStreamWriter = null;

		} catch (XMLStreamException e) {
			logger.error("ERROR: Writing out the end of a SEM TRIPLE XML output file.", e);
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
		triples = new ArrayList<SemTriple>();
		
		
		try {
			// Transform the CSV file
	        HashMap<String,Integer> header = (HashMap<String, Integer>) parser.getHeaderMap();
			for (CSVRecord record : parser) {
	
		        write(null); // Trigger writing logic

		        // Parse each value in header
		        String key = null;
				for (String h : header.keySet()) {
					
					if (null == key) {
						// Grab the first header as key
						key = h;
					}
					
			        if (null != record.get(h) && record.get(h).length() > 0) {
			        	
				        // write out sem:triples for each row
				        if (key != h) {
					        triples.add(new SemTriple(
				        		namespace + "/" + header.get(key) + "/" + record.get(key), 
				        		namespace + "/" + h,
				        		record.get(h)
			        		));
				        }
				        
			        }
				}
	
		        // write out sem:triples for each row
		        if (!triples.isEmpty()) {
			        
		        	for (SemTriple triple : triples) {
		        		SemTriple.writeTriple(xMLStreamWriter, triple, false);
		        	}
		        	
			        triples.clear();
		        }

		    }
	        
		} catch (XMLStreamException xse) {
			logger.error("ERROR: Unable to write SEM TRIPLE XML file because it was not well-formed.");
			
		}
        
		return numRecordsInCurrentFile;
	}
  @Override
  public Integer transformToFormat(ResultSet results) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }


}
