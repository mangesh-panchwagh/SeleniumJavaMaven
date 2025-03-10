package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel is considered as workbook
// Inside workbook we have multiple sheets
// In each sheet we have multiple rows 
// In each rows we have multiple cells
// workbook -> sheet -> row -> cell (Order need to follow)

// create excel file and write data into it
public class createAndWriteExcel {

	public static void main(String[] args) throws IOException {
		/*
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("TestSheet");
		sheet.createRow(0);	// index starts from 0
		sheet.getRow(0).createCell(0).setCellValue("Hello");
		sheet.getRow(0).createCell(1).setCellValue("Selemnium");
		
		sheet.createRow(1);	
		sheet.getRow(1).createCell(0).setCellValue("HYR");
		sheet.getRow(1).createCell(1).setCellValue("Tutorials");
		
		File file = new File("E:\\Mangesh\\eclipse-workspace\\SeleniumJavaMaven\\ExcelFiles\\Test2.xls");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		
		workbook.close();
		*/
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TestSheet");
		sheet.createRow(0);	// index starts from 0
		sheet.getRow(0).createCell(0).setCellValue("Hello");
		sheet.getRow(0).createCell(1).setCellValue("Selenium");
		
		sheet.createRow(1);	
		sheet.getRow(1).createCell(0).setCellValue("HYR");
		sheet.getRow(1).createCell(1).setCellValue("Tutorials");
		
		File file = new File("E:\\Mangesh\\eclipse-workspace\\SeleniumJavaMaven\\ExcelFiles\\Test3.xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		
		workbook.close();
	}
}
