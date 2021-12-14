package superAdmin_ChallengeCreation;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
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
	public void tearup() throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{  
		
		 driver = initializeDriver() ; 
		
		driver.manage().window().maximize();
	
		
		LoginPage login = new LoginPage(driver) ; 
		HomePageEmployee home = new HomePageEmployee(driver);
		String usertype = "superadmin";

		driver=login(usertype ,driver);
		Thread.sleep(2000);
		
		driver.get("https://qa.ideate.ooredoo.com/challenges/challenge/226/expert-review");
		
	
	}
	@Test(priority=0)
	public void addnewChallenge() throws IOException, InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		Actions build = new Actions(driver);
	CrowedEvaluationPage cr = new CrowedEvaluationPage(driver);
	

	String path1 = "//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[";
	String path2 = "]/child::div[1]/child::div[1]/child::div[";
	String path3 = "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]";
	//wait.until(ExpectedConditions.visibilityOfElementLocated(cr.options1()));
	
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	build.moveToElement(cr.options1()).build().perform();
	build.moveToElement(cr.options1()).click().build().perform();
	build.moveToElement(cr.clickShortlist1()).build().perform();
	build.moveToElement(cr.clickShortlist1()).click().build().perform();

	
	
	//driver.navigate().refresh();
	//build.sendKeys(Keys.PAGE_DOWN).build().perform();
	//build.sendKeys(Keys.PAGE_DOWN).build().perform();
	//Thread.sleep(3000);
	build.moveToElement(cr.options1()).build().perform();
	build.moveToElement(cr.options1()).click().build().perform();
	build.moveToElement(cr.clickShortlist1()).build().perform();
	build.moveToElement(cr.clickShortlist1()).click().build().perform();
	//driver.navigate().refresh();
	
	build.sendKeys(Keys.PAGE_DOWN).build().perform();
	build.sendKeys(Keys.PAGE_DOWN).build().perform();
	//Thread.sleep(4000);
	build.moveToElement(cr.options1()).build().perform();
	build.moveToElement(cr.options1()).click().build().perform();
	build.moveToElement(cr.clickShortlist1()).build().perform();
	build.moveToElement(cr.clickShortlist1()).click().build().perform();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.navigate().refresh();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

      
      
	@AfterTest
	public void teardown()
	{
		//driver.close();

	}


	

}



