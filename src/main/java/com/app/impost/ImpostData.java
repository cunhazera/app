package com.app.impost;

import java.sql.SQLException;

public final class ImpostData implements Impost {

	private final Impost impost;
	private final String name;
	private final float percentage;

	public ImpostData(Impost impost, String name, float percentage) {
		this.impost = impost;
		this.name = name;
		this.percentage = percentage;
	}

	public int id() {
		return this.impost.id();
	}

	public String name() throws SQLException {
		return this.name;
	}

	public float percentage() throws SQLException {
		return this.percentage;
	}

}
