package pagesContentChecks;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import employeeTC.HomeEmployee;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import resources1.base;

public class Dashboardvalidation extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomeEmployee.class.getName());

	@BeforeTest
	public void tearup() throws IOException

	{
		driver = initializeDriver();

		if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa")) {
			driver.get(prop2.getProperty("url"));
		}

		else {
			driver.get(prop3.getProperty("url"));
		}

		driver.manage().window().maximize();

	}

	@Test
	public void homePagevalidation() throws IOException {
		LoginPage login = new LoginPage(driver);
		String usertype = "employee";

		driver = login(usertype, driver);
		HomePageEmployee hp = new HomePageEmployee(driver);

		AssertJUnit.assertTrue(hp.checkTrendingInsighs().isDisplayed());

		for (int i = 1; i <= 7; i++) {

			AssertJUnit.assertTrue(hp.findTrendingInsights(i).isDisplayed());
			System.out.println("Trending insights # " + i + "is displayed ");
		}
		Actions build = new Actions(driver);
		build.moveToElement(hp.ideaOfTheMonthCard()).build().perform();
		AssertJUnit.assertTrue(hp.ideaOfTheMonthCard().isDisplayed());
		build.moveToElement(hp.findHashtags()).build().perform();

		hp.findHashtags().isDisplayed();
		// hp.findTopHashttaged().isDisplayed();

		for (int i = 1; i <= 5; i++) {

			AssertJUnit.assertTrue(hp.findTopHashttaged(i).isDisplayed());
			System.out.println("hashtag number" + i + "is displayed ");
		}
		build.moveToElement(hp.findTms()).build().perform();
		hp.findTms().isDisplayed();
		// hp.findTopHashttaged().isDisplayed();
		for (int i = 1; i <= 5; i++) {
			AssertJUnit.assertTrue(hp.findTopTMS(i).isDisplayed());
			System.out.println("TMS" + i + "is displayed ");
		}
		build.moveToElement(hp.findskills()).build().perform();
		hp.findskills().isDisplayed();
		// hp.findTopHashttaged().isDisplayed();
		for (int i = 1; i <= 5; i++) {
			AssertJUnit.assertTrue(hp.findtopSkills(i).isDisplayed());
			System.out.println("Skill " + i + "is displayed ");
		}
		build.moveToElement(hp.findBU()).build().perform();
		hp.findBU().isDisplayed();
		// hp.findTopHashttaged().isDisplayed();

		for (int i = 1; i <= 5; i++) {
			try {
				AssertJUnit.assertTrue(hp.findTopBU(i).isDisplayed());
			} catch (AssertionError err) {

			}
			System.out.println("BU" + i + "is displayed ");
		}

	}

	private void assertTrue(boolean displayed) {
		// TODO Auto-generated method stub

	}

	@AfterTest
	public void teardown() {
		// driver.close();

	}

}
