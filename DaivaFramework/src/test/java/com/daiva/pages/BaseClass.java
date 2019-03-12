package com.daiva.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.daiva.utilities.BrowserFactory;
import com.daiva.utilities.ConfigDataProvider;
import com.daiva.utilities.ExcelDataProvider;
import com.daiva.utilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports exReport;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuit() {
		
		Reporter.log("Initialising reports and test is getting ready", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		//System.out.println(System.getProperty("user.dir"));
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/LoginDaiva"+Helper.getCurrentDateTime()+".html"));
		
		exReport =new ExtentReports();
		
		exReport.attachReporter(extent);
		
		Reporter.log("Test initialisation completed and test can be started",true);
	}
	
	@BeforeClass
	public void setUp() {
		
		Reporter.log("Trying to start browser and getting application ready", true);
		//driver=BrowserFactory.startApplication(driver, "Firefox", "http://daiva.live/login");
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		

		
		//System.out.println(config.getDataFromConfig("name"));
		Reporter.log("Browser and application is up and running", true);
	}
	
	
	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Test is above to end", true);
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			//Helper.captureScreenShot(driver);
			
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		exReport.flush();
		Reporter.log("Test completed and report generated", true);
	}
}
