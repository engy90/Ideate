package employeeTC;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModels.AddIdeaPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.ProfilePage;
import resources1.base;
import superAdminTC.Login;

public class employeeAddIdeaTC02 extends base {

	
	
	
     public WebDriver driver ;
	
	private static Logger log = LogManager.getLogger(employeeAddIdeaTC02.class.getName()) ;

	@BeforeTest
	public void tearup() throws IOException
	
	{
		 driver = initializeDriver() ; 
			
		 if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa") )
		 { driver.get(prop2.getProperty("url"));}
		 
		 else {
			 driver.get(prop3.getProperty("url"));
		 }
		
		 driver.manage().window().maximize();
	}
	
	
	@Test
	public   String[] addIdea() throws IOException
	{
		LoginPage login = new LoginPage(driver) ; 
		HomePageEmployee home = new HomePageEmployee(driver);
		String usertype = "employee";

		driver=login(usertype ,driver);
		String[] datearray2 = date ();
		home.clickAddIdea().click();
		AddIdeaPage addidea = new AddIdeaPage(driver) ;
		addidea.insertTitle().sendKeys("Automated Idea Creation "+datearray2[0]);

		addidea.inserIdeaSolution().sendKeys("this is idea solution automated script "+ datearray2[1] +  "  this is idea solution automated script " +  "  this is idea solution automated script ");

		addidea.inserIdeaProblem().sendKeys("this is idea solution automated script "+ "scripto"+datearray2[2] +  "  this is idea solution automated script " +  "  this is idea solution automated script ");


		addidea.insertHashtags().sendKeys("#one #two #three");
		addidea.insertIdeaUnique().sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
		
		
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

	build.moveToElement(addidea.clickMissingSkill()).moveByOffset(124, 0).click().build().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	build.moveToElement(addidea.selectSkillFromList()).moveByOffset(124, 0).click().build().perform();
	
	
	 addidea.clickSubmitbtn();
	 AssertJUnit.assertTrue(addidea.justNow().isDisplayed());
		
	String idea1= driver.getCurrentUrl();
	System.out.println(idea1);
	 driver=goProfileUrl(driver);
	ProfilePage ppage = new ProfilePage(driver);
	// driver.get(prop.getProperty("profile"));
	
	
	
	build.moveToElement(ppage.clickFirstIdea()).moveByOffset(124, 0).click().build().perform();
	String idea2 = driver.getCurrentUrl();
	System.out.println(idea2);
	AssertJUnit.assertTrue(idea1.equals(idea2));
	
	return datearray2;
	
	}
	
	@AfterTest
	public void teardown()
	{
		//driver.close();
		
	}
	

	
}
