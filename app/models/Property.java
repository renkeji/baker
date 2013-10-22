package models;

import java.util.Map;

import play.db.ebean.Model;

public class Property extends Model {
	private String name;
	private Map<String, Figure> figures;
	private Double avg;
	
	public Property(String name, Map<String, Figure> figures, Double avg) {
		super();
		this.name = name;
		this.figures = figures;
		this.avg = avg;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, Figure> getFigures() {
		return figures;
	}
	
	public void setFigures(Map<String, Figure> figures) {
		this.figures = figures;
	}
	
	public Double getAvg() {
		return avg;
	}
	
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	
	
}
