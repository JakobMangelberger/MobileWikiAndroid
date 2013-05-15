package com.mobilewiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseController implements IDatabaseController {
	 
	  private String db_username = "mobilewikia";
	  private String db_password = "sewm2013";
	  private String db_driver = "com.mysql.jdbc.Driver";
	  private String db_url = "jdbc:mysql://mobilewikia.unitedgosus.com/";
	  private Connection connection;
	  private Statement statement;

	  public DatabaseController() {
	    this.connectDB();
	  }

	  public DatabaseController(String username, String password) {
	    this.db_username = username;
	    this.db_password = password;
	    this.connectDB();
	  }

	  private void connectDB() {
	    try {
	      Class.forName(this.db_driver);

	      if (this.connection == null) {
	        this.connection = DriverManager.getConnection(this.db_url, this.db_username, this.db_password);
	      }

	      if (this.statement == null) {
	        this.statement = this.connection.createStatement();
	      }

	    } catch (Exception e) {
	      System.err.println(e.toString());
	      System.out.println("Error Connecting with User:" + this.db_username + " and Password:" + this.db_password);
	    }
	  }


	  @Override
	  public ResultSet getResultSet(String query) throws SQLException {
	    try {
	      ResultSet rs = this.statement.executeQuery(query);
	      return rs;

	    } catch (SQLException e) {
	      System.err.println(e.toString());
	      System.out.println("Error executing the Query:" + query);
	      return null;
	    }
	  }

	  @Override
	  public int executeUpdate(String query) throws SQLException {
	    try {
	      return this.statement.executeUpdate(query);

	    } catch (SQLException e) {
	      System.err.println(e.toString());
	      System.out.println("Error executing the Delete/Insert/Update:" + query);
	      return -1;
	    }
	  }

	  @Override
	  public void closeConnectionStatement() {
	    try {
	      if (this.connection != null) {
	        this.connection.close();
	      }

	      if (this.statement != null) {
	        this.statement.close();
	      }

	    } catch (SQLException e) {
	      System.err.println(e.toString());
	      System.out.println("Error at MySQLConnection.close().");
	    }
	  }
}
