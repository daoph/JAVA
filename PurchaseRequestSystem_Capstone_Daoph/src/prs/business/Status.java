package prs.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Status implements Serializable {

	// the instance variables
	private int id;
	private String description;

	// constructors
	public Status() {
	}

	public Status(int id, String description) {
		this.id = id;
		this.description = description;
	}

	// set and get methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// custom methods

}
