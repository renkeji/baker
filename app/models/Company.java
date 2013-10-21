package models;

import java.util.Map;

import play.db.ebean.Model;

public class Company extends Model {
	
	private String name;
	private String country;
	private String description;
	private Map<String, Property> properties;
	
	public Company(String name, String country, String description) {
		this.name = name;
		this.country = country;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	
	
}