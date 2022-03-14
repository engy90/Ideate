package Search;

import org.testng.annotations.Test;

import employeeTC.employeeAddIdeaTC02;
import pageObjectModels.AddIdeaPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.ProfilePage;
import pageObjectModels.SearchPage;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources1.base;

public class SearchForIdea extends base {
	public WebDriver driver;
	public String[] datearray2 = date ();
	public String url1 ;
	public String url2;
	String ideaNumber ;

	
	private static Logger log = LogManager.getLogger(SearchForIdea.class.getName());
	
	
	@BeforeTest
	public void tearup() throws IOException

	{
		driver = initializeDriver();
		LoginPage login = new LoginPage(driver) ; 
	
		String usertype = "employee";

		driver=login(usertype ,driver);
	}
	
	@Test(priority=0)
	public void createIdea() throws IOException {
		
		HomePageEmployee home = new HomePageEmployee(driver);
		 // String[] datearray2 = date ();
		home.clickAddIdea().click();
		AddIdeaPage addidea = new AddIdeaPage(driver) ;
		addidea.insertTitle().sendKeys("Automated Idea Creation "+datearray2[0]);

		addidea.inserIdeaSolution().sendKeys("this is idea solution automated script "+ datearray2[1] +  "  this is idea solution automated script " +  "  this is idea solution automated script ");

		addidea.inserIdeaProblem().sendKeys("this is idea solution automated script "+ "scripto"+datearray2[2] +  "  this is idea solution automated script " +  "  this is idea solution automated script ");
      addidea.insertHashtags().sendKeys("#"+datearray2[0]);
		addidea.insertIdeaUnique().sendKeys("Unique automated script for the idea Unique automated script for the idea  Unique automated script for the idea  Unique automated script for the idea  Unique automated script for the idea");
	new Actions(driver).moveToElement(addidea.clickAddNew()).perform();
	Actions build = new Actions(driver);  
		build.moveToElement(addidea.clickAddNew()).moveByOffset(124, 0).click().build().perform();
		addidea.clickAddNew();  
		addidea.clickOnArticle();
	addidea.insertRE().click();
	addidea.insertRE().sendKeys("Automated test");
	build.moveToElement(addidea.clickTMS()).moveByOffset(124, 0).click().build().perform();

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	build.moveToElement(addidea.clickSectorBtoC()).moveByOffset(124, 0).click().build().perform();

	
	build.moveToElement(addidea.clickMissingSkill()).click().build().perform();
	build.moveToElement(addidea.clickMissingSkill()).sendKeys(datearray2[0]+datearray2[1]+datearray2[2]).build().perform();
	driver.findElement(By.xpath("//*[text()='Add item']")).click();
//	build.moveToElement(addidea.clickMissingSkill()).sendKeys(Keys.ENTER).build().perform();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//build.moveToElement(addidea.selectSkillFromList()).moveByOffset(124, 0).click().build().perform();
	addidea.clickSubmitbtn();
	assertTrue(addidea.justNow().isDisplayed());
	 url1= driver.getCurrentUrl();
	System.out.println(url1);
	 driver=goProfileUrl(driver);
	ProfilePage ppage = new ProfilePage(driver);
	
	build.moveToElement(ppage.clickFirstIdea()).moveByOffset(124, 0).click().build().perform();
	 url2 = driver.getCurrentUrl();
	System.out.println(url2);
     assertTrue(url1.equals(url2));
     ideaNumber =  getIdeanumber(url1);
    System.out.println("Idea number is "+ideaNumber);
	
	}

	@Test(priority=1)
	public void searchForIdea() throws InterruptedException
	{
		driver.get("https://qa.ideate.ooredoo.com/dashboard");
	
		 Actions build =  new Actions(driver);
		SearchPage search =  new SearchPage(driver);
		build.moveToElement(search.clickonSearch());
		build.moveToElement(search.clickonSearch()).click().build().perform();
		build.moveToElement(search.sendTextSearch());
		build.moveToElement(search.sendTextSearch()).sendKeys(datearray2[0]).build().perform();
		build.moveToElement(search.clickEnter()).click().build().perform();
	
		if (driver.findElement(By.xpath("//*[contains(@href,'"+ideaNumber+"')]")).isDisplayed() )
			{
			System.out.println("card is displayed");
			}
			else 
			{
				System.out.println("card isnot displayed");
			}
		
		//build.doubleClick(search.clickonSearch()).build().perform();
		
	}
	
	@Test(priority=2)
	public void searchForPeople()
	{
		 Actions build =  new Actions(driver);
		 SearchPage search =  new SearchPage(driver);
		//build.moveToElement(search.clickonSearch()).click().build().perform();
		driver.findElement(By.xpath("//*[text()='people']")).click();
		
		build.doubleClick(search.sendTextSearch()).build().perform();
		
		build.moveToElement(search.sendTextSearch()).sendKeys("SunOct1720 59EET2021").build().perform();
		
		build.moveToElement(search.clickEnter()).click().build().perform();
		
		if (driver.findElement(By.xpath("//*[text()='SunOct1720 59EET2021']")).isDisplayed() )
		{
		System.out.println("user is displayed");
		}
		else 
		{
			System.out.println("user is not displayed");
		}}
	
		
		@Test(priority=3)
		public void searchForskills()
		{
			driver.get("https://qa.ideate.ooredoo.com/dashboard");
			 Actions build =  new Actions(driver);
			 SearchPage search =  new SearchPage(driver);
			 build.moveToElement(search.clickonSearch());
				build.moveToElement(search.clickonSearch()).click().build().perform();
				build.moveToElement(search.sendTextSearch());
				build.moveToElement(search.sendTextSearch()).sendKeys(datearray2[0]+datearray2[1]+datearray2[2]).build().perform();
				build.moveToElement(search.clickEnter()).click().build().perform();

			driver.findElement(By.xpath("//Li[text()='skills']")).click();
			
			
			
			if (driver.findElement(By.xpath("//*[contains(@href,'"+ideaNumber+"')]")).isDisplayed() )
			{
			System.out.println("Skill  is displayed");
			}
			else 
			{
				System.out.println("user is not displayed");
			}
		
	}
		
		@Test(priority=4)
		public void searchForBussUnit()
		{driver.get("https://qa.ideate.ooredoo.com/dashboard");
		 Actions build =  new Actions(driver);
		 SearchPage search =  new SearchPage(driver);
		 build.moveToElement(search.clickonSearch());
			build.moveToElement(search.clickonSearch()).click().build().perform();
			build.moveToElement(search.sendTextSearch());
			build.moveToElement(search.sendTextSearch()).sendKeys("Technology").build().perform();
			build.moveToElement(search.clickEnter()).click().build().perform();

			driver.findElement(By.xpath("//Li[text()='business units']")).click();
			
		String text = 	driver.findElement(By.xpath("//*[contains(text(),'Ideas')]//following-sibling::div[1]")).getText();
		String Count = 	getIdeasCount(text);
		System.out.println(Count);
		if(Count.equalsIgnoreCase("2"))
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[contains(@href,'840')]")).isDisplayed();
			System.out.println("first card is displayed Id 840");
			driver.findElement(By.xpath("//*[contains(@href,'758')]")).isDisplayed();
			System.out.println("second card is displayed Id 758");
			
		}
		else
		{
			System.out.println("No card  is displayed");
		}
		
	}
	
	@AfterTest
	public void teardown() {
		// driver.close();

	}
	
	
}
