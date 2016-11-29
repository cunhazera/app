package com.app.impost;

import java.sql.SQLException;

public interface Impost {

	int id();

	String name() throws SQLException;

	float percentage() throws SQLException;

}
