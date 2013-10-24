package controllers;

import java.util.List;

import models.Company;

import play.mvc.Controller;
import play.mvc.Result;
import utils.SpreadSheetParser;
import views.html.*;

public class CompanyReport extends Controller {
	
	public static Result showPage(int id) {
		List<Company> companies = SpreadSheetParser.getSpreadSheet().getCompanies();
		Company company = companies.get(id-1);
		return ok(company_report.render(company.getDescription()));
	}
	
	public static Result showAllPage() {
		List<Company> companies = SpreadSheetParser.getSpreadSheet().getCompanies();
		return ok(companyreport.render(companies));
	}
	
}
