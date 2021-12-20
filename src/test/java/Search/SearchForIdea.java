package Search;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources1.base;

public class SearchForIdea extends base {

	

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(SearchForIdea.class.getName());
	
	
	@BeforeTest
	public void tearup() throws IOException

	{
		driver = initializeDriver();
		
		
	}
	
	
	@Test
	public void homePagevalidation() throws IOException {}
	
	@AfterTest
	public void teardown() {
		// driver.close();

	}
	
	
}
