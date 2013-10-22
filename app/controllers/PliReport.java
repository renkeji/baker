package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class PliReport extends Controller {
	public static Result showPage() {
		return ok(pli_report.render("[3.54, 'jan', '#f3f3f3'], [2.98, 'feb', '#f4f4f4'], [-1.78, 'feb', '#f4f4f4']"));
	}
	
	public static Result getData() {
		return ok("Hello");
	}
}
