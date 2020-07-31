package com.MyColor.PagesData;

import java.io.File;
import java.io.IOException;

import com.Utils.ExcelConnection;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Member_SignUpPagedata {
	static ExcelConnection testData = null;

	public Member_SignUpPagedata() {

	}

	public Member_SignUpPagedata(String ExcelPath, String sheetname, String WritalPath) {
		testData = new ExcelConnection(ExcelPath, sheetname, WritalPath);
		testData.columnDictionary();

	}
	public String Getdata(String FieldName, int row) {

		return testData.readCell(testData.GetCell(FieldName), row).trim();

	}

	public int GetRows() {

		return testData.rowcount();
	}

	public void setData(String FieldName, int row, String TexttoEnter) throws BiffException, IOException {

		testData.setValueintocell(FieldName, row, TexttoEnter);

	}
	
	public void CloseWriteExcel() throws WriteException, IOException {
		
		testData.CloseWritExcel();
	}

	public void ClearExistingStatus() throws BiffException, IOException {

		for (int row = 1; row <= GetRows(); row++) {

			setData("Execution Status", row, "");			

		}

	}
	
	/*public void ClearExistingStatus(int row) throws BiffException, IOException {
		{
			setData("Execution Status", row, "");
		}
	}*/

}
