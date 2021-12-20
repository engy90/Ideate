package superAdmin_ChallengeCreation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import employeeTC.employeeAddIdeaTC02;
import pageObjectModels.LoginPage;
import resources1.base;

public class EmployeeAddIdeaToChallenge extends base {
	
	private static Logger log = LogManager.getLogger(EmployeeAddIdeaToChallenge.class.getName()) ;

	@BeforeTest
	public void tearup() throws IOException, ClassNotFoundException, SQLException, InterruptedException

	{

		driver = initializeDriver() ; 
		if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa") )
		{ 
			driver.get(prop2.getProperty("url"));
			
		}

		else 
		{
			driver.get(prop3.getProperty("url"));
		}


		String usertype = "superadmin";

		driver=login(usertype ,driver);
        Thread.sleep(1000);
		
		String url = prop2.getProperty("addnewchallenge");
		 
		driver.get(url);
		driver.manage().window().maximize();
}
	@Test
	public void  addIdeaToChallenge () throws IOException, InterruptedException
	
	{
		CreateChallenge rr = new CreateChallenge();

		
		
	}
	
}
