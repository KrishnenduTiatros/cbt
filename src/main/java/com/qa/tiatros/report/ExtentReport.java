package com.qa.tiatros.report;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class ExtentReport extends TestBase {
	// public ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	public ExtentTest test;

	DateFormat sdf = new SimpleDateFormat("ddMMyyyy HH:mm");
	Date date = new Date();
	public String d = sdf.format(date);

	public static ExtentReports createInstance(String fileName) {

		// Specify location of the report
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		// Setting Encoding to UTF-8
		htmlReporter.config().setEncoding("utf-8");

		// Title of the Report
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		// Name of the Report
		htmlReporter.config().setReportName("Tiatros Automation Test Report.html");
		htmlReporter.config().setTheme(Theme.DARK);

		// Creating extent report class
		extent = new ExtentReports();
		// attaching the html reporter to extent object
		extent.attachReporter(htmlReporter);

		// Passing General information
		extent.setSystemInfo("Host name", "CBTFuture");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("Automation QA", "Krishnendu Saha");

		return extent;

	}

//	@AfterTest
//	public void endReport() {
//		extent.flush();
//	}

//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			// to add name in extent report
//			test.log(Status.FAIL, "TEST METHOD FAILED - " + result.getName());
//			// to add error/exception in extent report
//			test.log(Status.FAIL, "REASON FAILURE -  " + result.getThrowable());
//			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
//			//test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
//			test.log(Status.PASS, "Test Case Description --> " + result.getMethod().getDescription());
//		}
//
//	}

//	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//
//		// after execution, you could see a folder "FailedTestsScreenshots" under src
//		// folder
//		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
//		File finalDestination = new File(destination);
//		FileUtils.copyFile(source, finalDestination);
//		return destination;
//	}

	public void sendEMailReport() throws Throwable {

		// Creating Extend Report path for sending Mail.
		String reportPath = "/Users/krishnendu/eclipse-workspace/Tiatros/test-output/TiatrosReport_" + d + ".html";
		String s1 = "Please find the attached updated report for the TestCase Runned on " + d + ".";
		UtilTest.sendEmailNotification(prop.getProperty("SendEmail"), prop.getProperty("EmailSubject"), reportPath, s1);
	}

}
