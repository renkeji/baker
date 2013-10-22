package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import models.Company;
import models.SpreadSheet;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class SpreadSheetParser {
	
	public static SpreadSheet parseSheet(String file) {
		SpreadSheet newSheet = new SpreadSheet();
		
		try {
			// Read the source spreadsheet
			FileInputStream file = new FileInputStream(new File(file));
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
					int rowIndex = cell.getRowIndex();
					int colIndex = cell.getColumnIndex();
					
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (!isHeader) {
								cell.getNumericCellValue();
							}
							break;
						case Cell.CELL_TYPE_STRING:
							String cellValue = cell.getStringCellValue();
							if (!isHeader) {
								String colName = newSheet.getHeader().get(colIndex);
								String prefix = NameExtractor.extractName(colName)[0];
								String suffix = NameExtractor.extractName(colName)[1];
								if (colName.trim().equals("Company")) {
									Company newCompany = new Company();
									newCompany.setName(prefix);
									newSheet.companies.put(prefix, newCompany);
								} else if (prefix.equals("Trading Address")) {
									
								} else if (prefix.equals("Description")) {
									
								} else {
									
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
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		
		return newSheet;
	}
	
}
