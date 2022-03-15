package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources1.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddnewchallengePage extends base {

	public WebDriver driver;

	By challengeName = By.xpath("//input[@placeholder='Challenge name']");
	By challengedesc = By.xpath("//div[@lang='en']/parent::div");
	By calenderIcon = By.xpath("//i[@class='icon-calendar']");
	String todayDay1 = "//div[@class='ngb-dp-day ngb-dp-today']/div[text()='";

	String todayDate2 = "']";
	By entity = By.xpath("//div[@class='ooredoo-entities mt-3']/ng-select");
	By allEntities = By.xpath("//*[text()='All Ooredoo Entities']");
	By businessUnits = By.xpath("//div[@class='business-units mt-3']/ng-select");
	By allBusiness = By.xpath("//span[text()='All Business Units']");
	By TMS = By.xpath("//div[@class='market-sectors mt-3']/ng-select");
	By tmsBsstocons = By.xpath("//span[text()='Business to Consumer']");
	By skills = By.xpath("//div[@class='skills-required mt-3']/ng-select");
	By skillAnalyze = By.xpath("//span[text()='Analyze']");
	By saveButton = By.xpath("//button[text()=' Submit Challenge ']");

	public AddnewchallengePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public WebElement insertChallengeName() {
		return driver.findElement(challengeName);
	}

	public WebElement insertChallengeDESC() {
		return driver.findElement(challengedesc);
	}

	public WebElement calenderIcon() {
		return driver.findElement(calenderIcon);
	}

	public WebElement clickToday() {
		int day = currentDate1();

		return driver.findElement(By.xpath(todayDay1 + day + todayDate2));
	}

	public WebElement clickEntity() {
		return driver.findElement(entity);
	}

	public WebElement clickAllEntities() {
		return driver.findElement(allEntities);
	}

	public WebElement clickBusinessUnits() {
		return driver.findElement(businessUnits);
	}

	public WebElement clickAllBusinessUnits() {
		return driver.findElement(allBusiness);
	}

	public WebElement clickTMS() {
		return driver.findElement(TMS);
	}

	public WebElement clickBTC() {
		return driver.findElement(tmsBsstocons);
	}

	public WebElement clickSkills() {
		return driver.findElement(skills);
	}

	public WebElement clickAnalyze() {
		return driver.findElement(skillAnalyze);
	}

	public WebElement clickSaveBtn() {
		return driver.findElement(saveButton);
	}
}