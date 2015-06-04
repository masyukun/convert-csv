package com.matthewroyal.marklogic.semantics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public abstract class OutputFormat {

	private static final Logger logger = LogManager.getLogger(OutputFormat.class.getName()); 	

	private static final Integer MAX_NAME_ATTEMPTS = 100;
	private static final String DEFAULT_OUTPUT_FILENAME = "outputFile.1.out";
	private static final Integer DEFAULT_MAX_RECORDS_PER_FILE = 1000000;
	
	protected static int totalLinesInCsv = 0;
	protected static Long totalProcessedRecordCount = 0L;
	protected static Integer numRecordsInCurrentFile = 0;
	
	protected String outputPath = null;
	protected String outputFilename = null;
	protected File outputFile = null;
	protected FileWriter fw = null;
	protected BufferedWriter bw = null;
	protected Integer maxRecordsPerFile = DEFAULT_MAX_RECORDS_PER_FILE;
	
	
	OutputFormat() {
		if (null == outputFilename)
			outputFilename = DEFAULT_OUTPUT_FILENAME;
	}
		
	OutputFormat(String outputFilename, String outputPath, Integer maxRecordsPerFile) {

		setOutputPath(outputPath, outputFilename);
		
		if (null != maxRecordsPerFile)
			this.maxRecordsPerFile = maxRecordsPerFile;
	}

	
	public Integer getMaxRecordsPerFile() {
		return maxRecordsPerFile;
	}
	public void setMaxRecordsPerFile(Integer maxRecordsPerFile) {
		this.maxRecordsPerFile = maxRecordsPerFile;
	}

	/**
	 * Set the output path and filename of the current output file
	 * @param outputPath String absolute filesystem path for the directory that the output file should be written to. 
	 * @param outputFilename String filename of the output file.
	 */
	public void setOutputPath(String outputPath, String outputFilename) {

		// Set the outputfilename
		if (null == outputFilename && null == this.outputFilename)
			this.outputFilename = DEFAULT_OUTPUT_FILENAME;
		else
			this.outputFilename = outputFilename;
		

		// Create the output directory hierarchy
		if (null != outputPath && outputPath.length() > 0) {
			this.outputPath = outputPath;
			
			try {
				new File(outputPath).mkdirs();
			} catch (SecurityException se) {
				logger.error(String.format("ERROR: Couldn't create output path '%s' because of filesystem permissions.\n\n", outputPath));
				ConvertCSV.callForHelp();
					
			} catch (NullPointerException npe) {
				logger.error(String.format("ERROR: Couldn't create output path '%s' because that path is null.\n\n", outputPath));
				ConvertCSV.callForHelp();
			}
		}

	}
	
	/**
	 * Quickly count the lines in a file.
	 * @param filename String filename of the file to open and count
	 * @return Integer number of lines in the file
	 */
	public int countLineNumber(File filename) {
		
		try {
			File file = filename;
			   
			LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
			lineNumberReader.skip(Long.MAX_VALUE);
			totalLinesInCsv = lineNumberReader.getLineNumber();
			lineNumberReader.close();
   
		} catch (FileNotFoundException e) {
			logger.error(String.format("ERROR: Could not count lines of file '%s' because FileNotFoundException Occured", filename)); 

		} catch (IOException e) {
			logger.error("IOException Occured", e);
		}

		return totalLinesInCsv;

	}

	
	/**
	 * Create the output file using the output filename.
	 * Finds the next available filename if it's already in use.
	 * Will NOT overwrite existing data files.
	 * @param outputFilename String filename of output file to write
	 * @return String actual filename of output file
	 */
	public String createOutputFile(String outputFilename) {

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
			
		} catch (NullPointerException npe) {
			logger.error(String.format("ERROR: Failed creating Output filename '%s'!\n\n", outputFilename));
			logger.error(String.format("Attempt %d of %d to find new output name...", nameAttempt, MAX_NAME_ATTEMPTS));				
		} catch (IOException e) {
			logger.error(String.format("ERROR: The output file '%s' exists, but \n"
					+ "  1) is a directory rather than a regular file, \n"
					+ "  2) does not exist but cannot be created, or \n"
					+ "  3) cannot be opened for some other reason", outputFilename), e);
			ConvertCSV.callForHelp();
		}

		return outputFilename;
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
	public abstract Integer transformToFormat(CSVParser parser) throws IOException;
	
	public abstract String getFileExtension();
	
	protected abstract String customFileBeginning() throws IOException;
	protected abstract String customFileEnding() throws IOException;
	
	
	protected void beginNewFile() throws IOException {
		// Append trailing slash to output path
		if (!outputPath.endsWith("/"))
			outputPath += "/";

		// Combine output path and filename
		if (!outputFilename.contains(outputPath))
			outputFilename = outputPath + outputFilename;
		
		// Create the new output file
		outputFilename = createOutputFile(outputFilename);
		bw.write(this.customFileBeginning());
	}
	
	protected void endCurrentFile() throws IOException {

		// Good night, BufferedWriter.
		if (null != bw) {
			// Write the output format's last wishes into the file
			bw.write(this.customFileEnding());
			
			bw.flush();
			bw.close();
			bw = null;	
		}

		// Good night, FileWriter.
		if (null != fw) {
			fw.close();
			fw = null;	
		}

		// Good night, Gracie.
	}
	
	public void printJobStatus() {
		if (null != maxRecordsPerFile && maxRecordsPerFile > 0 && totalLinesInCsv > 0)
			System.out.printf("[%s] %.2f%% complete writing %d of %d files.\n   Converting CSV into output file '%s'\n", 
				(new Date()).toString(),
				(totalProcessedRecordCount/(double)totalLinesInCsv)*100,
				(long)((totalProcessedRecordCount/(double)totalLinesInCsv)*Math.ceil(totalLinesInCsv/maxRecordsPerFile)),
				(long)Math.ceil(totalLinesInCsv/maxRecordsPerFile),
				outputFilename);
		else
			System.out.printf("[%s] 0.00%% Beginning transform of CSV into output files.\n", 
				(new Date()).toString() );
	}
	
	/**
	 * Write a record to the file.
	 * Keeps track of the record count to manage file-splitting.
	 * 
	 * @param recordToWrite String with record content
	 * @throws IOException
	 */
	protected void write(String recordToWrite) throws IOException {
		
		// File opening
		if (0 == numRecordsInCurrentFile) 
			beginNewFile();
		
		// Tally up all the writes
		++totalProcessedRecordCount;
		++numRecordsInCurrentFile;
		
		// Write the record
		if (null != recordToWrite)
			bw.write(recordToWrite);
		
		// Open a new file?
		if (numRecordsInCurrentFile >= maxRecordsPerFile) {
			endCurrentFile();
			numRecordsInCurrentFile = 0;
			
			// Some output format classes call their own output methods, and need a little help
			if (this instanceof OutputXML) {
				beginNewFile();
				++numRecordsInCurrentFile;
			}
		}
	}
	
	
}



