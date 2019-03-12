package come.daiva.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.daiva.pages.BaseClass;
import com.daiva.pages.LoginPage;
import com.daiva.utilities.BrowserFactory;
import com.daiva.utilities.ExcelDataProvider;
import com.daiva.utilities.Helper;


public class LoginTestDaiva extends BaseClass{
	
	
	
	@Test(priority=1)
	public void loginApp() {
		
		//ExcelDataProvider excel=new ExcelDataProvider();
		
		//System.out.println(driver.getTitle());
		
		logger=exReport.createTest("Login to Daiva");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		//loginPage.loginToDaiva("msk@nova-global.in", "msk");
		loginPage.loginToDaiva(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Logged in to daiva successfully");
		
		//Helper.captureScreenShot(driver);
		
	}
	@Test(priority=2)
	public void logOutApp() {
		logger=exReport.createTest("Logout");
		
		logger.fail("Logout test failed");
	}
	

}
