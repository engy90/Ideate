package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class AddnewchallengePage {

	
	public WebDriver driver ;
	
	By challengeName = By.xpath("//input[@placeholder='Challenge name']");
	By challengedesc = By.xpath("//div[@lang='en']/parent::div");
	By calenderIcon= By.xpath("//i[@class='icon-calendar']");
	By todayDay = By.xpath("//div[@class='ngb-dp-day ngb-dp-today']/div[text()='28']");
   
	public AddnewchallengePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2 ; 
	}
	
	


	
}