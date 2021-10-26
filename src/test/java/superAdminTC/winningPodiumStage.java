package superAdminTC;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import superAdminTC.Login;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.CrowedEvaluationPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.WinningPodiumPage;
import resources1.base;

public class winningPodiumStage extends base {


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
		String url = prop2.getProperty("evaluationurl")+id+"/winning-podium";
		driver.manage().window().maximize(); 
		driver.get(url);

	}



	@Test
	public   void committeeEvaluation() throws IOException
	{
		WinningPodiumPage cr = new WinningPodiumPage(driver) ;
		 Actions build = new Actions(driver);
		
		

		  for (int q =1;q<=3;q++)
		  {
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  build.moveToElement(cr.clickShortlisted(q)).click().build().perform();
			 build.moveToElement(cr.clickEvaluate1(q)).click().build().perform();
			
			
		  }
		  
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.navigate().refresh();

		 
		 
		  
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

