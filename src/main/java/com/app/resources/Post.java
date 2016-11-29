package com.app.resources;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.connection.PostgresSource;
import com.app.impost.Impost;
import com.app.impost.PgImposts;

@Path("post")
public final class Post {
	
	private final DataSource source = new PostgresSource();

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<Impost> post() throws SQLException {
		return new PgImposts(source).imposts();
	}
	
	@GET
	@Path("status")
	public String status() {
		return "Ok";
	}

}
