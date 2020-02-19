package com.qa.tiatros.gratitudeJournal.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.CourseDashboardPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;

public class TC03 extends TestBase 
{
	SignupPage sp;
	SigninPage sgn;
	CourseDashboardPage cdp;

	public TC03() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		cdp = new CourseDashboardPage();
	}

	@Test(invocationCount=1, description = "Add Gratitude Journal selecting MyOrganisation tag and check the comments which had been added. ")
	public void addMultiPost_GROUP() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		cdp.courseDashboardVerification();
		cdp.addGratitudeInDashboard_Group();
		cdp.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
