package resources1;


import static org.testng.Assert.assertTrue;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pageObjectModels.HomePageEmployee;
import pageObjectModels.LoginPage;

import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;

public class base {

	public  WebDriver driver  ; 
	public Properties prop1 ; 
	public Properties prop2;
	public Properties prop3;
	public WebDriver initializeDriver() throws IOException
	{
		
		 prop1 = new Properties () ; 
		FileInputStream fis = new FileInputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\data.properties");
		prop1.load(fis);
		
		 prop2 = new Properties () ; 
			FileInputStream fis1 = new FileInputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\qa.properties");
			prop2.load(fis1);
			
			prop3 = new Properties () ; 
			FileInputStream fis2 = new FileInputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\uat.properties");
			prop3.load(fis2);
			String browsertype="chrome";
			 if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
			 {
				 
				 if (browsertype.equalsIgnoreCase("chrome"))
					{
						System.out.println(browsertype);
						System.setProperty("webdriver.chrome.driver", "C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\drivers\\chromedriver95.exe") ; 
						 driver = new ChromeDriver() ; 
						 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						driver.get(prop2.getProperty("url"));
						 return driver;
					}
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 }
			 else
			 {
				// driver.get(prop3.getProperty("url"));
				 if (browsertype.equalsIgnoreCase("chrome"))
					{
						System.out.println(browsertype);
						System.setProperty("webdriver.chrome.driver", "C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\drivers\\chromedriver95.exe") ; 
						 driver = new ChromeDriver() ; 
						 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						 driver.get(prop3.getProperty("url"));
						 return driver;
					}
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 }
		
		return driver; 

	}
	
	
	
	public String[] date ()
	{

		Date da=java.util.Calendar.getInstance().getTime();
		String date = da.toString();
		System.out.println(date);
		
	     String[] st = date.split("\\:");
	
	     String date1 = st[0].replaceAll("\\s","");
		System.out.println(date1);
		
		String date2 = st[2].replaceAll("\\s","");
		System.out.println(date2);
		
		String time = st[1];
		System.out.println(st[1]);
		String[] datearray = new String[]{date1,date2, time};
		
		return datearray;
	}
	
	public int currentDate ()
	{

		Date da = java.util.Calendar.getInstance().getTime();
		String date = da.toString();
		System.out.println(date);

		String[] st = date.split("\\s");
        int foo = Integer.parseInt(st[2]);
		System.out.println(foo);
		return foo;
	}
	
	public String screenshot(String testCasename, WebDriver driver) throws IOException
	{
		int number = currentDate();
		TakesScreenshot ts = (TakesScreenshot) driver ; 
		File source  = ts.getScreenshotAs(OutputType.FILE);
		
		String distenationFile = System.getProperty("user.dir")+"\\reports\\"+ testCasename +number +".png" ; 
		
		FileUtils.copyFile(source,new File(distenationFile));
		return distenationFile;
	}
	
	
	
	public  String dbConnection(String email) throws ClassNotFoundException, SQLException, IOException
	{
		String dbURL="jdbc:oracle:thin:@//OQ-IDEATE-QA:1521/ORA12C" ;
		String userName = "OQ_IDEATE";
		String password = "oq_ideate";
		Connection con = DriverManager.getConnection(dbURL,userName,password);
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Statement state = con.createStatement();
		if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		 {
			 
			String q1 = prop2.getProperty("query1");
			String q2= prop2.getProperty("query2");
			
		    String	query = q1+email+q2;
		
			ResultSet re= state.executeQuery(query);
			 re.next();
				 String mylink = re.getString(1);
				 
				  con.close();
				  return mylink ;
		 }
		 else
		 {
			 String q1 = prop3.getProperty("query1");
				String q2= prop3.getProperty("query2");
				
			    String	query = q1+email+q2;
			
				ResultSet re= state.executeQuery(query);
				 re.next();
					 String mylink = re.getString(1);
					 
					  con.close();
					  return mylink ;
			
		 }
	
	
	}
	
	public String getActiveQuarter() throws SQLException, ClassNotFoundException
	
	{
		
		String dbURL="jdbc:oracle:thin:@//OQ-IDEATE-QA:1521/ORA12C" ;
		String userName = "OQ_IDEATE";
		String password = "oq_ideate";
		Connection con = DriverManager.getConnection(dbURL,userName,password);
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Statement state = con.createStatement();
		if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		 {
			 
			String quarterID = prop2.getProperty("activequarter");
			
			ResultSet re= state.executeQuery(quarterID);
			 re.next();
				 String id = re.getString(1);
				 System.out.println(id);
		return id ;
		 }
		else
		{
			String quarterID = prop2.getProperty("activequarter");
		     ResultSet re= state.executeQuery(quarterID);
			 re.next();
				 String id = re.getString(1);
				 System.out.println(id);
		return id ;
		}
		
	}

public String getActivechallenge() throws SQLException, ClassNotFoundException
	
	{
		
		String dbURL="jdbc:oracle:thin:@//OQ-IDEATE-QA:1521/ORA12C" ;
		String userName = "OQ_IDEATE";
		String password = "oq_ideate";
		Connection con = DriverManager.getConnection(dbURL,userName,password);
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Statement state = con.createStatement();
		if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		 {
			 
			String ChallengeID = prop2.getProperty("activechallenge");
			
			ResultSet re= state.executeQuery(ChallengeID);
			 re.next();
				 String id = re.getString(1);
				 System.out.println(id);
		return id ;
		 }
		else
		{
			String quarterID = prop2.getProperty("activechallenge");
		     ResultSet re= state.executeQuery(quarterID);
			 re.next();
				 String id = re.getString(1);
				 System.out.println(id);
		return id ;
		}
		
	}
public void  CloseActiveChlng (String id) throws ClassNotFoundException, SQLException
{
	
	String dbURL="jdbc:oracle:thin:@//OQ-IDEATE-QA:1521/ORA12C" ;
	String userName = "OQ_IDEATE";
	String password = "oq_ideate";
	Connection con = DriverManager.getConnection(dbURL,userName,password);
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	Statement state = con.createStatement();
	if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
	 {
		 
		String closeChallenge = prop2.getProperty("closechallenge");
		String all = closeChallenge + id ;
		ResultSet re= state.executeQuery(all);
		 re.next();
		 System.out.println("closed");
	 }
	else
	{
		String closeChallenge = prop2.getProperty("closechallenge");
		String all = closeChallenge + id ;
	     ResultSet re= state.executeQuery(all);
		 re.next();
	}
	
}


	
	public String resetQuarter() throws SQLException, ClassNotFoundException
	{
		String dbURL="jdbc:oracle:thin:@//OQ-IDEATE-QA:1521/ORA12C" ;
		String userName = "OQ_IDEATE";
		String password = "oq_ideate";
		Connection con = DriverManager.getConnection(dbURL,userName,password);
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		Statement state = con.createStatement();
		if (prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		 {
			 
			String quarterID = prop2.getProperty("activequarter");
			String q1= prop2.getProperty("reset1");
			
			String q2= prop2.getProperty("reset2");
			String q3= prop2.getProperty("reset3");
			String q4= prop2.getProperty("commit");
		    
		
			ResultSet re= state.executeQuery(quarterID);
			 re.next();
				 String id = re.getString(1);
				 System.out.println(id);
				 String qq1 = q1+id+")";
				 System.out.println(qq1);
				 ResultSet r1 = state.executeQuery(qq1);
				 r1.next();
				 
				 String qq2 = q2+id;
				 ResultSet r2 = state.executeQuery(qq2);
				 r2.next();
				 
				 String qq3 = q2+id;
				 ResultSet r3 = state.executeQuery(qq3);
				 r3.next();
				  con.close();
				  return id ; 
		 }
		 else
		 {
			 String quarterID = prop2.getProperty("activequarter");
				String q1= prop2.getProperty("reset1");
				
				String q2= prop2.getProperty("reset2");
				String q3= prop2.getProperty("reset3");
				String q4= prop2.getProperty("commit");
			    
			
				ResultSet re= state.executeQuery(quarterID);
				 re.next();
					 String id = re.getString(1);
					 System.out.println(id);
					 String qq1 = q1+id+")";
					 System.out.println(qq1);
					 ResultSet r1 = state.executeQuery(qq1);
					 r1.next();
					 
					 String qq2 = q2+id;
					 ResultSet r2 = state.executeQuery(qq2);
					 r2.next();
					 
					 String qq3 = q2+id;
					 ResultSet r3 = state.executeQuery(qq3);
					 r3.next();
					 
					 
					  con.close();
					  return id ; 
			
		 }
	
	}
	public void testDatasheetwrite(String email , String password) throws IOException
	{
		
		FileInputStream fis =null;
		if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		{
			fis=  new FileInputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\testdataQA.xlsx") ;
		}
		else
		{
			fis=  new FileInputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\testdataUAT.xlsx") ;

		}		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets  = workbook.getNumberOfSheets();
		
		for (int i=0;i<sheets ;i++)
		{
			System.out.println(workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator() ; 
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				
				int count = sheet.getLastRowNum()-sheet.getFirstRowNum();
				
				System.out.println(count);
				
				
			Row myrow=	sheet.createRow(count+1);
			Cell ce1= myrow.createCell(0);
			
			ce1.setCellValue(email);
			Cell ce11 = myrow.createCell(1);
			ce11.setCellValue(password);
			
			;
			
			
		fis.close();
		FileOutputStream fos =null;
		if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		{
			fos=  new FileOutputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\testdataQA.xlsx") ;
		}
		else
		{
			fos=  new FileOutputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\testdataUAT.xlsx") ;

		}
		//FileOutputStream fos = new FileOutputStream("C:\\Users\\Engy.Moghazy\\eclipse-workspace2forGIT\\Ideate\\src\\main\\java\\resources1\\testdata.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();
				
			}
			
		}
	}

	
	public String[] testdataread(String usertype) throws IOException
	{
		
		FileInputStream fis =null;
		if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		{
			fis=  new FileInputStream("C:\\Users\\ihuser\\git\\Ideate\\src\\main\\java\\resources1\\testdataQA.xlsx") ;
		}
		else
		{
			fis=  new FileInputStream("C:\\Users\\ihuser\\gitIdeate\\src\\main\\java\\resources1\\testdataUAT.xlsx") ;

		}
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
		int sheets  = workbook.getNumberOfSheets();
		 String pass =null ;
		 String email1 = null ;
		 String[] data = new String [2];
		  
		for (int i=0;i<sheets ;i++)
		{
			String s= "@";
			System.out.println(workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase(usertype))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator() ; 
				
				int count =sheet.getLastRowNum()-sheet.getFirstRowNum();
				System.out.println(count);
				
				
				for (int r = 0 ; r<=count ; r++)
				{
					Row firstrow = sheet.getRow(r);
					
					for (int j=0 ; j<firstrow.getLastCellNum() ; j++)
					{
						if (firstrow.getCell(j).getStringCellValue().contains(s))//  equalsIgnoreCase(email))
						{
							     email1 = firstrow.getCell(j).getStringCellValue();
                                 pass = firstrow.getCell(j+1).getStringCellValue();
                                 data[0]= email1;
                                 data[1]= pass;
                                 System.out.println(email1 + pass);
                         return data ; 
	                     }
					}
					
				}
			}
	}
		return data;
		
	}
	
	public WebDriver login(String usertype, WebDriver driver2) throws IOException
	{
		LoginPage login = new LoginPage(driver) ; 
		HomePageEmployee home = new HomePageEmployee(driver);
		String[] st = new String[2] ; 
		String usertype1 =usertype; 
		st = testdataread(usertype1);
		login.insertEmail().sendKeys(st[0]);
		login.insertpass().sendKeys(st[1]);
		login.loginbtn().click();
		
		assertTrue(home.checkTrendingInsighs().isDisplayed());
		return driver ;
	}
	
	public WebDriver goProfileUrl(WebDriver driver)
	{
		
		if(prop1.getProperty("testEnvironmet").equalsIgnoreCase("qa"))
		{
			driver.get(prop2.getProperty("profile"));		}
		else
		{
			driver.get(prop3.getProperty("profile"));
		}
		return driver;
	}
	


}
		

	
	

