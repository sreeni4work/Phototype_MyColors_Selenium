package com.MyColors.Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;

public class Page_Login extends BasePages {
//	LaunchBrowser launchBrowser = new LaunchBrowser();
	Member_SignUpPagedata data = new Member_SignUpPagedata();

	String NavigatedPageTitle = "Salesforce - Unlimited Edition";

// Objects from Application

	public WebElement txtUserName() {

		return driver.findElement(By.name("username"));
	}

	public WebElement txtPassword() {

		return driver.findElement(By.name("password"));
	}

	public WebElement btnLog_In() {

		return driver.findElement(By.id("btn-submit"));
	}
	public WebElement lnkUserName() {

		//return driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		return driver.findElement(By.xpath("//*[@id=\"content\"]/app-top-nav-bar/nav/div/div/div[2]/div/a"));		
		
	}
	public WebElement lnkLog_Out() {
		
		//Mouseover on Username 
        Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"content\"]/app-top-nav-bar/nav/div/div/div[2]/div/a"));
        action.moveToElement(btn).perform();
		return driver.findElement(By.linkText("Logout"));
	}

// Each Object  Method	

	public void EnterUserName() throws IOException {

		enterText(txtUserName(), "User Name", LaunchBrowser.TestSettingsObjects.getProperty("UserName"));
	}

	public void EnterPassword() throws IOException {
		enterText(txtPassword(), "Password", LaunchBrowser.TestSettingsObjects.getProperty("Password"));
		//txtPassword().sendKeys(LaunchBrowser.TestSettingsObjects.getProperty("Password"));
	}

	public void ClickSignButton() throws IOException {

		clickOnButton(btnLog_In(), "Log In");
	}
	public void verificationCode() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Please Enter Verification Code");
		String verificationCode = scanner.nextLine();
		driver.findElement(By.xpath("//div[@class='formArea']/input")).sendKeys(verificationCode);
		driver.findElement(By.xpath("//input[@value='Verify']")).click();
	}
	

	public void LaunchURL() throws IOException {

		driver.get(LaunchBrowser.TestSettingsObjects.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

// Actual Functional Method 

	public void login() throws IOException, InterruptedException {
		LaunchURL();
		EnterUserName();
		EnterPassword();
		ClickSignButton();
		

	}

	// Negative Login Test -- User Name
	public void NegativeloginUserName() throws IOException {
		LaunchURL();
		enterText(txtUserName(), "User Name", "Testing");
		txtPassword().sendKeys(LaunchBrowser.TestSettingsObjects.getProperty("Password"));
		clickOnButton(btnLog_In(), "Log In");

	}

	// Negative Login Test -- Password
	public void NegativeloginPassword() throws IOException {
		LaunchURL();
		enterText(txtUserName(), "User Name", LaunchBrowser.TestSettingsObjects.getProperty("UserName"));
		txtPassword().sendKeys("Password");
		clickOnButton(btnLog_In(), "Log In");

	}
	public void logOut() throws IOException, InterruptedException {
		clickOnLink(lnkUserName(), "UserName");
		clickOnLink(lnkLog_Out(), "LogOut");
			}

}

