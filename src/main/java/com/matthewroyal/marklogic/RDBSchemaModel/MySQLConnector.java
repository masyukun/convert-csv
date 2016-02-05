/**
 * Use a MySQL database connection to extract schema information from a database 
 */
package com.matthewroyal.marklogic.RDBSchemaModel;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * @author mroyal
 *
 */
public class MySQLConnector {

  private static Logger logger = LogManager.getLogger( MySQLConnector.class.getClass() );

  public ArrayList<String> tables = new ArrayList<String>();
  private String databaseName;
  
  // MySQL database connection stuff
  private String connectionString = null;
  private Connection connect = null;
  
  // Get all the tables of the desired MySQL database 
  private String selectMySqlSchema = 
    "SELECT 'mysql' dbms,t.TABLE_SCHEMA,t.TABLE_NAME "
    + " FROM INFORMATION_SCHEMA.TABLES t "
    + " WHERE t.TABLE_TYPE='BASE TABLE' "
    + "   AND t.TABLE_SCHEMA NOT IN('INFORMATION_SCHEMA','mysql') "
    + "   AND t.TABLE_SCHEMA = ? "
    + " ORDER BY dbms desc, t.TABLE_SCHEMA desc, t.TABLE_NAME asc ";

  // A fast way of estimating the number of rows in a table -- count(*) is just TOO SLOW for tables will millions of records.
  private String estimateTableSize = 
      "SELECT TABLE_ROWS AS 'numRows' FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s'; ";
  
  // Get everything from the table, ordered by the table's primary key
  private String selectAllFromTable = 
      "SELECT * FROM `%s`.`%s`;";// ORDER BY ? ASC;";


  /**
   * Pass in the connection string
   * @param connectionString MySQL connection string
   */
  public MySQLConnector(String connectionString) { 
    this.connectionString = connectionString.trim();
    
    initMySQL();
  }

  /**
   * Pass in connection string and databasename
   * @param connectionString MySQL connection string
   * @param databasename Name of MySQL database to use
   */
  public MySQLConnector(String connectionString, String databasename) { 
    this.connectionString = connectionString.trim();
    this.databaseName = databasename.trim();

    initMySQL();
}

  /**
   * Init the MySQL driver //TODO: look into alternatives -- I don't remember ever doing it this way before...
   */
  private void initMySQL() {
    // Load the MySQL driver
    try {
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch (ClassNotFoundException e) {
      logger.error("Couldn't find the MySQL database driver com.mysql.jdbc.Driver. Could be that your lib directory is missing the connector JAR.", e);
      System.exit(1);
    }
  }
  
  public String getdatabaseName() {
    return databaseName;
  }

  
  
  
  /**
   * Read the specified schema from MySQL database
   * @param databaseName String name of the target MySQL database
   * @return String Content of MySQL database schema as CREATE TABLE statements
   * @throws Exception
   */
  public String readDataBaseSchema(String databaseName) {

    // Store for later use
    this.databaseName = databaseName.trim();

    return readDataBaseSchema();
  }
  
  /**
   * Read the specified schema from MySQL database.
   * Must have previously set the databasename to use this function.
   * @return String Content of MySQL database as CREATE TABLE statements
   */
  public String readDataBaseSchema() {
    
    // Sanity check
    if (null == databaseName || databaseName.length() <= 0)
      throw new InvalidParameterException("You MUST specify a databasename.");

    
    // Connect, if needed
    connect();
    
    // Populate the select schema SQL with the specified database name
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      preparedStatement = connect.prepareStatement(selectMySqlSchema);
      preparedStatement.setString(1, databaseName);
      resultSet = preparedStatement.executeQuery();
    }
    catch (SQLException e) {
      logger.error(String.format("Failed getting the tables for database [%s]. Check that this mysql user has the required permissions.", databaseName), e);
      System.exit(1);
    }
    
    // Get the CREATE TABLE statement for each table from the database
    String createTableSqlString = "";
    String TABLE_NAME = "";
    try {
      while (resultSet.next()) {
        
        // Get and save the table name
        TABLE_NAME = resultSet.getString("t.TABLE_NAME");
        tables.add(TABLE_NAME);
        
        // I wanted to use a PreparedStatement here, but setString() encapsulates with single quotes, which is a syntax error here.
        preparedStatement = connect.prepareStatement("show create table `"+databaseName+"`.`"+TABLE_NAME+"`;"); 
        ResultSet createTableResult = preparedStatement.executeQuery();
        
        while (createTableResult.next()) {
          String createTableString = createTableResult.getString("Create Table");
          createTableSqlString += createTableString + ";\n\n";
        }
          
      }
    }
    catch (SQLException e) {
      logger.error(String.format(
          "Failed generating the CREATE TABLE code for `%s`.`%s`. The user may not have adequate permissions.", 
          databaseName, TABLE_NAME) ,e);
      System.exit(1);
    }

    close(resultSet, preparedStatement, connect);
    logger.debug(createTableSqlString);

    return createTableSqlString;
  }

  
  /**
   * Estimate how many rows the table contains.
   * Faster than a count(*), but not guaranteed to be 100% accurate.
   * @return BigInteger, because it's possible to exceed the size of an Integer
   */
  public BigInteger estimateTableSize(String tableName) {

    // Sanity check
    if (null == databaseName || databaseName.length() <= 0) {
      throw new InvalidParameterException("You MUST specify a databaseName.");
    } else if (null == tableName || tableName.length() <= 0) {
      throw new InvalidParameterException("You MUST specify a tableName to get an estimate of its size.");
    }
    
    // If necessary
    connect();
    
    // Populate the estimation SQL with the specified database name and table name
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      logger.debug(String.format(estimateTableSize, databaseName, tableName));
      preparedStatement = connect.prepareStatement(String.format(estimateTableSize, databaseName, tableName));
      resultSet = preparedStatement.executeQuery();
    }
    catch (SQLException e) {
      logger.error(String.format("Failed getting the estimate for database table `%s`.`%s`. "
          + "Check that this mysql user has the required permissions and that the table exists.", databaseName, tableName), e);
      System.exit(1);
    }
    
    // Get the estimate for the specified table
    BigInteger tableRowEstimate = null;
    try {
      while (resultSet.next()) { 
        tableRowEstimate = new BigInteger( resultSet.getString("numRows").trim() );
      }
    }
    catch (SQLException e) {
      logger.error("Failed to read the row estimate for `%s`.`%s` from the ResultSet.", e);
    }
    
    return tableRowEstimate; 
  }
  
  /**
   * Get a ResultSet that will load each row from the specified database table
   * @param databaseName
   * @param tableName
   * @return
   */
  public ResultSet selectAllFromTable(String databaseName, String tableName) {

    // Sanity check
    if (null == databaseName || databaseName.length() <= 0) {
      throw new InvalidParameterException("You MUST specify a databaseName.");
    } else {
      this.databaseName = databaseName;
    }
    if (null == tableName || tableName.length() <= 0) {
      throw new InvalidParameterException("You MUST specify a table, and it must have a tableName in order to SELECT all its data.");
    }
    
    // If needed
    connect();

    // Populate the estimation SQL with the specified database name and table name
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      logger.debug(String.format(selectAllFromTable, databaseName, tableName));
      preparedStatement = connect.prepareStatement(String.format(selectAllFromTable, databaseName, tableName));
      resultSet = preparedStatement.executeQuery();
    }
    catch (SQLException e) {
      logger.error(String.format("Failed to SELECT * from database table `%s`.`%s`. "
          + "Check that this mysql user has the required permissions and that the table exists.", databaseName, tableName), e);
      System.exit(1);
    }

    return resultSet;
  }
  
  
  

  /**
   * Connect to the database, if needed //TODO replace with connection pool
   */
  private void connect() {
    // Setup the connection with the DB
    try {
      if (null == connect || !connect.isValid(0))
        connect = DriverManager.getConnection(connectionString);
    }
    catch (SQLException e) {
      logger.error(String.format("Couldn't connect to the MySQL database with that connection string [%s]", connectionString), e); //TODO possible security problem -- password in log files
      System.exit(1);
    }
  }
  
  /**
   *  You need to close the resultSet
   * @param resultSet close this
   * @param preparedStatement close this
   * @param connect close this
   */
  private void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connect) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (preparedStatement != null) {
        preparedStatement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

  
  
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {

    BigInteger maxPrintLines = new BigInteger("20");
    String databaseName = "northwind";
    
    try {
      MySQLConnector mconn = new MySQLConnector("jdbc:mysql://localhost/northwind?" + "user=root&password=admin");
      logger.debug( mconn.readDataBaseSchema(databaseName) );
      
      for (String tableName : mconn.tables) {
        BigInteger tableSize = mconn.estimateTableSize(tableName);
        Integer maxLines = Integer.parseInt(maxPrintLines.toString());

        // Set table size for printing
        if (tableSize.compareTo(maxPrintLines) == -1) {
          maxLines = Integer.parseInt(tableSize.toString());
        }
        
        
        // Query the table
        ResultSet rs = mconn.selectAllFromTable(databaseName, tableName);
        Integer numColumns = rs.getMetaData().getColumnCount();
        System.out.println(
            String.format("\nTable `%s`.`%s` has %s rows (estimate) %d columns, showing %d rows\n==============", 
                databaseName, tableName, tableSize.toString(), numColumns, maxLines)
        );
        
        
        // Get each record
        for (int ii = 0; ii < maxLines; ++ii) {
          rs.next();
          
          // Get each column
          for (int jj = 1; jj <= numColumns; ++jj) {
            Object columnData = rs.getObject(jj);
            System.out.print((null != columnData) ? columnData.toString() + "|" : "NULL|");
          }
          System.out.print("\n");
        }
        
      }
    }
    catch (Exception e) {
      logger.error("Whoopsadaisy! Failed to read the database schema.", e);
    }
  }

}
