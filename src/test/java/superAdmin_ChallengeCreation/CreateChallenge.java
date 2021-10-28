package superAdmin_ChallengeCreation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.LoginPage;
import pageObjectModels.WinningPodiumPage;
import resources1.base;

public class CreateChallenge extends base {
	
	
	@BeforeTest
	public void tearup() throws IOException, ClassNotFoundException, SQLException

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
		String id  =  getActiveQuarter();
		String url = prop2.getProperty("addnewchallenge");
		driver.manage().window().maximize(); 
		driver.get(url);

	}
	@Test
	public   void committeeEvaluation() throws IOException, InterruptedException
	{
		WinningPodiumPage cr = new WinningPodiumPage(driver) ;
		 Actions build = new Actions(driver);
	
		  for (int q =1;q<=3;q++)
		  {
			  
			  build.moveToElement(cr.clickShortlisted(1)).click().build().perform();
			 build.moveToElement(cr.clickEvaluate1(1)).click().build().perform();
				driver.navigate().refresh(); 
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			build.moveToElement(driver.findElement(By.xpath("//div[text()=' Top 10 Scored Idea ']")));
		  }
		  
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		  build.moveToElement(cr.clickUpdate()).click().build().perform();
		  build.moveToElement(cr.moveToNextStage()).click().build().perform();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		

		}

	@AfterTest
	public void teardown()
	{
		//driver.close();

	}



}


