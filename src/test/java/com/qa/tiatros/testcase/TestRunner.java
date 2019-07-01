package com.qa.tiatros.testcase;

import org.testng.TestNG;

public class TestRunner {

	static TestNG testng;

	@SuppressWarnings("deprecation")
	public static void main(String[] args)

	{
		// ExtentReportListner ext = new ExtentReportListner();

		testng = new TestNG();
		testng.setTestClasses(new Class[] { DashboardTest.class });
		// testng.addListener(ext);
		testng.run();

	}
}
