package com.matthewroyal.marklogic.semantics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class OutputFormat {

	private static final Logger logger = LogManager.getLogger(Class.class.getName()); 	

	private static final Integer MAX_NAME_ATTEMPTS = 100;
	private static final String DEFAULT_OUTPUT_FILENAME = "outputFile.1.out";
	
	protected String outputFilename = null;
	protected File outputFile = null;
	protected FileWriter fw = null;
	protected BufferedWriter bw = null;
	protected Integer maxRecordsPerFile = 100;
	
	
	OutputFormat() {
		if (null == outputFilename)
			outputFilename = DEFAULT_OUTPUT_FILENAME;
		
		createOutputFile(outputFilename);
	}
		
	OutputFormat(String outputFilename) {
		if (null == outputFilename && null == this.outputFilename)
			this.outputFilename = DEFAULT_OUTPUT_FILENAME;
		else
			this.outputFilename = outputFilename;
		
		createOutputFile(this.outputFilename);
	}

	
	public Integer getMaxRecordsPerFile() {
		return maxRecordsPerFile;
	}
	public void setMaxRecordsPerFile(Integer maxRecordsPerFile) {
		this.maxRecordsPerFile = maxRecordsPerFile;
	}
	
	
	public void createOutputFile(String outputFilename) {

		// Create the output file, if it doesn't exist
		Boolean needsGoodname = true;
		Integer nameAttempt = 1;
		try {
			do {
				// Try creating the output file
				outputFile = new File(outputFilename);
				if (!outputFile.exists()) { 
					outputFile.createNewFile();
					needsGoodname = false;
				}

				// Try getting a new output name
				if (needsGoodname) {
					outputFilename = getNextOutputFilename(outputFilename);
				}
				
			} while (needsGoodname && nameAttempt <= MAX_NAME_ATTEMPTS);

			// Fancy file-writing classes // TODO convert to stream?
			fw = new FileWriter(outputFile.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			
		} catch (NullPointerException npe) {
			logger.error(String.format("ERROR: Failed creating Output filename '%s'!\n\n", outputFilename));
			logger.error(String.format("Attempt %d of %d to find new output name...", nameAttempt, MAX_NAME_ATTEMPTS));				
		} catch (IOException e) {
			logger.error(String.format("ERROR: The output file '%s' exists, but \n"
					+ "  1) is a directory rather than a regular file, \n"
					+ "  2) does not exist but cannot be created, or \n"
					+ "  3) cannot be opened for some other reason", outputFilename));
			ConvertCSV.callForHelp();
		}
		

	}
	
	
	/**
	 * If your current filename is no good, keep using this function until you
	 * get a nice, numerically incremented filename.
	 * @param outputFilename String your current filename that already exists
	 * @return String a new version-incremented filename, that we hope doesn't already exist 
	 */
	protected String getNextOutputFilename(String outputFilename) {
		
		String newFilename = null;
		
		ArrayList<String> filenamePieces = new ArrayList<String>( Arrays.asList(outputFilename.split("\\.")) );
		
		// Let's see what sort of filename we have here...
		if (filenamePieces.size() > 2) {
			
			// Lots of period-separated pieces
			
			ArrayList<String> constructedName = new ArrayList<String>();
			
			Integer versionControlNumber = null;
			String nextToLast = filenamePieces.get(filenamePieces.size() - 2);
			
			// See if it's already following our versioning scheme
			if ( nextToLast.matches("^[0-9]+$") ) {
				try {
					// NEXT!
					versionControlNumber = Integer.parseInt(nextToLast) + 1;
					
				} catch (NumberFormatException nfe) {
					logger.info("File [%s] is not current one of our versioned output files.");
				}
			}

			// Grab everything up til where the version number goes.
			if (null != versionControlNumber) {

				for (int ii = 0; ii < filenamePieces.size() - 2; ++ii)
					constructedName.add(filenamePieces.get(ii));
				
			} else {
				// Begin versioning
				versionControlNumber = 1;

				// Add everything up to the last piece (probably the file extension)
				for (int ii = 0; ii < filenamePieces.size() - 1; ++ii)
					constructedName.add(filenamePieces.get(ii));
			}
			
			// Add version number and file extension
			constructedName.add(versionControlNumber.toString());
			constructedName.add(filenamePieces.get(filenamePieces.size() - 1));
			
			// We have the technology. We can rebuild this.
			newFilename = StringUtils.join(constructedName, ".");
			
		} else if (filenamePieces.size() > 1) {
			// The filename has an extension, but is unversioned
			ArrayList<String> constructedName = new ArrayList<String>();
			constructedName.add(filenamePieces.get(0));
			constructedName.add("1"); // Begin versioning
			constructedName.add(filenamePieces.get(1));
			
			newFilename = StringUtils.join(constructedName, ".");
			
		} else if (filenamePieces.size() == 1) {
			// The filename has no extension
			newFilename = outputFilename + ".1.out";
		} else {
			// There is no filename -- use the default.
			newFilename = DEFAULT_OUTPUT_FILENAME;
		}
		

		return newFilename;
	}

	
	/**
	 * Inheriting classes will overwrite this method and use BufferedWriter bw
	 * to write to the output file.
	 * @param record CSVRecord to write to the output file
	 * @return Integer number of records parsed from CSV file
	 */
	public abstract Integer write(CSVParser parser) throws IOException;
	
	
	
}
