package com.matthewroyal.marklogic.semantics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
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
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.matthewroyal.marklogic.RDBSchemaModel.MySQLConnector;
import com.matthewroyal.marklogic.RDBSchemaModel.RDBSchemaModel;
import com.matthewroyal.marklogic.RDBSchemaModel.RDBSchemaModel.OUTPUT_TYPES;

public class ConvertCSV {

  // Class error/debug logger
  private static final Logger logger = LogManager.getLogger(ConvertCSV.class.getName());

  private static Options options;

  private static final String DEFAULT_PROPERTIES_FILENAME = "convertCsv.properties";
  private static final String DEFAULT_OUTPUT_FORMAT = "";

  // Output settings
  private static String dataOutputFormat = DEFAULT_OUTPUT_FORMAT;
  private static String outputPath = null;
  private static String dataOutputFilename = null;
  private static Boolean autogenerateOutputFilenames = false;
  private static Integer maxRecordsPerFile = null;

  // CSV input settings
  private static String csvInputDirectory = null;
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
  private static Boolean generateSemTriples = false;

  // RDB settings
  private static String sqlFilename;
  private static OUTPUT_TYPES schemaOutputType;
  private static String schemaOutputFilename = "myfile.txt"; // Default filename
  private static String dbName;
  private static String mysqlConnectionString;
  private static String ingestDatabaseType = "MySQL";
  private static String ingestDatabaseUser = "admin";
  private static String ingestDatabasePassword = "admin";

  // External 
  
  /**
   * Display the command-line help menu, then quit.
   * 
   * @param options
   *          Options data structure defining valid options.
   */
  public static void callForHelp() {
    // generate the help statement
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp(Class.class.getName(), options);
    System.exit(0);
  }

  /**
   * Parse a CSV File and transform it into the destination template
   * 
   * @param output
   *          OutputFormat class representing the format into which the CSV will
   *          be transformed.
   */
  public static void parseCSV(OutputFormat output) {

    File[] csvFilesToProcess;

    // Create the CSV Parser
    CSVParser parser;
    try {
      // Use the CSV input directory specified
      if (null != csvInputDirectory) {
        // Append trailing slash to input path
        if (!csvInputDirectory.endsWith("/"))
          csvInputDirectory += "/";

        // Open directory and list the CSV files inside
        File dir = new File(csvInputDirectory);

        // Accept only files ending with case-insensitive ".csv"
        FilenameFilter csvFilter = new FilenameFilter() {
          public boolean accept(File dir, String name) {
            return name.trim().toLowerCase().endsWith(".csv");
          }
        };
        csvFilesToProcess = dir.listFiles(csvFilter);

        if (null == csvFilesToProcess) {
          logger.error(String.format(
              "ERROR: CSV input directory '%s' is not a valid directory.",
              csvInputDirectory));
          callForHelp();
        }
      } else {
        // No directory specified, so let's use the filename specified instead
        csvFilesToProcess = new File[] { new File(csvFilename.trim()) };
      }

      // Process each CSV file
      for (File csvFile : csvFilesToProcess) {

        // Write the new data file
        if (autogenerateOutputFilenames) {
          String inputFilename = csvFile.getName();

          // Add the appropriate output file extension to the end of the
          // filename
          if (inputFilename.trim().toLowerCase().lastIndexOf(".csv") == inputFilename
              .length() - 4) {
            inputFilename = inputFilename.substring(0,
                inputFilename.length() - 4) + output.getFileExtension();
          } else {
            inputFilename = inputFilename + output.getFileExtension();
          }

          // Tell the output format class what the output filename should be
          dataOutputFilename = inputFilename;
          output.setOutputPath(outputPath, inputFilename);
        }

        // TODO throwing IOException for some reason
        // Build CSV parser with the specified options
        parser = new CSVParser(new FileReader(csvFile),
            (hasHeaderInFile) ? CSVFormat.DEFAULT.withHeader()
                : ((null != userDefinedHeader) ? CSVFormat.DEFAULT
                    .withHeader(userDefinedHeader) : null));

        // Transform!
        OutputFormat.numRecordsInCurrentFile = 0;
        output.countLineNumber(csvFile);
        output.transformToFormat(parser);
        if (null != parser) {
          parser.close();
          parser = null;
        }
      }

    }
    catch (FileNotFoundException e) {
      logger.error(String.format("ERROR: Failed to find input CSV file '%s'.\n\n", csvFilename));
      callForHelp();

    }
    catch (SecurityException se) {
      logger.error(String.format("ERROR: Filesystem permissions prevent using CSV input directory '%s'.\n\n", csvInputDirectory));
      callForHelp();

    }
    catch (IOException e) {
      logger.error(String.format("ERROR: The output file '%s' exists, but \n"
          + "  1) is a directory rather than a regular file, \n"
          + "  2) does not exist but cannot be created, or \n"
          + "  3) cannot be opened for some other reason\n\n",
          dataOutputFilename), e);
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
    options.addOption(OptionBuilder.withLongOpt("properties-file")
        .withDescription(String.format("set properties file name [%s]", DEFAULT_PROPERTIES_FILENAME))
        .hasArg().withArgName("FILENAME").create());
    options.addOption(OptionBuilder.withLongOpt("csv-input-directory")
        .withDescription("The absolute path of a folder containing 1 or more CSV files for ingest. Overrides csv-filename!")
        .hasArg().withArgName("CSVFILENAME").create());
    options.addOption(OptionBuilder.withLongOpt("csv-filename")
        .withDescription("File name of the CSV file to read as input.")
        .hasArg().withArgName("CSVFILENAME").create());
    options.addOption(OptionBuilder.withLongOpt("has-header")
        .withDescription("The first line of the CSV file contains a comma separated list of column names.")
        .create());
    options.addOption(OptionBuilder.withLongOpt("define-header")
        .withDescription("Specify the header by command line with comma separated list. \"ColumnID,Column1,Column2,Column3\"")
        .hasArg().withArgName("DEFINITION-STRING").create());

    options.addOption(OptionBuilder.withLongOpt("template-file")
        .withDescription("File name of template file to use.").hasArg()
        .withArgName("TEMPLATEFILENAME").create());
    options.addOption(OptionBuilder.withLongOpt("template-header")
        .withDescription("Header content to insert at the beginning of each template output file.")
        .hasArg().withArgName("HEADER").create());
    options.addOption(OptionBuilder.withLongOpt("template-footer")
        .withDescription("Footer content to insert at the end of each template output file.")
        .hasArg().withArgName("FOOTER").create());
    options.addOption(OptionBuilder.withLongOpt("output-format")
        .withDescription("Type to convert into: SEMTRIPLE, TEMPLATE, XML")
        .hasArg().withArgName("TYPE").create());
    options.addOption(OptionBuilder.withLongOpt("output-path")
        .withDescription("Output directory for output files as absolute filesystem path.")
        .hasArg().withArgName("PATH").create());
    options.addOption(OptionBuilder.withLongOpt("output-filename")
        .withDescription("Filename to store converted content.").hasArg()
        .withArgName("FILENAME").create());
    options.addOption(OptionBuilder.withLongOpt("output-filename-auto")
        .withDescription("Automatically generate output filenames based on the name of each input CSV file.")
        .hasArg().withArgName("BOOLEAN").create());
    options.addOption(OptionBuilder.withLongOpt("output-record-num")
        .withDescription("Maximum number of transformed records to write to the output file before starting a new output file.")
        .hasArg().withArgName("NUMRECORDS").create());

    options.addOption(OptionBuilder.withLongOpt("xml-namespace")
        .withDescription("Default namespace URI for XML output file.").hasArg()
        .withArgName("URI").create());
    options.addOption(OptionBuilder.withLongOpt("xml-namespace-prefix")
        .withDescription("Prefix name for XML default namespace.").hasArg()
        .withArgName("PREFIX").create());
    options.addOption(OptionBuilder.withLongOpt("xml-root")
        .withDescription("Element name for root of XML output file.").hasArg()
        .withArgName("ELEMENTNAME").create());
    options.addOption(OptionBuilder.withLongOpt("xml-record")
        .withDescription("Element name for each output CSV record.").hasArg()
        .withArgName("ELEMENTNAME").create());
    options.addOption(OptionBuilder.withLongOpt("generate-triples")
        .withDescription("Should the code attempt to generate MarkLogic sem:triple nodes inside the resulting output document? (True/false)")
        .hasArg().withArgName("BOOLEAN").create());

    // Schema ingestion options
    options.addOption(OptionBuilder.withLongOpt("sql-file")
        .withDescription("Filename of MySQL SQL file containing CREATE TABLE statements to ingest.")
        .hasArg().withArgName("SQLFILE").create());
    // options.addOption( OptionBuilder.withLongOpt( "sql-file-type" )
    // .withDescription( "SQL Language to ingest: MYSQL, ORACLE, etc." )
    // .hasArg().withArgName("SQLFILETYPE").create() );
    options.addOption(OptionBuilder.withLongOpt("mysql-connection-string")
        .withDescription("Connect to this MySQL database and generate CREATE TABLE statements for [database-name] to ingest. "
                          + "Example: jdbc:mysql://localhost/northwind?user=root&password=admin")
        .hasArg().withArgName("CONNECTION_STRING").create());
    options.addOption(OptionBuilder.withLongOpt("schema-output-type")
        .withDescription("Format of output schema: " + StringUtils.join(OUTPUT_TYPES.values(), ", ")).hasArg()
        .withArgName("FORMAT").create());
    options.addOption(OptionBuilder.withLongOpt("schema-output-filename")
        .withDescription(String.format("Filename for output schema. (Default=[%s])", schemaOutputFilename))
        .hasArg().withArgName("OUTFILE").create());
    options.addOption(OptionBuilder.withLongOpt("database-name")
        .withDescription("Name of database to ingest (over JDBC) and for output schema. (Default=[sql-file])")
        .hasArg().withArgName("DBNAME").create());
        
    // External database connectivity options
    options.addOption(OptionBuilder.withLongOpt("ingest-database-type")
        .withDescription("Type of database to ingest (MySQL). (Default=[MySQL])")
        .hasArg().withArgName("DBTYPE").create());
    options.addOption(OptionBuilder.withLongOpt("ingest-database-user")
        .withDescription("User name to use when connecting to external database.")
        .hasArg().withArgName("DBUSER").create());
    options.addOption(OptionBuilder.withLongOpt("ingest-database-password")
        .withDescription("Password to use when connecting to external database.")
        .hasArg().withArgName("DBPASS").create());

  }

  /**
   * Load the options specified on the command line.
   * 
   * @param args String[] command line options from main(String[] args) function
   * @return String properties filename, if specified
   */
  private static String loadCLIOptions(String[] args) {

    String propsFilename = null;

    // Read in command-line options
    CommandLine cmd;
    CommandLineParser parser = new GnuParser();
    try {
      cmd = parser.parse(options, args);

      // Get properties filename
      if (cmd.hasOption("properties-file")) { propsFilename = cmd.getOptionValue("properties-file"); }

      // Get other run-time options
      if (cmd.hasOption("csv-input-directory")) { csvInputDirectory = cmd.getOptionValue("csv-input-directory"); }
      if (cmd.hasOption("csv-filename")) { csvFilename = cmd.getOptionValue("csv-filename"); }
      if (cmd.hasOption("has-header")) { hasHeaderInFile = true; }
      if (cmd.hasOption("define-header")) { userDefinedHeader = cmd.getOptionValue("define-header"); }

      if (cmd.hasOption("template-file")) { templateFilename = cmd.getOptionValue("template-file"); }
      if (cmd.hasOption("template-header")) { templateHeader = cmd.getOptionValue("template-header"); }
      if (cmd.hasOption("template-footer")) { templateFooter = cmd.getOptionValue("template-footer"); }

      if (cmd.hasOption("output-format")) { dataOutputFormat = cmd.getOptionValue("output-format"); }
      if (cmd.hasOption("output-path")) { outputPath = cmd.getOptionValue("output-path"); }
      if (cmd.hasOption("output-filename")) { dataOutputFilename = cmd.getOptionValue("output-filename"); }
      if (cmd.hasOption("output-filename-auto")) { autogenerateOutputFilenames = Boolean.parseBoolean(cmd.getOptionValue("output-filename-auto")); }
      if (cmd.hasOption("output-record-num")) { maxRecordsPerFile = Integer.parseInt(cmd.getOptionValue("output-record-num")); }

      if (cmd.hasOption("xml-namespace")) { namespace = cmd.getOptionValue("xml-namespace"); }
      if (cmd.hasOption("xml-namespace-prefix")) { namespacePrefix = cmd.getOptionValue("xml-namespace-prefix"); }
      if (cmd.hasOption("xml-root")) { rootElementName = cmd.getOptionValue("xml-root"); }
      if (cmd.hasOption("xml-record")) { recordElementName = cmd.getOptionValue("xml-record"); }
      if (cmd.hasOption("generate-triples")) { generateSemTriples = Boolean.parseBoolean(cmd.getOptionValue("generate-triples")); }

      // Schema ingestion options // TODO get rid of static access to these values
      if (cmd.hasOption("sql-file")) { sqlFilename = cmd.getOptionValue("sql-file"); }
      if (cmd.hasOption("schema-output-type")) { schemaOutputType = OUTPUT_TYPES.valueOf(cmd.getOptionValue("schema-output-type")); }
      if (cmd.hasOption("schema-output-filename")) { schemaOutputFilename = cmd.getOptionValue("schema-output-filename"); }
      if (cmd.hasOption("database-name")) { dbName = cmd.getOptionValue("database-name"); }

      // External database connectivity options
      if (cmd.hasOption("mysql-connection-string")) { mysqlConnectionString = cmd.getOptionValue("mysql-connection-string"); }
      if (cmd.hasOption("ingest-database-type")) { ingestDatabaseType = cmd.getOptionValue("ingest-database-type"); }
      if (cmd.hasOption("ingest-database-user")) { ingestDatabaseUser = cmd.getOptionValue("ingest-database-user"); }
      if (cmd.hasOption("ingest-database-password")) { ingestDatabasePassword = cmd.getOptionValue("ingest-database-password"); }

      // Higher-level sanity checks
      if (null != dataOutputFilename && null == outputPath) { 
        throw new ParseException("When output-filename is used, output-path must also be specified."); 
      }

    }
    catch (ParseException e1) {
      logger.error("ERROR: Incoming arguments just aren't cutting the mustard!\n\n", e1);
      callForHelp();
    }

    return propsFilename;
  }

  /**
   * Load properties from the specified properties file
   */
  public static void loadProperties(String propsFilename) {

    // Sanity check
    if (null == propsFilename || propsFilename.trim().length() <= 0)
      return;

    // Load properties file
    File propFile = new File(propsFilename);
    Properties properties = new Properties();

    try {
      FileInputStream propertiesFI = new FileInputStream(propFile);
      properties.load(propertiesFI);

      // Get properties filename
      if (properties.containsKey("csv-input-directory")) { csvInputDirectory = properties.getProperty("csv-input-directory"); }
      if (properties.containsKey("csv-filename")) { csvFilename = properties.getProperty("csv-filename"); }
      if (properties.containsKey("has-header")) { hasHeaderInFile = true; }
      if (properties.containsKey("define-header")) { userDefinedHeader = properties.getProperty("define-header"); }

      if (properties.containsKey("template-file")) { templateFilename = properties.getProperty("template-file"); }
      if (properties.containsKey("template-header")) { templateHeader = properties.getProperty("template-header"); }
      if (properties.containsKey("template-footer")) { templateFooter = properties.getProperty("template-footer"); }

      if (properties.containsKey("output-format")) { dataOutputFormat = properties.getProperty("output-format"); }
      if (properties.containsKey("output-path")) { outputPath = properties.getProperty("output-path"); }
      if (properties.containsKey("output-filename")) { dataOutputFilename = properties.getProperty("output-filename"); }
      if (properties.containsKey("output-filename-auto")) { autogenerateOutputFilenames = Boolean.parseBoolean(properties.getProperty("output-filename-auto")); }
      if (properties.containsKey("output-record-num")) { maxRecordsPerFile = Integer.parseInt(properties.getProperty("output-record-num")); }

      if (properties.containsKey("xml-namespace")) { namespace = properties.getProperty("xml-namespace"); }
      if (properties.containsKey("xml-namespace-prefix")) { namespacePrefix = properties.getProperty("xml-namespace-prefix"); }
      if (properties.containsKey("xml-root")) { rootElementName = properties.getProperty("xml-root"); }
      if (properties.containsKey("xml-record")) { recordElementName = properties.getProperty("xml-record"); }
      if (properties.containsKey("generate-triples")) { generateSemTriples = Boolean.parseBoolean(properties.getProperty("generate-triples")); }

      // Schema ingestion options
      if (properties.containsKey("sql-file")) { sqlFilename = properties.getProperty("sql-file"); }
      // if (properties.containsKey( "sql-filetype" )) { sqlFiletype =
      // properties.getProperty( "sql-filetype" ); }
      if (properties.containsKey("schema-output-type")) { schemaOutputType = OUTPUT_TYPES.valueOf(properties.getProperty("schema-output-type")); }
      if (properties.containsKey("schema-output-filename")) { schemaOutputFilename = properties.getProperty("schema-output-filename"); }
      if (properties.containsKey("database-name")) { dbName = properties.getProperty("database-name"); }

      // External database connectivity options
      if (properties.containsKey("mysql-connection-string")) { mysqlConnectionString = properties.getProperty("mysql-connection-string"); }
      if (properties.containsKey("ingest-database-type")) { ingestDatabaseType = properties.getProperty("ingest-database-type"); }
      if (properties.containsKey("ingest-database-user")) { ingestDatabaseUser = properties.getProperty("ingest-database-user"); }
      if (properties.containsKey("ingest-database-password")) { ingestDatabasePassword = properties.getProperty("ingest-database-pass"); }

      // Close properties file
      propertiesFI.close();

    }
    catch (SecurityException se) {
      logger.error(String.format(
        "ERROR: Security restrictions are denying read access to the properties file '%s'.",
        propsFilename
      ));
    }
    catch (NullPointerException npe) {
      logger.error(String.format(
        "WARNING: That properties file '%s' doesn't exist!\n\n",
        propsFilename));
    }
    catch (FileNotFoundException fnf) {
      logger.error(String.format(
          "WARNING: That properties file '%s' doesn't exist!\n\n",
          propsFilename));
    }
    catch (IllegalArgumentException iae) {
      logger.error(String.format(
          "ERROR: Sweet biscuits of mercy! The properties file '%s' contains a malformed Unicode escape sequence!\n\n",
          propsFilename));
      System.exit(0);
    }
    catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {

    OutputFormat output;
    OutputMonitor monitor;

    RDBSchemaModel model = null;

    // Properties file overrides command-line options
    buildCLIOptions();
    if (null != args)
      loadProperties(loadCLIOptions(args));

    // Ingest the schema
    if (null != sqlFilename || null != mysqlConnectionString) {
      // Build the schema model
      if (null != mysqlConnectionString) {
        model = new RDBSchemaModel(schemaOutputFilename, dbName);
        
        // Add user parameter to connection string
        if (!mysqlConnectionString.contains("user=") 
            && ingestDatabaseUser != null && ingestDatabaseUser != "")
          mysqlConnectionString +=
            mysqlConnectionString 
            + ((mysqlConnectionString.contains("?")) ? "&user=" : "?user=" )
            + ingestDatabaseUser;
        
        // Add password parameter to connection string
        if (!mysqlConnectionString.contains("password=") 
            && ingestDatabasePassword != null && ingestDatabasePassword!= "")
          mysqlConnectionString +=
            mysqlConnectionString 
            + ((mysqlConnectionString.contains("?")) ? "&password=" : "?password=" )
            + ingestDatabasePassword;
      }
      else
        model = new RDBSchemaModel(sqlFilename, schemaOutputFilename, dbName);

      try {
        // Parse the schema
        if (null != mysqlConnectionString) {
          MySQLConnector mysql = new MySQLConnector(mysqlConnectionString);
          String sqlString = mysql.readDataBaseSchema(dbName);
          model.parseSchemaString(sqlString);
        }
        else
          model.parseSchema(sqlFilename);

        // Output the schema
        model
            .printSchema(
                schemaOutputType,
                ((outputPath.substring(outputPath.length() - 1) == "/") ? outputPath
                    : outputPath + "/")
                    + schemaOutputFilename, dbName);

        logger.info(String.format("Finished exporting schema as %s to %s.",
            schemaOutputType.toString(), schemaOutputFilename));
      }
      catch (IllegalArgumentException | IOException e) {
        logger.error(String.format(
            "Failed to parse SQL file [%s] for some reason.", sqlFilename), e);
        callForHelp();
      }
    }

    // Handle different output types
    switch (dataOutputFormat) {

      case "JSON":
        logger.info(String.format(
            "Output format [%s] not yet implemented. Please use TEMPLATE for this instead.\n\n",
            dataOutputFormat));
        break;

      case "SEMTRIPLE":
        logger.info(String.format("Output format [%s]\n", dataOutputFormat));
        output = new OutputSemTriple(dataOutputFilename, outputPath, namespace,
            maxRecordsPerFile);
        monitor = new OutputMonitor(output, 5);
        parseCSV(output);
        monitor.cancelTimer();
        break;

      case "TEMPLATE":
        logger.info(String.format("Output format: [%s]\n", dataOutputFormat));
        if (null == templateFilename) {
          logger.error("ERROR: Missing template-file definition!\n");
          callForHelp();
        }

        output = new OutputTemplate(dataOutputFilename, outputPath,
            templateFilename, templateHeader, templateFooter, maxRecordsPerFile);
        monitor = new OutputMonitor(output, 5);
        parseCSV(output);
        monitor.cancelTimer();
        break;

      case "XML":
        logger.info(String.format("Output format [%s]\n", dataOutputFormat));

        output = new OutputXML(dataOutputFilename, outputPath, namespace,
            namespacePrefix, rootElementName, recordElementName,
            generateSemTriples, maxRecordsPerFile, model);
        monitor = new OutputMonitor(output, 5);
        parseCSV(output);
        monitor.cancelTimer();
        break;

      default:
        // They clearly didn't invoke the software correctly.
        if (null == sqlFilename)
          callForHelp();
        break;
    }
  }

}
