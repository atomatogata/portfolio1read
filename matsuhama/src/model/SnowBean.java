package model;

import java.sql.Timestamp;

public class SnowBean {
	private int id;
	private String name;
	private String text;
	private Timestamp created;

	public SnowBean() {
	};

	public SnowBean(int id, String name, String text, Timestamp created) {
		this.id = id;
		this.name = name;
		this.text = text;
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

}
