package superAdmin_ChallengeCreation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import employeeTC.AddIdeaToChallenge;
import pageObjectModels.AddnewchallengePage;
import pageObjectModels.ChallengeEvaluationpage;
import pageObjectModels.ChallengesPage;
import pageObjectModels.CrowedEvaluationPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.WinningPodiumPage;
import resources1.base;
import superAdminTC.Login;

public class fortest extends base {
	

	public WebDriver driver ;
	public WebDriver driver1 ;
	public String url ; 
	private static Logger log = LogManager.getLogger(SAdminChallengeevaluation.class.getName()) ;

	@Test
	public void evaluation() throws IOException, InterruptedException
	{
	     
		 driver = initializeDriver() ; 
		
		driver.manage().window().maximize();
		
		LoginPage login = new LoginPage(driver) ; 
		HomePageEmployee home = new HomePageEmployee(driver);
		String usertype = "superadmin";

		driver=login(usertype ,driver);
		
		ChallengesPage chall = new ChallengesPage(driver) ;
		  Actions build = new Actions(driver);
		 // build.moveToElement(chall.clickOnChallenge());
		  driver.get("https://qa.ideate.ooredoo.com/challenges/challenge/238/selection-committee");

			String path1 = "//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[";
			String path2 = "]/child::div[1]/child::div[1]/child::div[";
			String path3 = "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]";
	/*	build.moveToElement(chall.clickOnChallenge()).click().build().perform();
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		build.moveToElement(chall.clickOnActiveChallenge()).click().build().perform();
		ChallengeEvaluationpage challenge = new ChallengeEvaluationpage(driver);
		Thread.sleep(2000);
		build.moveToElement(challenge.clickOnUpdate()).click().build().perform();
		build.moveToElement(challenge.clickOnUpdatephase()).click().build().perform();
		Thread.sleep(2000);
		build.moveToElement(challenge.clickOnUpdate()).click().build().perform();
		build.moveToElement(challenge.clickOnUpdatephase()).click().build().perform();
		CrowedEvaluationPage cr = new CrowedEvaluationPage(driver);
		

		String path1 = "//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[";
		String path2 = "]/child::div[1]/child::div[1]/child::div[";
		String path3 = "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]";

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		build.moveToElement(cr.options1()).click().build().perform();
		build.moveToElement(cr.clickShortlist1()).click().build().perform();

		
		
		driver.navigate().refresh();
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		build.moveToElement(cr.options1()).build().perform();
		build.moveToElement(cr.options1()).click().build().perform();
		build.moveToElement(cr.clickShortlist1()).click().build().perform();
		driver.navigate().refresh();
		
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(4000);
		build.moveToElement(cr.options1()).build().perform();
		build.moveToElement(cr.options1()).click().build().perform();
		build.moveToElement(cr.clickShortlist1()).click().build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
*/
//			build.sendKeys(Keys.PAGE_DOWN).build().perform();
//			build.sendKeys(Keys.PAGE_DOWN).build().perform();
//			ChallengeEvaluationpage challenge = new ChallengeEvaluationpage(driver);
//		  CrowedEvaluationPage cr = new CrowedEvaluationPage(driver);
//		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  for (int i=1; i<=3; i++)
//	  {	 
//			driver.navigate().refresh();
//			Thread.sleep(2000);
//			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
//		  build.moveToElement(cr.options1()).click().build().perform();
//			build.moveToElement(cr.clickShortlist1()).click().build().perform();
//			//driver.navigate().refresh();
//		
//		  }
//		
//		  
//	  driver.navigate().refresh();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		for (int q = 1; q <= 3; q++) 
//		{
//			Thread.sleep(2000);
//			build.moveToElement(cr.clickShortlisted(q)).click().build().perform();
//			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//
//			build.moveToElement(cr.clickEvaluate1(q)).click().build().perform();
//		
//
//			for (int i = 1; i <= 5; i++)
//
//			{
//				for (int j = 1; j < 2; j++) 	
//				{
//
//					try {
//
//						Thread.sleep(1000);
//						WebDriverWait wait = new WebDriverWait(driver, 20);
//						wait.until(
//								ExpectedConditions.visibilityOfElementLocated(By.xpath(path1 + i + path2 + j + path3)));
//
//						build.moveToElement(driver.findElement(By.xpath(path1 + i + path2 + j + path3))).click().build()
//								.perform();
//					}
//
//					catch (Exception e) {
//						System.out.println(e);
//					}
//
//		
//		}
//			}
//			Thread.sleep(1000);
//			build.moveToElement(cr.clicksaveparam()).click().build().perform();
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.navigate().refresh();
//
//		}
//		Thread.sleep(1000);
//		build.sendKeys(Keys.PAGE_UP).build().perform();
//		build.sendKeys(Keys.PAGE_UP).build().perform();
//		Thread.sleep(1000);
//		build.moveToElement(cr.clickUpdate()).click().build().perform();
//		 //cr.moveToNextStage().click();
//		build.moveToElement(cr.moveToNextStage()).click().build().perform();
//
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		
		
		//------Committee stage ----
			ChallengeEvaluationpage challenge = new ChallengeEvaluationpage(driver);
  CrowedEvaluationPage cr = new CrowedEvaluationPage(driver);
		Actions build2 = new Actions(driver);
        //driver.navigate().refresh();
		Thread.sleep(1000);
		 String path4 ="//div[@class=\"infinite-scroll-wrapper px-2 ng-tns-c162-0\"]/child::div[";
		 String path5 = "]/div/div/child::div["; 
		 String path6 ="]/div[2]/div/ngb-rating/span[4]";
		
		// driver.navigate().refresh();
		 build.sendKeys(Keys.PAGE_DOWN).build().perform();
		 for (int q =1;q<=3;q++)
		  {
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 driver.navigate().refresh();
			  build.moveToElement(cr.clickShortlisted(q)).click().build().perform();
			  build.moveToElement(cr.clickEvaluateCommittee(q)).click().build().perform();
			
		    
		   for (int i = 1 ; i <=6 ; i++)
		  
		  { 
			  //build.sendKeys(Keys.PAGE_DOWN).build().perform();
			   
		   for (int j =1 ; j<=4 ; j++) 
		   {
		  
		  try {
		  
			
		  WebDriverWait wait=new WebDriverWait(driver, 5);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path4+i+path5+j+path6)));
		  build.moveToElement(driver.findElement(By.xpath(path4+i+path5+j+path6)));
		  build.moveToElement(driver.findElement(By.xpath(path4+i+path5+j+path6))).click().build().perform();
		  ///build.sendKeys(Keys.PAGE_DOWN).build().perform();
		  
		  } 
		  catch(Exception e) 
		  {
			   System.out.println(e);
			  
		  
		  }
		  
		   }
		  
		

		  
		  }
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			  build.moveToElement(cr.clicksaveparam()).click().build().perform();
			//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.navigate().refresh();
			//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  }
		
		   //Thread.sleep(1000);
		  
		  
			build.sendKeys(Keys.PAGE_UP).build().perform();
			build.sendKeys(Keys.PAGE_UP).build().perform();

			build.moveToElement(challenge.clickOnUpdate());
			build.moveToElement(challenge.clickOnUpdate()).click().build().perform();
			build.moveToElement(challenge.clickOnUpdatephase()).click().build().perform();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  Thread.sleep(1000);
              //______Winning Podium__________________
		  
		  WinningPodiumPage cr1 = new WinningPodiumPage(driver) ;
			 //Actions build = new Actions(driver);
		
		  for (int q =1;q<=3;q++)
			 
		  
		  { driver.navigate().refresh(); 
				//build.sendKeys(Keys.PAGE_DOWN).build().perform();
				build.sendKeys(Keys.PAGE_DOWN).build().perform();
			  
			  Thread.sleep(1000);
		   
			  build.moveToElement(driver.findElement(By.xpath("//div[text()=' Top 10 Scored Idea ']")));
			  build.moveToElement(cr1.clickShortlisted(1));
			  build.moveToElement(cr1.clickShortlisted(1)).click().build().perform();
			 build.moveToElement(cr1.clickEvaluate1(1)).click().build().perform();
				driver.navigate().refresh(); 
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			
		  }
		  
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			build.moveToElement(challenge.clickOnUpdate());
			build.moveToElement(challenge.clickOnUpdate()).click().build().perform();
			build.moveToElement(challenge.clickOnannounceClose()).click().build().perform();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 AssertJUnit.assertTrue(challenge.CheckWinnerAnnouncedText().isDisplayed()) ;
		  System.out.println("Winners are announced successfully");
		  
		  
}
	

      
      
	@AfterTest
	public void teardown()
	{
		//driver.close();

	}


	

}
