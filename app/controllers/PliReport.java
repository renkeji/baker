package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import models.Company;

import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import utils.SpreadSheetParser;
import views.html.*;

public class PliReport extends Controller {
	
	public static Result showPage() {
//		Map<Company, Double> pliData = new LinkedHashMap<Company, Double>();
		List<Company> companies = SpreadSheetParser.getSpreadSheet().getCompanies();
		List<Double> plis = SpreadSheetParser.getPliData();
//		for (int i = 0; i < companies.size(); ++i) {
//			pliData.put(companies.get(i), plis.get(i));
//		}
		return ok(pli_report.render(companies, plis));
	}
	
	public static Result sendData() {
		
		return ok("Hello");
	}
	
}
