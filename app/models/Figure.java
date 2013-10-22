package models;

import play.db.ebean.Model;

public class Figure extends Model {
	private String year;
	private Double value;
	
	public Figure(String year, Double value) {
		this.year = year;
		this.value = value;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
