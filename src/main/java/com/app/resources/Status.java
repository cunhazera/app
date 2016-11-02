package com.app.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("status")
public class Status {
	
	@GET
	public String status() {
		return "Ok";
	}

}
