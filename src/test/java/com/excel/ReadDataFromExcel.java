package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// This program reads first row first column cell value
public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		
		File file = new File("./ExcelFiles/Test.xlsx");
		// to read data from file we use FileInputStream. It will read data in the form of bytes
		// we convert bytes data in excel work format
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cellValue);
		
		workbook.close();
		fis.close();
		
		
	}
}
