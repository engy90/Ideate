package pageObjectModels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TempEmailPage {

	public WebDriver driver;

	By email = By.xpath("//input[@id='mail']");

	public TempEmailPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public WebElement findEmail() {
		return driver.findElement(email);
	}

}
