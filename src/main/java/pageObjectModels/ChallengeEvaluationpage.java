package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChallengeEvaluationpage {

	public WebDriver driver;

	By updateBtn = By.xpath("//button[text()=' Update Phase ']");

	By updatePhaseBtn = By.xpath("//button[text()=' Update Phase']");

	By announceAndclose = By.xpath("//button[text()=' Announce & Close']");
	By winnerAnnouncedText = By.xpath("//small[text()=' Winners Announced ']");

	public ChallengeEvaluationpage(WebDriver driver2)

	{

		this.driver = driver2;
	}

	public WebElement clickOnUpdate() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updateBtn));
		return driver.findElement(updateBtn);

	}

	public WebElement clickOnUpdatephase() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updatePhaseBtn));
		return driver.findElement(updatePhaseBtn);

	}

	public WebElement clickOnannounceClose() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(announceAndclose));
		return driver.findElement(announceAndclose);

	}

	public WebElement CheckWinnerAnnouncedText() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(winnerAnnouncedText));
		return driver.findElement(winnerAnnouncedText);

	}
}
