package pageObjectModels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public   class LoginPage  {
	
	public WebDriver driver ; 
	
	By emailid = By.xpath("//*[@id='email']");
	By password= By.xpath("//*[@id='password']");
	By forgetPass = By.xpath("//a[@href='/auth/forget-password']");
	By register = By.xpath("//a[@href='/auth/register']");

	By loginbtn = By.xpath("//*[@class='btn btn-primary']");
	By logintext = By.xpath("//h2[@class='mb-3']");
	
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2 ; 
	}


	
public WebElement getLoginText() 
{
	return driver.findElement(logintext);
}

	public WebElement insertEmail ()
	
	{
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(emailid);
		
	}
	
	
public WebElement insertpass ()
	
	{
	
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(password);
		
	}
	

public WebElement register ()

{ driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver.findElement(forgetPass);
	
}

public WebElement forgetPass ()

{ driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver.findElement(register);
	
}
public WebElement loginbtn ()

{ driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver.findElement(loginbtn);
	
}
}
