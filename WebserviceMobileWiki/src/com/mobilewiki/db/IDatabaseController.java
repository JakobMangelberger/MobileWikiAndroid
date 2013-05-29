package com.mobilewiki.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDatabaseController {

	public abstract ResultSet getResultSet(String query) throws SQLException;

	public abstract int executeUpdate(String query) throws SQLException;

	public abstract void closeConnectionStatement();

	public abstract String getDb_username();

	public abstract void setDb_username(String db_username);

	public abstract String getDb_password();

	public abstract void setDb_password(String db_password);

	public abstract String getDb_driver();

	public abstract void setDb_driver(String db_driver);

	public abstract String getDb_url();

	public abstract void setDb_url(String db_url);

	public abstract Connection getConnection();

	public abstract void setConnection(Connection connection);

	public abstract Statement getStatement();

	public abstract void setStatement(Statement statement);

}