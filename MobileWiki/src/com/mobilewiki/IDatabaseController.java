package com.mobilewiki;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseController {

	public abstract ResultSet getResultSet(String query) throws SQLException;

	public abstract int executeUpdate(String query) throws SQLException;

	public abstract void closeConnectionStatement();

}