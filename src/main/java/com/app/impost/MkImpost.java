package com.app.impost;

public final class MkImpost implements Impost {

	private int id;
	private String name;
	private float percentage;
	
	public MkImpost(String name, float percentage) {
		this.name = name;
		this.percentage = percentage;
	}

	public int id() {
		return this.id;
	}

	public String name() {
		return this.name;
	}

	public float percentage() {
		return this.percentage;
	}

}
