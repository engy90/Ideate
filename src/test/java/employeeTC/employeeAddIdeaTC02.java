package employeeTC;

import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageObjectModels.AddIdeaPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.ProfilePage;
import resources1.base;

public class employeeAddIdeaTC02 extends base {
	public WebDriver driver;
	public String[] datearray2 = date();
	public String url1;
	public String url2;
	String ideaNumber;
	private static Logger log = LogManager.getLogger(employeeAddIdeaTC02.class.getName());

	@BeforeTest
	public void tearup() throws IOException

	{
		driver = initializeDriver();

	}

	@Test
	public void addIdea() throws IOException

	{
		LoginPage login = new LoginPage(driver);
	
		String usertype = "employee";

		driver = login(usertype, driver);
		HomePageEmployee home = new HomePageEmployee(driver);
		// String[] datearray2 = date ();
		home.clickAddIdea().click();
		AddIdeaPage addidea = new AddIdeaPage(driver);
		addidea.insertTitle().sendKeys("Automated Idea Creation " + datearray2[0]);

		addidea.inserIdeaSolution().sendKeys("this is idea solution automated script " + datearray2[1]
				+ "  this is idea solution automated script " + "  this is idea solution automated script ");

		addidea.inserIdeaProblem().sendKeys("this is idea solution automated script " + "scripto" + datearray2[2]
				+ "  this is idea solution automated script " + "  this is idea solution automated script ");
		addidea.insertHashtags().sendKeys("#" + datearray2[0]);
		addidea.insertIdeaUnique().sendKeys(
				"Unique automated script for the idea Unique automated script for the idea  Unique automated script for the idea  Unique automated script for the idea  Unique automated script for the idea");
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
		build.moveToElement(addidea.clickMissingSkill()).sendKeys(datearray2[0] + datearray2[1] + datearray2[2]).build()
				.perform();
		driver.findElement(By.xpath("//*[text()='Add item']")).click();

		addidea.clickSubmitbtn();
		assertTrue(addidea.justNow().isDisplayed());
		url1 = driver.getCurrentUrl();
		System.out.println(url1);
		driver = goProfileUrl(driver);
		ProfilePage ppage = new ProfilePage(driver);

		build.moveToElement(ppage.clickFirstIdea()).moveByOffset(124, 0).click().build().perform();
		url2 = driver.getCurrentUrl();
		System.out.println(url2);
		assertTrue(url1.equals(url2));
		ideaNumber = getIdeanumber(url1);
		System.out.println("Idea number is " + ideaNumber);

	}

	@AfterTest
	public void teardown() {
		// driver.close();

	}

}
