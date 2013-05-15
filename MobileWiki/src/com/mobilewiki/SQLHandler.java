package com.mobilewiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// This class provides the interface to the mySQL database
// It has functions to get and update data in the database

public class SQLHandler {
	  // All the connection vars 
	  private String db_username = "mobilewikia";
	  private String db_password = "sewm2013";
	  private String db_driver = "com.mysql.jdbc.Driver";
	  private String db_url = "jdbc:mysql://mobilewikia.unitedgosus.com/";
	  private Connection connection;
	  private Statement statement;

	  // default Constructor
	  public SQLHandler() {
	    this.connectDB();
	  }

	  // Constructor with username and password
	  public SQLHandler(String username, String password) {
	    this.db_username = username;
	    this.db_password = password;
	    this.connectDB();
	  }

	  // initialise the connection and the statement
	  private void connectDB() {
	    try {
	      // check if the class for the driver exists in the project
	      Class.forName(this.db_driver);

	      // create connection for the DB url, username and password
	      if (this.connection == null) {
	        this.connection = DriverManager.getConnection(this.db_url, this.db_username, this.db_password);
	      }

	      // create the statement for the connection
	      if (this.statement == null) {
	        this.statement = this.connection.createStatement();
	      }

	    } catch (Exception e) {
	      // Exception handling
	      System.err.println(e.toString());
	      System.out.println("Error Connecting with User:" + this.db_username + " and Password:" + this.db_password);
	    }
	  }

	  // get the ResultSet for the query
	  //
	  // returns: either the ResultSet or null
	  public ResultSet getResultSet(String query) throws SQLException {
	    try {
	      ResultSet rs = this.statement.executeQuery(query);
	      return rs;

	    } catch (SQLException e) {
	      // Exception handling
	      System.err.println(e.toString());
	      System.out.println("Error executing the Query:" + query);
	      return null;
	    }
	  }

	  // execute the Delete/Insert/Update query
	  //
	  // returns: either the row count of the changed rows or 0 if no row changed
	  //          or -1 if there was an Exceptipon
	  public int executeUpdate(String query) throws SQLException {
	    try {
	      return this.statement.executeUpdate(query);

	    } catch (SQLException e) {
	      // Exception handling
	      System.err.println(e.toString());
	      System.out.println("Error executing the Delete/Insert/Update:" + query);
	      return -1;
	    }
	  }

	  // close the open connection and statement
	  public void closeConnectionStatement() {
	    try {
	      // close the connection
	      if (this.connection != null) {
	        this.connection.close();
	      }

	      // close the statement
	      if (this.statement != null) {
	        this.statement.close();
	      }

	    } catch (SQLException e) {
	      // Exception handling
	      System.err.println(e.toString());
	      System.out.println("Error at MySQLConnection.close().");
	    }
	  }
}
