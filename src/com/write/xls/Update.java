package com.write.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class Update {

	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File("C:\\Srini\\MyDocs\\MyProjects\\myworkspace\\POI\\src\\com\\write\\xls\\update.xls"));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null;

			// Update the value of cell
			cell = sheet.getRow(1).getCell(2);
			cell.setCellValue(cell.getNumericCellValue() * 2);
			cell = sheet.getRow(2).getCell(2);
			cell.setCellValue(cell.getNumericCellValue() * 2);
			cell = sheet.getRow(3).getCell(2);
			cell.setCellValue(cell.getNumericCellValue() * 2);

			file.close();

			FileOutputStream outFile = new FileOutputStream(new File("C:\\Srini\\MyDocs\\MyProjects\\myworkspace\\POI\\src\\com\\write\\xls\\update.xls"));
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
