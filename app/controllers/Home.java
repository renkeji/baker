package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import models.*;

import utils.SpreadSheetParser;
import views.html.*;

import java.io.*;
import java.util.Iterator;

public class Home extends Controller {
	
	public static Result showHomePage() {
		return ok(index.render(SpreadSheetParser.test()));
	}
	
	public static Result showPliReport() {
		return ok(plireport.render("This is PLI Report Page!"));
	}
	
	public static Result showFunctionalTable() {
		return ok(functionaltable.render("This is Functional Table Page!"));
	}
}
