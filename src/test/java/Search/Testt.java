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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources1.base;

public class Testt extends base {
	public WebDriver driver;
	public String[] datearray2 = date();
	private static Logger log = LogManager.getLogger(Testt.class.getName());

	@BeforeTest
	public void tearup() throws IOException

	{
		driver = initializeDriver();
		String usertype = "employee";

		driver = login(usertype, driver);
	}

	@Test(priority = 1)
	public void searchForIdea() {
		driver.get("https://qa.ideate.ooredoo.com/dashboard");
		Actions build = new Actions(driver);
		SearchPage search = new SearchPage(driver);
		// search.clickonSearch().click();
		build.moveToElement(search.clickonSearch()).click().build().perform();
		build.moveToElement(search.sendTextSearch()).sendKeys(datearray2[0]).build().perform();
		// search.sendTextSearcsearch.sendTextSearch()h().sendKeys(datearray2[0]);
		build.moveToElement(search.clickEnter()).click().build().perform();
		// search.clickonSearch().click();
		build.moveToElement(search.clickonFirstIdea()).moveByOffset(20, 20).click().build().perform();
		String idea2 = driver.getCurrentUrl();
		// assertTrue(idea1.equals(idea2));
	}

	@AfterTest
	public void teardown() {
		// driver.close();

	}

}
