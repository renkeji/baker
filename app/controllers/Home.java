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
	
	private static final Logger logger = new Logger();; 
	
	public static final SpreadSheet sheet = SpreadSheetParser.parseSheet("/var/tmp/projects/play/baker/public/spreadsheets/screen_design.xlsx"); 
	
	public static Result showPage() {
		
//		for (Company c : sheet.getCompanies()) {
//			logger.warn("Company name is: " + c.getName());
//			logger.warn("Country is : " + c.getCountry());
//			logger.warn("Description is : " + c.getDescription());
//			for (Property p : c.getProperties().values()) {
//				for (Figure f : p.getFigures()) {
//					logger.warn(p.getName() + " " + f.getYear() + " is: " + f.getValue());
//				}
//				logger.warn(p.getName() + " avg is: " + p.getAvg());
//			}
//			logger.warn("\n\n\n");
//		}
		return ok(index.render(sheet.getCompanies()));
	}
	
}
