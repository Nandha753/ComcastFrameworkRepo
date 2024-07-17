package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel (String sheetName, int rowNum,int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel=row.getCell(celNum);
		String data =cel.getStringCellValue().toString();
		wb.close();
		return data;
	}
	
	public int getRowcount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum,int celNum,String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		FileOutputStream fos = new FileOutputStream("./testdata/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
