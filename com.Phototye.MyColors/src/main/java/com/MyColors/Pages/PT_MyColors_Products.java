package com.MyColors.Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;
import com.google.common.collect.Table.Cell;

import jxl.read.biff.BiffException;


public class PT_MyColors_Products extends BasePages {
	Member_SignUpPagedata data = new Member_SignUpPagedata();
	PT_MyColors_MainMenu MenuPage = new PT_MyColors_MainMenu();
	PT_MyColors_Dashboard profilepage = new PT_MyColors_Dashboard();
	
	String clientName = null;	
	String Region = null;	
	String BusinessUnit = null;	
	String Brand = null;	
	String PackageType = null;	
	String Substrate = null;
	String SurfaceValue = null;
	String UpcValue = null;
	String Size = null;	
	String PrintProcess = null;	
	String Printer = null;
	String PrintCondition = null;
	String ColorLibrary = null;	
	String ColorName = null;	
	String clientName_Change = null;
	String Region_Change = null;
	String BusinessUnit_Change = null;	
	String Brand_Change = null;
	String PackageType_Change = null;
	String Substrate_Change = null;
	String Size_Change = null;
	String SurfaceReverse_Change = null;
	String UpcValue_Change = null;
	String Printer_Change = null;
	boolean PrinterListFound = false;
	String PrintCondition_Change = null;
	String PrintProcess_Change = "N/A";
	String SurfaceReverse = null;
	String Color_Change = null;
	String ColorLibrary_Change = null;
	String AddColor_Change = null;
	String churchAndDwight = "Church and Dwight";
	String artCode = null;
	String client_Change_Yes = "Yes";
	String success_message = null;
	String Invalid = "Validation Fail";
	String Valid = "Validation Success";
	String notApplicable = "NA";
	static String result = "Pass";
    public String element_status = null;
	int sucess_count=0;
	int fail_count=0;
	boolean added_newProduct = false;	
	boolean Color_AlreadyExist = false;
	boolean clientChange = false;
	boolean regionChange = false;
	boolean businessunitChange = false;
	boolean brandChange = false;
	boolean packagetypeChange = false;
	boolean substrateChange = false;
	boolean sizeChange = false;
	boolean printProcessChange = false;
	boolean surfaceReverseChange = false;
	boolean UpcChange = false;
	boolean printerChange = false;
	boolean printConditionChange = false;
	boolean colorLibraryChange = false;
	boolean colorChange = false;
	
	
	

	public PT_MyColors_Products() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
// Objects from Products Page

	public static WebElement Product_Grid() {
		return driver.findElement(By.xpath("//div[@class='ag-root ag-unselectable ag-layout-normal']"));
	}	
	
	public static WebElement btn_NewProduct() {
		return driver.findElement(By.xpath("//*[text()=' New Product ']"));
	}
		
	public static WebElement txt_Artcode() {
		return driver.findElement(By.xpath("//*[@id='artcode']"));
	}
	
	public static WebElement txt_Client() {
		return driver.findElement(By.xpath("//*[@id='client']"));
	}
	
	public static WebElement option_Client() {
		return driver.findElement(By.xpath("//*[@text=' Abbott International (Dev) ']"));		
	}
	
	public static WebElement dpd_Region() {
		return driver.findElement(By.xpath("//*[@id='region-list']"));	
	}
	
	public static WebElement dpd_BusinessUnit() {
		return driver.findElement(By.xpath("//*[@id='businessUnit-list']"));					
	}
	
	public static WebElement txt_Brand() {
		return driver.findElement(By.xpath("//input[@name='brand']"));
	}
	
	public static WebElement option_Brand() {
		return driver.findElement(By.xpath("//*[@id='ngb-typeahead-9-1']"));
	}
	
	public static WebElement dpd_PackageType() {
		return driver.findElement(By.xpath("//*[@id='package-type']"));
	}
	
	public static WebElement option_PackageType() {
		return driver.findElement(By.xpath("//*[text()=' New Product '//*[text()='Label']/parent::select]"));
	}
	
	public static WebElement dpd_Substrate() {
		return driver.findElement(By.xpath("//select[@id='substrate-list']"));
	}
	
	public static WebElement option_Substrate() {
		return driver.findElement(By.xpath("//*[text()='Paper']"));
	}
	
	public static WebElement txt_Size() {
		return driver.findElement(By.xpath("//*[@id='size']"));
	}
	
	public static WebElement dpd_PrintProcess() {
		return driver.findElement(By.xpath("//*[@id='process-list']"));
	}
	
	public static WebElement option_PrintProcess() {
		return driver.findElement(By.xpath("//*[text()='Dry Offset']"));
	}
	
	public static WebElement dpd_SurfaceList() {
		return driver.findElement(By.xpath("//*[@id='surface-list']"));
	}
		
	public static WebElement txt_UPC() {
		return driver.findElement(By.xpath("//*[@id='upc']"));
	}
	
	public static WebElement btn_AddPrinterDetails() {
		return driver.findElement(By.xpath("//*[@class='far fa-plus']"));
	}
	
	public static WebElement option_Printer() {
		return driver.findElement(By.xpath("//*[@id='printerCust']"));
	}
	
	public static WebElement option_PrintCondition() {
		return driver.findElement(By.xpath("//*[@id='printCon']"));
	}
	
	public static WebElement option_SurfaceList() {
		return driver.findElement(By.xpath("//*[text()='Surface']"));
	}
	
	public static WebElement dpd_Libraries() {
		return driver.findElement(By.xpath("//*[@id='library-list']"));
	}
	
	public static WebElement tst_DuplicateColorClose() {
		return driver.findElement(By.xpath("//i[@class='far fa-times'] [@aria-hidden='true']"));
	}
	
	public static WebElement option_Libraries() {
		return driver.findElement(By.xpath("//*[text()='All Libraries']"));
	}
	
	public static WebElement option_Colors() {
		return driver.findElement(By.xpath("//input[@id='color']"));
	}
	
	public static WebElement btn_Save() {
		return driver.findElement(By.xpath("//*[text()=' Save ']"));
	}	
	
	public static WebElement btn_Cancel() {
		return driver.findElement(By.xpath("//*[text()=' Cancel ']"));
	}
	
	public static WebElement btn_Close() {
		return driver.findElement(By.xpath("//*[@class='far fa-times-circle']"));
	}
	
	public static WebElement btn_Product() {
		return driver.findElement(By.xpath("/html/body/app-layout/app-dashboard/div/div/app-dashboard-product/section/div[2]/ag-grid-angular/div/div[2]/div[1]/div[3]/div[2]/div/div/div[8]/div[1]/span/span[2]/i']"));
	}
	
	public static WebElement invalid_Entry() {
		return driver.findElement(By.xpath("//*[text()='Artcode already exists for this customer. ']"));
	}
	
	public static WebElement product_Link() {
		return driver.findElement(By.xpath("/html/body/app-layout/app-dashboard/app-side-bar/nav/ul/li[11]/a/span"));
	}
	
	public static WebElement search_Product() {
		
		return driver.findElement(By.xpath("/html/body/app-layout/app-dashboard/div/div/app-dashboard-product/section/div[2]/ag-grid-angular/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/ng-component/input"));
		//return driver.findElement(By.xpath("//*[@class='ag-header-row']/div[@class='ag-header-cell']/div[@class='ag-floating-filter-full-body']/ng-component/*[@class='ng-pristine ng-valid ng-touched']"));
	} 
	
	public static WebElement verify_Product() {
		return driver.findElement(By.xpath("//*[@class='fas fa-arrow-circle-right']"));
	}
	
	public static WebElement edit_Product() {
		return driver.findElement(By.xpath("//*[@class='far fa-edit modify-icon edit']"));
		
	}
	
	public static WebElement close_ColorAlreadyExist_Validation() {
		return driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-edit-product/div[2]/form/div/div[2]/div[3]/div/span[2]"));
	}
	
	public static WebElement delete_Product() {
		return driver.findElement(By.xpath("//*[@class='fal fa-trash-alt' and @placement='top']"));		
	}
	
	public static WebElement delete_Pop_Product() {
		return driver.findElement(By.xpath("//*[contains(@class,'far fa-trash-alt')]"));		
	}
	
	
	// Each Object Performance Method
	// My Time Page
	
	public void clickbtnNewProduct() throws IOException {

		clickOnButton(btn_NewProduct(), "New Product");
	}	
	
	public void addClient(int row) throws Exception, NoSuchElementException {
		clientName = data.Getdata("Client", row);	
		if (!clientName.isEmpty()) {
			clickOnLink(txt_Client(), "Client");	
			List <WebElement> ClientListOptions=driver.findElements(By.xpath("//button[@role='option']"));
			
			for(WebElement we:ClientListOptions) {
				if(we.getText().trim().equalsIgnoreCase(clientName.trim())) {
					enterText(txt_Client(), "Client", clientName);					
					we.click();
					//The below sleep added because application taking long time to select the element 
					//it suppose to take max 10sec but taking almost 19sec for few clients
					switch(clientName.trim()) {
					case "Church and Dwight":
						Thread.sleep(10000);
						break;
					case "Tyson":
						Thread.sleep(10000);
						break;
					case "Beam Suntory Inc.":
						Thread.sleep(10000);
						break;
					default:
						Thread.sleep(10000);
						break;						  
					}					
					System.out.println("Client: "+clientName+ "Selected");
					break;
					}				
				}		
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for Client name",Invalid);
			result = "Fail";
		}
	}

	public void addRegion(int row) throws Exception {
		Region = data.Getdata("Region", row);
		if (!Region.isEmpty()) {			
			/*WebDriverWait wait1 = new WebDriverWait(driver, 10);
			WebDriverWait wait2 = new WebDriverWait(driver, 10)
			wait1.until(ExpectedConditions.elementToBeClickable(dpd_Region()));
			wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='region-list']")));*/
			clickOnLink(dpd_Region(), "Region");
			System.out.println("Region: "+data.Getdata("Region", row));			
			WebElement RegionList=driver.findElement(By.xpath("//*[contains(@id,'region-list')]"));
			Select regionType=new Select(RegionList);			
				regionType.selectByVisibleText(Region);			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for Region",Invalid);
			result = "Fail";
		}		
	}

	public void addBusinessUnit(int row) throws Exception {		
		BusinessUnit = data.Getdata("Business Unit", row);
		if (!BusinessUnit.isEmpty()) {
			clickOnLink(dpd_BusinessUnit(), "Business Unit");
			Select drpBusninessUnit = new Select(driver.findElement(By.xpath("//*[contains(@id,'businessUnit-list')]")));
			drpBusninessUnit.selectByVisibleText(BusinessUnit);
			System.out.println("In Method Business Unit: "+data.Getdata("Business Unit", row));
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Business Unit",Invalid);
			result = "Fail";
		}		
	}

	public void addBrand(int row) throws Exception {		
		Thread.sleep(1000);		
		Brand = data.Getdata("Brand", row);		
		if (!Brand.isEmpty()) {
			clickOnLink(txt_Brand(), "Brand");
			List <WebElement> BrandListOptions=driver.findElements(By.xpath("//button[@role='option']"));			
			for(WebElement we:BrandListOptions) {
				if(we.getText().trim().equalsIgnoreCase(Brand.trim())) {	
					we.click();
					System.out.println("Brand: "+Brand+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for Brand",Invalid);
			result = "Fail";
		}
	}

	public void addPackageType(int row) throws Exception {		
		PackageType = data.Getdata("PackageType", row);		
		if (!PackageType.isEmpty()) {
			clickOnLink(dpd_PackageType(), "Package Type");
			WebElement PackageTypeList=driver.findElement(By.xpath("//select[@name='package-type']"));
			Select packageType=new Select(PackageTypeList);		
			packageType.selectByVisibleText(PackageType);
			System.out.println("In Method PackageType: "+PackageType);		
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for PackageType",Invalid);
			result = "Fail";
		}
	}

	public void addSubstrate(int row) throws Exception {				
		Substrate = data.Getdata("Substrate", row);
		if (!Substrate.isEmpty()) {
			clickOnLink(dpd_Substrate(), "Substrate");
			WebElement SubstrateList=driver.findElement(By.xpath("//select[@name='substrate-list']"));
			Select substrateType=new Select(SubstrateList);
			substrateType.selectByVisibleText(Substrate);
			System.out.println("In Method Substrate: "+Substrate);			
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Substrate",Invalid);
			result = "Fail";
		}
	}

	public void addSize(int row) throws Exception {		
		Size = data.Getdata("Size", row);
		//Thread.sleep(5000);
		if (!Size.isEmpty()) {
			txt_Size().clear();
			clickOnLink(txt_Size(), "Size");			
			List <WebElement> SizeList=driver.findElements(By.xpath("//button[@role='option']"));		
			for(WebElement we:SizeList) {							
				if(we.getText().trim().equalsIgnoreCase(Size.trim())) {
					enterText(txt_Size(), "Size", data.Getdata("Size", row));
					Actions act = new Actions(driver);					
					act.moveToElement(we).perform();
					act.click();		
					System.out.println("Selected Size: "+we.getText());
					break;				
				}
			}
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Size",Invalid);
			result = "Fail";
		}
	}

	public void addPrintProcess(int row) throws Exception {	
		PrintProcess = data.Getdata("Print Process", row);
		if (!PrintProcess.isEmpty()) {
			clickOnLink(dpd_PrintProcess(), "PrintProcess");
			WebElement PrintProcessList=driver.findElement(By.xpath("//select[@name='process-list']"));
			Select PrintProcessListValue=new Select(PrintProcessList);
			PrintProcessListValue.selectByVisibleText(PrintProcess);	
			System.out.println("In Method Print Process: "+PrintProcess);			
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Print Process",Invalid);
			result = "Fail";
		}
	}

	public void addSurface(int row) throws Exception {		
		SurfaceValue = data.Getdata("Surface/Reverse", row);
		//Thread.sleep(5000);
		if (!SurfaceValue.isEmpty()) 
		{
			clickOnLink(dpd_SurfaceList(), "Surface/Reverse");
			WebElement SurfaceList=driver.findElement(By.xpath("//select[@name='surface-list']"));
			Select SurfaceListValue=new Select(SurfaceList);		
			SurfaceListValue.selectByVisibleText(SurfaceValue);
			System.out.println("In Method Surface/Reverse: "+SurfaceValue);
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Surface",Invalid);
			result = "Fail";
		}		
	}
	
	public void addUPC(int row) throws Exception {		
		UpcValue = data.Getdata("UPC", row);
		//Thread.sleep(5000);
		if (!UpcValue.isEmpty()) 
		{
			enterText(txt_UPC(), "UPC", data.Getdata("UPC", row));			
		}else{
			ResultsLog.ReportDoneEvent("UPC not enter the value for optional field UPC for Artcode: " + artCode.trim());
		}		
	}
	
	
	public void addPrinter(int row) throws Exception {
		if(btn_AddPrinterDetails().isDisplayed()){
			clickOnLink(btn_AddPrinterDetails(), "add print details");		
			Printer = data.Getdata("Printer", row);		
			if (!Printer.isEmpty()) {
				option_Printer().clear();
				clickOnLink(option_Printer(), "Printer");	
				List <WebElement> PrinterList=driver.findElements(By.xpath("//button[@role='option']"));
				System.out.println(PrinterList);
				for(WebElement list:PrinterList) {
					System.out.println("Printer lis is: "+ list.getText());
				}
				for(WebElement list:PrinterList) {
					String printerfromappl = list.getText().trim();
					if(list.getText().trim().equalsIgnoreCase(Printer.trim())) {		
						/*enterText(option_Printer(), "Printer", data.Getdata("Printer", row));
					Actions act = new Actions(driver);					
					act.moveToElement(list).perform();*/				
						list.click();		
						System.out.println("Selected Printer: "+printerfromappl.trim());
						PrinterListFound = true;	
						break;
					}				
				}		
				if(!PrinterListFound){
					ResultsLog.ReportFail(driver,"Values are not matching for Printer",Invalid);
					result = "Fail";
				}

			}else{
				ResultsLog.ReportFail(driver,"Please enter value for Printer",Invalid);
				result = "Fail";
			}
		}
	}

	public void addPrintCondition(int row) throws Exception {
		if(option_PrintCondition().isDisplayed()){
			PrintCondition = data.Getdata("PrintCondition", row);
			boolean PrinterCOnditionFound = false;
			//Thread.sleep(5000);
			if (!PrintCondition.isEmpty()) {			
				//option_PrintCondition().clear();
				clickOnLink(option_PrintCondition(), "PrintCondition");
				List <WebElement> PrinterList=driver.findElements(By.xpath("//button[@role='option']"));
				for(WebElement we:PrinterList) {							
					if(we.getText().trim().equalsIgnoreCase(PrintCondition.trim())) {
						String printcond = we.getText().trim();										
						we.click();
						System.out.println("Selected Print Condition: "+printcond.trim());						
						PrinterCOnditionFound = true;
						break;
					}

				}
				if(!PrinterCOnditionFound){
					ResultsLog.ReportFail(driver,"Values are not matching for Print Condition",Invalid);
					result = "Fail";
				}
			}
			else{
				ResultsLog.ReportFail(driver,"Please enter value for Printer Condition",Invalid);
				result = "Fail";
			}
		}
	}
	
	public void addColorLibrary(int row) throws Exception {		
		ColorLibrary = data.Getdata("AllLibraries", row);		
		if (!ColorLibrary.isEmpty()) {
			clickOnLink(dpd_Libraries(), "Color Library");
			WebElement LibrariesList=driver.findElement(By.xpath("//select[@name='library-list']"));
			Select Libraries=new Select(LibrariesList);				
			Libraries.selectByVisibleText(ColorLibrary);			
			System.out.println("In Method AllLibraries: "+ColorLibrary);
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Color Library",Invalid);
			result = "Fail";
		}
	}

	public void addColor(int row) throws Exception {
		boolean colorExist = false;
		ColorName = data.Getdata("Add Color", row);
		if (!ColorName.isEmpty()) {
			clickOnLink(option_Colors(), "Add Colors");
			enterText(option_Colors(), "Color", ColorName);
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//button[@role='option']"));
			String color = element.getText();
			System.out.println("application color: "+color);
			if (color.trim().equalsIgnoreCase(ColorName.trim())) {
				element.click();
				colorExist = true;
				ResultsLog.ReportDoneEvent("Color: "+color.trim()+" added");
				System.out.println("Color: "+color.trim());
			}else			{
				System.out.println("Color: " + ColorName + " not exist in application ");
			}			
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Color",Invalid);
			result = "Fail";
		}
			/*List<WebElement> ColorsList = driver.findElements(By.xpath("//*[@id='ngb-typeahead-4']/button"));
			Thread.sleep(1000);
			for (WebElement we : ColorsList) {
				String color = we.getText();
				if (color.trim().equalsIgnoreCase(ColorName.trim())) {
					Actions act = new Actions(driver);					
					act.moveToElement(we).perform();
					act.click();
					//robotClassActionForEnter();
					try
				    {
						we.click();
				    }
				    catch(StaleElementReferenceException e)
				    {
				    	we.click();
				    }
					
					System.out.println("Selected Color: " + ColorName);
					colorExist = true;
					break;			
					} 					
			}
			if(!colorExist)
			{
				System.out.println("Color: " + ColorName + " not exist in application ");
			}
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Color",Invalid);
			result = "Fail";
		}*/
	}	

	public void performEditSaveprocess() throws IOException, AWTException, InterruptedException {
		if(result != "Fail") {
			try {
				clickEditSave();					
			}
			catch(NoSuchElementException e) {
				System.out.println("Error in selecting save button");
				ResultsLog.ReportFail(driver, "Error in selecting save button", e.toString());
				result ="Fail";
			   }	
		}
		else
		{
			try {
				clickCancel();
				if(isAlertPresent()) {
					driver.switchTo().alert().accept();				
				}
				System.out.println("Product edited unsuccessfully for: "+artCode);
				ResultsLog.ReportDoneEvent("Product edited unsuccessfully for " + "artCode" + ": " + artCode.trim());
				fail_count = fail_count+1;
			}
			catch(NoSuchElementException e) {
				System.out.println("Error in selecting cancel button");
				ResultsLog.ReportFail(driver, "Error in selecting cancel button", e.toString());
				result = "Fail";
			}
		}
	}
	
	public void clickEditSave() throws IOException, AWTException, InterruptedException {
		clickOnButton(btn_Save(), "Save");

		//********* Verify whether product edited successfully by taking successful Toast message **********
		try {
			WebElement element = driver.findElement(By.xpath("//*[contains(text(),'edited successfully')]"));
			System.out.println("element*****: "+ element.getAttribute("innerText"));
			String editproduct_sucess_toast = " " + artCode + " edited successfully";
			
			if(element.getAttribute("innerText").matches(editproduct_sucess_toast))
			{
				System.out.println("Product edited successfully with "+artCode);
				ResultsLog.ReportDoneEvent("Product edited successfully with " + "artCode" + ": " + artCode.trim());
				sucess_count = sucess_count+1;
			}				
		}	
		catch(NoSuchElementException e)
		{
			System.out.println("Product edited unsuccessfully for: "+artCode);
			ResultsLog.ReportDoneEvent("Product edited unsuccessfully for " + "artCode" + ": " + artCode.trim());
			fail_count = fail_count+1;
		}		
	}
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 	    
	}  
	
	public void clickAddSave() throws IOException, AWTException, InterruptedException {
		if(!btn_Save().isEnabled())
		{
			clickCancel();							
			if(isAlertPresent()) {
				driver.switchTo().alert().accept();				
			}						
		}else {					
			clickOnButton(btn_Save(), "Save");
			//********* Verify whether product added successfully or duplicate art code by taking successful Toast message **********
			try {
				WebElement element = driver.findElement(By.xpath("//*[contains(text(),'added successfully')]"));				
				String addproduct_sucess_toast = " "+artCode+" added successfully";
				
				if(element.getAttribute("innerText").matches(addproduct_sucess_toast))
				{
					System.out.println("Product created successfully with "+artCode);
					ResultsLog.ReportDoneEvent("Product created successfully with " + "artCode" + ": " + artCode.trim());
					added_newProduct = true;
				}		
			}
			catch(NoSuchElementException e1){					
				WebElement duplicate_Artcode_Element = driver.findElement(By.xpath("//*[contains(text(),'Invalid Entry:')]"));
				String duplicate_artcode_toast = "Invalid Entry:";
				if(duplicate_Artcode_Element.getAttribute("innerText").matches(duplicate_artcode_toast)) {
					System.out.println("Duplicate Art Code: "+artCode);
					ResultsLog.ReportFail(driver, "Duplicate Artcode: " + artCode.trim()+" for "+clientName, e1.toString());
					result = "Fail";
					clickCancel();
					Thread.sleep(3000);
					if(isAlertPresent()) {
						driver.switchTo().alert().accept();				
					}								
				}
			}
		}
	}
	
	public void clickCancel() throws IOException {
		clickOnButton(btn_Cancel(), "Cancel");
		//btn_Cancel().click();
		//ResultsLog.ReportDoneEvent("Successfully clicked on button: Cancel");
	}
	
	public void clickDupArtcodeClose() throws IOException {
		clickOnButton(btn_Close(), "Cancel");		
	}
		
	public void enterArtcode(int row) throws IOException {		    
			enterText(txt_Artcode(), "ArtCode", data.Getdata("Artcode", row));
			artCode = data.Getdata("Artcode", row);
	}
	
	//Verify Product action methods
	
	public void clickbtnProductDetails() throws IOException {

		clickOnButton(verify_Product(), "Product Details");
	}
	
	public void verifyProduct_AfterAdd(int row) throws IOException, InterruptedException {
		if(added_newProduct) {
			enterText(search_Product(), "Artcode", artCode);
			clickbtnProductDetails();
			Thread.sleep(2000);

			boolean Client_Added = false;
			boolean Region_Added = false;		
			boolean Brand_Added = false;
			boolean PackageType_Added = false;
			boolean Substrate_Added = false;
			boolean Size_Added = false;
			boolean PrintProcess_Added = false;
			boolean SurfaceReverse_Added = false;
			boolean UPC_Added = false;
			boolean Printer_Added = false;
			boolean PrintCondition_Added = false;
			boolean ColorLibrary_Added = false;
			boolean Color_Added = false;	


			try {
				List <WebElement> ProductValues=driver.findElements(By.xpath("//div[@row-id='detail_0']/app-product-detail/div/div/div/*[@class='col-6 product-value']"));
				List <WebElement> PrinterDetails=driver.findElements(By.xpath("//div[@row-id='detail_0']/app-product-detail/div/div/div[2]/div"));

				System.out.println("***Xpath Found***");



				for(WebElement we:ProductValues) {
					String addclient = we.getText();
					if(addclient.trim().equalsIgnoreCase(clientName.trim())) {						
						System.out.println("Client name added for "+artCode);
						ResultsLog.ReportDoneEvent("Client added successfully for Artcode: " + artCode.trim());
						//ResultsLog.ReportPass(driver, "Client added successfully for Artcode: ", artCode.trim());						
						Client_Added = true;						
						break;
					}					
				}
				if(!Client_Added) {
					System.out.println("Client not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Client not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				for(WebElement we:ProductValues) {
					String addregion = we.getText();
					if(addregion.trim().equalsIgnoreCase(Region.trim())) {
						System.out.println("Region added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Region added successfully for Artcode: " + artCode.trim());
						Region_Added = true;
						break;
					}
				}
				if(!Region_Added) {
					System.out.println("region not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Region not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				if(clientName.matches(churchAndDwight))	{
					WebElement Business_Unit = driver.findElement(By.xpath("//div[@row-id='detail_0']/app-product-detail/div/div/div/*[@class='col-6 product-value ng-star-inserted']"));
					String addBusinessUnit = Business_Unit.getText();
					if(addBusinessUnit.trim().equalsIgnoreCase(BusinessUnit.trim())) {
						System.out.println("BusinessUnit added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("BusinessUnit added successfully for Artcode:" + artCode.trim());						
					}
					else{
						System.out.println("BusinessUnit not added for Artcode: " + artCode);
						ResultsLog.ReportFail(driver,"BusinessUnit not added for Artcode: " + artCode,Invalid.trim());
						result = "Fail";
					}
				}

				for(WebElement we:ProductValues) {
					String addBrand = we.getText();
					if(addBrand.trim().equalsIgnoreCase(Brand.trim())) {
						System.out.println("Brand added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Brand added successfully for Artcode: " + artCode.trim());
						Brand_Added = true;
						break;
					}
				}
				if(!Brand_Added) {
					System.out.println("Brand not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Brand not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}				

				for(WebElement we:ProductValues) {
					String addPackagetype = we.getText();
					if(addPackagetype.trim().equalsIgnoreCase(PackageType.trim())) {
						System.out.println("PackageType added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("PackageType added successfully for Artcode: " + artCode.trim());
						PackageType_Added = true;
						break;
					}				
				}
				if(!PackageType_Added) {
					System.out.println("PackageType not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"PackageType not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				for(WebElement we:ProductValues) {
					String addSubstrate = we.getText();
					if(addSubstrate.trim().equalsIgnoreCase(Substrate.trim())) {
						System.out.println("Substrate added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Substrate added successfully for Artcode: " + artCode.trim());
						Substrate_Added = true;
						break;
					}
				}
				if(!Substrate_Added) {
					System.out.println("Substrate not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Substrate not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				for(WebElement we:ProductValues) {
					String addSize = we.getText();
					if(addSize.trim().equalsIgnoreCase(Size.trim())) {
						System.out.println("Size added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Size added successfully for Artcode: " + artCode.trim());
						Size_Added = true;
						break;
					}
				}
				if(!Size_Added) {
					System.out.println("Size not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Size not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				for(WebElement we:ProductValues) {
					String addPrintProcess = we.getText();
					if(addPrintProcess.trim().equalsIgnoreCase(PrintProcess.trim())) {
						System.out.println("PrintProcess added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("PrintProcess added successfully for Artcode: " + artCode.trim());
						PrintProcess_Added = true;
						break;
					}
				}
				if(!PrintProcess_Added) {
					System.out.println("PrintProcess not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"PrintProcess not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				for(WebElement we:ProductValues) {
					String addSurfaceReverse = we.getText();
					if(addSurfaceReverse.trim().equalsIgnoreCase(SurfaceValue.trim())) {
						System.out.println("SurfaceReverse added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("SurfaceReverse added successfully for Artcode: " + artCode.trim());
						SurfaceReverse_Added = true;
						break;
					}
				}
				if(!SurfaceReverse_Added) {
					System.out.println("SurfaceReverse not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"SurfaceReverse not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				for(WebElement we:ProductValues) {
					String addUPC = we.getText();
					if(addUPC.trim().equalsIgnoreCase(UpcValue.trim())) {
						System.out.println("UPC added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("UPC added successfully for Artcode: " + artCode.trim());
						UPC_Added = true;
						break;
					}
				}
				if(!UPC_Added) {
					System.out.println("UPC not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"UPC not added for Artcode: " + artCode,Invalid.trim());				
					result = "Fail";
				}

				for(WebElement we:PrinterDetails) {
					String addPrinter = we.getText();
					if(addPrinter.trim().equalsIgnoreCase(Printer.trim())) {						
						System.out.println("Printer added for "+artCode);
						ResultsLog.ReportDoneEvent("Printer added successfully for Artcode: " + artCode.trim());
						//ResultsLog.ReportPass(driver, "Client added successfully for Artcode: ", artCode.trim());						
						Printer_Added = true;						
						break;
					}					
				}
				if(!Printer_Added) {
					System.out.println("Printer not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Printer not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				for(WebElement we:PrinterDetails) {
					String addPrintCondition = we.getText();
					if(addPrintCondition.trim().equalsIgnoreCase(PrintCondition.trim())) {						
						System.out.println("PrintCondition added for "+artCode);
						ResultsLog.ReportDoneEvent("PrintCondition added successfully for Artcode: " + artCode.trim());
						//ResultsLog.ReportPass(driver, "Client added successfully for Artcode: ", artCode.trim());						
						PrintCondition_Added = true;						
						break;
					}					
				}
				if(!PrintCondition_Added) {
					System.out.println("PrintCondition not added for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"PrintCondition not added for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}

				/*for(WebElement we:ProductValues) {
				String addColorLibrary = we.getText();
				if(addColorLibrary.trim().equalsIgnoreCase(ColorLibrary.trim())) {
					System.out.println("ColorLibrary added successfully for Artcode: "+artCode);
					ResultsLog.ReportDoneEvent("ColorLibrary added successfully for Artcode: " + artCode.trim());
					ColorLibrary_Added = true;
					break;
				}
			}
			if(!ColorLibrary_Added) {
				System.out.println("ColorLibrary not added for Artcode: " + artCode);
				ResultsLog.ReportFail(driver,"ColorLibrary not added for Artcode: " + artCode,Invalid.trim());
				result = "Fail";
			}*/


				try {				
					WebElement Color = driver.findElement(By.xpath("//div[@row-id='detail_0']/app-product-detail/div/div[3]/div/div[2]/span[2]"));				
					String addColor = Color.getText();
					if(addColor.trim().equalsIgnoreCase(ColorName.trim())) {
						System.out.println("Color added successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Color added successfully for Artcode: " + artCode.trim());
						Color_Added = true;						
					}
					else {
						System.out.println("Color not added for Artcode: " + artCode);
						ResultsLog.ReportFail(driver,"Color not added for Artcode: " + artCode,Invalid.trim());
						result = "Fail";
					}	
				}	
				catch(NoSuchElementException e) {
					System.out.println("Color Xpath not found");					
				}
			}

			catch(Exception e) {
				System.out.println("Product details Xpath not found: "+e.toString());
			}
		}
	}

	public void verifyProduct_AfterEdit(int row) throws IOException, InterruptedException {
		enterText(search_Product(), "Artcode", artCode);
		clickbtnProductDetails();
		Thread.sleep(3000);
		boolean PrintProcess_updated = false;		
		boolean ColorLibrary_updated = false;
		boolean Color_updated = false;
		boolean Size_updated = false;
		boolean Substrate_updated = false;
		boolean PackageType_updated = false;
		boolean Brand_updated = false;
		boolean Region_updated = false;
		boolean BusinessUnit_Updated = false;
		boolean Client_updated = false;
		boolean SurfaceReverse_updated = false;
		boolean UPC_updated = false;
		boolean Printer_updated = false;
		boolean PrintCondition_updated = false;
		
		try {
			List <WebElement> ProductValues=driver.findElements(By.xpath("//div[@id='detailContainer']//div/div/div[@class='col-6 product-value']"));
			List <WebElement> PrinterDetails=driver.findElements(By.xpath("//div[@class='row product-detail-pc']/div[2]/div"));
			//List <WebElement> ProductValues=driver.findElements(By.xpath("//div[@row-id='detail_0']/app-product-detail/div/div/div/*[@class='col-6 product-value']"));

			System.out.println("***Xpath Found***");
			if(clientChange) {			
				for(WebElement we:ProductValues) {
					String client = we.getText();
					if(client.trim().equalsIgnoreCase(clientName.trim())) {
						System.out.println("Client name updated for "+artCode);
						ResultsLog.ReportDoneEvent("Client updated successfully for Artcode: " + artCode.trim());
						Client_updated = true;
						break;
					}					
				}
				if(!Client_updated) {
					System.out.println("Client not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Client not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}		

			if(regionChange) {			
				for(WebElement we:ProductValues) {						
					String region = we.getText();
					System.out.println("Region values in loop: "+region.trim());
					if(region.trim().equalsIgnoreCase(Region_Change.trim())) {
						System.out.println("Region updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Region updated successfully for Artcode: " + artCode.trim());
						Region_updated = true;
						break;
					}
				}
				if(!Region_updated) {
					System.out.println("region not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Region not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(clientName.matches(churchAndDwight))	{
				if(businessunitChange) {
					WebElement Business_Unit = driver.findElement(By.xpath("//div[@id='detailContainer']/div/div/div[@class='col-6 product-value ng-star-inserted']"));
					String BusinessUnit = Business_Unit.getText();
					if(BusinessUnit.trim().equalsIgnoreCase(BusinessUnit_Change.trim())) {
						System.out.println("BusinessUnit updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("BusinessUnit updated successfully for Artcode:" + artCode.trim());				
					}else {
						System.out.println("BusinessUnit not updated for Artcode: " + artCode);
						ResultsLog.ReportFail(driver,"BusinessUnit not updated for Artcode: " + artCode,Invalid.trim());
						result = "Fail";
					}
				}
			}


			if(brandChange) {			
				for(WebElement we:ProductValues) {
					String brand = we.getText();
					if(brand.trim().equalsIgnoreCase(Brand_Change.trim())) {
						System.out.println("Brand updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Brand updated successfully for Artcode: " + artCode.trim());
						Brand_updated = true;
						break;
					}
				}
				if(!Brand_updated) {
					System.out.println("Brand not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Brand not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(packagetypeChange) {			
				for(WebElement we:ProductValues) {
					String Packagetype = we.getText();
					if(Packagetype.trim().equalsIgnoreCase(PackageType_Change.trim())) {
						System.out.println("PackageType updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("PackageType updated successfully for Artcode: " + artCode.trim());
						PackageType_updated = true;
						break;
					}				
				}
				if(!PackageType_updated) {
					System.out.println("PackageType not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"PackageType not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(substrateChange) {			
				for(WebElement we:ProductValues) {
					String Substrate = we.getText();
					if(Substrate.trim().equalsIgnoreCase(Substrate_Change.trim())) {
						System.out.println("Substrate updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Substrate updated successfully for Artcode: " + artCode.trim());
						Substrate_updated = true;
						break;
					}
				}
				if(!Substrate_updated) {
					System.out.println("Substrate not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Substrate not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(sizeChange) {			
				for(WebElement we:ProductValues) {
					String Size = we.getText();
					if(Size.trim().equalsIgnoreCase(Size_Change.trim())) {
						System.out.println("Size updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Size updated successfully for Artcode: " + artCode.trim());
						Size_updated = true;
						break;
					}
				}
				if(!Size_updated) {
					System.out.println("Size not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Size not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(printProcessChange) {			
				for(WebElement we:ProductValues) {
					String PrintProcess = we.getText();
					if(PrintProcess.trim().equalsIgnoreCase(PrintProcess_Change.trim())) {
						System.out.println("PrintProcess updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("PrintProcess updated successfully for Artcode: " + artCode.trim());
						PrintProcess_updated = true;
						break;
					}
				}
				if(!PrintProcess_updated) {
					System.out.println("PrintProcess not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"PrintProcess not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(surfaceReverseChange) {			
				for(WebElement we:ProductValues) {
					String SurfaceReverse = we.getText();
					if(SurfaceReverse.trim().equalsIgnoreCase(SurfaceReverse_Change.trim())) {
						System.out.println("SurfaceReverse updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("SurfaceReverse updated successfully for Artcode: " + artCode.trim());
						SurfaceReverse_updated = true;
						break;
					}
				}
				if(!SurfaceReverse_updated) {
					System.out.println("SurfaceReverse not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"SurfaceReverse not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}
			
			if(UpcChange) {			
				for(WebElement we:ProductValues) {
					String UPC = we.getText();
					if(UPC.trim().equalsIgnoreCase(UpcValue_Change.trim())) {
						System.out.println("UPC updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("UPC updated successfully for Artcode: " + artCode.trim());
						UPC_updated = true;
						break;
					}
				}
				if(!UPC_updated) {
					System.out.println("UPC not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"UPC not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(printerChange) {			
				for(WebElement we:PrinterDetails) {
					String printer = we.getText();
					if(printer.trim().equalsIgnoreCase(Printer_Change.trim())) {						
						System.out.println("Printer updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Printer updated successfully for Artcode: " + artCode.trim());
						Printer_updated = true;						
						break;
					}
				}
				if(!Printer_updated) {
					System.out.println("Printer not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Printer not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			if(printConditionChange) {			
				for(WebElement we:PrinterDetails) {
					String printCondition = we.getText();
					if(printCondition.trim().equalsIgnoreCase(PrintCondition_Change.trim())) {
						//System.out.println("Print Condition updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("Print Condition updated successfully for Artcode: " + artCode.trim());
						PrintCondition_updated = true;
						break;
					}
				}
				if(!PrintCondition_updated) {
					System.out.println("Print Condition not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"Print Condition not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}

			/*if(colorLibraryChange) {			
				for(WebElement we:ProductValues) {
					String ColorLibrary = we.getText();
					if(ColorLibrary.trim().equalsIgnoreCase(ColorLibrary_Change.trim())) {
						System.out.println("ColorLibrary updated successfully for Artcode: "+artCode);
						ResultsLog.ReportDoneEvent("ColorLibrary updated successfully for Artcode: " + artCode.trim());
						ColorLibrary_updated = true;
						break;
					}
				}
				if(!ColorLibrary_updated) {
					System.out.println("ColorLibrary not updated for Artcode: " + artCode);
					ResultsLog.ReportFail(driver,"ColorLibrary not updated for Artcode: " + artCode,Invalid.trim());
					result = "Fail";
				}
			}*/

			if(colorChange) {	
				// Get number of rows In Color grid table.
				List<String> ColorList = new ArrayList<String>();		
				try {
					//allRows_Count includes header and footer, Row_count excludes those
					int allRows_Count = driver.findElements(By.xpath("//div[@id='detailContainer']//div[3][@class='col divider-top']/div/div")).size();
					int Row_count = allRows_Count-2;

					// divided xpath In two parts to pass Row count values.
					String first_part = "//div[@id='detailContainer']//div[3][@class='col divider-top']/div/div[";
					String second_part = "]/span[2]";

					// Used for loop for number of rows.
					for (int i = 2; i < allRows_Count; i++) {
						// Prepared final xpath of specific cell as per values of i.
						String final_xpath = first_part + i + second_part;
						String ColorNames = driver.findElement(By.xpath(final_xpath)).getText();
						// Will retrieve value from located cell and added them to array list.
						ColorList.add(ColorNames);
					}
					for (int j = 0; j < Row_count; j++) {
						System.out.println(ColorList.get(j).toString());
						String Color = ColorList.get(j).toString();						
						if(Color.trim().equalsIgnoreCase(Color_Change.trim())) {
							System.out.println("Color updated successfully for Artcode: "+artCode);
							ResultsLog.ReportDoneEvent("Color updated successfully for Artcode: " + artCode.trim());
							Color_updated = true;
							break;
						}
					}
					if(!Color_updated) {
						System.out.println("Color not updated for Artcode: " + artCode);
						ResultsLog.ReportFail(driver,"Color not updated for Artcode: " + artCode,Invalid.trim());
						result = "Fail";
					}			
				}catch(Exception e) {
					System.out.println("ColorList Xpath not found: "+e.toString());
				}	
			}
		}
		catch(Exception e) {
			System.out.println("Product details Xpath not found: "+e.toString());
		}
	}		
	
	public void clickArtCode(int row) throws IOException {
		clickOnLink(verify_Product(), "Selected Artcode");
	}
			
	//Edit methods
	public void enterArtcodeToModify(int row) throws IOException {		
		enterText(search_Product(), "ArtCode", data.Getdata("Artcode", row));
		artCode = data.Getdata("Artcode", row);
	}
	
	public void editClient(int row) throws Exception, NoSuchElementException {
		clientName_Change = data.Getdata("Client Change", row);	
		clientName = data.Getdata("Client", row);
		System.out.println("Client change details from Excel:"+clientName_Change);
		if (clientName_Change.equalsIgnoreCase(client_Change_Yes))      //This condition is for client name change for the product, if no client change then we didn't clear the client data so that no fields got changed
		{
			txt_Client().clear();                							//We added this logic for Edit product, in case client name is change for existing product, we should clear existing client data
			clientChange = true;
		}
		clickOnLink(txt_Client(), "Client");	
		List <WebElement> ClientListOptions=driver.findElements(By.xpath("//button[@role='option']"));
		for(WebElement we:ClientListOptions) {
			if(we.getText().equalsIgnoreCase(data.Getdata("Client", row))) {
				//enterText(txt_Client(), "Client", data.Getdata("Client", row));
				we.click();
				break;
			}
		}	   
	}
	
	public void editRegion(int row) throws Exception {	
		Region_Change = data.Getdata("Region", row);
		//if (Region_Change != null && !notApplicable.equalsIgnoreCase(Region_Change)) 
		if (Region_Change != null && !Region_Change.isEmpty())
		{
			regionChange = true;
			clickOnLink(dpd_Region(), "Region");
			System.out.println("Region: "+data.Getdata("Region", row));		   
			WebElement RegionList=driver.findElement(By.xpath("//*[contains(@id,'region-list')]"));
			Select regionType=new Select(RegionList);
			regionType.selectByVisibleText(Region_Change);		   
	    }		
	}
	
	public void editBusinessUnit(int row) throws Exception {		
		BusinessUnit_Change = data.Getdata("Business Unit", row);
		//if (BusinessUnit_Change != null && !notApplicable.equalsIgnoreCase(BusinessUnit_Change)) 
		if (BusinessUnit_Change != null && !BusinessUnit_Change.isEmpty()) 
		{
			businessunitChange = true;
			clickOnLink(dpd_BusinessUnit(), "Business Unit");
			Select drpBusninessUnit = new Select(driver.findElement(By.xpath("//*[contains(@id,'businessUnit-list')]")));
			drpBusninessUnit.selectByVisibleText(BusinessUnit_Change);
			System.out.println("In Method Business Unit: "+data.Getdata("Business Unit", row));
		}		
	}
	public void clearBrand(int row) throws Exception {
		txt_Brand().clear();
		Thread.sleep(1000);
	}
	public void editBrand(int row) throws Exception {			
		Thread.sleep(1000);			
		Brand_Change = data.Getdata("Brand", row);		
		//if (Brand_Change != null && !notApplicable.equalsIgnoreCase(Brand_Change)) 
		if (Brand_Change != null && !Brand_Change.isEmpty())
		{
			brandChange = true;
			clearBrand(row);
			clickOnLink(txt_Brand(), "Brand");			
			List <WebElement> BrandListOptions=driver.findElements(By.xpath("//button[@role='option']"));
			for(WebElement we:BrandListOptions) {
				if(we.getText().equalsIgnoreCase(Brand_Change)) {			
					System.out.println("In Method Brand: "+Brand_Change);					
					we.click();
					break;
				}
			}
		}
	}
	
	public void editPackageType(int row) throws Exception {		
		PackageType_Change = data.Getdata("PackageType", row);		
		//if (PackageType_Change != null && !notApplicable.equalsIgnoreCase(PackageType_Change))
		if (PackageType_Change != null && !PackageType_Change.isEmpty())
		{
			packagetypeChange = true;
			clickOnLink(dpd_PackageType(), "Package Type");
			WebElement PackageTypeList=driver.findElement(By.xpath("//select[@name='package-type']"));
			Select packageType=new Select(PackageTypeList);		
			packageType.selectByVisibleText(PackageType_Change);
			System.out.println("In Method PackageType: "+PackageType_Change);		
		}
	}
	
	public void editSubstrate(int row) throws Exception {				
		Substrate_Change = data.Getdata("Substrate", row);
		if (Substrate_Change != null && !Substrate_Change.isEmpty())
		{
			substrateChange = true;
			clickOnLink(dpd_Substrate(), "Substrate");
			WebElement SubstrateList=driver.findElement(By.xpath("//select[@name='substrate-list']"));
			Select substrateType=new Select(SubstrateList);
			substrateType.selectByVisibleText(Substrate_Change);
			System.out.println("In Method Substrate: "+Substrate_Change);			
		}
	}
	
	public void editSize(int row) throws Exception {		
		Size_Change = data.Getdata("Size", row);
		//Thread.sleep(5000);
		if (Size_Change != null && !Size_Change.isEmpty()) 
		{
			sizeChange = true;
			txt_Size().clear();
			clickOnLink(txt_Size(), "Size");
			List <WebElement> SizeList=driver.findElements(By.xpath("//button[@role='option']"));
			for(WebElement we:SizeList) {
				if(we.getText().equalsIgnoreCase(Size_Change)) {
					enterText(txt_Size(), "Size", data.Getdata("Size", row));
					Actions act = new Actions(driver);					
					act.moveToElement(we).perform();
					act.click();		
					System.out.println("Updated Size: "+we.getText());
					break;								
				}
			}
		}
	}
	
	public void editPrintProcess(int row) throws Exception {	
		PrintProcess_Change = data.Getdata("Print Process", row);
		if (PrintProcess_Change != null && !PrintProcess_Change.isEmpty()) 
		{
			printProcessChange = true;
			clickOnLink(dpd_PrintProcess(), "PrintProcess");
			WebElement PrintProcessList=driver.findElement(By.xpath("//select[@name='process-list']"));
			Select PrintProcessListValue=new Select(PrintProcessList);
			PrintProcessListValue.selectByVisibleText(PrintProcess_Change);	
			System.out.println("In Method Print Process: "+PrintProcess_Change);			
		}
	}
	
	public void editSurface(int row) throws Exception {		
		SurfaceReverse_Change = data.Getdata("Surface/Reverse", row);
		//Thread.sleep(5000);
		if (SurfaceReverse_Change != null && !SurfaceReverse_Change.isEmpty()) 
		{
			surfaceReverseChange = true;
			clickOnLink(dpd_SurfaceList(), "Surface/Reverse");
			WebElement SurfaceList=driver.findElement(By.xpath("//select[@name='surface-list']"));
			Select SurfaceListValue=new Select(SurfaceList);		
			SurfaceListValue.selectByVisibleText(SurfaceReverse_Change);
			System.out.println("In Method Surface/Reverse: "+SurfaceReverse_Change);
		}
		
	}
	
	public void editUPC(int row) throws Exception {		
		UpcValue_Change = data.Getdata("UPC", row);		
		if (!UpcValue_Change.isEmpty()) 
		{
			txt_UPC().clear();
			enterText(txt_UPC(), "UPC", UpcValue_Change);	
			UpcChange = true;
		}	
	}
	
	public void editPrinter(int row) throws Exception {					
		Printer_Change = data.Getdata("Printer", row);		
		//if (Brand_Change != null && !notApplicable.equalsIgnoreCase(Brand_Change)) 
		if (Printer_Change != null && !Printer_Change.isEmpty())
		{
			printerChange = true;
			option_Printer().clear();
			clickOnLink(option_Printer(), "Printer");			
			List <WebElement> PrinterList=driver.findElements(By.xpath("//*[@role='option']"));
			for(WebElement we:PrinterList) {							
				if(we.getText().trim().equalsIgnoreCase(Printer_Change.trim())) {				
					System.out.println("In Method Printer: "+Printer_Change);					
					we.click();
					break;
				}
			}
		}
	}

	public void editPrintCondition(int row) throws Exception {					
		PrintCondition_Change = data.Getdata("PrintCondition", row);		
		//if (Brand_Change != null && !notApplicable.equalsIgnoreCase(Brand_Change)) 
		if (PrintCondition_Change != null && !PrintCondition_Change.isEmpty())
		{
			printConditionChange = true;
			option_PrintCondition().clear();
			clickOnLink(option_PrintCondition(), "PrintCondition");	
			enterText(option_PrintCondition(), "Print Condition", PrintCondition_Change);
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//button[@role='option']"));
			String printcond = element.getText();
			System.out.println("application color: "+printcond);
			if (printcond.trim().equalsIgnoreCase(PrintCondition_Change.trim())) {
				element.click();
				//colorExist = true;
				ResultsLog.ReportDoneEvent("Print Condition: "+printcond.trim()+" updated");
				System.out.println("Print Condition: "+printcond.trim());
			}else			{
				System.out.println("Print Condition: " + PrintCondition_Change + " not exist in application ");
			}	
			/*List <WebElement> PrinterList=driver.findElements(By.xpath("//*[@role='option']"));
			for(WebElement we:PrinterList) {							
				if(we.getText().trim().equalsIgnoreCase(PrintCondition_Change.trim())) {
					String printcond = we.getText().trim();
					enterText(option_PrintCondition(), "Print Condition", data.Getdata("PrintCondition", row));						
					we.click();
					System.out.println("Print Condition Updated as: "+printcond);
					break;					
				}
			}*/
		}
	}
	
	
	public void editColorLibrary(int row) throws Exception {		
		ColorLibrary_Change = data.Getdata("AllLibraries", row);		
		if (ColorLibrary_Change != null && !ColorLibrary_Change.isEmpty()) 		{
			colorLibraryChange = true;
			clickOnLink(dpd_Libraries(), "Color Library");
			WebElement LibrariesList=driver.findElement(By.xpath("//select[@name='library-list']"));
			Select Libraries=new Select(LibrariesList);		
			Libraries.selectByVisibleText(ColorLibrary_Change);			
			System.out.println("In Method AllLibraries: "+ColorLibrary_Change);
		}
	}

	
	public void editColor(int row) throws Exception {
		String colorAlreadyExist_toast = "Product already contains this color";		
		Color_Change = data.Getdata("Add Color", row);
		boolean color_matched =false;
		if (Color_Change != null && !Color_Change.isEmpty()) {
			colorChange = true;
			enterText(option_Colors(), "Color", Color_Change);
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//button[@role='option']"));
			String color = element.getText();
			System.out.println("application color: "+color);
			if (color.trim().equalsIgnoreCase(Color_Change.trim())) {
				element.click();
				//colorExist = true;
				ResultsLog.ReportDoneEvent("Color: "+color.trim()+" appended");
				System.out.println("Color: "+color.trim());
				System.out.println("*********** GitHub Testing ************* ");
			}else			{
				System.out.println("Color: " + Color_Change + " not exist in application ");
			}			
		}
		/*	clickOnLink(option_Colors(), "Add Colors");
			enterText(option_Colors(), "Color", Color_Change);
			List<WebElement> ColorsList = driver.findElements(By.xpath("//*[@id='ngb-typeahead-4']/button"));
			//List<WebElement> ColorsList = driver.findElements(By.xpath("//button[@role='option']"));

			for (WebElement we : ColorsList) {
				if (we.getText().trim().equalsIgnoreCase(Color_Change.trim())) {
					Actions act = new Actions(driver);					
					act.moveToElement(we).perform();
					act.click();
					//WebElement.sendKeys(Keys.RETURN);
					//robotClassActionForEnter();
					//we.click();
					color_matched = true;
					System.out.println("Updated or appended Color: " + Color_Change);
					break;					
				} 
			}
			if(!color_matched){
				System.out.println("Color: " + Color_Change + " not exist in application ");
			}*/

		try {
			WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Product already contains this color')]"));			
			if (element.getAttribute("innerText").trim().matches(colorAlreadyExist_toast)) {
				System.out.println("**** entered into If condition****");
				try {
					WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/i[@class='far fa-times-circle ng-tns-c12-0 ng-star-inserted']"));
					element2.click();
				} catch (NoSuchElementException e2) {
					WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/a/i[@class='far fa-times']"));
					element2.click();
				}
				System.out.println("Product having duplicate color for Artcode" + artCode);
				ResultsLog.ReportFail(driver,"Color not updated to this color library due to " + colorAlreadyExist_toast.trim(),colorAlreadyExist_toast.trim());
				result = "Fail";
			}
		} catch (NoSuchElementException e) {
			System.out.println("This color added [or] appended successfully");
			result = "Pass";
		}

	}
	
	public void editProduct(int row) throws IOException, NullPointerException, NoSuchElementException {			
		try {
			clickOnLink(edit_Product(), "Edit Product");
		}			
		catch(NoSuchElementException e2){
			ResultsLog.ReportFail(driver, "Given Art Code: " + artCode.trim() + " not found", e2.toString());
			result = "Fail";
		}
	}
		
	//Delete Product methods
	
	public void deleteProduct(int row) throws IOException, NullPointerException, NoSuchElementException, InterruptedException {
			try {				
				clickOnLink(delete_Product(), "Delete Product");
				deletePopupProduct(row);

				//********* Verify whether product deleted successfully by taking successful Toast message **********

				WebElement element = driver.findElement(By.xpath("//div[@class='toast-c']/div[contains(text(),'Product deleted successfully')]"));
				System.out.println("Inner Text: "+element.getAttribute("innerText"));
				String deleteproduct_sucess_toast = "Product deleted successfully";

				if(element.getAttribute("innerText").trim().matches(deleteproduct_sucess_toast))
				{
					System.out.println("Product deleted successfully with "+artCode);
					ResultsLog.ReportDoneEvent("Product deleted successfully with artCode" + ": " + artCode.trim());
					verifyProduct_AfterDelete(row);
				} else {
					System.out.println("Product deleted unsuccessfully for: "+artCode);
					ResultsLog.ReportDoneEvent("Product deleted unsuccessfully for " + "artCode" + ": " + artCode.trim());
					fail_count = fail_count+1;
				}								
			}
			catch(NoSuchElementException e2){
				ResultsLog.ReportFail(driver, "Given Art Code: " + artCode.trim() + " not found", e2.toString());
				element_status = "not exist";
				result = "Fail";
			}				
		}
		
	    public void deletePopupProduct(int row) throws IOException {
			   clickOnLink(delete_Pop_Product(), "Delete popup Product");
		   	   System.out.println("Product deleted successfully");	   	
		   
		}
	    
	    public void verifyProduct_AfterDelete(int row) throws IOException, NullPointerException, NoSuchElementException, InterruptedException {
			enterArtcodeToModify(row);
			Thread.sleep(1000);
			try {
				clickOnLink(delete_Product(), "Delete Product");
				ResultsLog.ReportFail(driver, "Delete Product verification fail for Artcode: " + artCode.trim(), Invalid);
				result = "Fail";
				
			}catch(NoSuchElementException e){
				//ResultsLog.ReportPass(driver, "Delete Product Verified for Art Code: "+ artCode.trim(), Valid);
				ResultsLog.ReportDoneEvent("Delete Product Verified for Art Code" + ": " + artCode.trim());
			}		
		}
	    
	    public static String ExecutionResult(String testResult) {
			return testResult = result;
		}
	    
	
	//*****************************************************
	//************** Actual Functional Method *************
	//*****************************************************

	//************* Adding new product ********************	
	public void addProduct(int row) throws Exception {		
		clickbtnNewProduct();
		enterArtcode(row);
		addClient(row);
		Thread.sleep(1000);
		addRegion(row);
		if(clientName.matches(churchAndDwight))	{
			addBusinessUnit(row);
		};
		addBrand(row);
		addPrintProcess(row);
		addSurface(row);
		addPackageType(row);
		addSubstrate(row);
		addSize(row);
		addUPC(row);
		addPrinter(row);
		addPrintCondition(row);
		addColorLibrary(row);
		Thread.sleep(2000);
		addColor(row);
		Thread.sleep(2000);
		clickAddSave();	
		verifyProduct_AfterAdd(row);
		Thread.sleep(3000);		
	}		
	
	//************ Edit Product execution section *************************
	public void editProducts(int row) throws Exception {		
		enterArtcodeToModify(row);
		editProduct(row);
		editClient(row);
		Thread.sleep(1000);		
		editRegion(row);
		if(clientName.matches(churchAndDwight))
		{
			editBusinessUnit(row);
		};
		editBrand(row);
		editPrintProcess(row);
		editSurface(row);
		editPackageType(row);
		editSubstrate(row);
		editSize(row);
		editPrintProcess(row);
		editSurface(row);
		editUPC(row);
		editPrinter(row);
		editPrintCondition(row);
		editColorLibrary(row);
		editColor(row);
		Thread.sleep(2000);
		performEditSaveprocess();		
		verifyProduct_AfterEdit(row);
		Thread.sleep(3000);	
	}


	//************ Delete Product execution section *************************
	public void deleteProducts(int row) throws Exception {	
		enterArtcodeToModify(row);
		deleteProduct(row);	
		Thread.sleep(3000);
	}
}





