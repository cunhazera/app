package com.app.connection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.Driver;

public class PostgresSource implements DataSource {

	private static final String PSQL_URL = "jdbc:postgresql://localhost:5432/tax?user=postgres&password=password&ssl=true";
	private static final Driver DRIVER = new Driver();

	public Connection getConnection() throws SQLException {
		return PostgresSource.DRIVER.connect(
					PSQL_URL, new Properties()
				);
	}

	public PrintWriter getLogWriter() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public int getLoginTimeout() throws SQLException {
		throw new UnsupportedOperationException();
	}

	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new UnsupportedOperationException();
	}

	public void setLogWriter(PrintWriter arg0) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public void setLoginTimeout(int arg0) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return false;
	}

	public <T> T unwrap(Class<T> arg0) throws SQLException {
		throw new UnsupportedOperationException();
	}

	public Connection getConnection(String username, String password) throws SQLException {
		throw new UnsupportedOperationException();
	}

}
