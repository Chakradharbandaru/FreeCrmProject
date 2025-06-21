package com.capgemini.parameters;
 
import java.io.FileInputStream;
 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
public class ExcelReader {
	public static String getCellData(String excelpath,String sheetName,int row,int column) {
		String cellData = "";
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			cellData  = wb.getSheet(sheetName).getRow(row).getCell(column).toString();
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cellData;	
	}
	public static int getRowCount(String excelpath,String sheetName) {
		int rowCount = 0;
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			rowCount = wb.getSheet(sheetName).getLastRowNum();	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return rowCount;
		}
}



















//FileInputStream: Used to read the Excel file from the file system.
//Workbook and WorkbookFactory: Part of Apache POI, used to work with Excel files (both .xls and .xlsx formats).
//If any error occurs (e.g., file not found, sheet/cell doesn't exist), it prints the error message.

