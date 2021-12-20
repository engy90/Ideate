 package superAdminTC;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.CrowedEvaluationPage;
import pageObjectModels.LoginPage;
import resources1.base;

public class ExpertReviewStage extends base {
	
	private static Logger log = LogManager.getLogger(ExpertReviewStage.class.getName()) ;
	@BeforeTest
	public void tearup() throws IOException, ClassNotFoundException, SQLException

	{

		driver = initializeDriver();
		if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa")) {
			driver.get(prop2.getProperty("url"));

		}

		else {
			driver.get(prop3.getProperty("url"));
		}

		String usertype = "superadmin";

		driver=login(usertype ,driver);
		String id = resetQuarter();
		String url = prop2.getProperty("evaluationurl") + id + "/expert-review";
		driver.manage().window().maximize();
		driver.get(url);

	}
	
	@Test
	public void expertReview() throws IOException, InterruptedException {
		CrowedEvaluationPage cr = new CrowedEvaluationPage(driver);
		Actions build = new Actions(driver);

		String path1 = "//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[";
		String path2 = "]/child::div[1]/child::div[1]/child::div[";
		String path3 = "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]";

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		build.moveToElement(cr.options1()).click().build().perform();
		build.moveToElement(cr.clickShortlist1()).click().build().perform();

		
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		Thread.sleep(2000);
		build.moveToElement(cr.options1());
		build.moveToElement(cr.options1()).click().build().perform();
		build.moveToElement(cr.clickShortlist1()).click().build().perform();
		driver.navigate().refresh();
		Thread.sleep(2000);
		build.moveToElement(cr.options1());
		build.moveToElement(cr.options1()).click().build().perform();
		build.moveToElement(cr.clickShortlist1()).click().build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		for (int q = 1; q <= 3; q++) {
			Thread.sleep(2000);
			build.moveToElement(cr.clickShortlisted(q)).click().build().perform();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			build.moveToElement(cr.clickEvaluate1(q)).click().build().perform();

			for (int i = 1; i <= 5; i++)

			{
				for (int j = 1; j < 2; j++) {

					try {

						Thread.sleep(1000);
						WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath(path1 + i + path2 + j + path3)));

						build.moveToElement(driver.findElement(By.xpath(path1 + i + path2 + j + path3))).click().build()
								.perform();
					}

					catch (Exception e) {
						System.out.println(e);
					}

				}

			}

			Thread.sleep(1000);
			build.moveToElement(cr.clicksaveparam()).click().build().perform();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.navigate().refresh();

		}
		Thread.sleep(1000);
		build.sendKeys(Keys.PAGE_UP).build().perform();
		build.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(1000);
		build.moveToElement(cr.clickUpdate()).click().build().perform();
		
		build.moveToElement(cr.moveToNextStage()).click().build().perform();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}
}
