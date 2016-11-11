package com.app.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("post")
public class Post {
	
	@POST
	public String post() {
		return "another post";
	}

}
