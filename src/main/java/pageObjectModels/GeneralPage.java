package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralPage {
	
	public WebDriver driver ; 
	By generalTab = By.xpath("//nav[@class='ite-navigation show-sep']//child::span[text()='General Ideas']");
	By gTopInnovators = By.xpath("//h4[text()='Top General Innovators']");
	By topInnovatorsList1 = By.xpath("//div[@class=\"top-innovators__list\"]/child::div[");
	By topInnoatorList2=By.xpath("]//div[@class=\"user-avatar short user-avatar--md\"]");
	By generalIdeas = By.xpath("//div[@class=\"page-header\"]/child::h4[text()='General Ideas']");
    By ideaOfTheMonth = By.xpath("//ite-idea-results-card[@type=\"winnerIdeaOfX\"]");
    By quarterlyView = By.xpath("//div[@class=\"look-view-card pointer\"]");
    
    
    
    public GeneralPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver  = driver2 ;
	}
    
    
    public WebElement chechGeneralIdeaTab() {
    	
    	        
    return	driver.findElement(generalTab);
    
    }
    
 public WebElement checkGTopInnovators() {
    	
	 return driver.findElement(gTopInnovators);
    	
    }
 
 public WebElement checkTInnovatorsList(int  i ) {
 	By topInnovatorList = By.xpath("//div[@class=\"top-innovators__list\"]/child::div["+i+"]//div[@class=\"user-avatar short user-avatar--md\"]");
 	 return  driver.findElement(topInnovatorList);
 	
 }
 public WebElement checkGenelIdeas() {
 	
 	 return driver.findElement(generalIdeas);
 	 
 }
 public WebElement  checkIdeaOfTheMonth() {
	 	
	 return driver.findElement(ideaOfTheMonth);
	 	
	 }
 public WebElement CheckQurterlyView() {
	 	
	 return 	driver.findElement(quarterlyView);
	 	
	 }
}
