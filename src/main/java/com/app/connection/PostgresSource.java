package com.app.connection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.Driver;

import com.jcabi.log.Logger;

public class PostgresSource implements DataSource {

	private static final Driver DRIVER = new Driver();

	public Connection getConnection() throws SQLException {
		Connection connection = DRIVER.connect(
				"jdbc:postgresql://localhost:5432/tax?user=postgres&password=password&ssl=true", new Properties());
		Logger.info(this, "Sucessfull connection");
		return connection;
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
