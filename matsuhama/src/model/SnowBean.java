package model;

import java.sql.Timestamp;

public class SnowBean {
	private int id;
	private int type;
	private String discription;
	private String name;
	private String text;
	private Timestamp created;

	public SnowBean() {
	};

	public SnowBean(int id, int type, String discription, String name, String text, Timestamp created) {
		this.id = id;
		this.type = type;
		this.discription = discription;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
