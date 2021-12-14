package superAdmin_ChallengeCreation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import employeeTC.AddIdeaToChallenge;
import pageObjectModels.AddnewchallengePage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.WinningPodiumPage;
import resources1.base;
import superAdminTC.Login;

public class CreateChallenge extends base {
	
	public WebDriver driver ;
	public WebDriver driver1 ;
	public String url ; 
	private static Logger log = LogManager.getLogger(CreateChallenge.class.getName()) ;

	@BeforeTest
	public void tearup() throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{  
	     
		 driver = initializeDriver() ; 
		
		driver.manage().window().maximize();
		
		try {
		String id = getActivechallenge();
		CloseActiveChlng(id);}
		
		catch (Exception e) {
			System.out.println("No opened challenges");
		}
		LoginPage login = new LoginPage(driver) ; 
		HomePageEmployee home = new HomePageEmployee(driver);
		String usertype = "superadmin";

		driver=login(usertype ,driver);
		driver.get("https://qa.ideate.ooredoo.com/challenge/add-new");
	}
	
	@Test(priority=0)
	public void addnewChallenge() throws IOException
	{
		AddnewchallengePage add = new AddnewchallengePage(driver) ;
		 Actions build = new Actions(driver);
		 
		 build.moveToElement(add.insertChallengeName()).click().sendKeys(" Automated script for challenge name , this is only for automation testing ").build().perform();
		 build.moveToElement(add.insertChallengeDESC()).click().sendKeys("Automated script for challenge name , this is only for automation testing  name challenge name Challenge name Challenge name ").build().perform();
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
	  

		 WebDriverWait wait=new WebDriverWait(driver, 40);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()=' Idea Submission in progress ']")));
	   // driver.findElement(By.xpath("//small[text()=' Idea Submission in progress ']")).isDisplayed();
		   url=  driver.getCurrentUrl();
		 
		}
      @Test(dependsOnMethods = { "addnewChallenge" })
       public void employeeaddidea() throws IOException, InterruptedException, ClassNotFoundException, SQLException
    {
	
	
	AddIdeaToChallenge test = new AddIdeaToChallenge();
	test.addIdea();
      

}
      @Test(dependsOnMethods = { "employeeaddidea" })
      public void sAdminevaluatesIdea () throws IOException, InterruptedException 
      {
    	  SAdminChallengeevaluation test = new SAdminChallengeevaluation();
    	  test.evaluation();
    	  
      }
      
	@AfterTest
	public void teardown()
	{
		//driver.close();

	}



}


