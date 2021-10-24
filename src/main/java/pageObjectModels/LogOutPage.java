package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {
	
	
	public WebDriver driver ;
	
	
	
	By profileIcon = By.xpath("//div[@id='profile-links']");
	
	By logout = By.xpath("//button[@class='dropdown-item']") ;
	
	

	public LogOutPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver  = driver2 ;
	}


	public WebElement profile()
	{
		
		return  driver.findElement(profileIcon);
	}
	
	
	public WebElement clickLogout()
	{
		
		return  driver.findElement(logout);
	}
	
	
}
