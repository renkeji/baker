package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import models.*;

import views.html.*;

public class PliReport extends Controller {
	public static Result showReport(long id) {
		return ok(plireport.render("The company id is: " + id));
	}
}
