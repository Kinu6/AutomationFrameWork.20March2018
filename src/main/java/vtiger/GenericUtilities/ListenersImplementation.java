package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ITestListener Interface of TestNG
 * @author kravi
 *
 */
public class ListenersImplementation implements ITestListener{
	    ExtentReports report;
	    ExtentTest test;
	 
	public void onTestStart(ITestResult result) {
		
		String methodName= result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, methodName+"--- Test script execution started----" );
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
        test.log(Status.PASS, methodName+"---Test is passed----");
	}

	public void onTestFailure(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		test.log(Status.FAIL, "Test is failed");
		test.log(Status.INFO, result.getThrowable()); //Print Exception
		
		String screenshotName= methodName+"-"+new JavaUtility().getSystemDateInFormat();
		WebDriverUtility wUtil= new WebDriverUtility();
		try {
			String path=wUtil.takesScreenShot(BaseClass.sDriver,screenshotName);
		    test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //create object of base class, inherit , static variable 
	}

	public void onTestSkipped(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+ "Test is skipped");
		test.log(Status.INFO, result.getThrowable()); //Print Exception
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//30% is passed
	} 

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		// timeout
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution started");
		//Extent Report configuration steps
		
		ExtentSparkReporter htmlReporter= new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html"); 
		htmlReporter.config().setDocumentTitle("vtiger Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Automation Execution Report");
		
		report= new ExtentReports(); 
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Base Browser","Firefox" );
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter-Name", "Ravish");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution finished");
		report.flush(); //generate the Report, all things are completed
	}
}
