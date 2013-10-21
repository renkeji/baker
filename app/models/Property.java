package models;

import play.db.ebean.Model;

public class Property extends Model {
	private String name;
	private String year;
	private Long data;
	
	public Property(String name, String year, Long data) {
		this.name = name;
		this.year = year;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}
	
	
}
