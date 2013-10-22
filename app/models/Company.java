package models;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import play.db.ebean.Model;

public class Company extends Model {
	
	private int companyId;
	private String name;
	private String country;
	private String description;
	private Map<String, Property> properties;
	
	public Company() {
		this(0, "", "", "");
	}
	
	public Company(int companyId, String name, String country, String description) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.country = country;
		this.description = description;
		this.properties = new LinkedHashMap<String, Property>();
	}
	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	public Map<String, Property> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Property> properties) {
		this.properties = properties;
	}
	
}