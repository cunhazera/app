package com.app.resources;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.connection.PostgresSource;
import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class Status {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String tests() throws SQLException {
		DataSource source = new PostgresSource();
		String name = new JdbcSession(source).sql("SELECT NM_IMPOST FROM IMPOST")
				.select(new SingleOutcome<String>(String.class));
		return name;
	}

}
