package com.MyColors.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;

import jxl.read.biff.BiffException;

public class PT_MyColors_UserAccess extends BasePages {
	Member_SignUpPagedata data = new Member_SignUpPagedata();
	PT_MyColors_MainMenu MenuPage = new PT_MyColors_MainMenu();
	PT_MyColors_Dashboard profilepage = new PT_MyColors_Dashboard();

	public PT_MyColors_UserAccess() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Objects from Application
// Menu-LHS
	
	public static WebElement lnk_Timesheet() {
		return driver.findElement(By.xpath("//a[@href='/dashboard/timesheet']"));

	}
	public static WebElement lnk_Materials() {
		return driver.findElement(By.xpath("//a[@href='/dashboard/materials']"));

	}
	public static WebElement lnk_Dashboard() {
		return driver.findElement(By.xpath("//a[@href='/dashboard/home']"));

	}
	public static WebElement lnk_MyEmployees() {
		return driver.findElement(By.xpath("//a[@href='/dashboard/my-employee']"));

	}
	
	// Objects from Application
	// Main Menu
	public static WebElement lnk_UserName() {
		return driver.findElement(By.xpath("//span[text()='Test AD user']"));

	}
	public static WebElement lnk_Logout() {
		return driver.findElement(By.xpath("//a[text()='Logout']"));

	}
	public static WebElement lnk_EnterTime() {
		return driver.findElement(By.xpath("//span[text()=' Enter Time ']"));

	}
	public static WebElement lnk_StartShift() {
		return driver.findElement(By.xpath("//span[text()='Start Shift']"));

	}
	

	// Each Object Performance Method
	// My Time Page
	
	public void clickTimesheet() throws IOException {

		clickOnLink(lnk_Timesheet(), "Timesheet");
			}	
	}
