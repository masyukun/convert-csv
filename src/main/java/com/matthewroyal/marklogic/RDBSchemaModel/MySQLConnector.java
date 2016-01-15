/**
 * Use a MySQL database connection to extract schema information from a database 
 */
package com.matthewroyal.marklogic.RDBSchemaModel;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * @author mroyal
 *
 */
public class MySQLConnector {

  private static Logger logger = LogManager.getLogger( MySQLConnector.class.getClass() );
  
  // MySQL database connection stuff
  private Connection connect = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  private String connectionString = null;



  /**
   * Pass in the connection string
   * @param connectionString
   */
  public MySQLConnector(String connectionString) { 
    this.connectionString = connectionString;
  }

  /**
   * Read the specified schema from MySQL database
   * @return String Content of MySQL database schema as CREATE TABLE statements
   * @throws Exception
   */
  public String readDataBaseSchema(String databasename) {
    
      // Get all the tables of the desired database 
      String selectSchema = 
          "SELECT 'mysql' dbms,t.TABLE_SCHEMA,t.TABLE_NAME "
          + " FROM INFORMATION_SCHEMA.TABLES t "
          + " WHERE t.TABLE_TYPE='BASE TABLE' "
          + "   AND t.TABLE_SCHEMA NOT IN('INFORMATION_SCHEMA','mysql') "
          + "   AND t.TABLE_SCHEMA = ? "
          + " ORDER BY dbms desc, t.TABLE_SCHEMA desc, t.TABLE_NAME asc ";
      
      
      // Load the MySQL driver
      try {
        Class.forName("com.mysql.jdbc.Driver");
      }
      catch (ClassNotFoundException e) {
        logger.error("Couldn't find the MySQL database driver com.mysql.jdbc.Driver. Could be that your lib directory is missing the connector JAR.");
        e.printStackTrace();
        System.exit(1);
      }

      // Setup the connection with the DB
      try {
        connect = DriverManager.getConnection(connectionString);
      }
      catch (SQLException e) {
        logger.error(String.format("Couldn't connect to the MySQL database with that connection string [%s]", connectionString)); //TODO possible security problem -- password in log files
        e.printStackTrace();
        System.exit(1);
      }
      
      // Populate the select schema SQL with the specified database name
      try {
        preparedStatement = connect.prepareStatement(selectSchema);
        preparedStatement.setString(1, databasename);
        resultSet = preparedStatement.executeQuery();
      }
      catch (SQLException e) {
        logger.error(String.format("Failed getting the tables for database [%s]. Check that this mysql user has the required permissions.", databasename));
        e.printStackTrace();
        System.exit(1);
      }
      
      // Get the CREATE TABLE statement for each table from the database
      String createTableSqlString = "";
      String TABLE_NAME = "";
      try {
        while (resultSet.next()) {
          TABLE_NAME = resultSet.getString("t.TABLE_NAME");

          // I wanted to use a PreparedStatement here, but setString() encapsulates with single quotes, which is a syntax error here.
          preparedStatement = connect.prepareStatement("show create table `"+databasename+"`.`"+TABLE_NAME+"`;"); 
          ResultSet createTableResult = preparedStatement.executeQuery();
          
          while (createTableResult.next()) {
            String createTableString = createTableResult.getString("Create Table");
            createTableSqlString += createTableString + ";\n\n";
          }
            
        }
      }
      catch (SQLException e) {
        logger.error("Failed generating the CREATE TABLE code for `%s`.`%s`. The user may not have adequate permissions.", databasename, TABLE_NAME);
        e.printStackTrace();
        System.exit(1);
      }

      close();
      logger.debug(createTableSqlString);

      return createTableSqlString;
  }



  // You need to close the resultSet
  private void close() {
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

    
    try {
      MySQLConnector mconn = new MySQLConnector("jdbc:mysql://localhost/northwind?" + "user=root&password=admin");
      logger.error( mconn.readDataBaseSchema("northwind") );
    }
    catch (Exception e) {
      logger.error("Whoopsadaisy! Failed to read the database schema.");
      e.printStackTrace();
    }
  }

}