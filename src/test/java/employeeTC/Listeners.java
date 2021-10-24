package employeeTC;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources1.ExtentReporterNG;
import resources1.base;

public class Listeners extends base implements ITestListener {
	
	ExtentReports extent  = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>() ; 
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "success");
		WebDriver driver = null ; 
		String tc= result.getMethod().getMethodName();
		try {
			 
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		  try { String destPath = screenshot(tc , driver) ;
		  extentTest.get().addScreenCaptureFromPath(destPath, result.getMethod().getMethodName()) ;
			//screenshot(tc , driver) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null ; 
	String tc= result.getMethod().getMethodName();
	try {
		 
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		
	}
	  try {
		  String destPath = screenshot(tc , driver) ;
		  extentTest.get().addScreenCaptureFromPath(destPath, result.getMethod().getMethodName()) ;
		//String destPath = screenshot(tc , driver) ;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
