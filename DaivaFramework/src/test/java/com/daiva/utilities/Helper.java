package com.daiva.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	//screens shot, alaerts, frames, windows, sync issue,java script runner 
	public static String captureScreenShot(WebDriver driver) {
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath=System.getProperty("user.dir")+"/Screenshots/LoginToDaiva"+getCurrentDateTime()+".png";
		
		try {
			//FileHandler.copy(src,new File("./Screenshots/Daiva"+getCurrentDateTime()+".png"));
			
			FileHandler.copy(src,new File(screenShotPath));
			
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			
			System.out.println("Unable to capture screenshot "+e.getMessage());

		}
		return screenShotPath;
		
	}
	public static String getCurrentDateTime() {
		
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm-ss");
		
		Date currentDate=new Date();
		
		return customFormat.format(currentDate);
		
		
	}
}
