package com.daiva.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		File src=new File("./TestData/daivaTestData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("Ubale to read test data excel sheet "+e.getMessage());
			
		}
	}
	
	public String getStringData(int SheetIndex, int row, int col){
		
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(String SheetName, int row, int col){
		
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumbericData(String SheetName, int row, int col) {
		return wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
	}

}
