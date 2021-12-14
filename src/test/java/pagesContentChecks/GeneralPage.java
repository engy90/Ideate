package pagesContentChecks;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import employeeTC.HomeEmployee;
import employeeTC.Login;
import resources1.base;

public class GeneralPage extends base {
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomeEmployee.class.getName());
	@BeforeTest
	public void tearup() throws IOException

	{
		driver = initializeDriver();
		String usertype = "employee";

		driver=login(usertype ,driver);
		
	}
	
	
	@Test
	public void homePagevalidation() throws IOException {}
	
	@AfterTest
	public void teardown() {
		// driver.close();

	}
	

}
