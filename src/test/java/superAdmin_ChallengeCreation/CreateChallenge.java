package superAdmin_ChallengeCreation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.AddnewchallengePage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.WinningPodiumPage;
import resources1.base;

public class CreateChallenge extends base {
	
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
		driver.get("https://qa.ideate.ooredoo.com/challenge/add-new");
	}
	
	@Test(priority=0)
	public void newChallenge() throws IOException
	{
		AddnewchallengePage add = new AddnewchallengePage(driver) ;
		 Actions build = new Actions(driver);
		 
		 build.moveToElement(add.insertChallengeName()).click().sendKeys(" challenge name Challenge name Challenge name ").build().perform();
		 build.moveToElement(add.insertChallengeDESC()).click().sendKeys("challenge name Challenge name Challenge name challenge name Challenge name Challenge name challenge name Challenge name Challenge name ").build().perform();
	     build.moveToElement(add.calenderIcon()).click().build().perform();
	     build.moveToElement(add.clickToday()).click().build().perform();

	     build.moveToElement(add.clickEntity()).click().build().perform();
	     build.moveToElement(add.clickAllEntities()).click().build().perform();

	     build.moveToElement(add.clickBusinessUnits()).click().build().perform();
	     build.moveToElement(add.clickAllBusinessUnits()).click().build().perform();
	     build.moveToElement(add.clickTMS()).click().build().perform();
	     build.moveToElement(add.clickBTC()).click().build().perform();
	     
	     build.moveToElement(add.clickSkills()).click().build().perform();
	     build.moveToElement(add.clickAnalyze()).click().build().perform();
	     build.moveToElement(add.clickSaveBtn()).click().build().perform();
	    //String url=  driver.getCurrentUrl();
	   // String url = "https://qa.ideate.ooredoo.com/challenges/challenge/192/idea-submission";
		//String[] urls = url.split("/");
		//System.out.println(urls[5]);

		 WebDriverWait wait=new WebDriverWait(driver, 40);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()=' Idea Submission in progress ']")));
	   // driver.findElement(By.xpath("//small[text()=' Idea Submission in progress ']")).isDisplayed();
		   url=  driver.getCurrentUrl();
		 
		}
@Test(priority=1)
public void employeeaddidea() throws IOException, InterruptedException, ClassNotFoundException, SQLException
{
	
       driver1=  initializeDriver() ; 
       LoginPage login = new LoginPage(driver1) ; 
		HomePageEmployee home = new HomePageEmployee(driver1);
		String usertype = "employee";
		String[] st = new String[2] ;  
		st= login(usertype);
		
		login.insertEmail().sendKeys(st[0]);
		login.insertpass().sendKeys(st[1]);
		login.loginbtn().click();
		Thread.sleep(2000);
		//String id =getActivechallenge();
		String url1= "https://qa.ideate.ooredoo.com/add-new?addTo=challenge";
	driver1.get(url1);
	
	


}
	@AfterTest
	public void teardown()
	{
		//driver.close();

	}



}


