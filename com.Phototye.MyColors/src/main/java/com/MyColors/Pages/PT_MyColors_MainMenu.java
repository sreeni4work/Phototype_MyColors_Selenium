package com.MyColors.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Utils.BasePages;

public class PT_MyColors_MainMenu extends BasePages {

	public PT_MyColors_MainMenu() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Objects from Application
// My Colors Menu
	public static WebElement lnk_Products() {
		return driver.findElement(By.linkText("Products"));

	}

	public static WebElement colorLibraries_Grid() {
		return driver.findElement(By.xpath("//*[@class='far fa-qrcode']"));
	}


// Each Object Performance Method
	// My Colors Menu


	public void clickProducts() throws IOException, InterruptedException {
		Thread.sleep(3000);
		lnk_Products().click();	
	}	

	public void colorLibrary() throws IOException {

		clickOnButton(colorLibraries_Grid(), "ColorLibrary grid");
	}
}
