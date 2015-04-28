package com.matthewroyal.marklogic.semantics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConvertCSV {

	private static final Logger logger = LogManager.getLogger(ConvertCSV.class.getName()); 	
	
	private static Options options;
	
	private static final String DEFAULT_PROPERTIES_FILENAME = "convertCsv.properties";
	private static final String DEFAULT_OUTPUT_FORMAT = "";
	
	// Output settings
	private static String outputFormat = DEFAULT_OUTPUT_FORMAT;
	private static String outputFilename = null;
	
	// CSV input settings
	private static String csvFilename = null;
	private static Boolean hasHeaderInFile = false;
	private static String userDefinedHeader = null;
	
	// TEMPLATE settings
	private static String templateFilename = null;
	private static String templateHeader = "";
	private static String templateFooter = "";

	// XML settings
	private static String namespace = null;
	private static String namespacePrefix = null;
	private static String rootElementName = null;
	private static String recordElementName = null;	

	
	/**
	 * Display the command-line help menu, then quit.
	 * 
	 * @param options Options data structure defining valid options.
	 */
	public static void callForHelp() {
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
	public static void parseCSV(OutputFormat output) {
		
		// Create the CSV Parser
		CSVParser parser;
		try {
			// Build CSV parser with the specified options
			parser = new CSVParser(
				new FileReader(csvFilename),
				(hasHeaderInFile) 
					? CSVFormat.DEFAULT.withHeader() 
					: ((null != userDefinedHeader) 
							? CSVFormat.DEFAULT.withHeader( userDefinedHeader ) 
							: null));

			
			// Write the new data file
			output.countLineNumber(csvFilename);
			output.transformToFormat(parser);
			if (null != parser) {
				parser.close();
				parser = null;
			}
		    
			
		} catch (FileNotFoundException e) {
			logger.error(String.format("ERROR: Failed to find input CSV file '%s'.", csvFilename));
			
		} catch (IOException e) {
			logger.error(String.format("ERROR: The output file '%s' exists, but \n"
					+ "  1) is a directory rather than a regular file, \n"
					+ "  2) does not exist but cannot be created, or \n"
					+ "  3) cannot be opened for some other reason", outputFilename), e);
			callForHelp();
		}

	}
	
	
	/**
	 * Build the options accepted on the command line
	 */
	@SuppressWarnings("static-access")
	private static void buildCLIOptions() {
		// Define the command-line options
		options = new Options();
		options.addOption( OptionBuilder.withLongOpt( "properties-file" )
                .withDescription( String.format("set properties file name [%s]", DEFAULT_PROPERTIES_FILENAME) )
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
		
		options.addOption( OptionBuilder.withLongOpt( "xml-namespace" )
                .withDescription( "Default namespace URI for XML output file." )
                .hasArg().withArgName("URI").create() );
		options.addOption( OptionBuilder.withLongOpt( "xml-namespace-prefix" )
                .withDescription( "Prefix name for XML default namespace." )
                .hasArg().withArgName("PREFIX").create() );
		options.addOption( OptionBuilder.withLongOpt( "xml-root" )
                .withDescription( "Element name for root of XML output file." )
                .hasArg().withArgName("ELEMENTNAME").create() );
		options.addOption( OptionBuilder.withLongOpt( "xml-record" )
                .withDescription( "Element name for each output CSV record." )
                .hasArg().withArgName("ELEMENTNAME").create() );
		
	}
	
	
	/**
	 * Load the options specified on the command line.
	 * @param args String[] command line options from main(String[] args) function
	 * @return String properties filename, if specified
	 */
	private static String loadCLIOptions(String[] args) {
				
		String propsFilename = null;
		
		// Read in command-line options
		CommandLine cmd;
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
		
		    if (cmd.hasOption( "xml-namespace" ))        { namespace = cmd.getOptionValue( "xml-namespace" ); }
		    if (cmd.hasOption( "xml-namespace-prefix" )) { namespacePrefix= cmd.getOptionValue( "xml-namespace-prefix" ); }
		    if (cmd.hasOption( "xml-root" ))             { rootElementName = cmd.getOptionValue( "xml-root" ); }
		    if (cmd.hasOption( "xml-record" ))           { recordElementName = cmd.getOptionValue( "xml-record" ); }
		    
		} catch (ParseException e1) {
			System.out.println("ERROR: Incoming arguments just aren't cutting the mustard!\n\n");
			callForHelp();
		}
		
		return propsFilename;
	}

	
	/**
	 * Load properties from the specified properties file
	 */
	public static void loadProperties(String propsFilename) {
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

		    if (properties.containsKey( "xml-namespace" ))        { namespace = properties.getProperty( "xml-namespace" ); }
		    if (properties.containsKey( "xml-namespace-prefix" )) { namespacePrefix = properties.getProperty( "xml-namespace-prefix" ); }
		    if (properties.containsKey( "xml-root" ))             { rootElementName = properties.getProperty( "xml-root" ); }
		    if (properties.containsKey( "xml-record" ))           { recordElementName = properties.getProperty( "xml-record" ); }

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
		
	}
	
	
	public static void main(String[] args) {

		OutputFormat output;
    	OutputMonitor monitor;
    	
    	
		// Properties file overrides command-line options
		buildCLIOptions();
		loadProperties( loadCLIOptions(args) );
		
		
		// Handle different output types
	    switch(outputFormat) {

		    case "JSON":
		    	logger.info(String.format("Output format [%s] not yet implemented.\n\n", outputFormat));
		    	break;
		    	
		    case "RDF":
		    	logger.info(String.format("Output format [%s] not yet implemented.\n\n", outputFormat));
		    	break;
		    	
		    case "SEMTRIPLE":
		    	logger.info(String.format("Output format [%s] not yet implemented.\n\n", outputFormat));
		    	break;
		    	
		    case "TEMPLATE":
		    	logger.info(String.format("Output format: [%s]\n", outputFormat));
			    if (null == templateFilename) {
			    	System.out.println("ERROR: Missing template-file definition!\n");
					callForHelp();
				}
				
			    output = new OutputTemplate(outputFilename, templateFilename, templateHeader, templateFooter);
		    	monitor = new OutputMonitor(output, 5);
		    	parseCSV(output);
		    	monitor.cancel();
			    break;
		    	
		    case "XML":
		    	logger.info(String.format("Output format [%s]\n", outputFormat));
		    	
		    	output = new OutputXML(outputFilename, namespace, namespacePrefix, rootElementName, recordElementName);
		    	monitor = new OutputMonitor(output, 5);
		    	parseCSV(output);
		    	monitor.cancel();
		    	break;
	    	
	    	default:
	    		callForHelp();
	    		break;
	    }
				
	}

}
