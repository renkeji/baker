package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class SpreadSheetParser {
	public static String test() {
		/*
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
		*/
		return "Inside utils package";
	}
}
