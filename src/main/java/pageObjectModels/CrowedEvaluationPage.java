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
public class CrowedEvaluationPage {

	
	public WebDriver driver ;
	
	By cardOptions1 = By.xpath("//div[text()=' 10 Most Liked Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[1]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[1]/i");
	By cardOptions2 = By.xpath("//div[text()=' 10 Least Liked Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[1]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[1]/i");
	By cardOptions3 = By.xpath("//div[text()=' All Other Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[1]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[1]/i");
	By shortlist1 =By.xpath("//div[text()=' 10 Most Liked Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[1]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[3]");
	By shortlist2 =By.xpath("//div[text()=' 10 Least Liked Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[1]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[3]");
	By shortlist3 =By.xpath("//div[text()=' All Other Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[1]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[3]");

	String shortlisted1 ="//div[text()=' Shortlisted Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[";
	
	String shortlisted2 ="]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[1]/i";
	String ideaNumber;
       String evaluate1="//div[text()=' Shortlisted Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[";
       String evaluate2="]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[4]";
       String commEvaluate ="]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[3]";
	//By evaluate1 = By.xpath("//div[text()=' Shortlisted Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[1]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[4]");
//	By evaluate2 = By.xpath("//div[text()=' Shortlisted Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[2]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[4]");
//	By evaluate3 = By.xpath("//div[text()=' Shortlisted Ideas ']/parent::div/child::div[2]/child::div[1]/child::div[3]/child::ite-idea-card/child::div[1]/child::div[2]/child::div[1]/child::div[2]/child::div[2]/child::button[4]");
    int x ; 
    int y ; 
    By parameters = By.xpath("//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div["+x+"]/child::div[1]/child::div[1]/child::div["+y+"]/child::div[2]/child::div[1]/child::ngb-rating/child::span[8]");
  //  By updateButton = By.xpath("//div[text()='Expert Review Evaluation']/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]/child::div[11]/button");
    By updateButton = By.xpath("//button[text()=' Update ']");
    
    By saveChangesBtn = By.xpath("//button[text()=' Save Changes ']");
	//getting till first parameter //div[text()="Expert Review Evaluation"]/parent::div/parent::div/parent::ite-modal/child::div[2]/child::ite-evaluation-rating/child::ite-rating-comments/child::div/child::div[2]/child::div[1]
	By updateBtn = By.xpath("//button[text()=' Update Phase ']");
	By updateBtnCommittee = By.xpath("//button[text()='Update phase']");
	
	By nextStage = By.xpath("//button[@type='submit']");
	public CrowedEvaluationPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2 ; 
	}
	
	public WebElement clickShortlisted(int z) 
	{
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
		        .pollingEvery(Duration.ofMillis(100))
		        .withTimeout(Duration.ofSeconds(30));
		        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shortlisted1+z+shortlisted2)));
		
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.elementToBeClickable((By.xpath(shortlisted1+z+shortlisted2))));
		 System.out.println(shortlisted1+z+shortlisted2);
		return driver.findElement(By.xpath(shortlisted1+z+shortlisted2));
		
	}
	
	public WebElement options1() 
	{
		
		 WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(cardOptions1));
		 		return driver.findElement(cardOptions1);
	}

	public WebElement options2() 
	{/*
		 * WebDriverWait wait=new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(shortlist2));
		 */
		return driver.findElement(cardOptions2);
	}

	public WebElement options3() 
	{
		
		  WebDriverWait wait=new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.elementToBeClickable(cardOptions3));
		 
		return driver.findElement(cardOptions3);
		
	}
	
	public WebElement clickShortlist1() 
	{/*
		 * WebDriverWait wait=new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(shortlist2));
		 */
		return driver.findElement(shortlist1);
		
	}
	
	public WebElement clickShortlist2() 
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(shortlist2));
		return driver.findElement(shortlist2);
	}
	
	public WebElement clickShortlist3() 
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(shortlist3));
		return driver.findElement(shortlist3);
	}
	
	
	public WebElement clickEvaluate1(int ideanum) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(evaluate1+ideanum+evaluate2)));

		return driver.findElement(By.xpath(evaluate1+ideanum+evaluate2));
		
	}
	
	public WebElement clickEvaluateCommittee(int ideanum) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(evaluate1+ideanum+commEvaluate)));

		return driver.findElement(By.xpath(evaluate1+ideanum+commEvaluate));
		
	}
	
	
	public WebElement clicksaveparam() 
	{WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updateButton));  
		return driver.findElement(updateButton);
		
	}

	public WebElement clickSave() 
	{WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtn));  
		return driver.findElement(saveChangesBtn);
		
	} 
	
	public WebElement clickUpdateCommittee() 
	{WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updateBtnCommittee));  
		return driver.findElement(updateBtnCommittee);
		
	}
	
	
	public WebElement clickUpdate() 
	{WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updateBtn));  
		return driver.findElement(updateBtn);
		
	}
	
	public WebElement moveToNextStage() 
	{WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(nextStage));  
		return driver.findElement(nextStage);
		
	}
}