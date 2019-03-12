package com.daiva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	//This is new change committed by Wali
	public LoginPage(WebDriver localdriver) {
		
		this.driver=localdriver;
		
	}
	
	@FindBy(id="inputEmail") WebElement uname;
	
	@FindBy(id="inputPassword") WebElement password;
	
	@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
	
	public void loginToDaiva(String userName, String userPassword) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		uname.sendKeys(userName);
		password.sendKeys(userPassword);
		loginButton.click();
	}
}


