package employeeTC;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModels.AddIdeaPage;
import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.ProfilePage;
import resources1.base;

public class Login extends base {

	public WebDriver driver;

	private static Logger log = LogManager.getLogger(Login.class.getName());

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
	public void employeeLogin() throws IOException {
		String usertype = "employee";

		driver = login(usertype, driver);

	}

	@AfterTest
	public void teardown() {
		// driver.close();

	}

}
