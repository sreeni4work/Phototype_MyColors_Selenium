package com.MyColors.Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;
import com.Utils.LaunchBrowser;

public class PT_MyColors_Login extends BasePages {
	// LaunchBrowser launchBrowser = new LaunchBrowser();
	Member_SignUpPagedata data = new Member_SignUpPagedata();
	
	public PT_MyColors_Login(){
		
		driver.switchTo().defaultContent();
	}

// Objects from Application

	public WebElement txtUserName() {

		return driver.findElement(By.name("username"));
	}

	public WebElement txtPassword() {

		return driver.findElement(By.name("password"));
	}

	public WebElement btnSignIn() {

		return driver.findElement(By.id("btn-submit"));
	}

	
// Each Object  Method	

	public void EnterUserName() throws IOException {

		enterText(txtUserName(), "User Name", LaunchBrowser.TestSettingsObjects.getProperty("UserName"));
		txtUserName().sendKeys(LaunchBrowser.TestSettingsObjects.getProperty("UserName"));
	}

	public void EnterPassword() throws IOException {

		txtPassword().sendKeys(LaunchBrowser.TestSettingsObjects.getProperty("Password"));
	}

	public void SignIn() throws IOException {

		clickOnButton(btnSignIn(), "Sign In");
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
		SignIn();

	}

	// Negative Login Test -- User Name
	public void NegativeloginUserName() throws IOException {
		LaunchURL();
		enterText(txtUserName(), "User Name", "Testing");
		txtPassword().sendKeys(LaunchBrowser.TestSettingsObjects.getProperty("Password"));
		clickOnButton(btnSignIn(), "Sign In");

	}

	// Negative Login Test -- Password
	public void NegativeloginPassword() throws IOException {
		LaunchURL();
		enterText(txtUserName(), "User Name", LaunchBrowser.TestSettingsObjects.getProperty("UserName"));
		txtPassword().sendKeys("Password");
		clickOnButton(btnSignIn(), "Sign In");

	}

}			