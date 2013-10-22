package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

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
	
	private static final Logger logger = new Logger();
	
	public static SpreadSheet parseSheet(String fileName) {
		
		SpreadSheet newSheet = new SpreadSheet();
		
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
								String colName = newSheet.getHeader().get(colIndex);
								Double cellValue = cell.getNumericCellValue();
								Company currCompany = newSheet.getCompanies().get(rowIndex-1);
								String prefix = NameExtractor.extractName(colName)[0];
								String suffix = NameExtractor.extractName(colName)[1];
									
								if (prefix == null) {
									logger.error("DEBUG 1: Shouldn't be here");
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
							} else {
								logger.error("DEBUG 2: Shouldn't be here");
							}
							break;
						case Cell.CELL_TYPE_STRING:
							String cellValue = cell.getStringCellValue();
							if (!isHeader) {
								String colName = newSheet.getHeader().get(colIndex);
								if (colName.matches(".*Company.*")) {
									Company newCompany = new Company();
									newCompany.setName(cellValue);
									newCompany.setCompanyId(cell.getRowIndex());
									newSheet.getCompanies().add(newCompany);
									newSheet.getCompanyIndex().put(cellValue, newCompany);
								} else if (colName.matches(".*Country.*")) {
									newSheet.getCompanies().get(rowIndex-1).setCountry(cellValue);
								} else if (colName.matches(".*Description.*")) {
									newSheet.getCompanies().get(rowIndex-1).setDescription(cellValue);
								} 
							} else {
								newSheet.getHeader().add(cellValue);
							}
							break;
					}
				}
				isHeader = false;
			}
			file.close();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		return newSheet;
	}
	
}
