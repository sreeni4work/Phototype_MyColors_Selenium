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
import com.MyColors.Pages.PT_MyColors_ColorLibraries;
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

public class ColorLibrary_ExecutionClass {
	
	private static String HTMLReportPAth = null;
	private static String CurrentPageTestCaseName = null;
	private static String ExcelSheetPath = null;	
	private static String ColorLibraryExcelSheetPath = null;
	private static String Excel_SheetName1 = null;	
	private static String Excel_SheetName2 = null;
	private static String Excel_SheetName3 = null;
	private static String Excel_SheetName4 = null;
	private static String WritePath = null;
	private static String result = null;	
	private static String ColorLibraryWritePath = null;
	private static BasePages ReportingPages = null;
	private static int passedRowNumber = 0;
	private static int failedRowNumber = 0;
	private static String testResult = null;

	private static Member_SignUpPagedata NewColorLibraryData = null;
	private static Member_SignUpPagedata EditColorLibraryData = null;
	private static Member_SignUpPagedata DeleteColorLibraryData = null;	

	//This method used to add a time stamp to name of HTML report
	public static String DateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy hh_mm_ss");
		String timeStamp = df.format(date);
		return timeStamp;
	}
	
	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************    Before Test    ***************************************//
	//*************************************************************************************//

	@BeforeSuite
	public static void Beforetest() throws IOException, BiffException {

		//Below 3 variables used for naming the HTML report with time stamp
		String Name = "Color Library HTML Report";
		String timeStamp = DateTime();
		String ReportName = Name+"_"+ timeStamp+".html";		
		HTMLReportPAth = System.getProperty("user.dir") + "/Resources/Reports/"+ReportName;	
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
	
	@Test()
	//***************************************************************************************//
	//*************************** Add Color Library Execution method ******************************//
	//****************************************@***********************************************//
	public static void addColorLibrary_Execution() throws BiffException, IOException, InterruptedException {
		CurrentPageTestCaseName = "Adding New Color Library";		
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(6000);
		BasePages.ResultsLog.ReportScriptStarted("*** Add Color Library Script Execution Started ***");
		MyColorPages.PT_MyColors_ClickColorLibrary();
		Excel_SheetName1 = "AddColorLibrary";		
		NewColorLibraryData = new Member_SignUpPagedata(ColorLibraryExcelSheetPath, Excel_SheetName1, ColorLibraryWritePath);		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		NewColorLibraryData.ClearExistingStatus();

		for (int row = 1; row <= NewColorLibraryData.GetRows(); row++) {			
			if (NewColorLibraryData.Getdata("Color Library", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_addColorLibraries(row);	
					testResult = (String) PT_MyColors_ColorLibraries.ExecutionResult(result);					
					NewColorLibraryData.setData("Execution Status", row, (String) PT_MyColors_ColorLibraries.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'
					
					switch(testResult){  
			        case "Pass":  
			        	passedRowNumber = row;  
			            break;  
			        case "Fail":  
			        	failedRowNumber = row;  
			            break;  
			        }  					
					//NewColorLibraryData.setData("Execution Status", row, "Pass");
					Thread.sleep(2000);
					if(row==NewColorLibraryData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						BasePages.ResultsLog.ReportScriptCompletedSucessfully("*** Add Color Library Script Execution Completed Sucessfully ***");
						break;	
					}
				} 
				catch (Exception e) {
					e.printStackTrace();                                     
					try {
						System.out.println("Entered into Add Color Library Try Catch1:"+row);
						failedRowNumber = row;
					} catch (Exception e1) {
						System.out.println("Entered into Add Color Library Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e.toString());	
						failedRowNumber = row;								
					}		
					NewColorLibraryData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
					MyColorPages.Page_LogOut();
					break;
				}
			}
		}
	}
	
	
	/*public static void restart_AddProduct_Execution() throws BiffException, IOException, InterruptedException {	
		MyColorPages.Page_Login();
		Thread.sleep(4000);	
		MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName1 = "AddProducts";		
		NewColorLibraryData = new Member_SignUpPagedata(ColorLibraryExcelSheetPath, Excel_SheetName1, ColorLibraryWritePath);
		CurrentPageTestCaseName = "Testcase Name - Adding new Products";
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		NewColorLibraryData.ClearExistingStatus();

		for (int row = failedRowNumber; row <= NewColorLibraryData.GetRows()-passedRowNumber; row++) {			
			if (NewColorLibraryData.Getdata("Artcode", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_addProduct(row);				
					NewColorLibraryData.setData("Execution Status", row, (String) PT_MyColors_Products.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'
					//NewColorLibraryData.setData("Execution Status", row, "Pass");
					Thread.sleep(2000);
					if(row==NewColorLibraryData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						break;	
					}
				} 
				catch (Exception e) {
					e.printStackTrace();                                     
					try {
						System.out.println("Entered into Add products Try Catch1:"+row);
					} catch (Exception e1) {
						System.out.println("Entered into Add products Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e.toString());						
					}		
					NewColorLibraryData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
					MyColorPages.Page_LogOut();
					break;
				}
			}
		}
	}*/
	
	@Test(dependsOnMethods = {"addColorLibrary_Execution"})
	//***************************************************************************************//
	//************************** Edit Color Library Execution method ******************************//
	//***************************************************************************************//
	public static void editColorLibrary_Execution() throws BiffException, IOException, InterruptedException {
		CurrentPageTestCaseName = "Edit Existing Color Library";
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(10000);
		BasePages.ResultsLog.ReportScriptStarted("*** Edit Color Library Script Execution Started ***");
		MyColorPages.PT_MyColors_ClickColorLibrary();
		Excel_SheetName2 = "EditColorLibrary";		
		EditColorLibraryData = new Member_SignUpPagedata(ColorLibraryExcelSheetPath, Excel_SheetName2, ColorLibraryWritePath);		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		EditColorLibraryData.ClearExistingStatus();

		for (int row = 1; row <= EditColorLibraryData.GetRows(); row++) {			
			if (EditColorLibraryData.Getdata("Color Library", row).trim().length() > 2) {
				try {					
					MyColorPages.PT_MyColors_editColorLibraries(row);					
					//EditColorLibraryData.setData("Execution Status", row, "Pass");						//This method is used to update the Execution Status column with results 'Fail'
					EditColorLibraryData.setData("Execution Status", row, (String) PT_MyColors_ColorLibraries.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'
					Thread.sleep(2000);
					if(row==EditColorLibraryData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						BasePages.ResultsLog.ReportScriptCompletedSucessfully("*** Edit Color Library Script Execution Completed Sucessfully ***");
						break;	
					}
				} 
				catch(NoSuchElementException e1)
				{					
					EditColorLibraryData.setData("Execution Status", row, "Fail");					
					if (row >= EditColorLibraryData.GetRows()-1) {
						MyColorPages.Page_LogOut();	
						break;
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					try {
						System.out.println("Entered into Edit Color Library Try Catch1:"+row);
						EditColorLibraryData.setData("Execution Status", row, "Fail");
						MyColorPages.Page_LogOut();	
						break;
					} catch (Exception e1) {
						System.out.println("Entered into  Edit Color Library Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e.toString());
						EditColorLibraryData.setData("Execution Status", row, "Fail");
						MyColorPages.Page_LogOut();	
						break;
					}				
				}
			}
		}
	}
	
	
	@Test(dependsOnMethods = {"editColorLibrary_Execution"})
	//***************************************************************************************//
	//************************** Delete Color Library Execution method ****************************//
	//***************************************************************************************//
	public static void DeleteColorLibrary_Execution() throws BiffException, IOException, InterruptedException, NoSuchElementException, ArrayIndexOutOfBoundsException  {
		CurrentPageTestCaseName = "Delete Existing Color Library";
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(10000);
		BasePages.ResultsLog.ReportScriptStarted("*** Delete Color Library Script Execution Started ***");
		MyColorPages.PT_MyColors_ClickColorLibrary();
		Excel_SheetName3 = "DeleteColorLibrary";		
		DeleteColorLibraryData = new Member_SignUpPagedata(ColorLibraryExcelSheetPath, Excel_SheetName3, ColorLibraryWritePath);
		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		DeleteColorLibraryData.ClearExistingStatus();
		for (int row = 1; row <= DeleteColorLibraryData.GetRows(); row++) {			
			if (DeleteColorLibraryData.Getdata("Color Library", row).trim().length() > 2) {
				try {					
					MyColorPages.PT_MyColors_deleteColorLibraries(row);
					DeleteColorLibraryData.setData("Execution Status", row, (String) PT_MyColors_ColorLibraries.ExecutionResult(result)); 
					Thread.sleep(4000);
					if(row==DeleteColorLibraryData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						BasePages.ResultsLog.ReportScriptCompletedSucessfully("*** Delete Color Library Script Execution Completed Sucessfully ***");
						break;	
					}
				} 
				catch(NoSuchElementException e1)
				{				
					DeleteColorLibraryData.setData("Execution Status", row, "Fail");
					if (row >= DeleteColorLibraryData.GetRows()-1) {
						MyColorPages.Page_LogOut();	
						break;
					}
				}						
				catch (Exception e2) {
					e2.printStackTrace();
					try {								
						System.out.println("Entered into Delete Color Library Try Catch1:"+e2.toString());
						DeleteColorLibraryData.setData("Execution Status", row, "Fail");
						MyColorPages.Page_LogOut();	
						break;
					} 
					catch (Exception e3) {
						System.out.println("Entered into  Delete Color Library Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e3.toString());
						DeleteColorLibraryData.setData("Execution Status", row, "Fail");
						MyColorPages.Page_LogOut();	
						break;
					}	
				}

			}
		}
	}


	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************      AfterTest    ***************************************//
	//*************************************************************************************//
	@AfterSuite
	public static void CloseBroswer() throws IOException {
		ReportingPages.CloseBrowser();

	}


}
