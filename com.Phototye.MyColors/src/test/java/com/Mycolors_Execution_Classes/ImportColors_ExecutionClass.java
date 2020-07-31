package com.Mycolors_Execution_Classes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;


import com.MyColors.Pages.Page_Login;
import com.MyColor.PagesData.Member_SignUpPagedata;
import com.MyColors.CommonPages.MyColorsMenu;
import com.MyColors.CommonPages.MyColorPages;
import com.MyColors.Pages.PT_MyColors_ImportColors;
import com.MyColors.Pages.PT_MyColors_Login;
import com.MyColors.Pages.PT_MyColors_Products;
import com.Utils.BasePages;
import com.Utils.HTMLReporter;

import com.Utils.LaunchBrowser;
import com.Utils.WriteExcel;
import com.aventstack.extentreports.Status;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ImportColors_ExecutionClass {

	private static String HTMLReportPAth = null;
	private static String CurrentPageTestCaseName = null;
	private static String ExcelSheetPath = null;
	private static String ImportColorExcelSheetPath = null;	
	private static String Excel_SheetName1 = null;	
	private static String Excel_SheetName2 = null;
	private static String Excel_SheetName3 = null;
	private static String Excel_SheetName4 = null;
	private static String WritePath = null;
	private static String ImprtColorWritePath = null;
	private static String result = null;	
	private static String testResult = null;
	private static BasePages ReportingPages = null;
	private static int passedRowNumber = 0;
	private static int failedRowNumber = 0;
	

	private static Member_SignUpPagedata ImportColorData = null;

	//This method used to add a time stamp to name of HTML report
	public static String DateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy hh_mm_ss");
		String timeStamp = df.format(date);
		return timeStamp;
	}


	@BeforeSuite
	public static void BeforeImportColorstest() throws IOException, BiffException {

		//Below 3 variables used for naming the HTML report with time stamp
		String Name = "ImportColor HTML Report";
		String timeStamp = DateTime();
		String ReportName = Name+"_"+ timeStamp+".html";		
		HTMLReportPAth = System.getProperty("user.dir") + "/Resources/Reports/"+ReportName;	
		ReportingPages = new BasePages(HTMLReportPAth);		
		ImportColorExcelSheetPath = System.getProperty("user.dir") + "/Resources/TestData/UAT/ImportColors_UAT_Testdata.xls";		
		ImprtColorWritePath = System.getProperty("user.dir") + "/Resources/TestOutData/UAT/ImportColors_UAT_TestResults.xls";			
		LaunchBrowser.LaunchBrowserapp();
		ReportingPages.testscreen();
	}

	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************         Test      ***************************************//
	//*************************************************************************************//
	
	@Test()
	//***************************************************************************************//
	//*************************** ImportColor Execution method ******************************//
	//***************************************************************************************//
	public static void importColor_Execution() throws BiffException, IOException, InterruptedException {		
		//MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName1 = "ImportColors";		
		ImportColorData = new Member_SignUpPagedata(ImportColorExcelSheetPath, Excel_SheetName1, ImprtColorWritePath);		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		ImportColorData.ClearExistingStatus();

		for (int row = 1; row <= ImportColorData.GetRows(); row++) {			
			if (ImportColorData.Getdata("AutoItScript Path", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_ImportColors(row);		
					testResult = (String) PT_MyColors_ImportColors.ExecutionResult(result);
					ImportColorData.setData("Execution Status", row, (String) PT_MyColors_ImportColors.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'					
					switch(testResult){
						case "Pass":
						passedRowNumber = row;
						break;
						case "Fail":
						failedRowNumber = row;
						break;
					}
					/*if (testResult="Pass") {
					passedRowNumber = row;
					}
					if (testResult="Fail") {
						failedRowNumber = row;
					}*/
					
					Thread.sleep(4000);
					if(row==ImportColorData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						break;	
					}
				} 
				catch (Exception e) {
					e.printStackTrace();                                     
					try {
						System.out.println("Entered into Import Color Try Catch1:"+row);
						failedRowNumber = row;
					} catch (Exception e1) {
						System.out.println("Entered into Import Color Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
						CurrentPageTestCaseName + " Data Row Number, " + row, e.toString());	
						failedRowNumber = row;
					}						
					ImportColorData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
					MyColorPages.Page_LogOut();
					break;
				}
			}
		}
	}


	public static void Restart_ImportColor_Execution() throws BiffException, IOException, InterruptedException {		
		MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName1 = "Testcase Name - ImportColors";		
		ImportColorData = new Member_SignUpPagedata(ImportColorExcelSheetPath, Excel_SheetName1, ImprtColorWritePath);		
		CurrentPageTestCaseName = "Importing New Color[s]";
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		ImportColorData.ClearExistingStatus();

		for (int row = failedRowNumber; row <= ImportColorData.GetRows()-passedRowNumber; row++) {			
			if (ImportColorData.Getdata("AutoItScript Path", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_ImportColors(row);		
					ImportColorData.setData("Execution Status", row, (String) PT_MyColors_ImportColors.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'					
					Thread.sleep(4000);
					if(row==ImportColorData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						break;	
					}
				} 
				catch (Exception e) {
					e.printStackTrace();                                     
					try {
						System.out.println("Entered into Import Color Try Catch1:"+row);
					} catch (Exception e1) {
						System.out.println("Entered into Import Color Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e.toString());						
					}						
					ImportColorData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
					MyColorPages.Page_LogOut();
					break;
				}
			}
		}
	}
	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************    Before Test    ***************************************//
	//*************************************************************************************//

	@BeforeTest
	public static void Beforetest() throws IOException, BiffException {

		//Below 3 variables used for naming the HTML report with time stamp
		String Name = "Product HTML Report";
		String timeStamp = DateTime();
		String ReportName = Name+"_"+ timeStamp+".html";
		HTMLReportPAth = System.getProperty("user.dir") + "/Resources/Reports/"+ReportName;	
		CurrentPageTestCaseName = "Products HTML Report";
		ImportColorExcelSheetPath = System.getProperty("user.dir") + "/Resources/TestData/UAT/ImportColors_UAT_Testdata.xls";
		ReportingPages = new BasePages(HTMLReportPAth);		
		ImprtColorWritePath = System.getProperty("user.dir") + "/Resources/TestOutData/UAT/ImportColors_UAT_TestResults.xls";		
		LaunchBrowser.LaunchBrowserapp();
		ReportingPages.testscreen();
	}


	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************         Test      ***************************************//
	//*************************************************************************************//

	@Test
	public static void MyColorsProcess() throws Exception {
		CurrentPageTestCaseName = "Importing New Color[s]";		
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(6000);		
		importColor_Execution();
		//restart_ImportColor_Execution();
	}

	
	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************      AfterTest    ***************************************//
	//*************************************************************************************//
	@AfterTest
	public static void CloseBroswer() throws IOException {
		ReportingPages.CloseBrowser();

	}

}
