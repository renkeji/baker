package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.functional_table;

public class FunctionalTable extends Controller {
	
	public static Result showPage() {
		return ok(functional_table.render("Hello"));
	}
	
}
