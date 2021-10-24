package pageObjectModels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public   class RegistrationPage  {
	
	public WebDriver driver ; 
	
	By fistNameField = By.xpath("//input[@id='firstName']");
	By lastNameField = By.xpath("//input[@id='lastName']");
	By mobileNumber = By.xpath("//input[@id='mobileNumber']");
	By selectEntity = By.xpath("//div[@class='entity-input']/ng-select");
	By entityQatar = By.xpath("//*[text()='Qatar']");
	By selectBU = By.xpath("//div[@class='bu-input']/ng-select");
	By buCorporate = By.xpath("//*[text()='Corporate Services ~ QA']");
	By selectDivision = By.xpath("//div[@class='dep-input']");
	By divisionCEOOffice = By.xpath("//*[text()='CEO Office']");
	By selectAge = By.xpath("//div[@class='age-input']");
	By age20to30 = By.xpath("//*[text()='20 ~ 30']");
	By selectGender = By.xpath("//div[@class='gender-input']");
	By genderMale = By.xpath("//*[text()='Male']");
	By btnProceed = By.xpath("//*[contains(text(),'Proceed')]");
	By userNameField = By.xpath("//input[@id='userName']");
	By emailField = By.xpath("//input[@id='email']");
	By passwordField = By.xpath("//input[@id='password']");
	By confirmPasswordField = By.xpath("//input[@id='confirmedPassword']");
	//*[contains(text(),"Complete Registration ")]
	By btnCompleteRegisteration = By.xpath("//*[contains(text(),'Complete Registration ')]");
	By confirmationMailMsg = By.xpath("//*[contains(text(),'Check your Email')]");

	public RegistrationPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2 ; 
	}
public WebElement insertFirstName() 
{
	return driver.findElement(fistNameField);
}
public WebElement insertLastName() 
{
	return driver.findElement(lastNameField);
}
public WebElement insertMobileNumber() 
{
	return driver.findElement(mobileNumber);
}

public WebElement clickEntity() 
{
	return driver.findElement(selectEntity);
}
public WebElement selectQatar() 
{
	return driver.findElement(entityQatar);
}
public WebElement clickBU() 
{
	return driver.findElement(selectBU);
}
public WebElement selectCorporateBU() 
{
	return driver.findElement(buCorporate);
}

public WebElement clickDivision() 
{
	return driver.findElement(selectDivision);
}
public WebElement selectDiv() 
{
	return driver.findElement(divisionCEOOffice);
}
public WebElement clickAge() 
{
	return driver.findElement(selectAge);
}
public WebElement selectAgeGroup() 
{
	return driver.findElement(age20to30);
}

public WebElement clickGender() 
{
	return driver.findElement(selectGender);
}
public WebElement selectMale() 
{
	return driver.findElement(genderMale);
}

public WebElement clickProceedBtn() 
{
	return driver.findElement(btnProceed);
}

//-----------------2nd page--------------

public WebElement insertUN() 
{
	return driver.findElement(userNameField);
}

public WebElement insertEmail() 
{
	return driver.findElement(emailField);
}
public WebElement insertPWD() 
{
	return driver.findElement(passwordField);
}
public WebElement insertConfirmPWD() 
{
	return driver.findElement(confirmPasswordField);
}
public WebElement clickOnRegister() 
{
	return driver.findElement(btnCompleteRegisteration);
}

public WebElement checkConfirmMsg() 
{
	return driver.findElement(confirmationMailMsg);
}
}

