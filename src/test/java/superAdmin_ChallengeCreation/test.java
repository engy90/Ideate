package superAdmin_ChallengeCreation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.ChallengeEvaluationpage;
import pageObjectModels.ChallengesPage;
import pageObjectModels.CrowedEvaluationPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.WinningPodiumPage;
import resources1.base;

public class test extends base {
	

	public WebDriver driver ;
	public WebDriver driver1 ;
	public String url ; 

	@BeforeTest
	public void tearup() throws IOException, InterruptedException
	{  
	     
		 driver = initializeDriver() ; 
		
		driver.manage().window().maximize();
		
		LoginPage login = new LoginPage(driver) ; 
		HomePageEmployee home = new HomePageEmployee(driver);
		String usertype = "superadmin";
		String[] st = new String[2] ;  
		st= login(usertype);
		
		login.insertEmail().sendKeys(st[0]);
		login.insertpass().sendKeys(st[1]);
		login.loginbtn().click();
		Thread.sleep(2000);
		
		ChallengesPage chall = new ChallengesPage(driver) ;
		  Actions build = new Actions(driver);
		build.moveToElement(chall.clickOnChallenge()).click().build().perform();
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		build.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		build.moveToElement(chall.clickOnActiveChallenge()).click().build().perform();
		
	
	}
	@Test(priority=0)
	public void addnewChallenge() throws IOException, InterruptedException
	{Actions build = new Actions(driver);
		ChallengeEvaluationpage challenge = new ChallengeEvaluationpage(driver);


			build.moveToElement(challenge.clickOnUpdate());
			build.moveToElement(challenge.clickOnUpdate()).click().build().perform();
			build.moveToElement(challenge.clickOnUpdatephase()).click().build().perform();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  Thread.sleep(1000);
               //______Winning Podium__________________
		  
		  WinningPodiumPage cr1 = new WinningPodiumPage(driver) ;
			 //Actions build = new Actions(driver);
		
		  for (int q =1;q<=3;q++)
			  
		  
		  {
				build.sendKeys(Keys.PAGE_DOWN).build().perform();
				build.sendKeys(Keys.PAGE_DOWN).build().perform();
			  
			  Thread.sleep(1000);
		   
			  build.moveToElement(driver.findElement(By.xpath("//div[text()=' Top 10 Scored Idea ']")));
			  build.moveToElement(cr1.clickShortlisted(1));
			  build.moveToElement(cr1.clickShortlisted(1)).click().build().perform();
			 build.moveToElement(cr1.clickEvaluate1(1)).click().build().perform();
				driver.navigate().refresh(); 
				

			
		  }
		  
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			build.moveToElement(challenge.clickOnUpdate());
			build.moveToElement(challenge.clickOnUpdate()).click().build().perform();
			build.moveToElement(challenge.clickOnannounceClose()).click().build().perform();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

      
      
	@AfterTest
	public void teardown()
	{
		//driver.close();

	}


	

}



