package employeeTC;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjectModels.AddIdeaPage;
import pageObjectModels.ChallengesPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import resources1.base;

public class AddIdeaToChallenge extends base

{
	public WebDriver driver;
	
	
	@Test
	public  void addIdea () throws IOException, InterruptedException
	{
		
		driver = initializeDriver();
		LoginPage login = new LoginPage(driver) ;
		ChallengesPage chall = new ChallengesPage(driver) ;
		HomePageEmployee home = new HomePageEmployee(driver);
		String usertype = "employee";
		String[] st = new String[2] ;  
		st= login(usertype);
		
		login.insertEmail().sendKeys(st[0]);
		login.insertpass().sendKeys(st[1]);
		login.loginbtn().click();
		  driver.manage().window().maximize();
		Thread.sleep(2000);
		  
		Actions build = new Actions(driver);
		//ChallengesPage chall = new ChallengesPage(driver) ;
		build.moveToElement(chall.clickOnChallenge()).click().build().perform();
		build.moveToElement(chall.clickOnActiveChallenge()).click().build().perform();
		build.moveToElement(chall.clickOnAddIdea()).click().build().perform();
      
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AddIdeaPage addidea = new AddIdeaPage(driver) ;
		addidea.insertTitle().sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

		addidea.inserIdeaSolution().sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

		addidea.inserIdeaProblem().sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");


		addidea.insertHashtags().sendKeys("#one #two #three");
		addidea.insertIdeaUnique().sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
		
		
		new Actions(driver).moveToElement(addidea.clickAddNew()).perform();
		
		//Actions build = new Actions(driver);
		build.moveToElement(addidea.clickAddNew()).moveByOffset(124, 0).click().build().perform();
		addidea.clickAddNew();
		addidea.clickOnArticle();
		
		//new Actions(driver).moveToElement(addidea.clickRE()).perform();
		addidea.insertRE().click();
	addidea.insertRE().sendKeys("Automated test");
	build.moveToElement(addidea.clickTMS()).moveByOffset(124, 0).click().build().perform();
//	addidea.clickTMS();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	build.moveToElement(addidea.clickSectorBtoC()).moveByOffset(124, 0).click().build().perform();
	//addidea.clickSectorBtoC();
	
	build.moveToElement(addidea.clickMissingSkill()).moveByOffset(124, 0).click().build().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//addidea.clickMissingSkill();
	build.moveToElement(addidea.selectSkillFromList()).moveByOffset(124, 0).click().build().perform();
	//addidea.selectSkillFromList();
	
	 addidea.clickSubmitbtn();
	AssertJUnit.assertTrue(addidea.justNow().isDisplayed());	
	String idea1= driver.getCurrentUrl(); 
	
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
