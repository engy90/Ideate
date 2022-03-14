package pagesContentChecks;


import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import employeeTC.HomeEmployee;
import employeeTC.Login;
import pageObjectModels.GeneralPage;
import pageObjectModels.HomePageEmployee;
import resources1.base;

public class GeneralPageValidation extends base {
	
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomeEmployee.class.getName());
	@BeforeTest
	public void tearup() throws IOException

	{
		
		driver = initializeDriver();
		String usertype = "employee";

		driver=login(usertype ,driver);
		driver.get("https://qa.ideate.ooredoo.com/ideas");
	}
	
	
	@Test
	public void homePagevalidation() throws IOException {
		
		GeneralPage general = new GeneralPage(driver);
		HomePageEmployee hp = new HomePageEmployee(driver);
		
	assertTrue(general.chechGeneralIdeaTab().isDisplayed());
		
		assertTrue(general.checkGTopInnovators().isDisplayed());
		
		 for (int i=1 ; i<=8; i++)
		 {
			 assertTrue(general.checkTInnovatorsList(i).isDisplayed());
			 System.out.println(general.checkTInnovatorsList(i).getText());
		 }
		 
		 
		 assertTrue(general.checkGenelIdeas().isDisplayed());
		 assertTrue(general.checkIdeaOfTheMonth().isDisplayed());
		 assertTrue(general.CheckQurterlyView().isDisplayed());
			for(int i = 1 ; i<=7 ; i++)
			{
				
				assertTrue(hp.findTrendingInsights(i).isDisplayed());
				System.out.println(hp.findTrendingInsights(i).getText()+ "  is displayed ");
			}
	}
	
	@AfterTest
	public void teardown() {
		// driver.close();

	}
	

}
