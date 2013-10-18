package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Home extends Controller {
	public static Result showHomePage() {
		return ok("This is the home page!");
	}
}
