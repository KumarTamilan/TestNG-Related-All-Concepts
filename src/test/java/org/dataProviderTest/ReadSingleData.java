package org.dataProviderTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadSingleData {

	static File file;
	static FileInputStream inputStream;
	static Workbook wb;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	static String[][] stringArray;
	
	static DataFormatter formatter;
	
	@Test
	public void readSingleDataFromExcel() {
		try {
		file = new File(".\\Excel\\FBData.xlsx");
		inputStream = new FileInputStream(file);
		wb = new XSSFWorkbook(inputStream);
		sheet = wb.getSheet("Sheet5");
		}catch(FileNotFoundException e) {
			System.out.println("This is FileNotFoundException");
		}catch(IOException e) {
			System.out.println("This is IOException");
		}
		row=sheet.getRow(0);
		cell=row.getCell(1);
		formatter = new DataFormatter();
		String value = formatter.formatCellValue(cell);
		System.out.println(value);
	}
}
