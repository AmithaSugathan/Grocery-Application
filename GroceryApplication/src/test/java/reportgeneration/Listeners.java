package reportgeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportUtility;

public class Listeners implements ITestListener{ //ITestListener Interface
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {//Will execute before a test case is run

	ITestListener.super.onTestStart(result);
	test = extent.createTest(result.getMethod().getMethodName());//fetch methodnames of the testcase to be run
	extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {//Will execute after a test case is passed

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {//Will execute after a test case is failed

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;

	String testMethodName = result.getMethod().getMethodName();

	try {

	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (IllegalArgumentException e) {

	e.printStackTrace();//Error/Exception why testcase is failed will be printed
	} catch (IllegalAccessException e) {

	e.printStackTrace();
	} catch (NoSuchFieldException e) {

	e.printStackTrace();
	} catch (SecurityException e) {

	e.printStackTrace();
	}

	try {
	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (Exception e) {
	}
	}

	public void onTestSkipped(ITestResult result) {//Will execute when a test case is skipped

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {//will execute when a test case doesn't meet pass percentage

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {//Will execute when a test case fails due to timeout

	ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {//Will execute before a testcase is run

	ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {//Will execute when all test cases are run

	ITestListener.super.onFinish(context);
	extent.flush();//To log all data fetched from all methods into the report
	}
}
