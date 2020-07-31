package com.MyColors.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.MyColor.PagesData.Member_SignUpPagedata;
import com.Utils.BasePages;

public class PT_MyColors_Dashboard extends BasePages {

	Member_SignUpPagedata data = new Member_SignUpPagedata();
	PT_MyColors_MainMenu MenuPage = new PT_MyColors_MainMenu();

	public PT_MyColors_Dashboard() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Objects from Application
// Profile
	

	// Each Object Performance Method
	// Payment CC Info

	
// Should work on Radio Button Checked  Status 

	// Actual Functional Method

	public void ValidateProfile(int row) throws IOException, InterruptedException {

		
	}

}
