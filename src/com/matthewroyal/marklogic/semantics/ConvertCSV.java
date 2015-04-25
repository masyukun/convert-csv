package com.matthewroyal.marklogic.semantics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class ConvertCSV {

	private static Options options;
	
	private static String defaultPropertiesFilename = "convertCsv.properties";
	private static String defaultOutputFormat = "";
	
	private static String propsFilename = defaultPropertiesFilename;
	private static String outputFormat = defaultOutputFormat;
	private static String outputFilename = null;
	private static String csvFilename = null;
	private static Boolean hasHeaderInFile = false;
	private static String userDefinedHeader = null;
	private static String templateFilename = null;
	private static String templateHeader = "";
	private static String templateFooter = "";
	

	
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
	
	
	/**
	 * Display the command-line help menu, then quit.
	 * 
	 * @param options Options data structure defining valid options.
	 */
	public static void callForHelp(Options options) {
		// generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( Class.class.getName(), options );
		System.exit(0);
	}
	
	
	/**
	 * Parse a CSV File and transform it into the destination template
	 * @param csvFilename String representing the CSV filename on disk.
	 * @param hasHeaderInFile Boolean whether first line in CSV contains column names.
	 * @param userDefinedHeader String define your own column as a comma separated String.
	 * @param templateFilname String representing the template filename on disk.
	 */
	public static void writeCsvUsingTemplate(String csvFilename, Boolean hasHeaderInFile, String userDefinedHeader) {
		CSVParser parser;
		Integer numLines = 0;
		
		
		// Default output filename
		if (null == outputFilename && null != csvFilename) {
			outputFilename = csvFilename + ".out";
		}
	
		
		// Load template file as a String
		String templateFile = null;
		
		try {
			templateFile = readFile(templateFilename);
			
		} catch (IOException e) {
			System.out.printf("ERROR: Template file '%s' doesn't exist or can't be opened!\n\n", templateFilename);
			callForHelp(options);
		}
		
		
		// Create the output file, if it doesn't exist
		File outputFile;
		FileWriter fw;
		BufferedWriter bw = null;
		try {
			outputFile = new File(outputFilename);
			if (!outputFile.exists()) { outputFile.createNewFile(); }
			fw = new FileWriter(outputFile.getAbsoluteFile());
			bw = new BufferedWriter(fw);
		} catch (NullPointerException npe) {
			System.out.printf("ERROR: Failed creating Output filename '%s'!\n\n", outputFilename);
			callForHelp(options);
		} catch (IOException e) {
			System.out.printf("ERROR: The output file '%s' exists, but \n"
					+ "  1) is a directory rather than a regular file, \n"
					+ "  2) does not exist but cannot be created, or \n"
					+ "  3) cannot be opened for some other reason", outputFilename);
			callForHelp(options);
		}
	
		
		// Create the CSV Parser
		try {
			parser = new CSVParser(
				new FileReader(csvFilename),
				(hasHeaderInFile) 
					? CSVFormat.DEFAULT.withHeader() 
					: ((null != userDefinedHeader) 
							? CSVFormat.DEFAULT.withHeader( userDefinedHeader ) 
							: null));

			HashMap<String,Integer> header = (HashMap<String, Integer>) parser.getHeaderMap();
		
			
			// Write the header, if applicable
			if (null != templateHeader && templateHeader.length() > 0)
				bw.write(templateHeader);
			
			// Parse the CSV file
			for (CSVRecord record : parser) {

				String rowFile = new String(templateFile);

				// Parse each value in header
				for (String h : header.keySet()) {
//					System.out.printf("  Reading column [%s]: %s\n", h, record.get(h));
					rowFile = rowFile.replaceAll("\\{"+h+"\\}", record.get(h));
				}

				System.out.println(rowFile);
				bw.write(rowFile);
				
				++numLines;
		    }
			parser.close();

			// Write the footer, if applicable
			if (null != templateFooter && templateFooter.length() > 0)
				bw.write(templateFooter);

			bw.close();
			
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		// Define the command-line options
		CommandLine cmd;
		options = new Options();
		options.addOption( OptionBuilder.withLongOpt( "properties-file" )
                .withDescription( String.format("set properties file name [%s]", defaultPropertiesFilename) )
                .hasArg().withArgName("FILENAME").create() );
		options.addOption( OptionBuilder.withLongOpt( "csv-filename" )
                .withDescription( "File name of the CSV file to read as input." )
                .hasArg().withArgName("CSVFILENAME").create() );
		options.addOption( OptionBuilder.withLongOpt( "has-header" )
                .withDescription( "The first line of the CSV file contains a comma separated list of column names." )
                .create() );
		options.addOption( OptionBuilder.withLongOpt( "define-header" )
                .withDescription( "Specify the header by command line with comma separated list. \"ColumnID,Column1,Column2,Column3\"" )
                .hasArg().withArgName("DEFINITION-STRING").create() );
		options.addOption( OptionBuilder.withLongOpt( "template-file" )
                .withDescription( "File name of template file to use." )
                .hasArg().withArgName("TEMPLATEFILENAME").create() );
		options.addOption( OptionBuilder.withLongOpt( "template-header" )
                .withDescription( "Header content to insert at the beginning of each template output file." )
                .hasArg().withArgName("HEADER").create() );
		options.addOption( OptionBuilder.withLongOpt( "template-footer" )
                .withDescription( "Footer content to insert at the end of each template output file." )
                .hasArg().withArgName("FOOTER").create() );
		options.addOption( OptionBuilder.withLongOpt( "output-format" )
                .withDescription( "Type to convert into: RDF, SEMTRIPLE, TEMPLATE, XML" )
                .hasArg().withArgName("TYPE").create() );
		options.addOption( OptionBuilder.withLongOpt( "output-filename" )
                .withDescription( "Filename to store converted content." )
                .hasArg().withArgName("OUTPUTFILENAME").create() );
		
				
		// Read in command-line options
		CommandLineParser parser = new GnuParser();
		try {
			cmd = parser.parse( options, args);
		
			// Get properties filename
		    if (cmd.hasOption( "properties-file" )) { propsFilename = cmd.getOptionValue( "properties-file" ); }
		    
		    // Get other run-time options
		    if (cmd.hasOption( "csv-filename" ))    { csvFilename = cmd.getOptionValue( "csv-filename" ); }
		    if (cmd.hasOption( "has-header" ))      { hasHeaderInFile = true; }
		    if (cmd.hasOption( "define-header" ))   { userDefinedHeader = cmd.getOptionValue( "define-header" ); }
		    if (cmd.hasOption( "template-file" ))   { templateFilename = cmd.getOptionValue( "template-file" ); }
		    if (cmd.hasOption( "template-header" )) { templateHeader = cmd.getOptionValue( "template-header" ); }
		    if (cmd.hasOption( "template-footer" )) { templateFooter = cmd.getOptionValue( "template-footer" ); }
		    if (cmd.hasOption( "output-format" ))   { outputFormat = cmd.getOptionValue( "output-format" ); }
		    if (cmd.hasOption( "output-filename" )) { outputFilename = cmd.getOptionValue( "output-filename" ); }
			
			
		} catch (ParseException e1) {
			System.out.println("ERROR: Incoming arguments just aren't cutting the mustard!\n\n");
			callForHelp(options);
		}
		
		
		
		// Load properties file
		File propFile = new File(propsFilename);
		Properties properties = new Properties();

		try {
			FileInputStream propertiesFI = new FileInputStream(propFile);
			properties.load(propertiesFI);
				
			// Get properties filename
		    if (properties.containsKey( "csv-filename" ))    { csvFilename = properties.getProperty( "csv-filename" ); }
		    if (properties.containsKey( "has-header" ))      { hasHeaderInFile = true; }
		    if (properties.containsKey( "define-header" ))   { userDefinedHeader = properties.getProperty( "define-header" ); }
		    if (properties.containsKey( "template-file" ))   { templateFilename = properties.getProperty( "template-file" ); } 
		    if (properties.containsKey( "template-header" )) { templateHeader = properties.getProperty( "template-header" ); }
		    if (properties.containsKey( "template-footer" )) { templateFooter = properties.getProperty( "template-footer" ); }
		    if (properties.containsKey( "output-format" ))   { outputFormat = properties.getProperty( "output-format" ); }
		    if (properties.containsKey( "output-filename" )) { outputFilename = properties.getProperty( "output-filename" ); }

		    // Close properties file
		    propertiesFI.close();
			
		} catch (SecurityException se) {
			System.out.printf("ERROR: Security restrictions are denying read access to the properties file '%s'.", propsFilename);
		} catch (NullPointerException npe) {
			System.out.printf("WARNING: That properties file '%s' doesn't exist!\n\n", propsFilename);
		} catch (FileNotFoundException fnf) {
			System.out.printf("WARNING: That properties file '%s' doesn't exist!\n\n", propsFilename);
		} catch (IllegalArgumentException iae) {
			System.out.printf("ERROR: Sweet biscuits of mercy! The properties file '%s' contains a malformed Unicode escape sequence!\n\n", propsFilename);
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	    switch(outputFormat) {
	    case "XML":
	    	System.out.printf("Output format [%s] not yet implemented.\n\n", outputFormat);
	    	break;
	    	
	    case "SEMTRIPLE":
	    	System.out.printf("Output format [%s] not yet implemented.\n\n", outputFormat);
	    	break;
	    	
	    case "RDF":
	    	System.out.printf("Output format [%s] not yet implemented.\n\n", outputFormat);
	    	break;
	    	
	    case "TEMPLATE":
	    	System.out.printf("Output format: [%s]\n\n", outputFormat);
		    if (null == templateFilename) {
		    	System.out.println("ERROR: Missing template-file definition!\n");
				callForHelp(options);
			}
			
	    	writeCsvUsingTemplate(csvFilename, hasHeaderInFile, userDefinedHeader);
	    	break;
	    	
	    	default:
	    		callForHelp(options);
	    		break;
	    }
				
	}

}





