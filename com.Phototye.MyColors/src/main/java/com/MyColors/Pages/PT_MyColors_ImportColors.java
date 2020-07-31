package com.MyColors.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;

import jxl.read.biff.BiffException;

public class PT_MyColors_ImportColors extends BasePages {
	Member_SignUpPagedata data = new Member_SignUpPagedata();
	PT_MyColors_MainMenu MenuPage = new PT_MyColors_MainMenu();
	PT_MyColors_Dashboard profilepage = new PT_MyColors_Dashboard();
	boolean isServereError = false;
	boolean ColorLibrary_NotExist = false;
	static String result = "Pass";
	static String ValidColor = null;
	String Invalid = "Validation Fail";
	String validCount = null;
	String invalidCount = null;
	String zero = "0";
	String NumberOfUploads = null;
	String UpoloadColorFileName = null;
	String UploadCount = "x";
	String FailedDashedLine = "-------------------------------------------";
	int i = 1;

	public PT_MyColors_ImportColors() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Objects from Application

	public static WebElement ImportColors_Grid() {
		return driver.findElement(By.xpath("//i[@class='fal fa-cloud-download']"));
	}

	public static WebElement btn_UploadFiles() {
		return driver.findElement(By.xpath("//i[@class='fa fa-upload']"));

	}
	
	public static WebElement btn_UploadAll() {
		return driver.findElement(By.xpath("//*[@class='btn btn-primary' or @class='btn btn-primary ng-star-inserted']"));

	}
	
	public static WebElement btn_UploadAll_OK() {
		return driver.findElement(By.xpath("//*[@class='btn btn-primary']"));

	}
	
	public static WebElement btn_UploadAll_Cancel() {
		//return driver.findElement(By.xpath("//div[@class='modal-content']/div/div[3]/div/button[contains(text(),'Cancel')]"));
		return driver.findElement(By.xpath("//*[@class='btn btn-secondary margin-left']"));

	}	

	public static WebElement txt_uploadFileName() {
		// return
		// driver.findElement(By.xpath("//*[@id='content']/div/app-import-colors/section/div/form/div/div/div[1]/div[2]/div[3]/span[1]"));
		return driver.findElement(By.xpath("//div[@class='custom-modal-container']/div[2]/table/tbody/tr/td[1]/span/strong[text()]"));

	}

	public static WebElement txt_uploadFileName_Hovertext() {
		return driver.findElement(By.xpath("//*[@id='ngb-tooltip-0']"));
		
	}

	public static WebElement import_OK() {
		return driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
		
	}
	
	public static WebElement import_Cancel() {
		return driver.findElement(By.xpath("//*[@class=btn btn-secondary margin-left']"));
		
	}
	
	public static WebElement btn_ColorLibrary() {
		return driver.findElement(By.xpath("//i[@class='fa fa-edit']"));

	}

	public static WebElement lnk_ColorNameHeader() {
		return driver.findElement(By.xpath("//*[@class='ag-header-cell']//app-color-badge[@class='ng-star-inserted']"));
		
	}

	public static WebElement txt_ColorLibraryName() {
		return driver.findElement(By.xpath(
				"/html/body/ngb-modal-window/div/div/app-assign-color-library/div[2]/table/thead/tr/th[2]/div/input"));
	}

	public static WebElement txt_ClientName() {
		return driver.findElement(By.xpath(
				"/html/body/ngb-modal-window/div/div/app-assign-color-library/div[2]/table/thead/tr/th[3]/div/input"));
		
	}

	public static WebElement option_ColorLibraryandClient() {
		//return driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[1]//td[1]"));
		return driver.findElement(By.xpath("//table[@class='myOtherTable']/tbody/tr[1]/td[1]"));
		
	}

	public static WebElement check_ColorLibraryName() {
		//return driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr[1]//td[2]"));
		return driver.findElement(By.xpath("//table[@class='myOtherTable']/tbody/tr[1]/td[2]"));
	}

	public static WebElement ChooseColorLibraryWindow_button_Cancel() {
		return driver.findElement(
				By.xpath("//div[@class='modal-footer']/span[@class='right']/button[@class='btn btn-secondary']"));
		
	}

	public static WebElement btn_Update() {
		return driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		
	}

	public static WebElement lnk_ClearAll() {
		return driver.findElement(By.xpath("//a[@class='btn btn-move-right' and text()=' Clear All ']"));
		
	}

	public static WebElement btn_Validate() {
		return driver.findElement(By.xpath("//i[@class='fa fa-check-circle']"));
		
	}

	public static WebElement btn_failed() {
		return driver.findElement(By.xpath("//*[@href='#tab2default']"));
		
	}

	public static WebElement failedCount() {
		return driver.findElement(By.xpath("//a[@href='#tab2default']//span[@class='count-number']"));
		
	}

	public static WebElement failedColor1() {
		return driver.findElement(By.xpath("//*[@id='tab2default']/table/tbody/tr/td[1]"));
		
	}

	public static WebElement validCount() {
		return driver.findElement(
				//By.xpath("/html/body/ngb-modal-window/div/div/app-import-color-validate/div[2]/ul/li[1]/a/span"));
				By.xpath("//div[@class='modal-dialog modal-lg']/div/app-import-color-validate/div[@class='modal-body']/ul/li[1]/a/span"));
		
	}

	public static WebElement invalidCount() {
		return driver.findElement(
				By.xpath("//div[@class='modal-dialog modal-lg']/div/app-import-color-validate/div[@class='modal-body']/ul/li[2]/a/span"));
				//By.xpath("/html/body/ngb-modal-window/div/div/app-import-color-validate/div[2]/ul/li[2]/a/span"));
		
	}

	public static WebElement btn_Validated() {
		return driver.findElement(By.xpath("//a[@href='#tab1default']"));
		
	}

	public static WebElement btn_ImportValidatedColor() {
		return driver.findElement(By.xpath("//button[@class='btn btn-primary px-4']"));
		
	}	

	public static WebElement txt_FailedColor1() {
		return driver.findElement(By.xpath("//tbody[@class='ng-star-inserted']//tr//td//div"));
		
	}

	public static WebElement btn_ImportValidateCancel() {
		return driver.findElement(By.xpath("//*[@class='btn btn-secondary']"));
		
	}

	public static WebElement btn_Ok() {
		return driver.findElement(By.xpath("//*[@class='swal2-confirm swal2-styled']"));
		
	}

	public static WebElement Colors_Grid() {
		return driver.findElement(By.xpath("//*[@id='sidebar']/ul/li[3]/a[@href='/dashboard/colors']"));
		
	}

	public static WebElement txt_ColorName() {		
		return driver.findElement(By.xpath("//ng-component//input[1]"));
		
	}

	public static WebElement Imported_Color1link() {
		return driver.findElement(By.xpath(
				"(//*[@class='ag-cell-wrapper ag-row-group ag-row-group-indent-0']//span[@class='ag-group-contracted']//i[@class='fas fa-arrow-circle-right'])[1]"));
		
	}

	// Each Object Performance Method
	// Import Colors Page

	public void clickImportColors() throws IOException {		
		clickOnLink(ImportColors_Grid(), "Import Colors");
	}

	public void clickUploadAll(int row) throws IOException, InterruptedException {		
		clickOnLink(btn_UploadAll(), "Upload All");
	}
	
	public void clickUploadAll_OK() throws IOException, InterruptedException {
		Thread.sleep(5000);
		clickOnLink(btn_UploadAll_OK(), "Ok");
	}
	
	public void clickUploadAll_Cancel() throws IOException, InterruptedException {
		Thread.sleep(5000);
		clickOnLink(btn_UploadAll_Cancel(), "Cancel");
	}
	
	
	public void clickUploadFiles(int row) throws IOException, InterruptedException {		
		clickOnLink(btn_UploadFiles(), "Upload Files");
	}

	public void getUploadToastMessage(int row) throws IOException {
		String Upload_Success_Toast_Text = "Import Color upload successfully";
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Import Color upload successfully')]"));

		System.out.println("element.getAttribute(\"innerText\"):" + element.getAttribute("innerText"));
		UpoloadColorFileName = data.Getdata("AutoItScript Path", row);

		if (element.getAttribute("innerText").trim().matches(Upload_Success_Toast_Text)) {
			ResultsLog.ReportDoneEvent("File: " + UpoloadColorFileName + ", Color[s] Uploaded Successfully ");
		} else {
			ResultsLog.ReportFail(driver, "Color[s] not Uploaded for file: " + UpoloadColorFileName, Invalid);
		}
	}
	
	public void uploadedColorFileProcess(int row) throws Exception {
		UpoloadColorFileName = data.Getdata("AutoItScript Path", row);
		boolean RemarksExist = false;
		List<WebElement> UploadFileHoverTextElements = null;		
		int j = 1;
		Actions act = new Actions(driver);
		WebElement UploadFileName = txt_uploadFileName();
		act.moveToElement(UploadFileName).perform();
		List<String> Hover_RemarksList = new ArrayList<String>();
		try {
			UploadFileHoverTextElements = driver
					.findElements(By.xpath("//table/tbody/tr[1]/td[1]/span/ngb-tooltip-window/div[2]/div/span/li"));
			//		.findElements(By.xpath("//table/tbody/tr[1]/td[1]/ngb-tooltip-window/div[2]/div[1]/span/li"));
			for (WebElement we : UploadFileHoverTextElements) {
				//ResultsLog.ReportDoneEvent("File Remarks " + i + ": " + we.getText());
				Hover_RemarksList.add(we.getText());
				i++;
				RemarksExist=true;
			}


			if(!btn_UploadAll_OK().isEnabled()) {
				clickUploadAll_Cancel();
				isServereError = true;
				if(RemarksExist) { 
					ResultsLog.ReportFail(driver, "*** Unable to upload due to imported Color file having below errors: ***" , Invalid);					
					for (int i = 0; i < Hover_RemarksList.size(); i++) {
						System.out.println(Hover_RemarksList.get(i).toString());
						String ValidColorName = Hover_RemarksList.get(i).toString();
						ResultsLog.ReportDoneEvent("Remark " + j + ": " + ValidColorName);
						j++;
					}
					Hover_RemarksList.clear();
				}
			}else {				
				if(RemarksExist) { 
					ResultsLog.ReportDoneEvent("** This Color file consist of below remarks **");
					ResultsLog.ReportDoneEvent("---------------------------------------------------------------");
					for (int i = 0; i < Hover_RemarksList.size(); i++) {
						System.out.println(Hover_RemarksList.get(i).toString());
						String ValidColorName = Hover_RemarksList.get(i).toString();
						ResultsLog.ReportDoneEvent("Remark " + j + ": " + ValidColorName);
						j++;
					}
					Hover_RemarksList.clear();					
				}else {
					ResultsLog.ReportDoneEvent("** This Color file has no remarks **");
				}
				clickUploadAll_OK();
				getUploadToastMessage(row);
				click_ColorNameHeading(row);							
			}	
		} catch (NoSuchElementException e1) {
			ResultsLog.ReportDoneEvent("** This file don't have any property remarks **");
		}			
	}			
		
	
	public void click_ColorNameHeading(int row) throws Exception {

		List<String> ColorList = new ArrayList<String>();		
		try {
			clickOnLink(lnk_ColorNameHeader(), "Color Name Header");
			// Get number of rows In Color grid table.
			int Row_count = driver.findElements(By.xpath("//*[@class='ag-center-cols-container']//div[@row-index]"))
					.size();			

			// divided xpath In two parts to pass Row_count values.
			String first_part = "//*[@class='ag-center-cols-container']//div[@row-index='";
			String second_part = "']//div[@col-id='colorName']";

			// Used for loop for number of rows.
			for (int i = 0; i < Row_count; i++) {
				// Prepared final xpath of specific cell as per values of i.
				String final_xpath = first_part + i + second_part;
				String ColorNames = driver.findElement(By.xpath(final_xpath)).getText();
				// Will retrieve value from located cell and added them to array list.
				ColorList.add(ColorNames);
			}		
			int k=1;		
			ResultsLog.ReportDoneEvent("This Color file also consist of below valid color[s]");
			ResultsLog.ReportDoneEvent("-----------------------------------------------------------------");		
			for (int j = 0; j < Row_count; j++) {
				System.out.println(ColorList.get(j).toString());
				String ValidColorName = ColorList.get(j).toString();
				ResultsLog.ReportDoneEvent("Valid Color " + k + ": " + ValidColorName);
				k++;
			}
			ColorList.clear();
		}catch(NoSuchElementException e) {
			ResultsLog.ReportDoneEvent("*** This color file has no colors ***");
		}
	}

	public void clickColorLibrary() throws IOException {
		clickOnLink(btn_ColorLibrary(), "Color Library");
	}

	public void enterAutoItScript(int row) throws IOException {
		Runtime.getRuntime().exec(data.Getdata("AutoItScript Path", row));
	}

	public void enterColorLibraryName(int row) throws IOException {
		enterText(txt_ColorLibraryName(), "Color Library name", data.Getdata("Color Library", row));		}

	public void enterClientName(int row) throws IOException {
		enterText(txt_ClientName(), "Client Name", data.Getdata("Client Name", row));
	}

	public void selectColorLibraryandClient() throws Exception {
		clickOnLink(option_ColorLibraryandClient(), "Color Library Checkbox");
	}

	public void verifyColorLibraryName(int row) throws Exception {		
		String ColorLibraryName = data.Getdata("Color Library", row);
		try {
			String ColorLibrarFromAppliaction = check_ColorLibraryName().getText();
			if (!ColorLibrarFromAppliaction.equalsIgnoreCase(ColorLibraryName)) {
				ResultsLog.ReportFail(driver, "Color library: " + ColorLibraryName + " not match", Invalid);
				ColorLibrary_NotExist = true;
				clickOnLink(ChooseColorLibraryWindow_button_Cancel(), "Cancel button");
				select_lnk_ClearAll();
				result = "Fail";
			}
		}catch(NoSuchElementException e ) {
			ResultsLog.ReportFail(driver, "Color library: " + ColorLibraryName + " not exist", Invalid);
			ColorLibrary_NotExist = true;
			clickOnLink(ChooseColorLibraryWindow_button_Cancel(), "Cancel button");
			select_lnk_ClearAll();
			result = "Fail";
		}	
	}	

	public void updateColorLibraryandClient() throws Exception {
		try {
			clickOnLink(btn_Update(), "Update");
			System.out.println("selected update button");
		} catch (NoSuchElementException e) {
			System.out.println("Unable to select update button");
		}
	}

	public void select_lnk_ClearAll() throws Exception {
		try {
			clickOnLink(lnk_ClearAll(), "Clear All");
			System.out.println("selected Clear All link");
		} catch (NoSuchElementException e1) {
			System.out.println("Unable to select clear all link");
		} catch (NullPointerException e2) {
			System.out.println("Getting exception after selecting clear all link" + e2.toString().trim());
		}
	}

	public void ClickValidated() throws IOException, InterruptedException {
		clickOnLink(btn_Validated(), "Validated tab");
	}

	public void ClickValidate() throws IOException, InterruptedException {
		try {
			clickOnLink(btn_Validate(), "Validate button");
			System.out.println("Selected Validate button");
		} catch (NoSuchElementException e) {
			System.out.println("Unable to select Validate button");
		}
	}

	public void ClickFailed() throws IOException, InterruptedException {
		try {
			clickOnLink(btn_failed(), "Failed tab");
			System.out.println("Selected Failed tab");
		} catch (NoSuchElementException e) {
			System.out.println("Unable to select Failed tab");
		}
	}

	public static String ExecutionResult(String testResult) {
		return testResult = result;
	}

	public static void ValidProcess(List<String> ValidColors) throws Exception {
		try {
			ResultsLog.ReportDoneEvent("Validated Color(s) have been uploaded Successfully");
			ValidatedColorUploadedOk();
			// Validation from Colors grid
			try {
				ClickOnColorsGrid();
				Thread.sleep(6000);
				for (int i = 0; i < ValidColors.size(); i++) {
					System.out.println(ValidColors.get(i).toString());
					String ValidColorName = ValidColors.get(i).toString();
					enterColorName(ValidColorName);
					ClickImported_Color1link();
					WebElement colorName = driver.findElement(By.xpath("//span[@class='color-name']"));
					String Color1 = colorName.getText().trim();
					if (!Color1.equals(ValidColor.trim())) {
						ResultsLog.ReportFail(driver, "Color not imported: " + ValidColor, ValidColor);
					} else {
						ResultsLog.ReportDoneEvent("Color: " + ValidColor + " Imported Successfully");
					}
				}
			} catch (NoSuchElementException e) {
				ResultsLog.ReportFail(driver, "Color grid element not selected", e.toString());
				result = "Fail";
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found exception: //button[@class='swal2-confirm swal2-styled");
			result = "Fail";
		}
	}

	public void InvalidProcess() throws Exception {
		try {
			ImportValidatedCancel();
			select_lnk_ClearAll();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found exception for cancel button");
			result = "Fail";			
		}
	}

	public static void ValidatedColorUploadedOk() throws IOException, InterruptedException {

		try {
			clickOnLink(btn_Ok(), "Ok button");
		} catch (NoSuchElementException e) {
			System.out.println("Unable to select Ok button");
		}
	}

	public void GetValidColorsData() throws Exception {

		List<WebElement> ValidColors = driver
				.findElements(By.xpath("(//*[@class='table table-bordered table-fixed']/tbody/tr[1]/td[1])[1]"));
		List<String> ValidColorList = new ArrayList<String>();
		for (WebElement we : ValidColors) {
			ResultsLog.ReportDoneEvent("Color: " + we.getText() + " is validated successfully");
			ValidColorList.add(we.getText());
		}
		// If we have Invalid Colors below method will execute and fetch the invalid 
		// color names
		if (!invalidCount.trim().equals(zero)) {
			ClickFailed();
			GetInValidColorsData();
		}
		try {
			ImportValidatedColor();
			ValidProcess(ValidColorList);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	public void GetValidColorsDataToPrint() throws Exception {
		ClickValidated();
		Thread.sleep(2000);
		// fetching all Valid colors into list
		List<WebElement> ValidColors = driver
				.findElements(By.xpath("//*[@class='table table-bordered table-fixed']/tbody/tr[1]/td[1]"));
		int j = 1;
		ResultsLog.ReportDoneEvent("This Color file also consist of below valid colors");
		ResultsLog.ReportDoneEvent("-----------------------------------------------------------------");
		for (WebElement color : ValidColors) {
			ResultsLog.ReportDoneEvent("Valid Color " + j + ": " + color.getText());
			j++;
		}
	}

	public void GetInValidColorsData() throws Exception {
		// fetching all invalid colors into list
		List<WebElement> InvalidColors = driver
				.findElements(By.xpath("(//*[@class='table table-bordered table-fixed']/tbody/tr[1]/td[1])[2]"));
		// fetching all reasons for color became invalid into list
		List<WebElement> InvalidColorReason = driver
				.findElements(By.xpath("(//*[@class='table table-bordered table-fixed']/tbody/tr[1]/td[4])[2]"));

		// Storing all invalid colors and their reasons into array list
		List<String> InvalidColorsList = new ArrayList<String>();
		List<String> InvalidColorsReasonList = new ArrayList<String>();

		for (WebElement color : InvalidColors) {
			InvalidColorsList.add(color.getText());
		}
		for (WebElement color : InvalidColorReason) {
			InvalidColorsReasonList.add(color.getText());
		}

		// Concatenate Color Name and failed reason, then write that string into HTML
		// ReportFail
		int j = 1;
		ResultsLog.ReportFail(driver, "Color[s] NOT Imported", Invalid.trim());
		ResultsLog.ReportFail(driver, "Due to below Failed reason[s]", FailedDashedLine.trim());
		for (int i = 0; i < InvalidColorsList.size(); i++) {
			String FailedColorDeatils = InvalidColorsList.get(i).toString().trim() + ": "
					+ InvalidColorsReasonList.get(i).toString().trim();
			ResultsLog.ReportFail(driver, "Faild Color " + j + ": " + FailedColorDeatils, Invalid.trim());
			j++;
		}
	}

	public static void ClickOnColorsGrid() throws IOException {
		clickOnLink(Colors_Grid(), "Colors");
	}

	public static void ClickImported_Color1link() throws IOException {
		clickOnLink(Imported_Color1link(), "Color expand button");
	}

	public static void enterColorName(String ColorName) throws IOException {
		ValidColor = ColorName;
		enterText(txt_ColorName(), "Color Name", ValidColor);
	}

	// **********************************************************************************************************
	// ************* Below one handling logic for import the validated colors and  ******************************
	// ************* cancel the Failed color  *******************************************************************
	// ************** In case of if we have a valid colors we are pass the test case ****************************	
	// **********************************************************************************************************
	/*
	 * public void ValidationProcess() throws Exception {
	 * 
	 * //We are verifying the validated and failed colors count and //Handling logic
	 * for import the validated colors and cancel the Failed color
	 * if(btn_Validatation().isEnabled()) { Thread.sleep(2000); validCount =
	 * validCount().getText(); invalidCount = invalidCount().getText(); zero = "0";
	 * String ColorName = null;
	 * 
	 * //If we have Valid Colors below method will execute and fetch the valid color
	 * names //If both valid colors and invalid colors are exist then valid process
	 * method will execute //If only valid colors are exist then valid process
	 * method will execute if(!validCount.trim().equals(zero)) {
	 * if(!invalidCount.trim().equals(zero)) { GetValidColorsData(); } else {
	 * GetValidColorsData(); } if ( !invalidCount.trim().equals(zero)) { result =
	 * "Fail"; } else { result = "Pass"; } }
	 * 
	 * //If we have Invalid Colors below method will execute and fetch the invalid
	 * color names //If only invalid colors are exist then invalid process method
	 * will execute if(!invalidCount.trim().equals(zero)) {
	 * if(validCount.trim().equals(zero)) { ClickFailed(); GetInValidColorsData();
	 * InvalidProcess(); result = "Fail"; } } } }
	 */

	public void ValidationProcess() throws Exception {

		// We are verifying the validated and failed colors count and
		// Handling logic for import the validated colors and cancel the Failed color
		if (btn_Validated().isEnabled()) {
			Thread.sleep(2000);
			validCount = validCount().getText();
			invalidCount = invalidCount().getText();
			zero = "0";

			// If we have Valid Colors below method will execute and fetch the valid color
			// names
			// If both valid colors and invalid colors are exist then fetch the valid and
			// invalid colors list, print them in HTMl report and failed the test case
			// If only valid colors are exist then valid process method will execute
			if (!validCount.trim().equals(zero)) {
				if (!invalidCount.trim().equals(zero)) {
					ClickFailed();
					GetInValidColorsData();
					GetValidColorsDataToPrint();
					InvalidProcess();
					result = "Fail";
				} else {
					GetValidColorsData();
					result = "Pass";
				}
				/*if (!invalidCount.trim().equals(zero)) {					
					result = "Fail";
				} else {
					result = "Pass";
				}*/
			}

			// If we have Invalid Colors below method will execute and fetch the invalid
			// color names
			// If only invalid colors are exist then invalid process method will execute
			if (!invalidCount.trim().equals(zero)) {
				if (validCount.trim().equals(zero)) {
					ClickFailed();
					GetInValidColorsData();
					InvalidProcess();
					result = "Fail";
				}
			}
		}
	}

	public static void ImportValidatedColor() throws Exception {
		try {
			clickOnLink(btn_ImportValidatedColor(), "Import Validated Color buton");
			System.out.println("Import Validated Color Successfull");
		} catch (NoSuchElementException e) {
			System.out.println("Import Validated Color Unsuccessfull");
		}
	}

	public void ImportValidatedCancel() throws Exception {
		try {
			clickOnLink(btn_ImportValidateCancel(), "Cancel button");
			System.out.println("ImportValidated Cancelled Successfull");
		} catch (NoSuchElementException e) {
			System.out.println("ImportValidated Cancelled Unsuccessfull");
		}
	}

	// *****************************************************
	// ************** Actual Functional Method *************
	// *****************************************************

	public void importColor(int row) throws Exception {		
		clickImportColors();
		clickUploadFiles(row);
		Thread.sleep(2000);
		enterAutoItScript(row);
		Thread.sleep(10000);
		clickUploadAll(row);
		uploadedColorFileProcess(row);				
		if (!isServereError) {  			
			clickColorLibrary();
			enterColorLibraryName(row);
			enterClientName(row);
			Thread.sleep(2000);
			verifyColorLibraryName(row);
			if (!ColorLibrary_NotExist) {
				selectColorLibraryandClient();
				updateColorLibraryandClient();
				ClickValidate();
				ValidationProcess();
			}
			Thread.sleep(3000);
		} else {
			ResultsLog.ReportFail(driver, "imported file: " + UpoloadColorFileName + " has above error[s]", Invalid);			
			result = "Fail";
		}
		Thread.sleep(3000);			
	}		
}