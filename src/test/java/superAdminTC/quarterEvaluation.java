package superAdminTC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import superAdminTC.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.CrowedEvaluationPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import resources1.base;

public class quarterEvaluation extends base {


	@BeforeTest
	public void tearup() throws IOException, ClassNotFoundException, SQLException

	{

		driver = initializeDriver() ; 
		if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa") )
		{ driver.get(prop2.getProperty("url"));}

		else {
			driver.get(prop3.getProperty("url"));
		}


		String usertype = "superadmin";
		String[] st = new String[2] ;  
		st= login(usertype);
		LoginPage login = new LoginPage(driver) ; 

		login.insertEmail().sendKeys(st[0]);
		login.insertpass().sendKeys(st[1]);
		login.loginbtn().click();
		String id  =  resetQuarter();
		String url = prop2.getProperty("evaluationurl")+id+"/expert-review";
		driver.manage().window().maximize(); 
		driver.get(url);



	}



	@Test
	public   void employeeLogin() throws IOException
	{
		CrowedEvaluationPage cr = new CrowedEvaluationPage(driver) ; 
		cr.options1().click();
		cr.clickShortlist1().click();
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		cr.clickShortlisted1().click();
		cr.clickEvaluate1().click();  
		
		
//		
//		cr.options2().click();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		cr.clickShortlist2().click();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//
//		cr.options3().click();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//
//		cr.clickShortlist3().click();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Actions build = new Actions(driver);
//		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		build.moveToElement(cr.clickShortlisted1());
//		cr.clickShortlisted1().click();
//		//build.moveToElement(cr.clickShortlisted1()).click().build().perform();
//		cr.clickEvaluate1().click();  
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		//driver.findElement(By.xpath("//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[1]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]")).click();
//
//
//		 build.moveToElement(driver.findElement(By.xpath("//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[8]/child::div[1]/child::div[1]/child::div[1]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]"))).click().build().perform();
    String path1 ="//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[";
	String path2 = "]/child::div[1]/child::div[1]/child::div[";
	String path3 = "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]" ;
		for (int i = 1 ; i <=10 ; i++) 

		{ driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			for (int j =1 ; j<=2 ; j++)
			{
				
				try
				   {
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

					WebDriverWait wait=new WebDriverWait(driver, 30);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path1+i+path2+j+path3))); 
							
		                     build.moveToElement(driver.findElement(By.xpath(path1+i+path2+j+path3))).click().build().perform();
				   }
				catch(Exception e)
				  {
				    System.out.println(e);
				  }
				
				
				/*
				 * else {
				 * 
				 * System.out.
				 * println("//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div["
				 * +i+"]/child::div[1]/child::div[1]/child::div["+j+
				 * "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]"+
				 * "/n Not found i="+i+"  j="+j) ;
				 */

					
				}

			}

		}



	

	@AfterTest
	public void teardown()
	{
		//driver.close();

	}



}


