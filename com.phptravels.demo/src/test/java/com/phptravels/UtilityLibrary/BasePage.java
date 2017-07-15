package com.phptravels.UtilityLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {

	final static Logger mylogger = Logger.getLogger(BasePage.class);
	public static WebDriver driver;
	public static UtitlityLibrary myLib;

	@BeforeMethod

	public void start() {
		myLib = new UtitlityLibrary();
		mylogger.info("Test starting ....");
		driver = myLib.startLocalBrowsers("chrome");

	
	}

	@AfterMethod
	public void teardown() {
		mylogger.info("testing is ended ...");
		driver.close();
		driver.quit();

	}

}
