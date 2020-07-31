package com.MyColors.CommonPages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;


import com.MyColors.Pages.Page_Login;

import com.MyColors.Pages.PT_MyColors_MainMenu;
import com.MyColors.Pages.PT_MyColors_Products;
import com.Utils.HTMLReporter;
import com.Utils.LaunchBrowser;

import jxl.read.biff.BiffException;

public class MyColorPages {
	

	// Login
	public static void Page_Login() throws IOException, InterruptedException {
		Page_Login getPage_PageLogin = new Page_Login();
		getPage_PageLogin.login();
	}
	
	//Clicking on Products link from side menu on home page
	public static void PT_MyColors_ClickProducts() throws IOException, InterruptedException {
		PT_MyColors_MainMenu getPage_Page_Products = new PT_MyColors_MainMenu();
		getPage_Page_Products.clickProducts();
	}
	
	//Creating new product using data driven
	public static void PT_MyColors_addProduct(int row) throws Exception {
		PT_MyColors_Products getPage_Page_addProduct = new PT_MyColors_Products();		
		getPage_Page_addProduct.addProduct(row);		
	}
	
	//Edit or updating existing product
	public static void PT_MyColors_editProduct(int row) throws Exception {
		PT_MyColors_Products getPage_Page_editProduct = new PT_MyColors_Products();
		getPage_Page_editProduct.editProducts(row);
	}	
	
	//Delete existing product
	public static void PT_MyColors_deleteProduct(int row) throws Exception {
		PT_MyColors_Products getPage_Page_deleteProduct = new PT_MyColors_Products();
		getPage_Page_deleteProduct.deleteProducts(row);
	}	
	
	//Import Colors
	public static void PT_MyColors_ImportColors(int row) throws Exception {
		com.MyColors.Pages.PT_MyColors_ImportColors getPage_Page_importColors = new com.MyColors.Pages.PT_MyColors_ImportColors();
		getPage_Page_importColors.importColor(row);
	}
	
	//Color Libraries
	
	//Clicking on Products link from side menu on home page
	public static void PT_MyColors_ClickColorLibrary() throws IOException, InterruptedException {
		PT_MyColors_MainMenu getPage_Page_Products = new PT_MyColors_MainMenu();
		getPage_Page_Products.colorLibrary();
	}
	//Creating new ColorLibrary using data driven

	public static void PT_MyColors_addColorLibraries(int row) throws Exception {
		com.MyColors.Pages.PT_MyColors_ColorLibraries getPage_Page_addColorLibrary = new com.MyColors.Pages.PT_MyColors_ColorLibraries();		
		getPage_Page_addColorLibrary.addColorLibraries(row);		
	}
		
	//Edit or updating existing ColorLibrary
	public static void PT_MyColors_editColorLibraries(int row) throws Exception {
		com.MyColors.Pages.PT_MyColors_ColorLibraries getPage_Page_editColorLibrary  = new com.MyColors.Pages.PT_MyColors_ColorLibraries();
		getPage_Page_editColorLibrary.editColorLibraries(row);
	}	
		
	//Delete existing ColorLibrary
		public static void PT_MyColors_deleteColorLibraries(int row) throws Exception {
			com.MyColors.Pages.PT_MyColors_ColorLibraries getPage_Page_deleteColorLibrary = new com.MyColors.Pages.PT_MyColors_ColorLibraries();
			getPage_Page_deleteColorLibrary.deleteColorLibraries(row);
		}	
		
	//Logout
	public static void Page_LogOut() throws IOException, InterruptedException {
		Page_Login getPage_PageLogin = new Page_Login();
		getPage_PageLogin.logOut();
	}
	
	
	
	}
