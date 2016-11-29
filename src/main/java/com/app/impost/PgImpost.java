package com.app.impost;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;

public final class PgImpost implements Impost {

	private final DataSource dbase;
	private final int number;

	public PgImpost(DataSource data, int id) {
		this.dbase = data;
		this.number = id;
	}

	public int id() {
		return this.number;
	}

	public String name() throws SQLException {
		return new JdbcSession(this.dbase)
				.sql("SELECT nm_impost FROM impost WHERE id = ?")
				.set(this.number)
				.select(new SingleOutcome<String>(String.class));
	}

	public float percentage() throws SQLException {
		return new JdbcSession(this.dbase)
				.sql("SELECT vl_percentage FROM impost WHERE id = ?")
				.set(this.number)
				.select(new SingleOutcome<Float>(Float.class));
	}

}
