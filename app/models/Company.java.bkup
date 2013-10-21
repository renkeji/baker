package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Company extends Model {
	
	@Id
	private Long companyId;
	private String name;
	private String country;
	private String description;
	
	public Company(String name, String country, String description) {
		this.name = name;
		this.country = country;
		this.description = description;
	}
	
	public static Model.Finder<Long, Company> find = new Model.Finder(Long.class, Company.class);
	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
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
	
	
}
