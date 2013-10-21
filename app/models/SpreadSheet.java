package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;

public class SpreadSheet extends Model {
	// Singleton object for this app?
	private List<Company> companies = new ArrayList<Company>();
	
	public SpreadSheet() {
		
	}
	
}
