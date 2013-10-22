package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import play.db.ebean.Model;

public class SpreadSheet extends Model {
	
	// Singleton object for this app?
	private List<Company> companies;
	private List<String> header;
	private Map<String, Company> companyIndex;
	
	public SpreadSheet() {
		super();
		companies = new ArrayList<Company>();
		header = new ArrayList<String>();
		companyIndex = new HashMap<String, Company>();
	}

	// Getter and Setter methods
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public Map<String, Company> getCompanyIndex() {
		return companyIndex;
	}

	public void setCompanyIndex(Map<String, Company> companyIndex) {
		this.companyIndex = companyIndex;
	}
	
}
