package superAdmin_ChallengeCreation;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.LoginPage;
import resources1.base;

public class EmployeeAddIdeaToChallenge extends base {
	
	//CreateChallenge rr = new CreateChallenge(driver);
	
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
		String[] st = new String[2] ;  
		st= login(usertype);
		LoginPage login = new LoginPage(driver) ; 

		login.insertEmail().sendKeys(st[0]);
		login.insertpass().sendKeys(st[1]);
		login.loginbtn().click();
		
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
