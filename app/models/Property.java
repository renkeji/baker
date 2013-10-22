package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import play.db.ebean.Model;

public class Property extends Model {
	private String name;
	private Map<String, Figure> figureIndex;
	private Double avg;
	private List<Figure> figures;
	
	public Property(String name) {
		super();
		this.name = name;
		this.figureIndex = new LinkedHashMap<String, Figure>();
		this.figures = new ArrayList<Figure>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Figure> getFigureIndex() {
		return figureIndex;
	}

	public void setFigureIndex(Map<String, Figure> figureIndex) {
		this.figureIndex = figureIndex;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public List<Figure> getFigures() {
		return figures;
	}

	public void setFigures(List<Figure> figures) {
		this.figures = figures;
	}
	
}
