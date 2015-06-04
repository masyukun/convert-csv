package com.matthewroyal.marklogic.semantics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputTemplate extends OutputFormat {

	private static final Logger logger = LogManager.getLogger(OutputTemplate.class.getName()); 	

	private String templateFilename;
	private String templateHeader;
	private String templateFooter;
	
	
	public OutputTemplate() {
		super();
	}

	public OutputTemplate(String outputFilename, String outputPath) {
		super(outputFilename, outputPath, null);
	}
	
	public OutputTemplate(String outputFilename, String outputPath, String templateFilename, String templateHeader, String templateFooter, Integer maxRecordsPerFile) {
		super(outputFilename, outputPath, maxRecordsPerFile);
		
		this.templateFilename = templateFilename;
		this.templateHeader = templateHeader;
		this.templateFooter = templateFooter;
	}
	
	
	
	/**
	 * Read a file's contents into a String
	 * @param file String filename for a file
	 * @return String contents of file
	 * @throws IOException
	 */
	private static String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    reader.close();
	    
	    return stringBuilder.toString();
	}
	
	
	public String customFileBeginning() throws IOException {
		// Write the header, if applicable
		if (null != templateHeader && templateHeader.length() > 0)
			return templateHeader;
		
		return null;
	}
	
	public String customFileEnding() throws IOException {
		// Write the footer, if applicable
		if (null != templateFooter && templateFooter.length() > 0)
			return templateFooter;

		return null;
	}
	

	@Override
	public String getFileExtension() {
		if (null != outputFilename && outputFilename.contains(".")) {
			String[] pieces = outputFilename.split("\\.");
			return pieces[pieces.length - 1];
		}
		
		return ".out";
	}
	
	@Override
	public Integer transformToFormat(CSVParser parser) throws IOException {

		Integer numLines = 0;
		
		// Load template file as a String
		String templateFile = null;
		try {
			templateFile = readFile(templateFilename);
		} catch (IOException e) {
			logger.error(String.format("ERROR: Template file '%s' doesn't exist or can't be opened!", templateFilename));
			ConvertCSV.callForHelp();
		}
	
		
		HashMap<String,Integer> header = (HashMap<String, Integer>) parser.getHeaderMap();
		
		// Transform the CSV file
		for (CSVRecord record : parser) {

			String rowFile = new String(templateFile);

			// Parse each value in header
			for (String h : header.keySet()) {
				rowFile = rowFile.replaceAll("\\{"+h+"\\}", record.get(h));
			}

			write(rowFile);
			++numLines;
	    }

		return numLines;
	}

}
