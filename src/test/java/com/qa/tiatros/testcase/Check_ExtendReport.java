package com.qa.tiatros.testcase;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cbt.qa.base.TestBase;

public class Check_ExtendReport extends TestBase {

	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	DateFormat sdf = new SimpleDateFormat("ddMMyyyy HH:mm");
	Date date = new Date();
	public String d = sdf.format(date);

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 7");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.nopcommerce.com/");
	}

	@BeforeTest
	public void setExtent() {

		// specify location of the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Tiatros.html");
		// Title of the Report
		htmlReporter.config().setDocumentTitle("Automation Report");
		// Name of the Report
		htmlReporter.config().setReportName("TiatrosReport_" + d + ".html");
		htmlReporter.config().setTheme(Theme.DARK);
		// Creating extent report class
		extent = new ExtentReports();
		// attaching the htmlreporter to extent object
		extent.attachReporter(htmlReporter);
		// Passing General information
		extent.setSystemInfo("Host name", "CBTFuture");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("Automation QA", "Krishnendu Saha");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	// Test1
	@Test(invocationCount=1, description = "TestCase One Running in Production... ")
	public void noCommerceTitleTest() {
		driver.get("http://demo.nopcommerce.com/");
		test = extent.createTest("noCommerceTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "eCommerce demo store");
	}

	// Test2
	@Test(invocationCount=1, description = "TestCase Two Running in Production...  ")
	public void noCommerceLogoTest() {
		test = extent.createTest("noCommerceLogoTest");
		boolean b = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertTrue(b);
	}

	// Test3
	@Test(invocationCount=1, description = "TestCase Three Running in Production...  ")
	public void noCommerceLoginTest() {
		test = extent.createTest("noCommerceLoginTest");

		test.createNode("Login with Valid input");
		Assert.assertTrue(true);

		test.createNode("Login with In-valid input");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			// to add error/exception in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

			String screenshotPath = Check_ExtendReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			test.log(Status.PASS, "Test Case Description --> " + result.getMethod().getDescription());
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
