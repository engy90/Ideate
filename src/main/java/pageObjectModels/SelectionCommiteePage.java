package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SelectionCommiteePage {

	public WebDriver driver;

	String shortlisted1 = "//div[text()=' Shortlisted Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[";

	String shortlisted2 = "]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[1]/i";
	String ideaNumber;
	String evaluate1 = "//div[text()=' Shortlisted Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[";
	String evaluate2 = "]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[4]";
	int x;
	int y;
	By parameters = By.xpath(
			"//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div["
					+ x + "]/child::div[1]/child::div[1]/child::div[" + y
					+ "]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]");
	By updateButton = By.xpath("//button[text()=' Update ']");
	By saveChangesBtn = By.xpath("//button[text()=' Save Changes ']");
	By updateBtn = By.xpath("//button[text()=' Update Phase ']");
	By nextStage = By.xpath("//button[@type='submit']");

	public SelectionCommiteePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public WebElement clickShortlisted(int z) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shortlisted1 + z + shortlisted2)));
		System.out.println(shortlisted1 + z + shortlisted2);
		return driver.findElement(By.xpath(shortlisted1 + z + shortlisted2));

	}

	public WebElement clickEvaluate1(int ideanum) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(evaluate1 + ideanum + evaluate2)));

		return driver.findElement(By.xpath(evaluate1 + ideanum + evaluate2));

	}

	public WebElement clickupdate() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updateButton));
		return driver.findElement(updateButton);

	}

	public WebElement clickSave() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtn));
		return driver.findElement(saveChangesBtn);

	}

	public WebElement clickUpdate() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
		return driver.findElement(updateBtn);

	}

	public WebElement moveToNextStage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(nextStage));
		return driver.findElement(nextStage);

	}
}