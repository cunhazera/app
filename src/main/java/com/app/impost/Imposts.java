package com.app.impost;

import java.sql.SQLException;

public interface Imposts {

	Impost add(String name, long percentage) throws SQLException;

	Iterable<Impost> imposts() throws SQLException;

}
