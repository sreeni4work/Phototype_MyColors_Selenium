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

public class Products_ExecutionClass {
	
	private static String HTMLReportPAth = null;
	private static String CurrentPageTestCaseName = null;
	private static String ExcelSheetPath = null;	
	private static String ProductExcelSheetPath = null;
	private static String Excel_SheetName1 = null;	
	private static String Excel_SheetName2 = null;
	private static String Excel_SheetName3 = null;
	private static String Excel_SheetName4 = null;
	private static String WritePath = null;
	private static String result = null;	
	private static String ProductWritePath = null;
	private static BasePages ReportingPages = null;
	private static int passedRowNumber = 0;
	private static int failedRowNumber = 0;
	private static String testResult = null;

	private static Member_SignUpPagedata NewProductData = null;
	private static Member_SignUpPagedata EditProductData = null;
	private static Member_SignUpPagedata DeleteProductData = null;	

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
		String Name = "Product HTML Report";
		String timeStamp = DateTime();
		String ReportName = Name+"_"+ timeStamp+".html";		
		HTMLReportPAth = System.getProperty("user.dir") + "/Resources/Reports/"+ReportName;	
		ReportingPages = new BasePages(HTMLReportPAth);		
		ProductExcelSheetPath = System.getProperty("user.dir") + "/Resources/TestData/Dev/Products_Dev_TestData.xls";		
		ProductWritePath = System.getProperty("user.dir") + "/Resources/TestOutData/Dev/Products_Dev_TestResults.xls";			
		LaunchBrowser.LaunchBrowserapp();
		ReportingPages.testscreen();
	}

	//*************************************************************************************//
	//*************************** NUnit Annotations ***************************************//
	//***************************         Test      ***************************************//
	//*************************************************************************************//
	
	@Test()
	//***************************************************************************************//
	//*************************** Add Product Execution method ******************************//
	//****************************************@***********************************************//
	public static void addProduct_Execution() throws BiffException, IOException, InterruptedException {
		CurrentPageTestCaseName = "Adding New Product[s]";		
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(6000);
		BasePages.ResultsLog.ReportScriptStarted("*** AddProducts Script Execution Started ***");
		MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName1 = "AddProducts";		
		NewProductData = new Member_SignUpPagedata(ProductExcelSheetPath, Excel_SheetName1, ProductWritePath);		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		NewProductData.ClearExistingStatus();

		for (int row = 1; row <= NewProductData.GetRows(); row++) {			
			if (NewProductData.Getdata("Artcode", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_addProduct(row);	
					testResult = (String) PT_MyColors_Products.ExecutionResult(result);					
					NewProductData.setData("Execution Status", row, (String) PT_MyColors_Products.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'
					
					switch(testResult){  
			        case "Pass":  
			        	passedRowNumber = row;  
			            break;  
			        case "Fail":  
			        	failedRowNumber = row;  
			            break;  
			        }  					
					//NewProductData.setData("Execution Status", row, "Pass");
					Thread.sleep(2000);
					if(row==NewProductData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						BasePages.ResultsLog.ReportScriptCompletedSucessfully("*** AddProducts Script Execution Completed Sucessfully ***");
						break;	
					}
				} 
				catch (Exception e) {
					e.printStackTrace();                                     
					try {
						System.out.println("Entered into Add products Try Catch1:"+row);
						failedRowNumber = row;
					} catch (Exception e1) {
						System.out.println("Entered into Add products Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e.toString());	
						failedRowNumber = row;								
					}		
					NewProductData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
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
		NewProductData = new Member_SignUpPagedata(ProductExcelSheetPath, Excel_SheetName1, ProductWritePath);
		CurrentPageTestCaseName = "Testcase Name - Adding new Products";
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		NewProductData.ClearExistingStatus();

		for (int row = failedRowNumber; row <= NewProductData.GetRows()-passedRowNumber; row++) {			
			if (NewProductData.Getdata("Artcode", row).trim().length() > 2) {
				try {
					MyColorPages.PT_MyColors_addProduct(row);				
					NewProductData.setData("Execution Status", row, (String) PT_MyColors_Products.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'
					//NewProductData.setData("Execution Status", row, "Pass");
					Thread.sleep(2000);
					if(row==NewProductData.GetRows()-1) {
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
					NewProductData.setData("Execution Status", row, "Fail");		                  //This method is used to update the Execution Status column with results 'Fail'			
					MyColorPages.Page_LogOut();
					break;
				}
			}
		}
	}*/
	
	@Test(dependsOnMethods = {"addProduct_Execution"})
	//***************************************************************************************//
	//************************** Edit Product Execution method ******************************//
	//***************************************************************************************//
	public static void editProduct_Execution() throws BiffException, IOException, InterruptedException {
		CurrentPageTestCaseName = "Edit Existing Product[s]";
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(10000);
		BasePages.ResultsLog.ReportScriptStarted("*** EditProducts Script Execution Started ***");
		MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName2 = "EditProducts";		
		EditProductData = new Member_SignUpPagedata(ProductExcelSheetPath, Excel_SheetName2, ProductWritePath);		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		EditProductData.ClearExistingStatus();

		for (int row = 1; row <= EditProductData.GetRows(); row++) {			
			if (EditProductData.Getdata("Artcode", row).trim().length() > 2) {
				try {					
					MyColorPages.PT_MyColors_editProduct(row);					
					//EditProductData.setData("Execution Status", row, "Pass");						//This method is used to update the Execution Status column with results 'Fail'
					EditProductData.setData("Execution Status", row, (String) PT_MyColors_Products.ExecutionResult(result));   		//This method is used to update the Execution Status column with results 'Pass'
					Thread.sleep(2000);
					if(row==EditProductData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						BasePages.ResultsLog.ReportScriptCompletedSucessfully("*** EditProducts Script Execution Completed Sucessfully ***");
						break;	
					}
				} 
				catch(NoSuchElementException e1)
				{					
					EditProductData.setData("Execution Status", row, "Fail");					
					if (row >= EditProductData.GetRows()-1) {
						MyColorPages.Page_LogOut();	
						break;
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					try {
						System.out.println("Entered into Edit Product Try Catch1:"+row);
						EditProductData.setData("Execution Status", row, "Fail");
						MyColorPages.Page_LogOut();	
						break;
					} catch (Exception e1) {
						System.out.println("Entered into  Edit Product Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e.toString());
						EditProductData.setData("Execution Status", row, "Fail");
						MyColorPages.Page_LogOut();	
						break;
					}				
				}
			}
		}
	}
	
	
	@Test(dependsOnMethods = {"editProduct_Execution"})
	//***************************************************************************************//
	//************************** Delete Product Execution method ****************************//
	//***************************************************************************************//
	public static void DeleteProduct_Execution() throws BiffException, IOException, InterruptedException, NoSuchElementException, ArrayIndexOutOfBoundsException  {
		CurrentPageTestCaseName = "Delete Existing Product[s]";
		ReportingPages.AttachTestcaseReport(CurrentPageTestCaseName);
		MyColorPages.Page_Login();
		Thread.sleep(10000);
		BasePages.ResultsLog.ReportScriptStarted("*** DeleteProducts Script Execution Started ***");
		MyColorPages.PT_MyColors_ClickProducts();
		Excel_SheetName3 = "DeleteProducts";		
		DeleteProductData = new Member_SignUpPagedata(ProductExcelSheetPath, Excel_SheetName3, ProductWritePath);
		
		BasePages.ResultsLog.ReportScriptStarted(CurrentPageTestCaseName);
		DeleteProductData.ClearExistingStatus();
		for (int row = 1; row <= DeleteProductData.GetRows(); row++) {			
			if (DeleteProductData.Getdata("Artcode", row).trim().length() > 2) {
				try {					
					MyColorPages.PT_MyColors_deleteProduct(row);
					DeleteProductData.setData("Execution Status", row, (String) PT_MyColors_Products.ExecutionResult(result)); 
					Thread.sleep(4000);
					if(row==DeleteProductData.GetRows()-1) {
						MyColorPages.Page_LogOut();
						BasePages.ResultsLog.ReportScriptCompletedSucessfully("*** DeleteProducts Script Execution Completed Sucessfully ***");
						break;	
					}
				} 
				catch(NoSuchElementException e1)
				{				
					DeleteProductData.setData("Execution Status", row, "Fail");
					if (row >= DeleteProductData.GetRows()-1) {
						MyColorPages.Page_LogOut();	
						break;
					}
				}						
				catch (Exception e2) {
					e2.printStackTrace();
					try {								
						System.out.println("Entered into Delete Product Try Catch1:"+e2.toString());
						DeleteProductData.setData("Execution Status", row, "Fail");
						MyColorPages.Page_LogOut();	
						break;
					} 
					catch (Exception e3) {
						System.out.println("Entered into  Delete Product Try Catch2:"+row);
						BasePages.ResultsLog.logger.log(Status.FAIL, "Error message not displayed");
						BasePages.ExecutionPageExceptionErrorCapture(
								CurrentPageTestCaseName + " Data Row Number, " + row, e3.toString());
						DeleteProductData.setData("Execution Status", row, "Fail");
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
