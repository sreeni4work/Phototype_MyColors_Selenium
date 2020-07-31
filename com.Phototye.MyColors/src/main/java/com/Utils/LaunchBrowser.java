package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;

public class LaunchBrowser extends BasePages {
	public static Properties TestSettingsObjects = null;
	public static FileInputStream TestSettingsfile = null;
	static String browserName = null;

	/**
	 * Get the browser object specified in the property
	 * 
	 * @param browserName
	 * @return
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	public static void LaunchBrowserapp() throws IOException {

		TestSettingsObjects = new Properties();
	//	FileInputStream TestSettingsfile;
		TestSettingsfile = new FileInputStream(System.getProperty("user.dir") + "\\TestSettings.properties");
		TestSettingsObjects.load(TestSettingsfile);
		browserName = TestSettingsObjects.getProperty("Browser");

		// final ThreadLocal<WebDriver> ThreadDriver = new ThreadLocal<WebDriver>();
		// WebDriver driver = ThreadDriver.get();
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marinette",
					System.getProperty("user.dir") + "\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

		if (browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			//d = new ChromeDriver(dc);
			if(TestSettingsObjects.getProperty("OSPlatform").equalsIgnoreCase("WindowsOS")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Resources/ChromeDriver/chromedriver.exe");
				ChromeOptions Options = new ChromeOptions();
				Options.addArguments("disable-infobars");
				Options.addArguments("--disable-notifications");
				Options.addArguments("--disable-extensions");
				Options.addArguments("--start-maximized");				 
				driver = new ChromeDriver(Options);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} else if(TestSettingsObjects.getProperty("OSPlatform").equalsIgnoreCase("Linux")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Resources/ChromeDriverLinux/chromedriver");
				ChromeOptions Options = new ChromeOptions();
				Options.addArguments("disable-infobars");
				Options.addArguments("--disable-notifications");
				Options.addArguments("--disable-extensions");
				Options.addArguments("--start-maximized");
				driver = new ChromeDriver(Options);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} else {
				System.out.println("OS Platform is undefind");
			}

			
			// ThreadDriver.set(driver);

		} else if (browserName.equalsIgnoreCase("iexplore") || browserName.equalsIgnoreCase("ie")) {
			LoggingPreferences logs = new LoggingPreferences();
			logs.enable(LogType.BROWSER, Level.ALL);
			logs.enable(LogType.CLIENT, Level.ALL);
			logs.enable(LogType.DRIVER, Level.ALL);
			logs.enable(LogType.PERFORMANCE, Level.ALL);
			logs.enable(LogType.PROFILER, Level.ALL);
			logs.enable(LogType.SERVER, Level.ALL);
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			// this is here to get around my personal(Pradeep) VM Internet option security
			// settings. Need to correct my own issues and remove eventually
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

			String testprop = System.getProperty("user.dir") + "\\IEDriver\\IEDriverServer.exe";
			System.out.println(testprop);
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}	

	}

	public void Logout() {

	}

}
