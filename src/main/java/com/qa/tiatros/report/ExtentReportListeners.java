package com.qa.tiatros.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class ExtentReportListeners extends TestBase implements ITestListener
{

	static Date d = new Date();
	static String filename = "Tiatros" + d.toString().replace(":", "_") + ".html";

	public ExtentTest test;
	private static ExtentReports extent = ExtentReport
			.createInstance(System.getProperty("user.dir") + "/reports/" + filename);
	private static ThreadLocal<ExtentTest> testRport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		testRport.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		testRport.set(test.log(Status.PASS, "Test Method --> " + result.getName()));
		testRport.set(test.log(Status.PASS, "Test Case Description--> " + result.getMethod().getDescription()));
		testRport.set(test.log(Status.PASS, "Test Case Invocation Count--> " + result.getMethod().getInvocationCount()));
	}

	public void onTestFailure(ITestResult result) {

		// to add name in extent report
		testRport.set(test.log(Status.FAIL, "Test Method -->" + result.getName()));
		
		// to add error/exception in extent report
		testRport.set(test.log(Status.FAIL, "Test Failure Description -->" + result.getThrowable()));
		// adding screen shot in the report
		String screenshotPath;
		try {
			screenshotPath = ExtentReportListeners.getScreenshot(driver, result.getName());
			testRport.set(test.addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Failed Test");
		UtilTest.takeScreenshot(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		testRport.set(test.log(Status.SKIP, "Test Method SKIPPED IS " + result.getName()));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}

	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

}
