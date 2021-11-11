package employeeTC;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;
import pageObjectModels.RegistrationPage;
import pageObjectModels.TempEmailPage;
import resources1.base;

public class registration extends base  {
	
public WebDriver driver ;
private static Logger log = LogManager.getLogger(registration.class.getName()) ;

	@BeforeTest
	public void tearup() throws IOException, InterruptedException
	
	{
		
		 driver = initializeDriver() ; 
		 if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa") )
		 { driver.get(prop2.getProperty("tempemail"));}
		 else {
			 driver.get(prop3.getProperty("tempemail"));
		 }
		
		
		
	}
	
	
	@Test
	public void tempEmailcreation() throws InterruptedException, IOException, AWTException, ClassNotFoundException, SQLException
	
	{
		TempEmailPage temp = new TempEmailPage(driver);
		HomePageEmployee home = new HomePageEmployee(driver);
		String windowHandle = driver.getWindowHandle();
		String email1=temp.findEmail().getAttribute("value");
		String parent=driver.getWindowHandle(); 
		
		String[] datearray  = date();
       
		 ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
	        driver.switchTo().window(tab.get(0));
	        if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
	        {
	        	driver.get(prop2.getProperty("register"));
	        }
	        else
	        {
	        driver.get(prop3.getProperty("register"));
	        }
			RegistrationPage rg = new RegistrationPage(driver);
			rg.insertFirstName().sendKeys(datearray[0]);
			rg.insertLastName().sendKeys(datearray[1]);
			rg.insertMobileNumber().sendKeys("85696565");
			Actions build = new Actions(driver);
			build.moveToElement(rg.clickEntity()).moveByOffset(124, 0).click().build().perform();
			build.click(rg.selectQatar()).build().perform();
			
			build.moveToElement(rg.clickBU()).moveByOffset(124, 0).click().build().perform();
			build.click(rg.selectCorporateBU()).build().perform();
			
			build.moveToElement(rg.clickDivision()).moveByOffset(124, 0).click().build().perform();
			build.click(rg.selectDiv()).build().perform();
			
			build.moveToElement(rg.clickAge()).moveByOffset(124, 0).click().build().perform();
			build.click(rg.selectAgeGroup()).build().perform();
			
			build.moveToElement(rg.clickGender()).moveByOffset(124, 0).click().build().perform();
			build.click(rg.selectMale()).build().perform();
			build.moveToElement(rg.clickProceedBtn());
			build.moveToElement(rg.clickProceedBtn()).click().build().perform();
			rg.insertUN().sendKeys(datearray[1]+"_"+ datearray[2] );
			rg.insertEmail().sendKeys(email1);
			String Password = datearray[0]+"@"+datearray[2];
			rg.insertPWD().sendKeys(Password);
			rg.insertConfirmPWD().sendKeys(Password);
			build.moveToElement(rg.clickOnRegister()).click().build().perform();
	
			AssertJUnit.assertTrue(rg.checkConfirmMsg().isDisplayed());
			
			String confirmURL= dbConnection(email1);
			
			driver.get(confirmURL);
			driver.findElement(By.xpath("//*[@id='details-button']")).click();
			driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
		
			System.out.println(email1);
			
		WebElement  nn = 	driver.findElement(By.xpath("//*[@id='email']"));
		nn.clear();
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email1);
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Password);
			driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
			
			testDatasheetwrite(email1,Password);
			
			AssertJUnit.assertTrue(home.brandCheck().isDisplayed());
	}
	
	
	@AfterTest
	public void teardown()
	
	{
		driver.close();
		
	}

}
