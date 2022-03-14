package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public WebDriver driver;
	By searchBtn = By.xpath("/html/body/ite-root/ite-main/div/ite-header/header/div/div[3]/div[1]/img");
    By searchText = By.xpath("//input[@name=\"keyword\"]");
    By searchClick =By.xpath("//div[@class=\"action\"]/child::img");
    By firstIdea =By.xpath("//div[@class='row d-flex flex-wrap justify-content-start mr-lg-2 ng-star-inserted']/div[1]/ite-idea-card/div[1]/child::div[2]/child::a");
    
    public SearchPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2 ; 
	}
	
    
    public WebElement clickonSearch()
    
    {
		return driver.findElement(searchBtn);
    	
    	
    }
    
    public WebElement sendTextSearch()
    {
		return driver.findElement(searchText);
    	
    	
    }
    public WebElement clickEnter()
    {
		return driver.findElement(searchClick);
    	
    	
    }
    public WebElement clickonFirstIdea()
    
    {
		return driver.findElement(firstIdea);
    	
    	
    }
}
