package com.MyColors.CommonPages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;
import com.aventstack.extentreports.Status;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class MyColorsMenu extends BasePages {
	static Member_SignUpPagedata data = new Member_SignUpPagedata();
	String ExpectedPageHeading = "Home";
	private String errormessage;

	/*
	 * public Menu() { driver.manage().timeouts().implicitlyWait(10,
	 * TimeUnit.SECONDS); driver.switchTo().defaultContent(); }
	 */

// Objects from Application

	public WebElement btnLightUserImage() {
		return driver.findElement(By.xpath("//*[@class='uiImage']"));
	}

	public WebElement btnLightlogout() {
		return driver.findElement(By.xpath("//*[text()='Log Out']"));
	}

	public WebElement lnkSwitchToSalesForceClassic() {
		return driver.findElement(By.xpath("//a[@class='profile-link-label switch-to-aloha uiOutputURL']"));
	}

	public WebElement PageTitleObject() {
		return driver.findElement(By.xpath("//*[@id='home_Tab']/a"));
	}

	public WebElement btnNew() {
		return driver.findElement(By.xpath("//*[@class='btn'][@name='new']"));
	}

	public WebElement dpd_RecordTypeofnewrecord() {
		return driver.findElement(
				By.xpath("//*[@class='labelCol requiredInput']/following-sibling::td/child::div/child::select"));
	}

	public WebElement btnContinue() {
		return driver.findElement(By.xpath("//*[@title='Continue'][@class='btn']"));
	}

	public WebElement btnNext() {
		return driver.findElement(
				By.xpath("//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']"));
	}

	public WebElement lnkHome() {
		return driver.findElement(By.xpath("//*[@class='brandPrimaryFgr'][contains(@title,'Home')]"));
	}

	public WebElement lnkWine_Shipments() {
		return driver.findElement(By.xpath("//*[@title='Wine Shipments Tab']"));
	}

	public WebElement lnkDaily_Summaries() {
		return driver.findElement(By.xpath("//*[@title='Daily Summaries Tab']"));
	}

	public WebElement lnkWC_Members() {
		return driver.findElement(By.xpath("//*[@title='WC Members Tab']"));
	}

	public WebElement lnkAllTAbs() {
		return driver.findElement(By.xpath("//*[@title='All Tabs']"));
	}

	public WebElement lnkcustomizePage() {
		return driver.findElement(By.xpath("//*[text()='Customize Page']"));
	}

	public WebElement lnkcustomizeMyTabs() {
		return driver.findElement(By.xpath("(//*[text()='Customize My Tabs'])[1]"));
	}

	public WebElement lnkWCMemberstoAdd() {
		return driver.findElement(By.xpath("(//*[text()='WC Members'])[2]"));
	}

	public WebElement lnkAddArrow() {
		return driver.findElement(By.xpath("//*[@title='Add']"));
	}

	public WebElement saveAddWCMembers() {
		return driver.findElement(By.xpath("//*[@title='Save']"));
	}

	public WebElement btnUser() {

		return driver.findElement(By.xpath("//*[@id='userNavLabel']"));
	}

	public WebElement btnLogout() {

		return driver.findElement(By.xpath("//*[@class='menuButtonMenuLink'][@title='Logout']"));
	}

	public WebElement lnkSwitchtoSalesforceClassic() {

		return driver.findElement(By.xpath("//*[@class='profile-link-label switch-to-aloha uiOutputURL']"));
	}

	public WebElement menudpd() {

		return driver.findElement(By.xpath("//*[@class='menuButtonLabel'][@id='tsidLabel']"));
	}

	public WebElement lnkSalesforceChatter() {

		return driver.findElement(By.xpath("//*[text()='Salesforce Chatter']"));
	}

	public WebElement lnkSwitchtoLightningExperience() {
		return driver
				.findElement(By.xpath("//*[@class='switch-to-lightning'][contains(@href,'SwitchToLightningClick')]"));
	}

	public WebElement lnkIconWaffle() {
		return driver.findElement(By.xpath("//*[@class='slds-icon-waffle']"));

	}

	public WebElement lnkLightWCMembers() {
		return driver.findElement(By.xpath("//*[@class='label slds-truncate slds-text-link'][text()='WC Members']"));

	}

	public WebElement btnLightNew() {
		return driver.findElement(By.xpath("//div[@class='slds-truncate'][@title='New']"));
	}

	public WebElement btnLightMonthlyMember() {
		return driver.findElement(By.xpath("//*[@class='slds-form-element__label'][text()='Monthly Member']"));

	}

	public WebElement rbtnLightMonthlyMember() {
		return driver.findElement(By.xpath("//*[text()='Monthly Member']/preceding-sibling::span"));

	}

	public WebElement btnLightComplimentary() {
		return driver.findElement(By.xpath("//*[@class='slds-form-element__label'][text()='Complimentary']"));

	}

	public WebElement rbtnLightComplimentary() {
		return driver.findElement(By.xpath("//*[text()='Complimentary']/preceding-sibling::span"));

	}

	public WebElement btnLightCoopersHawkCare() {
		return driver.findElement(By.xpath("//*[@class='slds-form-element__label'][text()='Coopers Hawk Care']"));

	}

	public WebElement rbtnLightCoopersHawkCare() {
		return driver.findElement(By.xpath("//*[text()='Coopers Hawk Care']/preceding-sibling::span"));

	}

	public WebElement btnLightFounder() {
		return driver.findElement(By.xpath("//*[@class='slds-form-element__label'][text()='Founder']"));

	}

	public WebElement rbtnLightFounder() {
		return driver.findElement(By.xpath("//*[text()='Founder']/preceding-sibling::span"));

	}

	public WebElement btnLightGiftMember() {
		return driver.findElement(By.xpath("//*[@class='slds-form-element__label'][text()='Gift Member']"));

	}

	public WebElement rbtnLightGiftMember() {

		return driver.findElement(By.xpath("//*[text()='Gift Member']/preceding-sibling::span"));

	}

	public WebElement btnLightPromotion() {
		return driver.findElement(By.xpath("//*[@class='slds-form-element__label'][text()='Promotion']"));

	}

	public WebElement rbtnLightPromotion() {
		return driver.findElement(By.xpath("//*[text()='Promotion']/preceding-sibling::span"));

	}

	public WebElement btnLightNext() {
		return driver.findElement(By.xpath("//*[@class=' label bBody'][text()='Next']"));

	}

	public WebElement txtSearch() {
		return driver.findElement(By.xpath("//*[@id='phSearchInput']"));
	}

	public WebElement txtSearchLightning() {
		return driver.findElement(
				By.xpath("//div[@class='autocompleteWrapper slds-grow slds-form-element__control']/div/input"));
	}

	public WebElement btnSearch() {
		return driver.findElement(By.xpath("//*[@id='phSearchButton']"));
	}

	public WebElement readOnlycardNumberonSerachPage() {
		return driver.findElement(By.linkText(
				"//*[text()='Card Number']/parent::th/parent::tr/following-sibling::tr/child::td/following-sibling::th/following-sibling::td[5]"));
	}

	public WebElement linkcardNumberNameonSerachPage() {
		return driver.findElement(By.linkText(
				"//*[text()='Card Number']/parent::th/parent::tr/following-sibling::tr/child::td/following-sibling::th/child::a"));
	}

	public WebElement lnkCardHolderName(int row) {
		String Name = "";

		try {
			Name = data.Getdata("First Name", row) + " " + data.Getdata("Last Name", row);
			System.out.println(Name);
			System.out.println("//*[text()='" + Name + "']");
			return driver.findElement(By.xpath("//*[text()='" + Name + "']"));

		} catch (Exception e) {
			try {
				Name = data.Getdata("First Name", row).toLowerCase() + " "
						+ data.Getdata("Last Name", row).toLowerCase();
				return driver.findElement(By.xpath("//*[text()='" + Name + "']"));
			} catch (Exception e1) {
				Name = data.Getdata("First Name", row).toUpperCase() + " "
						+ data.Getdata("Last Name", row).toUpperCase();
				return driver.findElement(By.xpath("//*[text()='" + Name + "']"));

			}

		}
	}

	public void clickCardHolderNameForLightning(int row) {

		List<WebElement> nameList = driver.findElements(By.xpath(
				"(//*[text()='Name']/parent::a/parent::div/parent::th/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td/following-sibling::th/child::span/child::a)"));
		List<WebElement> cardNumberList = driver.findElements(By.xpath(
				"(//*[text()='Name']/parent::a/parent::div/parent::th/parent::tr/parent::thead/following-sibling::tbody/child::tr/child::td[6])/child::span/child::span"));

		for (int i = 0; i < cardNumberList.size(); i++) {
			try {
				WebElement cardNumber = cardNumberList.get(i);
				WebElement name = nameList.get(i);
				Thread.sleep(200);
				System.out.println("cardNumber :" + cardNumber.getText()  +  "Excel :" + data.Getdata("Card Number", row));
				if (cardNumber.isDisplayed() && cardNumber.getText().equals(data.Getdata("Card Number", row))) {
					name.click();
					break;
				} else {
					 
				}

			} catch (Exception e) {
				System.out.println("Element not displyed");
			}

		}

	}
//Error Objects

	public WebElement ErrorMessage() {

		return driver.findElement(By.xpath("//*[@class='message errorM3'][@role='alert']"));
	}

// Each Object Methods

	public void ClickLightningUserImage() throws IOException {

		try {
			if (btnLightUserImage().isEnabled()) {
				clickOnLinkWithNoCatchLog(btnLightUserImage(), "Lightning User Image");
			}

		} catch (Exception e) {
			driver.navigate().refresh();
			if (btnLightUserImage().isEnabled()) {
				clickOnLinkWithNoCatchLog(btnLightUserImage(), "Lightning User Image");
			}
		}

	}

	public void ClickLightningLogout() throws IOException {

		try {
			clickOnLinkWithNoCatchLog(btnLightlogout(), "Lightning Logout");
		} catch (Exception e) {
			clickOnLink(btnLightlogout(), "Lightning Logout");
		}

	}

	public void ClickSwitchtoSalesForceClassic() throws IOException {

		waitForPageLoadToComplete();
		waitForElementFor10(lnkSwitchToSalesForceClassic());
		try {
			clickOnLinkWithNoCatchLog(lnkSwitchToSalesForceClassic(), "Switch to SalesForce Classic");
		} catch (Exception e) {
			clickOnLink(lnkSwitchToSalesForceClassic(), "Switch to SalesForce Classic");
		}

	}

	public void ClickSwitchtoLightningExperienc() throws IOException {

		clickOnLink(lnkSwitchtoLightningExperience(), "Switch to Lightning Experience");
	}

	public void ClickIconWaffle() throws IOException, InterruptedException {
		try {
			driver.navigate().refresh();
			Thread.sleep(5000);
			clickOnLinkWithNoCatchLog(lnkIconWaffle(), " Icon Waffle ");
		} catch (Exception e) {
			driver.navigate().refresh();
			Thread.sleep(5000);
			clickOnLink(lnkIconWaffle(), " Icon Waffle ");
		}

	}

	public void ClickLnkLightWCMembers() throws IOException {
		try {

			clickOnLinkWithNoCatchLog(lnkLightWCMembers(), "WC Members -- Lightning");
		} catch (Exception e) {
			clickOnLink(lnkLightWCMembers(), "WC Members -- Lightning");
		}

	}

	public void ClickLightningNewMemberButton() throws IOException {
		try {
			Thread.sleep(3000);
			clickOnLinkWithNoCatchLog(btnLightNew(), "New-- Lightning");
		} catch (Exception e) {
			clickOnLink(btnLightNew(), "New-- Lightning");
		}

	}

	public void ClickLightningMonthlyMemberButton() throws IOException {

		clickOnButton(rbtnLightMonthlyMember(), "Lightning Monthly Member");
	}

	public void ClickLightningComplimentaryButton() throws IOException {

		clickOnButton(rbtnLightComplimentary(), "Lightning Complimentary");
	}

	public void ClickLightningCoopersHawkCareButton() throws IOException {

		clickOnButton(rbtnLightCoopersHawkCare(), "Lightning Coopers Hawk Care");
	}

	public void ClickLightningFounderButton() throws IOException {

		clickOnButton(rbtnLightFounder(), "Lightning Founder");
	}

	public void ClickLightningGiftMemberButton() throws IOException {

		clickOnButton(rbtnLightGiftMember(), "Lightning Gift Member");
	}

	public void ClickLightningPromotionButton() throws IOException {

		clickOnButton(rbtnLightPromotion(), "Lightning Promotion");
	}

	public void ClickLightningNextButton() throws IOException {
		try {
			clickOnButton(btnLightNext(), "Lightning Next");
		} catch (Exception e) {
			clickOnButton(btnLightNext(), "Lightning Next");
		}

	}

	public void ClickNewMemberButton() throws IOException {

		clickOnButton(btnNew(), "New Member");
	}

	public void SelectRecordTypeofnewrecord(int row) throws IOException {

		selectByText(dpd_RecordTypeofnewrecord(), "Record Type of new record",
				data.Getdata("WC Member Record Type", row));

	}

	public void ClickContinueBtn() throws IOException {

		clickOnButton(btnContinue(), "WC Member Continue");
	}

	public void ClickWC_Member() throws InterruptedException, IOException {

		try {
			// clickMainMenu(lnkWC_Members());
			clickOnLink(lnkWC_Members(), "WC Members");
			// clickMainMenuWithNoCatchLOG(lnkWC_Members());
		} catch (Exception e) {
			// clickMainMenu(lnkWC_Members());
		}

	}

	public void ClickHome() throws IOException {

		clickMainMenu(lnkHome());
	}

	public void ClassicApplicationLogout() throws IOException, InterruptedException {

		try {
			driver.switchTo().defaultContent();
			if (btnUser().isDisplayed()) {

				clickOnButton(btnUser(), "User Name on Menu");
				Thread.sleep(3000);
				clickOnButton(btnLogout(), "User Logout button on Menu");
			} else {

				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("scroll(10000,0)");
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				clickOnButton(btnUser(), "User Name on Menu");
				Thread.sleep(3000);
				clickOnButton(btnLogout(), "User Logout button on Menu");

			}
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			if (btnUser().isDisplayed()) {
				clickOnButton(btnUser(), "User Name on Menu");
				Thread.sleep(3000);
				clickOnButton(btnLogout(), "User Logout button on Menu");
			} else {

				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("scroll(5000,0)");
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				clickOnButton(btnUser(), "User Name on Menu");
				Thread.sleep(3000);
				clickOnButton(btnLogout(), "User Logout button on Menu");

			}
		}

	}

	public void LightningApplicationLogout() throws IOException, InterruptedException {
		try {
			driver.switchTo().defaultContent();
			if (!btnLightUserImage().isDisplayed()) {
				Thread.sleep(3000);
				ScrollUpbyJavaScript(5000);
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				ClickLightningUserImage();
				Thread.sleep(5000);
				ClickLightningLogout();
			} else {
				Thread.sleep(2000);
				ScrollUpbyJavaScript(5000);
				Thread.sleep(3000);
				ClickLightningUserImage();
				Thread.sleep(5000);
				ClickLightningLogout();
			}

		} catch (Exception e) {
			e.printStackTrace();
			driver.navigate().refresh();
			if (!btnLightUserImage().isDisplayed()) {
				Thread.sleep(2000);
				ScrollUpbyJavaScript(5000);
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				ClickLightningUserImage();
				Thread.sleep(5000);
				ClickLightningLogout();
			} else {
				Thread.sleep(2000);
				ScrollUpbyJavaScript(5000);
				Thread.sleep(3000);
				ClickLightningUserImage();
				Thread.sleep(5000);
				ClickLightningLogout();
			}

		}
	}

	public void EnterCardNumber_IN_Search(int row) throws IOException {
		// data.Getdata("Card Number", row)
		// Hard Coded the card number and work on getting from Excel and work on
		// Writedata in same excel
		// enterText(txtSearchLightning(), "Search", "756845");
		System.out.println("Card Number :" + data.Getdata("Card Number", row));
		enterText(txtSearch(), "search", data.Getdata("Card Number", row));
	}

	public void EnterCardNumber_IN_SearchLightning(int row) throws Exception {
		Thread.sleep(5000);
		enterText(txtSearchLightning(), "Search", data.Getdata("Card Number", row));

	}

	public void ClickSearchButton() throws IOException {

		clickOnButton(btnSearch(), "Search");
	}

	public void ClickCardMemberName(int row) throws IOException, InterruptedException {

		waitForAjax();
		waitForPageLoadToComplete();
		Thread.sleep(3000);
		// List <WebElement>
		// cardNumberList=driver.findElements(By.xpath("//*[text()='Card
		// Number']/parent::th/parent::tr/following-sibling::tr/child::td/following-sibling::th/following-sibling::td[5]"));
		for (int i = 0; i < 10; i++) {
			try {
				WebElement cardNumber = driver.findElement(By.xpath(
						"(//*[text()='Card Number']/parent::th/parent::tr/following-sibling::tr/child::td/following-sibling::th/following-sibling::td[5])["
								+ i + "]"));
				System.out.println("cardNumber from Application:" + cardNumber.getText() + "Card Number from Excel:"
						+ data.Getdata("Card Number", row));
				if (cardNumber.getText().equals(data.Getdata("Card Number", row))) {
					WebElement linkcardNumberName = driver.findElement(By.xpath(
							"(//*[text()='Card Number']/parent::th/parent::tr/following-sibling::tr/child::td/following-sibling::th/child::a)["
									+ i + "]"));
					linkcardNumberName.click();
					break;
				}
			} catch (Exception e) {
				System.out.println("Element not available at :" + i);
			}

		}

	}

	public void enterSearchButtonInLightning() throws AWTException, IOException {

		BasePages.robotClassActionForEnter();

	}
	// Condition Methods

	public void SelectNewWCMember(int row) throws IOException, InterruptedException {
		/*
		 * String memberShipType = data.Getdata("WC Member Record Type", row);
		 * Thread.sleep(15000); switch (memberShipType) { case "Monthly Member":
		 * ClickLightningMonthlyMemberButton(); break; case "Gift Member":
		 * ClickLightningGiftMemberButton(); break; case "Coopers Hawk Care":
		 * ClickLightningCoopersHawkCareButton(); break; case "Complimentary":
		 * ClickLightningComplimentaryButton(); break; case "Founder":
		 * ClickLightningFounderButton(); break; case "Promotion":
		 * ClickLightningPromotionButton(); break; default:
		 * ResultsLog.ReportInfo(driver, "Element not Found"); }
		 */

		Thread.sleep(10000);

		System.out.println(data.Getdata("WC Member Record Type", row));
		if (data.Getdata("WC Member Record Type", row).trim().equalsIgnoreCase("Monthly Member")) {
			ClickLightningMonthlyMemberButton();
		} else if (data.Getdata("WC Member Record Type", row).trim().equalsIgnoreCase("Gift Member")) {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rbtnLightGiftMember());
			ClickLightningGiftMemberButton();
		} else if (data.Getdata("WC Member Record Type", row).trim().equalsIgnoreCase("Coopers Hawk Care")) {
			ClickLightningCoopersHawkCareButton();
		} else if (data.Getdata("WC Member Record Type", row).trim().equalsIgnoreCase("Complimentary")) {
			ClickLightningComplimentaryButton();
		} else if (data.Getdata("WC Member Record Type", row).trim().equalsIgnoreCase("Founder")) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rbtnLightFounder());
			ClickLightningFounderButton();
		} else if (data.Getdata("WC Member Record Type", row).trim().equalsIgnoreCase("Promotion")) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rbtnLightPromotion());
			ClickLightningPromotionButton();
		}

	}

	// error message logic
	public void Errormessage(int row) throws IOException, BiffException {

		waitForErrorMessage(ErrorMessage());
		if (isElementPresent(ErrorMessage())) {

			errormessage = ErrorMessage().getText();
			ResultsLog.logger.log(Status.FAIL, row + " Error Message: " + errormessage);
			data.setData("Error", row, errormessage);
		}

	}

	public void LightningErrormessage(int row) throws IOException, BiffException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			waitForErrorMessage(ErrorMessage());
			if (isElementPresent(ErrorMessage())) {
				errormessage = ErrorMessage().getText();
				ResultsLog.logger.log(Status.FAIL, row + " Error Message: " + errormessage);
				data.setData("Error", row, errormessage);
			}
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			waitForErrorMessage(ErrorMessage());
			if (isElementPresent(ErrorMessage())) {
				errormessage = ErrorMessage().getText();
				ResultsLog.logger.log(Status.FAIL, row + " Error Message: " + errormessage);
				data.setData("Error", row, errormessage);
			}
		}

	}

// Screen Logic Method

	public void LightningLoginFlow(int row) throws IOException, InterruptedException {

		try {

			if (isElementPresent(lnkSwitchtoLightningExperience())) {
				ClickSwitchtoLightningExperienc();

			}

		} catch (Exception e) {
			ResultsLog.ReportDoneEvent("link Switch to Lightning Experience - is not Present ");

		}
		try {
			ClickIconWaffle();
		} catch (Exception e) {
			CloseBrowser();
			LaunchBrowser.LaunchBrowserapp();
			MyColorPages.Page_Login();
			ClickIconWaffle();
		}

		ClickLnkLightWCMembers();

	}

	public void addNewMemberforLightning(int row) throws IOException, InterruptedException {

		ClickLightningNewMemberButton();
		SelectNewWCMember(row);
		Thread.sleep(3000);
		ClickLightningNextButton();
	}

	public void ClassicLoginFlow(int row) throws IOException, InterruptedException {

		try {
			Thread.sleep(5000);
			waitForPageLoadToComplete();
			waitForElementFor10(lnkSwitchtoLightningExperience());
			if (!isElementPresent(lnkSwitchtoLightningExperience())) {

				ClickLightningUserImage();
				waitForPageLoadToComplete();
				waitForAjax();
				ClickSwitchtoSalesForceClassic();
			}
		} catch (Exception e) {
			//e.printStackTrace();
			// driver.switchTo().frame(1);
			ClickLightningUserImage();
			// waitForPageLoadToComplete();
			waitForAjax();
			ClickSwitchtoSalesForceClassic();

		}

	}

	public void addNewMemberForClassic(int row) throws InterruptedException, IOException {
		if (!menudpd().getText().equalsIgnoreCase("Salesforce Chatter")) {

			clickOnButton(menudpd(), "Salesforce Chatter Menu");
			clickOnButton(lnkSalesforceChatter(), "Salesforce Chatter link");
		}
		verifyCorrectPageHeading(PageTitleObject(), ExpectedPageHeading);
		if (!lnkWC_Members().isDisplayed()) {
			clickOnLink(lnkcustomizePage(), "Customize Page");
			Thread.sleep(3000);
			clickOnLink(lnkcustomizeMyTabs(), "Customize My Tabs");
			Thread.sleep(3000);
			clickOnLink(lnkWCMemberstoAdd(), "WC Members");
			Thread.sleep(3000);
			clickOnLink(lnkAddArrow(), "Add-Right Arrow");
			Thread.sleep(3000);
			ClickWC_Member();
			ClickNewMemberButton();
			SelectRecordTypeofnewrecord(row);
			ClickContinueBtn();
		} else {
			ClickWC_Member();
			ClickNewMemberButton();
			SelectRecordTypeofnewrecord(row);
			ClickContinueBtn();
		}

	}

	public void SearchMember(int row) throws IOException, AWTException, InterruptedException {
		EnterCardNumber_IN_Search(row);
		ClickSearchButton();
		ClickCardMemberName(row);

	}

	public void SearchMemberLightning(int row) throws Exception {
		EnterCardNumber_IN_SearchLightning(row);
		Thread.sleep(5000);
		enterSearchButtonInLightning();
		Thread.sleep(5000);
		clickCardHolderNameForLightning(row);
		Thread.sleep(5000);

	}

}
