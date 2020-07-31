package com.Mycolors_Execution_Classes;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.MyColors.CommonPages.MyColorPages;
import com.MyColors.Pages.PT_MyColors_ImportColors;
import com.MyColors.Pages.PT_MyColors_ColorLibraries;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;
import com.aventstack.extentreports.Status;

import jxl.read.biff.BiffException;

public class ColorLibrary_Execution {
	private static String HTMLReportPAth = null;
	private static String CurrentPageTestCaseName = null;
	private static String ExcelSheetPath = null;
	private static String ColorLibraryExcelSheetPath = null;	
	private static String Excel_SheetName1 = null;	
	private static String Excel_SheetName2 = null;
	private static String Excel_SheetName3 = null;
	private static String Excel_SheetName4 = null;
	private static String WritePath = null;
	private static String ColorLibraryWritePath = null;
	private static String result = null;	
	private static String testResult = null;
	private static BasePages ReportingPages = null;
	private static int passedRowNumber = 0;
	private static int failedRowNumber = 0;
	

	private static Member_SignUpPagedata ColorLibraryData = null;

	//This method used to add a time stamp to name of HTML report
	public static String DateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy hh_mm_ss");
		String timeStamp = df.format(date);
		return timeStamp;
	}


	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************         Test      ***************************************//
	//*************************************************************************************//
	
	@Test()
	//***************************************************************************************//
	//*************************** ColorLibrary Execution method ******************************//
	//***************************************************************************************//
	
	//*************************** Add ColorLibrary Execution method ******************************//
	public static void AddcolorLibrary_Execution() throws BiffException, IOException, InterruptedException {		
		//MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName1 = "AddColorLibrary";		
		ColorLibraryData = new Member_SignUpPagedata(ColorLibraryExcelSheetPath, Excel_SheetName1, ColorLibraryWritePath);		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		ColorLibraryData.ClearExistingStatus();

		for (int row = 1; row <= ColorLibraryData.GetRows(); row++) {			
			if (ColorLibraryData.Getdata("Color Library", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_addColorLibraries(row);	
					//MyColorPages.
					testResult = (String) PT_MyColors_ColorLibraries.ExecutionResult(result);
					ColorLibraryData.setData("Execution Status", row, (String) PT_MyColors_ColorLibraries.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'					
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
					if(row==ColorLibraryData.GetRows()-1) {
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
					ColorLibraryData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
					MyColorPages.Page_LogOut();
					break;
				}
			}
		}
	}


	public static void Restart_ImportColor_Execution() throws BiffException, IOException, InterruptedException {		
		MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName1 = "Testcase Name - ImportColors";		
		ColorLibraryData = new Member_SignUpPagedata(ColorLibraryExcelSheetPath, Excel_SheetName1, ColorLibraryWritePath);		
		CurrentPageTestCaseName = "Importing New Color[s]";
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		ColorLibraryData.ClearExistingStatus();

		for (int row = failedRowNumber; row <= ColorLibraryData.GetRows()-passedRowNumber; row++) {			
			if (ColorLibraryData.Getdata("AutoItScript Path", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_ImportColors(row);		
					ColorLibraryData.setData("Execution Status", row, (String) PT_MyColors_ImportColors.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'					
					Thread.sleep(4000);
					if(row==ColorLibraryData.GetRows()-1) {
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
					ColorLibraryData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
					MyColorPages.Page_LogOut();
					break;
				}
			}
		}
	}
	
	//*************************** Add ColorLibrary Execution method ******************************//
		public static void deleteColorLibrary_Execution() throws BiffException, IOException, InterruptedException {		
			//MyColorPages.PT_MyColors_ClickProducts();
			Excel_SheetName1 = "DeleteColorLibrary";		
			ColorLibraryData = new Member_SignUpPagedata(ColorLibraryExcelSheetPath, Excel_SheetName1, ColorLibraryWritePath);		
			BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
			ColorLibraryData.ClearExistingStatus();

			for (int row = 1; row <= ColorLibraryData.GetRows(); row++) {			
				if (ColorLibraryData.Getdata("Color Library", row).trim().length() > 2) {
					try {
						MyColorPages.PT_MyColors_deleteColorLibraries(row);	
						//MyColorPages.
						testResult = (String) PT_MyColors_ColorLibraries.ExecutionResult(result);
						ColorLibraryData.setData("Execution Status", row, (String) PT_MyColors_ColorLibraries.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'					
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
						if(row==ColorLibraryData.GetRows()-1) {
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
						ColorLibraryData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
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
				String Name = "Color Library HTML Report";
				String timeStamp = DateTime();
				String ReportName = Name+"_"+ timeStamp+".html";		
				HTMLReportPAth = System.getProperty("user.dir") + "/Resources/Reports/"+ReportName;
				CurrentPageTestCaseName = "Color Library HTML Report";
				ReportingPages = new BasePages(HTMLReportPAth);		
				ColorLibraryExcelSheetPath = System.getProperty("user.dir") + "/Resources/TestData/UAT/ColorLibrary_UAT_Testdata.xls";		
				ColorLibraryWritePath = System.getProperty("user.dir") + "/Resources/TestOutData/UAT/ColorLibrary_UAT_TestResults.xls";			
				LaunchBrowser.LaunchBrowserapp();
				ReportingPages.testscreen();
	}

	

	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************         Test      ***************************************//
	//*************************************************************************************//

	@Test
	public static void MyColorsProcess() throws Exception {
		CurrentPageTestCaseName = "Color Libraries";		
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(6000);		
		AddcolorLibrary_Execution();
		//deleteColorLibrary_Execution();
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

