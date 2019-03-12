package come.daiva.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestWithoutFramework {

	@Test
	public void daivaLoginTest1() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://daiva.live/login");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("inputEmail")).sendKeys("msk@nova-global.in");
		
		driver.findElement(By.id("inputPassword")).sendKeys("msk");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.quit();
		

	}

}
