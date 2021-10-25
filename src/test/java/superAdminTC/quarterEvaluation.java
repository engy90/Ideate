package superAdminTC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import superAdminTC.Login;

import org.apache.hc.core5.util.Timeout;
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
		 Actions build = new Actions(driver);
		 
		 String path1 ="//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[";
		 String path2 = "]/child::div[1]/child::div[1]/child::div["; 
		 String path3 ="]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]";
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			cr.options1().click();
			cr.clickShortlist1().click();
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			build.moveToElement(driver.findElement(By.xpath("//div[text()=' 10 Most Liked Ideas ']"))).build().perform();
			//driver.wait(Timeout.ofSeconds(5), 5);
			build.moveToElement(cr.options1()).click().build().perform();
			build.moveToElement(cr.clickShortlist1()).click().build().perform();
		/*//div[text()=" 10 Most Liked Ideas "]
		 * cr.options1().click(); cr.clickShortlist1().click();
		driver.switchTo().alert().accept();
		 * driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 * cr.clickShortlisted1().click(); cr.clickEvaluate1().click(); Actions build =
		 * new Actions(driver);
		 * 
		 * String path1
		 * ="//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div["
		 * ; String path2 = "]/child::div[1]/child::div[1]/child::div["; String path3 =
		 * "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]" ; for (int i
		 * = 1 ; i <=10 ; i++)
		 * 
		 * {
		 * 
		 * for (int j =1 ; j<=2 ; j++) {
		 * 
		 * try {
		 * 
		 * 
		 * WebDriverWait wait=new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path1+i+
		 * path2+j+path3)));
		 * 
		 * build.moveToElement(driver.findElement(By.xpath(path1+i+path2+j+path3))).
		 * click().build().perform(); } catch(Exception e) { System.out.println(e); }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * build.moveToElement(cr.clickupdate()).click().build().perform();
		 */
		 
		 //-----------------------------------------------------------------------------------
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		cr.options2().click();
//		cr.clickShortlist2().click();
//		driver.switchTo().alert().accept();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		cr.clickShortlisted1().click();
//		cr.clickEvaluate1().click();  
//		for (int i = 1 ; i <=10 ; i++) 
//
//		{ 
//
//			for (int j =1 ; j<=2 ; j++)
//			{
//				
//				try
//				   {
//					
//
//					WebDriverWait wait=new WebDriverWait(driver, 20);
//					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path1+i+path2+j+path3))); 
//							
//		                     build.moveToElement(driver.findElement(By.xpath(path1+i+path2+j+path3))).click().build().perform();
//				   }
//				catch(Exception e)
//				  {
//				    System.out.println(e);
//				  }
//					
//				}
//
//			}
//		build.moveToElement(cr.clickupdate()).click().build().perform();
//
//        
//		
		

		}

	@AfterTest
	public void teardown()
	{
		//driver.close();

	}



}


