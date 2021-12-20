package superAdminTC;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import superAdminTC.Login;
import superAdmin_ChallengeCreation.EmployeeAddIdeaToChallenge;

import org.apache.hc.core5.util.Timeout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
import resources1.base;

public class committeeStage extends base {

	private static Logger log = LogManager.getLogger(committeeStage.class.getName()) ;

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

		driver=login(usertype ,driver);
		String id  =  getActiveQuarter();
		String url = prop2.getProperty("evaluationurl")+id+"/selection-committee";
		driver.manage().window().maximize(); 
		driver.get(url);

	}



	@Test
	public   void committeeEvaluation(WebDriver driver) throws IOException, InterruptedException
	{
		//driver.navigate().refresh();
		 Actions build = new Actions(driver);
		 
		 String path3 ="//div[@class=\"infinite-scroll-wrapper px-2 ng-tns-c162-0\"]/child::div[";
		 String path4 = "]/div/div/child::div["; 
		 String path5 ="]/div[2]/div/ngb-rating/span[4]";
		 CrowedEvaluationPage cr = new CrowedEvaluationPage(driver) ;
		 driver.navigate().refresh();
		
/*____________Committee stage____________*/
		 
		  for (int q =1;q<=3;q++)
		  {
			
			  build.moveToElement(cr.clickShortlisted(q)).click().build().perform();
			  build.moveToElement(cr.clickEvaluateCommittee(q)).click().build().perform();
			
			  
		   for (int i = 1 ; i <=6 ; i++)
		  
		  { 
		   for (int j =1 ; j<=4 ; j++) {
		  
		  try {
		  
	
			  
			
		  build.moveToElement(driver.findElement(By.xpath(path3+i+path4+j+path5)));
		  build.moveToElement(driver.findElement(By.xpath(path3+i+path4+j+path5))).click().build().perform();
		 
		  
		  } catch(Exception e) {
			  
			  
			  System.out.println(e);
			  break;
			  }
		  
		  }
		  
		  // build.sendKeys(Keys.PAGE_DOWN).build().perform();
		  }
		  
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		  build.moveToElement(cr.clicksaveparam()).click().build().perform();
		
			driver.navigate().refresh();
	

		  }
		 
			build.sendKeys(Keys.PAGE_UP).build().perform();
			build.sendKeys(Keys.PAGE_UP).build().perform();
			driver.navigate().refresh();
		  
		  build.moveToElement(cr.clickUpdateCommittee()).click().build().perform();
		  build.moveToElement(cr.moveToNextStage()).click().build().perform();
		  
		

		}

	@AfterTest
	public void teardown()
	{
		//driver.close();

	}



}


