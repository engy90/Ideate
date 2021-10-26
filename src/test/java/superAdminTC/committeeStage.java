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
import resources1.base;

public class committeeStage extends base {


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
		String url = prop2.getProperty("evaluationurl")+id+"/selection-committee";
		driver.manage().window().maximize(); 
		driver.get(url);

	}



	@Test
	public   void committeeEvaluation() throws IOException
	{
		CrowedEvaluationPage cr = new CrowedEvaluationPage(driver) ;
		 Actions build = new Actions(driver);
		 
		 String path1 ="//div[@class=\"rating-comments__parameters ng-tns-c161-0\"]/child::div[1]/child::div[";
		 String path2 = "]/child::div[1]/child::div[1]/child::div["; 
		 String path3 ="]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]";
		
/*____________Committee stage____________*/
		 
		  for (int q =1;q<=3;q++)
		  {
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  build.moveToElement(cr.clickShortlisted(q)).click().build().perform();
			  build.moveToElement(cr.clickEvaluateCommittee(q)).click().build().perform();
			
			  
		   for (int i = 1 ; i <=6 ; i++)
		  
		  { 
		   for (int j =1 ; j<=4 ; j++) {
		  
		  try {
		  
		  
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path1+i+
		  path2+j+path3)));
		  
		  build.moveToElement(driver.findElement(By.xpath(path1+i+path2+j+path3))).
		  click().build().perform(); } catch(Exception e) { System.out.println(e); }
		  
		  }
		  
		  }
		  
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		  build.moveToElement(cr.clicksaveparam()).click().build().perform();
		//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.navigate().refresh();
		//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		  }
		  driver.navigate().refresh();
		  
		  build.moveToElement(cr.clickUpdateCommittee()).click().build().perform();
		  build.moveToElement(cr.moveToNextStage()).click().build().perform();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		

		}

	@AfterTest
	public void teardown()
	{
		//driver.close();

	}



}


