package pageObjectModels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public   class AddIdeaPage  {
	
	public WebDriver driver ; 
	
	By ideaTitle = By.xpath("//textarea[@name='ideaTitleDiv']");
	By hashtags= By.xpath("//input[@id='hashtagsDiv']");
	By ideaProblem = By.xpath("//textarea[@id='idea_problem']");
	By ideaSolution = By.xpath("//textarea[@id='idea_solution']");
	By ideaUnique = By.xpath("//textarea[@id='idea_why_unique']");
    By dragFiles = By.xpath("//div[@class='ite-drop-zone']");
	By addMemberButton = By.xpath("//img[@alt='Add member']");
	By insertMember = By.xpath("//div[@class='ng-select-container ng-has-value']//div[@class='ng-input']");
	
	
	By saveButton =By.xpath("//button[@class='btn btn-submit m-auto btn-block btn-block-max-200 btn-primary']");
   
	By clickAddNewRE = By.xpath("/html/body/ite-root/ite-main/div/div/div/ite-idea-add-edit-page/form/div/div[2]/div[1]/div/div[2]/div");
	By clickArticle =By.xpath("//article[@class='relevant-experience']");
	By addRE = By.xpath("//input[@placeholder='Experience']");
	//By clickRE = By.xpath("/html/body/ite-root/ite-main/div/div/div/ite-idea-add-edit-page/form/div/div[2]/div[1]/div/div[2]/div");
	//By addRE = By.xpath("//input[@placeholder='Experience']") ;
	By targetMarketSector = By.xpath("//ng-select[@name='verticals']//div[@class='ng-select-container']//div[@class='ng-value-container']//div[@class='ng-input']//input[@role='combobox']");
	By businessToConsumer = By.xpath("//*[text()='Business to Consumer']");
	By missingSkills = By.xpath("/html/body/ite-root/ite-main/div/div/div/ite-idea-add-edit-page/form/div/div[2]/div[1]/div/div[4]/ng-select/div/div/div[1]");
	By selectSkill = By.xpath("//*[text()='BA']");
	By submitBtn = By.xpath("//button[@type='submit']");
	By justNow = By.xpath("/html/body/ite-root/ite-main/div/div/div/ite-idea-details/div/div[1]/div[1]/ite-idea-detail-card/div/div/div[1]");
	
	
	public AddIdeaPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2 ; 
	}
public WebElement insertTitle() 
{
	return driver.findElement(ideaTitle);
}

	public WebElement insertHashtags ()
	
	{
		return driver.findElement(hashtags);
		
	}
public WebElement inserIdeaSolution()
	
	{
		return driver.findElement(ideaSolution);
		
	}
public WebElement inserIdeaProblem()

{
	return driver.findElement(ideaProblem);
	
}
public WebElement  insertIdeaUnique()

{
	return driver.findElement(ideaUnique);
	
}
public WebElement clickDragFiles()

{
	return driver.findElement(dragFiles);
	
}

public WebElement  clickAddMember()

{
	return driver.findElement(addMemberButton);
	
}
public WebElement  insertMember()

{
	return driver.findElement(insertMember);
	
}
public WebElement  clickSaveButton()

{
	return driver.findElement(saveButton);
	
}
public WebElement  clickAddNew()
{
	return driver.findElement(clickAddNewRE);
	
}
public WebElement  clickOnArticle()
{
	return driver.findElement(clickArticle);
	
}
public WebElement  insertRE()
{
	return driver.findElement(addRE);
	
}
public WebElement  clickTMS()

{
	return driver.findElement(targetMarketSector);
	
}
public WebElement  clickSectorBtoC()

{
	return driver.findElement(businessToConsumer);
	
}
public WebElement  clickMissingSkill()

{
	return driver.findElement(missingSkills);
	
}
public WebElement  selectSkillFromList()

{
	return driver.findElement(selectSkill);
	
}
public WebDriver clickSubmitbtn()

{
	//System.out.println(driver.getCurrentUrl());
	
driver.findElement(submitBtn).click();

return driver ; 

	
}
public WebElement justNow()

{
	//System.out.println(driver.getCurrentUrl());
	
return driver.findElement(justNow);
 

	
}
}

