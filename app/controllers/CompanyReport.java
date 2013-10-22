package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.company_report;

public class CompanyReport extends Controller {
	
	public static Result showPage(int id) {
		return ok(company_report.render("Id is: " + id));
	}
	
}
