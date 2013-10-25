package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class DefaultController extends Controller {
	
	public static Result showPage() {
		return ok(defaultpage.render());
	}
	
}
