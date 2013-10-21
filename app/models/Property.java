package models;

import java.util.Map;

import play.db.ebean.Model;

public class Property extends Model {
	private String name;
	private Map<Integer, Figure> figures;
	private Long avg;
	
	/*
	public Property(String name, String year, Long data) {
		this.name = name;
		this.year = year;
		this.data = data;
	}
	*/
	
}
