package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Company;

import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import utils.CalculateQuartiles;
import utils.SpreadSheetParser;
import views.html.*;

public class PliReport extends Controller {
	
	public static Result showPage() {
//		Map<Company, Double> pliData = new LinkedHashMap<Company, Double>();
		List<Company> companies = SpreadSheetParser.getSpreadSheet().getCompanies();
		ArrayList<Double> plis = SpreadSheetParser.getPliData();
		if (companies.isEmpty() || plis.isEmpty()) {
			SpreadSheetParser.parseSheet("/var/tmp/projects/play/baker/public/spreadsheets/screen_design.xlsx");
		}
//		for (int i = 0; i < companies.size(); ++i) {
//			pliData.put(companies.get(i), plis.get(i));
//		}
		List<Double> quartiles = CalculateQuartiles.calculateQuartiles(plis);
		return ok(pli_report.render(companies, plis, quartiles));
	}
	
//	@BodyParser.Of(Json.class)
//	public static Result sendData() {
//		ObjectNode result = Json.newObject();
//		List<Double> plis = SpreadSheetParser.getPliData();
//		List<Double> quartiles = CalculateQuartiles.calculateQuartiles(plis);
//		result.put(arg0, arg1)
//		return ok("Hello");
//	}
	
}
