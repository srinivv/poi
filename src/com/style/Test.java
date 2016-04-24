package com.style;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Test {

	public static void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Style example");

		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);

		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("This is bold");
		cell.setCellStyle(style);

		font = workbook.createFont();
		font.setItalic(true);
		style = workbook.createCellStyle();
		style.setFont(font);

		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("This is italic");
		cell.setCellStyle(style);

		try {
			FileOutputStream out = new FileOutputStream(new File("C:\\Srini\\MyDocs\\MyProjects\\myworkspace\\POI\\src\\com\\style\\style.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
