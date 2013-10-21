package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import models.*;

import views.html.*;

import java.io.*;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class Home extends Controller {
	
	public static Result showHomePage() {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			// Read the source spreadsheet
			FileInputStream file = new FileInputStream(new File("/private/var/tmp/projects/play/baker/public/spreadsheet/sample.xlsx"));
			
			// Get the workbook instance for xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			// Get first sheetfrom the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_BOOLEAN:
							sb.append(cell.getBooleanCellValue()+"\t");
							break;
						case Cell.CELL_TYPE_NUMERIC:
							sb.append(cell.getNumericCellValue()+"\t");
							break;
						case Cell.CELL_TYPE_STRING:
							sb.append(cell.getStringCellValue()+"\t");
							break;
					}
				}
				sb.append("\n");
			}
			
			file.close();
		} catch (FileNotFoundException e) {
			sb.append(e.getMessage());
		} catch (IOException e) {
			sb.append(e.getMessage());
		}
		
		return ok(index.render(sb.toString()));
	}
	
	public static Result showPliReport() {
		return ok(plireport.render("This is PLI Report Page!"));
	}
	
	public static Result showFunctionalTable() {
		return ok(functionaltable.render("This is Functional Table Page!"));
	}
}
