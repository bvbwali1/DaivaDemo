package com.daiva.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver localdriver, String browserName, String applicationURL) {
	
		if(browserName.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			localdriver=new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			localdriver=new FirefoxDriver();
			
		}
		else if(browserName.equals("IE")) 
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
			
			localdriver=new InternetExplorerDriver();
			
		}
		else 
		{
			
			System.out.println("Sorry,selected browser is not supported");
		}
		localdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		localdriver.manage().window().maximize();
		
		localdriver.get(applicationURL);
		
		localdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return localdriver;
	}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
