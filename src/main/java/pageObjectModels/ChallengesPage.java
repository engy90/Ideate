package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengesPage {
	
	public WebDriver driver ;
	
	By challengeTab = By.xpath("//span[text()='Challenges']");
	
	By challengeActive = By.xpath("//ite-challenge-card");
	By addNewIdea = By.xpath("//div[@routerlink='/add-new']");
	
	public ChallengesPage(WebDriver driver2)

	{
		
		this.driver= driver2 ;
	}
	
	public WebElement clickOnChallenge ()
	{
		
		return	driver.findElement(challengeTab);
		
	}
	
	public WebElement clickOnActiveChallenge()
	{
		return	driver.findElement(challengeActive);
		
	}
	
	public WebElement clickOnAddIdea()
	{
		return	driver.findElement(addNewIdea);
		
	}
}
