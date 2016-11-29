package com.app.impost;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.ListOutcome;
import com.jcabi.jdbc.SingleOutcome;
import com.jcabi.log.Logger;

public final class PgImposts implements Imposts {

	private DataSource source;

	public PgImposts(DataSource source) {
		this.source = source;
	}

	public Impost add(String name, long percentage) throws SQLException {
		return new PgImpost(source, new JdbcSession(source)
						.sql("insert into impost values (?, ?)")
						.set(name)
						.set(percentage)
						.insert(new SingleOutcome<Integer>(Integer.class)));
	}

	public Collection<Impost> imposts() throws SQLException {
		List<Impost> select = select();
		Logger.warn(this, String.valueOf(select.get(0).name()));
		Logger.warn(this, String.valueOf(select.get(0).id()));
		Logger.warn(this, String.valueOf(select.get(0).percentage()));
		Logger.info(this, select.get(0).toString());
		return select;
	}

	private List<Impost> select() throws SQLException {
		return new JdbcSession(this.source)
			      .sql("SELECT id, nm_impost, vl_percentage FROM impost")
			      .select(
			        new ListOutcome<Impost>(
			          new ListOutcome.Mapping<Impost>() {
			            public Impost map(final ResultSet rset) throws SQLException {
			              return new ImpostData(
		            		  			new PgImpost(
		            		  					source, rset.getInt(1)
		            		  			), rset.getString(2), rset.getFloat(3)
			            		  );
			            }
			          }
			        )
			      );
	}

}
