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

public class ReadAllData {

	static File file;
	static FileInputStream inputStream;
	static Workbook wb;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	static DataFormatter formatter;
	static int i,j;
	static String[][] stringArray;
	
	@Test
	public void readAllDataFromExcel() {
		try {
		file = new File(".\\Excel\\FBData.xlsx");
		inputStream = new FileInputStream(file);
		wb = new XSSFWorkbook(inputStream);
		sheet = wb.getSheet("Sheet4");
		}catch(FileNotFoundException e) {
			System.out.println("Throw the FileNotFoundException");
		}catch(IOException e) {
			System.out.println("Throw the IOException");
		}
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for(int i=0; i<physicalNumberOfRows; i++) {
			int physicalNumberOfCells = sheet.getRow(i).getPhysicalNumberOfCells();
			for(int j=0; j<physicalNumberOfCells; j++) {
				row = sheet.getRow(i);
				cell = row.getCell(j);
				formatter = new DataFormatter();
				String value = formatter.formatCellValue(cell);
				System.out.print(value+"|");
			}
			System.out.println();
		}
	}
}
