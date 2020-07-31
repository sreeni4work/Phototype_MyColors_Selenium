package com.Utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.RefreshAllRecord;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.Cell;
import jxl.Sheet;

public class ExcelConnection {
	Workbook book;
	Sheet sheet;
	public WritableSheet wsht;
	public Workbook wbook;
	public WritableWorkbook wwbCopy;
	static String ExecutedTestCasesSheet;
	// static Hashtable dict = new Hashtable<Object, Object>();
	Hashtable<String, Integer> dict = new Hashtable<String, Integer>();
	String WriteExcelSheetPath;
	String WriteSheetname;

	public ExcelConnection(String excelSheetPath, String Sheetname, String WritalPath) {
		WriteExcelSheetPath = WritalPath;
		WriteSheetname = Sheetname;
		
		try {

			book = Workbook.getWorkbook(new File(excelSheetPath));
			sheet = book.getSheet(Sheetname);
			System.out.println("Fetching Excel and Collecting Data from Excel");
		} catch (Exception e) {
			try {
				Thread.sleep(15000);
				book = Workbook.getWorkbook(new File(excelSheetPath));
				sheet = book.getSheet(Sheetname);
				System.out.println("Fetching Excel and Collecting Data from Excel");
			} catch (Exception e1) {
				try {
					Thread.sleep(15000);
					book = Workbook.getWorkbook(new File(excelSheetPath));
					sheet = book.getSheet(Sheetname);
					System.out.println("Fetching Excel and Collecting Data from Excel");
				} catch (Exception e2) {
					try {
						Thread.sleep(15000);
						book = Workbook.getWorkbook(new File(excelSheetPath));
						sheet = book.getSheet(Sheetname);
						System.out.println("Fetching Excel and Collecting Data from Excel");
					} catch (Exception e3) {
						try {
							Thread.sleep(15000);
							book = Workbook.getWorkbook(new File(excelSheetPath));
							sheet = book.getSheet(Sheetname);
							System.out.println("Fetching Excel and Collecting Data from Excel");
						} catch (Exception e4) {
							System.out.println("Excel Was not Available, Terminating the attempts");
							e4.printStackTrace();
						}
					}
				}
			}
		}

	}

	public void setValueintocell(String FieldName, int row, String TexttoEnter) {

		Label label = new Label(getField(FieldName), row, TexttoEnter);
		try {
			wbook = Workbook.getWorkbook(new File(WriteExcelSheetPath));
			wwbCopy = Workbook.createWorkbook(new File(WriteExcelSheetPath), wbook);
			wsht = wwbCopy.getSheet(WriteSheetname);
			wsht.addCell(label);
			wwbCopy.write();
			wwbCopy.close();
			wbook.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void CloseWritExcel() throws WriteException, IOException {

		wwbCopy.close();
		wbook.close();

	}

	public int getField(String FieldName) {

		int colNo = 0;

		for (int col = 0; col < sheet.getColumns(); col++) {
			// for (int r = 0; r < rowcount(); r++)
			// {
			String attributeName = sheet.getCell(col, 0).getContents().trim();
			if (attributeName.equalsIgnoreCase(FieldName)) {
				colNo = col;
				break;
			}

			// }

		}
		return colNo;
	}

	public Sheet[] getSheet(Sheet[] name) {
		Sheet[] sheetname = book.getSheets();
		if (sheetname.equals(name)) {
			sheetname = name;
		}
		return sheetname;

	}

	public String GetData(String FName, int rownum) {

		return readCell(getField(FName), rownum).trim();
	}

	public int rowcount() {
		return sheet.getRows();
	}

	public int rowcounth() {
		return sheet.getRows();
	}

	public String readCell(int clonum, int rownum) {
		return sheet.getCell(clonum, rownum).getContents().trim();
	}

	public void columnDictionary() {
		for (int col = 0; col < sheet.getColumns(); col++) {
			dict.put(readCell(col, 0), col);
		}
	}

	public int GetCell(String colName) {
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);
		}
	}

	public void flush() throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(WriteExcelSheetPath));
		fos.flush();
		fos.close();

	}

}
