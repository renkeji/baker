package controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import models.*;

import utils.NameExtractor;
import utils.SpreadSheetParser;
import views.html.*;

import java.io.*;
import java.util.Iterator;


public class Home extends Controller {  
	
	public static Result showPage() {
		SpreadSheet sheet = SpreadSheetParser.getSpreadSheet();
		if (sheet.getCompanies().isEmpty()) {
			sheet = SpreadSheetParser.parseSheet("/var/tmp/projects/play/baker/public/spreadsheets/screen_design.xlsx");
		}
		return ok(index.render(sheet.getCompanies()));
	}
	
}
