package pageObjectModels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProfilePage {

	public WebDriver driver;

	By firstIdea = By.xpath(
			"//div[@class='d-flex flex-wrap justify-content-start profile-myIdea__list']/div[1]/ite-idea-card/div[1]");

	public ProfilePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public WebElement clickFirstIdea() {
		return driver.findElement(firstIdea);
	}

}
