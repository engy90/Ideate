package superAdminTC;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModels.HomePageEmployee;
import pageObjectModels.LogOutPage;
import pageObjectModels.LoginPage;
import resources1.base;

public class Login extends base {
	public WebDriver driver ;
	
	private static Logger log = LogManager.getLogger(Login.class.getName()) ;

	@BeforeTest
	public void tearup() throws IOException
	
	{
		driver = initializeDriver() ; 
		
		
		 
		 driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void login() throws IOException
	{
		
		LoginPage login = new LoginPage(driver) ; 
		HomePageEmployee home = new HomePageEmployee(driver);
		String usertype = "superadmin";
		String[] st = new String[2] ;  
		st= login(usertype);
		
		login.insertEmail().sendKeys(st[0]);
		login.insertpass().sendKeys(st[1]);
		login.loginbtn().click();
		AssertJUnit.assertTrue(home.checkTrendingInsighs().isDisplayed());
		
	
	}
	
	@AfterTest
	public void teardown()
	{
		//driver.close();
		
	}
	
	
	
		
	}

