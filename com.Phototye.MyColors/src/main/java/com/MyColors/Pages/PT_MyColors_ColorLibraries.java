package com.MyColors.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

public class PT_MyColors_ColorLibraries extends BasePages {
	Member_SignUpPagedata data = new Member_SignUpPagedata();
	PT_MyColors_MainMenu MenuPage = new PT_MyColors_MainMenu();
	PT_MyColors_Dashboard profilepage = new PT_MyColors_Dashboard();
	boolean isServereError = false;
	boolean ColorLibrary_NotExist = false;
	static String result = "Pass";
	static String ValidColor = null;
	static String colorLibaryName = null;
	static String illuminant = null;
	static String eFormulaType = null;
	static String eFormulaType_Properties = null;
	static String Client_Properties = null;
	static String observerAngle = null;
	static String measurementCondition = null;
	static String tolerance = null;
	static String clientname = null;
	static String clientname1 = null;
	static String clientname2 = null;
	static String clientname3 = null;
	static String clientname4 = null;
	static String clientname5 = null;
	String selectall = "Select All";
	static int totalClients = 0;
	static String color = null;
	static String weight1 = null;
	static String weight2 = null;
	static String weight3 = null;
	static boolean duplicateColorLibraryExist = false;
	String Invalid = "Validation Fail";
	String validCount = null;
	String invalidCount = null;
	String zero = "0";
	String colorLibrary = null;
	String description = null;
	String UploadCount = "x";
	String FailedDashedLine = "-------------------------------------------";
	int i = 1;
	public PT_MyColors_ColorLibraries() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}		

// Objects from Application

	public static WebElement colorLibraries_Grid() {
		return driver.findElement(By.xpath("//*[@class='far fa-qrcode']"));
	}

	public static WebElement btn_NewColorLibrary() {
		return driver.findElement(By.xpath("//*[@class='btn btn-curve btn-primary btn-move-right' or @class='btn btn-curve btn-primary btn-move-right ng-star-inserted']"));

	}
	
	public static WebElement txt_LibraryName() {
		return driver.findElement(By.xpath("//*[@id='colorLibraryName']"));

	}
	
	public static WebElement txt_Description() {
		return driver.findElement(By.xpath("//*[@id='colorLibraryDesc']"));

	}
	
	public static WebElement drpdwn_Illuminant() {		
		return driver.findElement(By.xpath("//*[@name='illuminantId']"));

	}	
	
	public static WebElement drpdwn_Observer_Angle() {		
		return driver.findElement(By.xpath("//*[@name='observerAngleLookupId']"));

	}
	
	public static WebElement drpdwn_Measurement_Condition() {		
		return driver.findElement(By.xpath("//*[@name='mesurementLookupId']"));

	}
	
	public static WebElement drpdwn_ΔE_Formula_Type() {		
		return driver.findElement(By.xpath("//*[@name='dEFormulaId']"));

	}
	
	public static WebElement drpdwn_Weight1() {		
		return driver.findElement(By.xpath("//*[@name='weight1']"));

	}

	public static WebElement drpdwn_Weight2() {		
		return driver.findElement(By.xpath("//*[@name='weight2']"));

	}

	public static WebElement drpdwn_Weight3() {		
		return driver.findElement(By.xpath("//*[@name='weight3']"));

	}

	public static WebElement txt_Tolerance() {		
		return driver.findElement(By.xpath("//*[@id='tolerance']"));

	}

	public static WebElement drpdwn_Client_Access () {		
		return driver.findElement(By.xpath("//*[@class='dropdown-down']"));

	}
	
	public static WebElement select_AllClients_ChkBox() {		
		return driver.findElement(By.xpath("//*[@class='multiselect-item-checkbox']/input"));

	}
	
	public static WebElement clientsDetails_ToVerify () {		
		return driver.findElement(By.xpath("//*[@col-id='filterColumn']/app-custom-badge/span[2]/span"));

	}
	
	public static WebElement total_clients_ToVerify () {		
		return driver.findElement(By.xpath("//*[@col-id='filterColumn']/app-custom-badge/span[1]"));

	}
	
	public static WebElement btn_ColorInformation() {
		return driver.findElement(By.xpath("//*[@class='fas fa-arrow-circle-right']"));			
		
	}
	 

	public static WebElement txt_AddClient() {
		return driver.findElement(By.xpath("//*[@class='ng-pristine ng-valid ng-touched']"));
		
	}
	
	public static WebElement client_SelectAll() {
		return driver.findElement(By.xpath("//*[@aria-label='multiselect-select-all']"));
		
	}
	
	public static WebElement btn_Available_Color() {
		return driver.findElement(By.xpath("//*[@class='col-sm-6 col-lg-6 col-md-6 search-color-tab1']"));

	}

	public static WebElement chkBox_ShowByColor() {
		return driver.findElement(By.xpath("//*[@class='checkmark fal fa-square']"));
		
	}
	
	public static WebElement chkBox_ToSelectColor() {
		return driver.findElement(By.xpath("//table[@class='myOtherTable']/tbody/tr/td[1]"));
	
	}

	public static WebElement txt_TypeColorName() {
		return driver.findElement(By.xpath("//*[@class='row search-heading']/div[2]/div/input"));
		//return driver.findElement(By.xpath("//div[@class='row search-heading']/div[2]/div/input or //*[@class='form-control border-right-0 ng-pristine ng-valid ng-touched' or @class='form-control border-right-0 ng-valid ng-touched ng-dirty']"));
	
	}

	public static WebElement btn_SelectedColors() {
		return driver.findElement(By.xpath("//table[@class='myOtherTable']/tbody/tr/td[2]"));				
		
	}
	
	public static WebElement txt_AddedLibraryName() {
		return driver.findElement(By.xpath("//*[@class='ag-header-container']/div[2]/div[1]/div/ng-component/input"));			
		
	}

	public static WebElement txt_AddedClientName() {
		return driver.findElement(By.xpath("//*[@class='ag-header-container']/div[2]/div[2]/div/ng-component/input"));		
		
	}	
	
	public static WebElement txt_AfterDeletedColorLibraryName() {
		return driver.findElement(By.xpath("(//*[@class='ng-valid ng-touched ng-dirty' or @class='ng-valid ng-dirty ng-touched'])[1]"));			
		
	}

	public static WebElement txt_AfterDeletedClientName() {
		return driver.findElement(By.xpath("(//*[@class='ng-valid ng-touched ng-dirty' or @class='ng-valid ng-dirty ng-touched'])[2]"));			
		
	}

	public static WebElement btn_ColorLibrary_Information() {
		return driver.findElement(By.xpath("(//*[@class='far fa-exclamation-circle'])[1]"));			
		
	}
	
	public static WebElement btn_ColorsList() {
		return driver.findElement(By.xpath("//*[@col-id='colorName']"));			
		
	}

	public static WebElement close_ColorsWindow() {
		return driver.findElement(By.xpath("//*[@class='far fa-times-circle']"));			
		
	}
	
	public static WebElement LibName() {
		return driver.findElement(By.xpath("//*[@class='col']/span/b"));			
		
	}
	
	public static WebElement ColorName() {
		return driver.findElement(By.xpath("//*[@class='color-name']"));			
		
	}
	
	public static WebElement IlluminantValue() {
		return driver.findElement(By.xpath("//*[@class='colorimetry']//div[2]/span"));			
		
	}
	
	public static WebElement ObserverAngleValue() {
		return driver.findElement(By.xpath("//*[@class='colorimetry']//div[3]/span"));			
		
	}
	
	public static WebElement MesurementConditionValue() {
		return driver.findElement(By.xpath("//*[@class='colorimetry']//div[4]/span"));			
		
	}
	
	public static WebElement EFormulaTypeValue() {
		return driver.findElement(By.xpath("//*[@class='colorimetry']//div[5]/span"));			
		
	}
	
	public static WebElement ToleranceValue() {
		return driver.findElement(By.xpath("//*[@class='colorimetry']//div[6]/span"));			
		
	}
	
	public static WebElement btn_SaveChanges() {
		return driver.findElement(By.xpath("//*[@class='btn btn-primary mediaValue']"));			
		
	}

	public static WebElement btn_Cancel() {
		return driver.findElement(By.xpath("//*[@class='btn btn-secondary']"));			
		
	}	

	public static WebElement btn_EditColorLibrary() {
		return driver.findElement(By.xpath("//*[@class='far fa-edit modify-icon edit']"));			
		
	}

	public static WebElement btn_DeleteColorLibrary() {
		return driver.findElement(By.xpath("//*[@class='fal fa-trash-alt']"));			
		
	}
	
	public static WebElement btn_DeleteColorLibraryPopup() {
		return driver.findElement(By.xpath("//*[@class='btn btn-primary']"));			
		
	}
	
	
	
	// Each Object Performance Method
	// Color Library Page
	public void colorLibrary() throws IOException {

		clickOnButton(colorLibraries_Grid(), "ColorLibrary grid");
	}
	
	public void click_btnNewColorLibrary() throws IOException {

		clickOnButton(btn_NewColorLibrary(), "New ColorLibrary");
	}
	
	public void add_ColorLibrary(int row) throws IOException {		    
		enterText(txt_LibraryName(), "Color Library", data.Getdata("Color Library", row));
		colorLibrary = data.Getdata("Color Library", row);		
		
	}
	
	public void add_Description(int row) throws IOException {			
		description = data.Getdata("Description", row);
		
		if(!description.isEmpty()) {
			enterText(txt_Description(), "Description", description);
		}else {
			ResultsLog.ReportFail(driver,"Please enter value for Description",Invalid);
			result = "Fail";			
		}		
	}
	
	public void add_Illuminant(int row) throws Exception {				
		illuminant = data.Getdata("Illuminant", row);
				
		if (!illuminant.isEmpty()) {
			clickOnLink(drpdwn_Illuminant(), "Illuminant");
			List <WebElement> IlluminantList=driver.findElements(By.xpath("//select[@name='illuminantId']/option"));			
			for(WebElement we:IlluminantList) {
				if(we.getText().trim().equalsIgnoreCase(illuminant.trim())) {	
					we.click();
					System.out.println("illuminant: "+illuminant+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for Illuminant",Invalid);
			result = "Fail";
		}
	}
	
	public void add_ObserverAngle(int row) throws Exception {				
		observerAngle = data.Getdata("Observer Angle", row);
				
		if (!observerAngle.isEmpty()) {
			clickOnLink(drpdwn_Observer_Angle(), "ObserverAngle");
			List <WebElement> ObserverAngleList=driver.findElements(By.xpath("//select[@name='observerAngleLookupId']/option"));			
			for(WebElement we:ObserverAngleList) {
				if(we.getText().trim().equalsIgnoreCase(observerAngle.trim())) {	
					we.click();
					System.out.println("ObserverAngle: "+observerAngle+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for ObserverAngle",Invalid);
			result = "Fail";
		}
		
		
	}

	public void add_MeasurementCondition(int row) throws Exception {				
		measurementCondition = data.Getdata("Measurement Condition", row);
			
		if (!measurementCondition.isEmpty()) {
			clickOnLink(drpdwn_Measurement_Condition(), "Measurement Condition");
			List <WebElement> MeasurementConditionList=driver.findElements(By.xpath("//select[@name='mesurementLookupId']/option"));			
			for(WebElement we:MeasurementConditionList) {
				if(we.getText().trim().equalsIgnoreCase(measurementCondition.trim())) {	
					we.click();
					System.out.println("ObserverAngle: "+measurementCondition+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for MeasurementCondition",Invalid);
			result = "Fail";
		}
		
		
	}

	public void add_ΔEFormulaType(int row) throws Exception {				
		eFormulaType = data.Getdata("EFormula Type", row);
		String eFormula2000 = "∆E 2000";
		String eFormulaCMC = "∆E CMC"; 

		if (!eFormulaType.isEmpty()) {
			clickOnLink(drpdwn_ΔE_Formula_Type(), "ΔEFormula Type");
			List <WebElement> EFormulaTypeList=driver.findElements(By.xpath("//select[@name='dEFormulaId']/option"));			
			for(WebElement we:EFormulaTypeList) {
				if(we.getText().trim().equalsIgnoreCase(eFormulaType.trim())) {	
					we.click();
					System.out.println("ObserverAngle: "+eFormulaType+ "Selected");			
					break;
				}
			}
			
			switch(eFormulaType.trim()) {
			case "∆E 2000":
				add_Weight1(row);
				add_Weight2(row);
				add_Weight3(row);
				break; 
			case "∆E CMC":
				add_Weight1(row);
				add_Weight2(row);
				break; 
			default:
				weight1 = "0";
				weight2 = "0";				
				weight3 = "0";			
			}	
			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for ΔEFormula Type",Invalid);
			result = "Fail";
		}
		
		eFormulaType_Properties = eFormulaType.trim()+"  "+weight1.trim()+":"+" "+weight2.trim()+":"+" "+weight3.trim();
		System.out.println("eFormulaType_Properties: "+eFormulaType_Properties);
	}
	
	public void add_Weight1(int row) throws Exception {				
		weight1 = data.Getdata("Weight1", row);	
		
		if (!weight1.isEmpty()) {
			clickOnLink(drpdwn_Weight1(), "Weight1");
			List <WebElement> Weight1List=driver.findElements(By.xpath("//*[@name='weight1']/option"));			
			for(WebElement we:Weight1List) {
				if(we.getText().trim().equalsIgnoreCase(weight1.trim())) {	
					we.click();
					System.out.println("weight3: "+weight1+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for weight1",Invalid);
			result = "Fail";
		}
		
	}

	public void add_Weight2(int row) throws Exception {				
		weight2 = data.Getdata("Weight2", row);	
		
		if (!weight2.isEmpty()) {
			clickOnLink(drpdwn_Weight2(), "weight2");
			List <WebElement> Weight1List=driver.findElements(By.xpath("//*[@name='weight2']/option"));			
			for(WebElement we:Weight1List) {
				if(we.getText().trim().equalsIgnoreCase(weight2.trim())) {	
					we.click();
					System.out.println("Weight2: "+weight2+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for weight2",Invalid);
			result = "Fail";
		}
		
	}

	public void add_Weight3(int row) throws Exception {				
		weight3 = data.Getdata("Weight3", row);	
		
		if (!weight3.isEmpty()) {
			clickOnLink(drpdwn_Weight3(), "weight3");
			List <WebElement> Weight1List=driver.findElements(By.xpath("//*[@name='weight3']/option"));			
			for(WebElement we:Weight1List) {
				if(we.getText().trim().equalsIgnoreCase(weight3.trim())) {	
					we.click();
					System.out.println("Weight3: "+weight3+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for weight3",Invalid);
			result = "Fail";
		}
		
	}

	public void add_Tolerance(int row) throws IOException {		    
		enterText(txt_Tolerance(), "Tolerance", data.Getdata("Tolerance", row));
		tolerance = data.Getdata("Tolerance", row);	
		
		tolerance = data.Getdata("Tolerance", row);	
		
		if(!tolerance.isEmpty()) {
			txt_Tolerance().clear();
			enterText(txt_Tolerance(), "Tolerance", data.Getdata("Tolerance", row));
		}else {
			ResultsLog.ReportFail(driver,"Please enter value for Tolerance",Invalid);
			result = "Fail";
		}
		
	}
	
	public void add_ClientAccess(int row) throws IOException, InterruptedException {
		List<String> clients_List = new ArrayList<String>();
		clientname = data.Getdata("Client Access1", row);
		clientname1 = data.Getdata("Client Access1", row);
		clientname2 = data.Getdata("Client Access2", row);
		clientname3 = data.Getdata("Client Access3", row);
		clientname4 = data.Getdata("Client Access4", row);
		clientname5 = data.Getdata("Client Access5", row);
		
		if (!clientname1.isEmpty()) {			
			clients_List.add(clientname1);
			Client_Properties = clientname1.trim();
		}else{
			ResultsLog.ReportFail(driver,"Please enter value for Client name",Invalid);
			result = "Fail";
		}
		if (!clientname2.isEmpty()) {			
			clients_List.add(clientname2);
			Client_Properties = Client_Properties.trim()+",  "+clientname2.trim();
		}
		if (!clientname3.isEmpty()) {			
			clients_List.add(clientname3);
			Client_Properties = Client_Properties.trim()+",  "+clientname3.trim();
		}
		if (!clientname4.isEmpty()) {			
			clients_List.add(clientname4);
			Client_Properties = Client_Properties.trim()+",  "+clientname4.trim();
		}
		if (!clientname5.isEmpty()) {			
			clients_List.add(clientname5);
			Client_Properties = Client_Properties.trim()+",  "+clientname5.trim();
		}
		add_RequestedClients(clients_List);
		totalClients = clients_List.size();
		/*if (!clientname1.isEmpty()) {
			clickOnLink(drpdwn_Client_Access(), "Client Access");
			List <WebElement> ClientList=driver.findElements(By.xpath("//*[@class='multiselect-item-checkbox' or @class='multiselect-item-checkbox ng-star-inserted']/div"));
			
			Thread.sleep(2000);
			for(WebElement we:ClientList) {
				if(we.getText().trim().equalsIgnoreCase(clientname.trim())) {	
					we.click();
					System.out.println("Client Acess: "+clientname+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for Client name",Invalid);
			result = "Fail";
		}*/		
	}
	
	public void add_RequestedClients(List<String> ClientsList) throws IOException, InterruptedException {
		
		String client = null;
		if (!ClientsList.isEmpty()) {
			clickOnLink(drpdwn_Client_Access(), "Client Access");
			List <WebElement> ClientList=driver.findElements(By.xpath("//*[@class='multiselect-item-checkbox' or @class='multiselect-item-checkbox ng-star-inserted']/div"));
			for (int i = 0; i < ClientsList.size(); i++) {
				System.out.println(ClientsList.get(i).toString());
				client = ClientsList.get(i).toString();			
				if(client.trim().equalsIgnoreCase(selectall.trim())) {				
					select_AllClients();
				}else {					
					Thread.sleep(2000);
					for(WebElement we:ClientList) {
						if(we.getText().trim().equalsIgnoreCase(client.trim())) {	
							we.click();
							System.out.println("Client Acess: "+client+ "Selected");			
							break;
						}
					}		
				}
			}
		}		
	}
	
	public void select_AllClients() throws IOException {

		clickOnLink(select_AllClients_ChkBox(), "Select All");
	}
	
	public void click_btnAvailableColors() throws IOException {

		clickOnButton(btn_Available_Color(), "Avilable Color");
	}
	
	public void click_BtnColorLibrary_Information() throws IOException {

		clickOnButton(btn_ColorLibrary_Information(), "Colorlibrary Information");
	}
	
	public void click_ColorInformation() throws IOException {

		clickOnButton(btn_ColorInformation(), "Color Information");
	}
	
	public void click_CloseColorWindow() throws IOException {

		clickOnButton(close_ColorsWindow(), "Close Color Window");
	}
	
	
	public void selectShowByColor() throws IOException {

		clickOnLink(chkBox_ShowByColor(), "Show By Color Checkbox");
	}
	
	public void add_Colors(int row) throws IOException {
		colorLibaryName = data.Getdata("Color Library", row);
		color = data.Getdata("Select Color", row);	
		enterText(txt_TypeColorName(), "Color", color);
		click_btnAvailableColors();
		selectShowByColor();	
		
		if (!color.isEmpty()) {
			//clickOnLink(drpdwn_Client_Access(), "Client Acess");
			List <WebElement> ColorList= driver.findElements(By.xpath("//table[@class='myOtherTable']/tbody/tr/td[2]"));		
			for(WebElement we:ColorList) {
				if(we.getText().trim().equalsIgnoreCase(color.trim())) {	
					//we.click();
					clickOnLink(chkBox_ToSelectColor(), "Color Selection Checkbox");
					System.out.println("Client Acess: "+color+ "Selected");			
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"Please enter value for Color name",Invalid);
			result = "Fail";
		}
	}
	
	public void SaveChanges(int row) throws Exception {			
		String duplicateColorLibrary = "ColorLibrary Name already exists.";		
		if (!btn_SaveChanges().isEnabled()) {
			clickOnLink(btn_Cancel(), "Cancel");
			System.out.println("Please enter the values for all mandatory fields");
			ResultsLog.ReportFail(driver,"*** Please enteer the values for all mandatory fields ***",Invalid);
			result ="Fail";
		}else {
			clickOnLink(btn_SaveChanges(), "Save");			
			try {
				WebElement duplicateColorLibraryToast = driver.findElement(By.xpath("//*[contains(text(),'ColorLibrary Name already exists')]"));
				WebElement closeDuplicateToast = driver.findElement(By.xpath("//*[@class='toast-cancel']"));
				
				System.out.println("element.getAttribute(\"innerText\"):" + duplicateColorLibraryToast.getAttribute("innerText"));
				
				if (duplicateColorLibraryToast.getAttribute("innerText").trim().matches(duplicateColorLibrary.trim())) {
					ResultsLog.ReportFail(driver,"*** Color Library: " + colorLibaryName + " already exist ***",Invalid);
					closeDuplicateToast.click();
					ResultsLog.ReportDoneEvent("Duplicate Color Library toast message closed");
					clickOnLink(btn_Cancel(), "Cancel");
					ResultsLog.ReportDoneEvent("*** Please enter unique Color Library name ***");
					System.out.println("Please enter unique Color Library name");
					result ="Fail";
					duplicateColorLibraryExist = true;
				} 						
			}catch(NoSuchElementException e) {
				ResultsLog.ReportDoneEvent("Color Library: " + colorLibaryName + " created successfully");
				result ="Pass";
				duplicateColorLibraryExist = false;
			}
		}
	}
	
	public void ColorlibraryAddToastMessage(int row) throws IOException {		
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Color Library saved Successfully')]"));
		String Upload_Success_Toast_Text = "Color Library saved Successfully";
		System.out.println("element.getAttribute(\"innerText\"):" + element.getAttribute("innerText"));
		
		if (element.getAttribute("innerText").trim().matches(Upload_Success_Toast_Text.trim())) {
			ResultsLog.ReportDoneEvent("Color Library: " + colorLibaryName + " created Successfully ");
		} else {
			ResultsLog.ReportFail(driver, "Color Library: " + colorLibaryName + "not created", Invalid);
		}
	}
		
	public static String ExecutionResult(String testResult) {
		return testResult = result;
	}	
	
	public void verify_AddedColorLibrary(int row) throws IOException, InterruptedException {
		Thread.sleep(3000);		
		clientname1 = data.Getdata("Client Access1", row);
		String AllClients = "All Clients";
		enterText(txt_AddedLibraryName(), "Color Library", colorLibaryName);
		enterText(txt_AddedClientName(), "Client Name", clientname);
		String clientDetails = clientsDetails_ToVerify().getText();
		String clientCount = total_clients_ToVerify().getText();		
		switch (clientname1.trim()) {
		case "Select All":
			if(clientDetails.trim().equalsIgnoreCase(AllClients.trim())) {
				ResultsLog.ReportDoneEvent("Client[s]: "+AllClients +" verified");
				System.out.println("Client[s]: "+Client_Properties +" verified");
			}else {
				ResultsLog.ReportFail(driver,"Client[s]: "+AllClients +" not matched",Invalid);
			}
			break;
		default:
			if(clientDetails.trim().equalsIgnoreCase(Client_Properties.trim())) {
				ResultsLog.ReportDoneEvent("Client[s]: "+Client_Properties +" verified");
				System.out.println("Client[s]: "+Client_Properties +" verified");
			}else {
				ResultsLog.ReportFail(driver,"Client[s]: "+Client_Properties +" not matched",Invalid);
			}
		}
		
		
		
		if(clientDetails.trim().equalsIgnoreCase(Client_Properties.trim())) {
			ResultsLog.ReportDoneEvent("Client[s]: "+Client_Properties +" verified");
			System.out.println("Client[s]: "+Client_Properties +" verified");
		}else {
			ResultsLog.ReportFail(driver,"Client[s]: "+Client_Properties +" not matched",Invalid);
		}	

		click_BtnColorLibrary_Information();	
		Thread.sleep(3000);

		if (!color.isEmpty()) {						
			List <WebElement> ColorList= driver.findElements(By.xpath("//*[@col-id='colorName']"));		
			for(WebElement we:ColorList) {				
				if(we.getText().trim().equalsIgnoreCase(color.trim())) {	
					click_ColorInformation();
					Thread.sleep(3000);
					if(ColorName().getText().trim().equalsIgnoreCase(color.trim())) {
						ResultsLog.ReportDoneEvent("Color: "+color +" verified");
						System.out.println("Color Verified");
					}else {
						ResultsLog.ReportFail(driver,"Color: "+color +" not matched",Invalid);
					}
					if(LibName().getText().trim().equalsIgnoreCase(colorLibaryName.trim())) {
						ResultsLog.ReportDoneEvent("Library Name: "+colorLibaryName +" verified");
						System.out.println("Color Library Verified");
					}else {
						ResultsLog.ReportFail(driver,"Color Library Name: "+colorLibaryName +" not matched",Invalid);	
					}
					
					if(IlluminantValue().getText().trim().equalsIgnoreCase(illuminant.trim())) {
						ResultsLog.ReportDoneEvent("Illuminant Value: "+illuminant +" verified");
						System.out.println("Illuminant Value Verified");
					}else {
						ResultsLog.ReportFail(driver,"Illuminant Value: "+illuminant +" not matched",Invalid);	
					}
					
					if(ObserverAngleValue().getText().trim().equalsIgnoreCase(observerAngle.trim())) {
						ResultsLog.ReportDoneEvent("ObserverAngle Value: "+observerAngle +" verified");
						System.out.println("ObserverAngle Value Verified");
					}else {
						ResultsLog.ReportFail(driver,"ObserverAngle Value: "+observerAngle +" not matched",Invalid);	
					}

					if(MesurementConditionValue().getText().trim().equalsIgnoreCase(measurementCondition.trim())) {
						ResultsLog.ReportDoneEvent("MesurementCondition Value: "+measurementCondition +" verified");
						System.out.println("MesurementCondition Value Verified");
					}else {
						ResultsLog.ReportFail(driver,"MesurementCondition Value: "+measurementCondition +" not matched",Invalid);	
					}

					if(EFormulaTypeValue().getText().trim().equalsIgnoreCase(eFormulaType_Properties.trim())) {
						ResultsLog.ReportDoneEvent("EFormulaType Value: "+eFormulaType_Properties +" verified");
						System.out.println("EFormulaType Value Verified");
						eFormulaType_Properties = null;
					}else {
						ResultsLog.ReportFail(driver,"EFormulaType Value: "+eFormulaType_Properties +" not matched",Invalid);
						eFormulaType_Properties = null;
					}

					if(ToleranceValue().getText().trim().equalsIgnoreCase(tolerance.trim())) {
						ResultsLog.ReportDoneEvent("Tolerance Value: "+tolerance +" verified");
						System.out.println("Tolerance Value Verified");
					}else {
						ResultsLog.ReportFail(driver,"Tolerance Value: "+tolerance +" not matched",Invalid);	
					}
					
					click_CloseColorWindow();
					break;
				}
			}			
		}
		else{
			ResultsLog.ReportFail(driver,"COlor: " +color+"  not added",Invalid);
			result = "Fail";
		}
	}	
	
	
	public void verify_ColorLibraryDetailsAfterEdit(int row) throws IOException, InterruptedException {
		Thread.sleep(3000);		
		colorLibaryName = data.Getdata("Color Library", row);
		clientname = data.Getdata("Client Name", row);
		
		enterText(txt_AddedLibraryName(), "Color Library", colorLibaryName);
		enterText(txt_AddedClientName(), "Client name", clientname);
		color = data.Getdata("Select Color", row);		
		click_BtnColorLibrary_Information();
		click_ColorInformation();
		Thread.sleep(3000);
		ResultsLog.ReportDoneEvent("*** After edit below fields going to verify ***");
		//if (!color.isEmpty()) {						
			List <WebElement> ColorList= driver.findElements(By.xpath("//*[@col-id='colorName']"));
			
			for(WebElement we:ColorList) {				
				//if(we.getText().trim().equalsIgnoreCase(color.trim())) {	
				//	click_ColorInformation();
				//	Thread.sleep(3000);
					if (!color.isEmpty()) {
						if(ColorName().getText().trim().equalsIgnoreCase(color.trim())) {
							ResultsLog.ReportDoneEvent("Color: "+color +" verified");
							System.out.println("Color Verified");						
						}else {
							ResultsLog.ReportFail(driver,"Color: "+color +" not matched",Invalid);
						}
					}
					
					if (!colorLibaryName.isEmpty()) {
						if(LibName().getText().trim().equalsIgnoreCase(colorLibaryName.trim())) {
							ResultsLog.ReportDoneEvent("Library Name: "+colorLibaryName +" verified");
							System.out.println("Color Library Verified");
						}else {
							ResultsLog.ReportFail(driver,"Color Library Name: "+colorLibaryName +" not matched",Invalid);	
						}	
					}
					if (!illuminant.isEmpty()) {
						if(IlluminantValue().getText().trim().equalsIgnoreCase(illuminant.trim())) {
							ResultsLog.ReportDoneEvent("Illuminant Value: "+illuminant +" verified");
							System.out.println("Illuminant Value Verified");
						}else {
							ResultsLog.ReportFail(driver,"Illuminant Value: "+illuminant +" not matched",Invalid);	
						}
					}
					
					if (!observerAngle.isEmpty()) {
						if(ObserverAngleValue().getText().trim().equalsIgnoreCase(observerAngle.trim())) {
							ResultsLog.ReportDoneEvent("ObserverAngle Value: "+observerAngle +" verified");
							System.out.println("ObserverAngle Value Verified");
						}else {
							ResultsLog.ReportFail(driver,"ObserverAngle Value: "+observerAngle +" not matched",Invalid);	
						}
					}

					if (!measurementCondition.isEmpty()) {
						if(MesurementConditionValue().getText().trim().equalsIgnoreCase(measurementCondition.trim())) {
							ResultsLog.ReportDoneEvent("MesurementCondition Value: "+measurementCondition +" verified");
							System.out.println("MesurementCondition Value Verified");
						}else {
							ResultsLog.ReportFail(driver,"MesurementCondition Value: "+measurementCondition +" not matched",Invalid);	
						}
					}

					if (!eFormulaType.isEmpty()) {
						if(EFormulaTypeValue().getText().trim().equalsIgnoreCase(eFormulaType_Properties.trim())) {
							ResultsLog.ReportDoneEvent("EFormulaType Value: "+eFormulaType_Properties +" verified");
							System.out.println("EFormulaType Value Verified");
						}else {
							ResultsLog.ReportFail(driver,"EFormulaType Value: "+eFormulaType_Properties +" not matched",Invalid);	
						}
					}

					if (!tolerance.isEmpty()) {
						if(ToleranceValue().getText().trim().equalsIgnoreCase(tolerance.trim())) {
							ResultsLog.ReportDoneEvent("Tolerance Value: "+tolerance +" verified");
							System.out.println("Tolerance Value Verified");
						}else {
							ResultsLog.ReportFail(driver,"Tolerance Value: "+tolerance +" not matched",Invalid);	
						}
					}
					
					click_CloseColorWindow();
					break;
				}
			//}			
		/*}else{
			ResultsLog.ReportFail(driver,"COlor: " +color+"  not added",Invalid);
			result = "Fail";
		}*/
	}	


//Edit methods
public void enterColorLibraryDetailsToEdit(int row) throws IOException {
		
		colorLibaryName = data.Getdata("Color Library", row);
		clientname = data.Getdata("Client Name", row);
		
		enterText(txt_AddedLibraryName(), "Color Library", colorLibaryName);
		enterText(txt_AddedClientName(), "Client name", clientname);

		/*if (row==1) {
		enterText(txt_AddedLibraryName(), "Color Library", colorLibaryName);
		enterText(txt_AddedClientName(), "Client name", clientname);
		}else {
			enterText(txt_AfterDeletedColorLibraryName(), "Color Library", colorLibaryName);
			enterText(txt_AfterDeletedClientName(), "Client name", clientname);			
		}*/
			
	}
	
	public void button_EditColorLibrary(int row) throws IOException {	
		try {
			clickOnButton(btn_EditColorLibrary(), "Edit Color Library");			
		}catch(NoSuchElementException e){
			ResultsLog.ReportFail(driver, "Unable to Edit Color Library:  " + colorLibaryName.trim() + " due to: ", e.toString());
		}		
	}
	
	public void edit_Description(int row) throws IOException {
		description = data.Getdata("Description", row);
		
		if(!description.isEmpty()) {
			txt_Description().clear();
			enterText(txt_Description(), "Description", description);
			ResultsLog.ReportDoneEvent("Description updated as: " + description);
		}		
	}
	
	public void edit_Illuminant(int row) throws Exception {				
		illuminant = data.Getdata("Illuminant", row);
				
		if (!illuminant.isEmpty()) {
			clickOnLink(drpdwn_Illuminant(), "Illuminant");
			List <WebElement> IlluminantList=driver.findElements(By.xpath("//select[@name='illuminantId']/option"));			
			for(WebElement we:IlluminantList) {
				if(we.getText().trim().equalsIgnoreCase(illuminant.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("Illuminant updated as: " + illuminant);
					System.out.println("illuminant: "+illuminant+ "Selected");			
					break;
				}
			}			
		}
	}
	
	public void edit_ObserverAngle(int row) throws Exception {				
		observerAngle = data.Getdata("Observer Angle", row);
				
		if (!observerAngle.isEmpty()) {
			clickOnLink(drpdwn_Observer_Angle(), "ObserverAngle");
			List <WebElement> ObserverAngleList=driver.findElements(By.xpath("//select[@name='observerAngleLookupId']/option"));			
			for(WebElement we:ObserverAngleList) {
				if(we.getText().trim().equalsIgnoreCase(observerAngle.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("ObserverAngle updated as: " + observerAngle);
					System.out.println("ObserverAngle: "+observerAngle+ "Selected");			
					break;
				}
			}			
		}		
	}

	public void edit_MeasurementCondition(int row) throws Exception {				
		measurementCondition = data.Getdata("Measurement Condition", row);
			
		if (!measurementCondition.isEmpty()) {
			clickOnLink(drpdwn_Measurement_Condition(), "Measurement Condition");
			List <WebElement> MeasurementConditionList=driver.findElements(By.xpath("//select[@name='mesurementLookupId']/option"));			
			for(WebElement we:MeasurementConditionList) {
				if(we.getText().trim().equalsIgnoreCase(measurementCondition.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("Measurement Condition updated as: " + measurementCondition);
					System.out.println("MeasurementCondition: "+measurementCondition+ "Selected");			
					break;
				}
			}			
		}	
	}

	public void edit_ΔEFormulaType(int row) throws Exception {				
		eFormulaType = data.Getdata("EFormula Type", row);
		String eFormula2000 = "∆E 2000";
		String eFormulaCMC = "∆E CMC"; 

		if (!eFormulaType.isEmpty()) {
			clickOnLink(drpdwn_ΔE_Formula_Type(), "EFormula Type");
			List <WebElement> EFormulaTypeList=driver.findElements(By.xpath("//select[@name='dEFormulaId']/option"));			
			for(WebElement we:EFormulaTypeList) {
				if(we.getText().trim().equalsIgnoreCase(eFormulaType.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("eFormulaType updated as: " + eFormulaType);
					System.out.println("eFormulaType: "+eFormulaType+ "Selected");			
					break;
				}
			}	
			
			switch(eFormulaType.trim()) {
			case "∆E 2000":
				edit_Weight1(row);
				edit_Weight2(row);
				edit_Weight3(row);
				break; 
			case "∆E CMC":
				edit_Weight1(row);
				edit_Weight2(row);
				break; 
			default:
				weight1 = "0";
				weight2 = "0";				
				weight3 = "0";			
			}			

			eFormulaType_Properties = eFormulaType.trim()+"  "+weight1.trim()+":"+" "+weight2.trim()+":"+" "+weight3.trim();
			System.out.println("eFormulaType_Properties: "+eFormulaType_Properties);
			
			/*if(eFormulaType.trim().equalsIgnoreCase(eFormula2000.trim())) {
				edit_Weight1(row);
				edit_Weight2(row);
				edit_Weight3(row);
			}
			if(eFormulaType.trim().equalsIgnoreCase(eFormulaCMC.trim())) {
				edit_Weight1(row);
				edit_Weight2(row);				
			}*/
		}
	}
	
	public void edit_Weight1(int row) throws Exception {				
		weight1 = data.Getdata("Weight1", row);	
		
		if (!weight1.isEmpty()) {
			clickOnLink(drpdwn_Weight1(), "Weight1");
			List <WebElement> Weight1List=driver.findElements(By.xpath("//*[@name='weight1']/option"));			
			for(WebElement we:Weight1List) {
				if(we.getText().trim().equalsIgnoreCase(weight1.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("Weight1 updated as: " + weight1);
					System.out.println("weight3: "+weight1+ "Selected");			
					break;
				}
			}			
		}
	}

	public void edit_Weight2(int row) throws Exception {				
		weight2 = data.Getdata("Weight2", row);	
		
		if (!weight2.isEmpty()) {
			clickOnLink(drpdwn_Weight2(), "weight2");
			List <WebElement> Weight1List=driver.findElements(By.xpath("//*[@name='weight2']/option"));			
			for(WebElement we:Weight1List) {
				if(we.getText().trim().equalsIgnoreCase(weight2.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("Weight2 updated as: " + weight2);
					System.out.println("Weight2: "+weight2+ "Selected");			
					break;
				}
			}			
		}		
	}

	public void edit_Weight3(int row) throws Exception {				
		weight3 = data.Getdata("Weight3", row);	
		
		if (!weight3.isEmpty()) {
			clickOnLink(drpdwn_Weight3(), "weight3");
			List <WebElement> Weight1List=driver.findElements(By.xpath("//*[@name='weight3']/option"));			
			for(WebElement we:Weight1List) {
				if(we.getText().trim().equalsIgnoreCase(weight3.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("Weight3 updated as: " + weight3);
					System.out.println("Weight3: "+weight3+ "Selected");			
					break;
				}
			}			
		}
	}

	public void edit_Tolerance(int row) throws IOException {	
		tolerance = data.Getdata("Tolerance", row);	
		
		if(!tolerance.isEmpty()) {
			txt_Tolerance().clear();
			enterText(txt_Tolerance(), "Tolerance", data.Getdata("Tolerance", row));
			ResultsLog.ReportDoneEvent("Tolerance updated as: " + tolerance);
		}	
	}
	
	public void edit_ClientAccess(int row) throws IOException, InterruptedException {	
		clientname = data.Getdata("Client Access", row);	
		if (!clientname.isEmpty()) {
			clickOnLink(drpdwn_Client_Access(), "Client Access");
			List <WebElement> ClientList=driver.findElements(By.xpath("//*[@class='multiselect-item-checkbox' or @class='multiselect-item-checkbox ng-star-inserted']/div"));
			//List <WebElement> ClientList=driver.findElements(By.xpath("//*[@class='ng-pristine ng-valid ng-touched' or @class='multiselect-item-checkbox ng-star-inserted']/div"));
			
			Thread.sleep(2000);
			for(WebElement we:ClientList) {
				if(we.getText().trim().equalsIgnoreCase(clientname.trim())) {	
					we.click();
					ResultsLog.ReportDoneEvent("Client Acess updated as: " + clientname);
					System.out.println("Client Acess: "+clientname+ "Selected");			
					break;
				}
			}			
		}	
	}
	
	public void edit_Colors(int row) throws IOException {
		colorLibaryName = data.Getdata("Color Library", row);
		color = data.Getdata("Select Color", row);	
		if (!color.isEmpty()) {
			enterText(txt_TypeColorName(), "Color", color);
			click_btnAvailableColors();
			selectShowByColor();			
			//clickOnLink(drpdwn_Client_Access(), "Client Acess");
			List <WebElement> ColorList= driver.findElements(By.xpath("//table[@class='myOtherTable']/tbody/tr/td[2]"));		
			for(WebElement we:ColorList) {
				if(we.getText().trim().equalsIgnoreCase(color.trim())) {	
					//we.click();
					clickOnLink(chkBox_ToSelectColor(), "Color Selection Checkbox");
					ResultsLog.ReportDoneEvent("Color updated as: " + color);
					System.out.println("color: "+color+ "Selected");			
					break;
				}
			}			
		}
	}
	
		
	//Delete Methods
	public void enterColorLibraryDetailsToDelete(int row) throws IOException {
		
		colorLibaryName = data.Getdata("Color Library", row);
		clientname = data.Getdata("Client Name", row);
		
		enterText(txt_AddedLibraryName(), "Color Library", colorLibaryName);
		enterText(txt_AddedClientName(), "Client name", clientname);

		/*if (row==1) {
		enterText(txt_AddedLibraryName(), "Color Library", colorLibaryName);
		enterText(txt_AddedClientName(), "Client name", clientname);
		}else {
			enterText(txt_AfterDeletedColorLibraryName(), "Color Library", colorLibaryName);
			enterText(txt_AfterDeletedClientName(), "Client name", clientname);			
		}*/
			
	}

	
	public void delete_ColorLibrary(int row) throws IOException {		
		clickOnButton(btn_DeleteColorLibrary(), "Delete Color Library");	
		
	}
	
	public void deletePopupColorLibrary(int row) throws IOException {		
		clickOnButton(btn_DeleteColorLibraryPopup(), "Delete on Color Library Popup");	
		
	}
	
	 public void verifyColorLirary_AfterDelete(int row) throws IOException, NullPointerException, NoSuchElementException, InterruptedException {
		 colorLibaryName = data.Getdata("Color Library", row);
		 clientname = data.Getdata("Client Name", row);
			
		 enterText(txt_AfterDeletedColorLibraryName(), "Color Library", colorLibaryName);
		 enterText(txt_AfterDeletedClientName(), "Client Name", clientname);
			Thread.sleep(1000);
			try {
				delete_ColorLibrary(row);
				ResultsLog.ReportFail(driver, "Delete ColorLibrary verification fail for Color Library: " + colorLibaryName.trim(), Invalid);
				result = "Fail";
				
			}catch(NoSuchElementException e){
				//ResultsLog.ReportPass(driver, "Delete Product Verified for Color Library: "+ colorLibaryName.trim(), Valid);
				ResultsLog.ReportDoneEvent("Delete ColorLibrary Verified for Color Library" + ": " + colorLibaryName.trim());
			}		
	 }	 
	 
	 public void deleteColorLibrary(int row) throws IOException, NullPointerException, InterruptedException {

		 try {				
			 delete_ColorLibrary(row);
			 deletePopupColorLibrary(row);

			 //********* Verify whether product deleted successfully by taking successful Toast message **********

			 WebElement element = driver.findElement(By.xpath("//div[@class='toast-c']/div[contains(text(),'ColorLibrary deleted successfully')]"));
			 System.out.println("Inner Text: "+element.getAttribute("innerText"));
			 String deleteproduct_sucess_toast = "ColorLibrary deleted successfully";

			 if(element.getAttribute("innerText").trim().matches(deleteproduct_sucess_toast))
			 {
				 System.out.println("Color Libary deleted successfully with "+colorLibaryName);
				 ResultsLog.ReportDoneEvent("Color Libary deleted successfully with Color Libary" + ": " + colorLibaryName.trim());
				 verifyColorLirary_AfterDelete(row);
			 } else {
				 System.out.println("Color Libary deleted unsuccessfully for: "+colorLibaryName);
				 ResultsLog.ReportDoneEvent("Color Libary deleted unsuccessfully for " + "artCode" + ": " + colorLibaryName.trim());			
			 }								
		 }
		 catch(NoSuchElementException e2){
			 ResultsLog.ReportFail(driver, "Given Color Libary Name: " + colorLibaryName.trim() + " not found", e2.toString());
			 //element_status = "not exist";
			 result = "Fail";
		 }				
	 }

	
	//*****************************************************
	//************** Actual Functional Method *************
	//*****************************************************

	//************* Adding Color Library *******************
	
		public void addColorLibraries(int row) throws Exception {		
			//colorLibrary();
			Thread.sleep(6000);
			click_btnNewColorLibrary();
			Thread.sleep(5000);
			add_ColorLibrary(row);
			add_Description(row);
			add_Illuminant(row);
			add_ObserverAngle(row);
			add_MeasurementCondition(row);
			add_ΔEFormulaType(row);
			add_Tolerance(row);
			add_ClientAccess(row);
			add_Colors(row);	
			SaveChanges(row);
			if (!duplicateColorLibraryExist) {
				//ColorlibraryAddToastMessage(row);
				verify_AddedColorLibrary(row);
			}
			Thread.sleep(3000);			
	}
		
		//Edit Color Library details
		public void editColorLibraries(int row) throws Exception {
			enterColorLibraryDetailsToEdit(row);
			button_EditColorLibrary(row);
			edit_Description(row);
			edit_Illuminant(row);
			edit_ObserverAngle(row);
			edit_MeasurementCondition(row);
			edit_ΔEFormulaType(row);
			edit_Tolerance(row);
			edit_ClientAccess(row);
			edit_Colors(row);
			SaveChanges(row);
			if (!duplicateColorLibraryExist) {
				//ColorlibraryAddToastMessage(row);
				verify_ColorLibraryDetailsAfterEdit(row);
			}
			Thread.sleep(3000);
		}
		
		//Delete Color library
		public void deleteColorLibraries(int row) throws Exception {
			enterColorLibraryDetailsToDelete(row);			
			deleteColorLibrary(row);	
			Thread.sleep(3000);			
		}
}