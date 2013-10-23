package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Company;
import models.Figure;
import models.Property;
import models.SpreadSheet;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import play.Logger;

public class SpreadSheetParser {
	
	/*
	 * TODO: Not good code below, get rid of this container in the future
	 */
	private static final List<Double> pliData = new ArrayList<Double>(); 
	private static final SpreadSheet spreadSheet = new SpreadSheet();
	
	public static SpreadSheet parseSheet(String fileName) {
		
		try {
			// Read the source spreadsheet
			FileInputStream file = new FileInputStream(new File(fileName));
			// Get the workbook instance for xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();
			Boolean isHeader = true;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int rowIndex = cell.getRowIndex();
					int colIndex = cell.getColumnIndex();
					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_BLANK:
							break;
						case Cell.CELL_TYPE_NUMERIC:
							if (!isHeader) {
								String colName = spreadSheet.getHeader().get(colIndex);
								Double cellValue = cell.getNumericCellValue();
								Company currCompany = spreadSheet.getCompanies().get(rowIndex-1);
								String prefix = NameExtractor.extractName(colName)[0];
								String suffix = NameExtractor.extractName(colName)[1];
									
								if (prefix == null) {
									Logger.error("DEBUG 1: Shouldn't be here");
								}
								if (prefix != null && currCompany.getProperties().containsKey(prefix)) {
									if (suffix != null && suffix.matches(".*Avg.*")) {
										currCompany.getProperties().get(prefix).setAvg(cellValue);
									} else {
										Figure newFigure = new Figure(suffix, cellValue);
										currCompany.getProperties().get(prefix).getFigures().add(newFigure);
										currCompany.getProperties().get(prefix).getFigureIndex().put(suffix, newFigure);
									}
								} else {
									currCompany.getProperties().put(prefix, new Property(prefix));
									Figure newFigure = new Figure(suffix, cellValue);
									currCompany.getProperties().get(prefix).getFigures().add(newFigure);
									currCompany.getProperties().get(prefix).getFigureIndex().put(suffix, newFigure);
								}
								/*
								 * TODO: Not good code below, get rid of it together with the pliData container
								 */
								if (prefix != null && colName.matches(".*OM%\\s*2011\\s*")) {
									pliData.add(cellValue);
								}
							} else {
								Logger.error("DEBUG 2: Shouldn't be here");
							}
							break;
						case Cell.CELL_TYPE_STRING:
							String cellValue = cell.getStringCellValue();
							if (!isHeader) {
								String colName = spreadSheet.getHeader().get(colIndex);
								if (colName.matches(".*Company.*")) {
									Company newCompany = new Company();
									newCompany.setName(cellValue);
									newCompany.setCompanyId(cell.getRowIndex());
									spreadSheet.getCompanies().add(newCompany);
									spreadSheet.getCompanyIndex().put(cellValue, newCompany);
								} else if (colName.matches(".*Country.*")) {
									spreadSheet.getCompanies().get(rowIndex-1).setCountry(cellValue);
								} else if (colName.matches(".*Description.*")) {
									spreadSheet.getCompanies().get(rowIndex-1).setDescription(cellValue);
								} 
							} else {
								spreadSheet.getHeader().add(cellValue);
							}
							break;
					}
				}
				isHeader = false;
			}
			file.close();
		} catch (FileNotFoundException e) {
			Logger.error(e.getMessage());
		} catch (IOException e) {
			Logger.error(e.getMessage());
		}
		
		return spreadSheet;
	}

	public static List<Double> getPliData() {
		return pliData;
	}

	public static SpreadSheet getSpreadSheet() {
		return spreadSheet;
	}
	
}
