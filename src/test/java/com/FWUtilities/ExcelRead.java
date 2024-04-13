package com.FWUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelRead {

	@DataProvider(name="register credentials")
	public  static Object [][] getExcelData() throws IOException {
		
		File fileData= new File(System.getProperty("user.dir")+"\\Configuration\\DataSheet.xlsx");
		FileInputStream fis= new FileInputStream(fileData);
	
	
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rowCount =sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		Object [][] data= new Object[rowCount][columnCount];
		
		for(int ro=0;ro<rowCount;ro++) {
			
			XSSFRow row = sheet.getRow(ro+1);
			for(int col=0;col<columnCount;col++) {
				XSSFCell cell = row.getCell(col);
				CellType cellType = cell.getCellType();
				switch(cellType) {
				
				case STRING:
					data[ro][col]=cell.getStringCellValue();
					break;
				case NUMERIC:
					data[ro][col]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[ro][col]=cell.getBooleanCellValue();
					break;
				
				}
			}
		}
		return data;
		
	
	}
	
	
}
