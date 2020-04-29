package com.qa.tiatros.regressionSuite.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.All_moderator_Page;
import com.qa.tiatros.pages.Moderator_ASSIGNED_Page;
import com.qa.tiatros.pages.Moderator_COMPLETE_Page;
import com.qa.tiatros.pages.Moderator_CONFIRMED_Page;
import com.qa.tiatros.pages.Moderator_NOCOUPON_Page;
import com.qa.tiatros.pages.Moderator_READY_Page;
import com.qa.tiatros.pages.Moderator_REGISTERED_Page;
import com.qa.tiatros.pages.Moderator_REMOVED_Page;
import com.qa.tiatros.pages.Moderator_ReassignRequests_Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.UtilTest;

public class TC03 extends TestBase {
	// Global object declaration

	SigninPage sgn;
	All_moderator_Page al;
	Moderator_ReassignRequests_Page mrrp;
	Moderator_NOCOUPON_Page mnnP;
	Moderator_READY_Page mrrrP;
	Moderator_REGISTERED_Page mrrP;
	Moderator_REMOVED_Page mrP;
	Moderator_CONFIRMED_Page mccP;
	Moderator_COMPLETE_Page mcP;
	Moderator_ASSIGNED_Page msP;

	public TC03() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		al = new All_moderator_Page();
		mrrp = new Moderator_ReassignRequests_Page();
		msP = new Moderator_ASSIGNED_Page();
		mcP = new Moderator_COMPLETE_Page();
		mccP = new Moderator_CONFIRMED_Page();
		mrP = new Moderator_REMOVED_Page();
		mrrP = new Moderator_REGISTERED_Page();
		mrrrP = new Moderator_READY_Page();
		mnnP = new Moderator_NOCOUPON_Page();

	}

	@Test(description = "Login with nexa moderator and check the below links and pages :-\r\n" + "1. Home page\r\n"
			+ "2. Reassign Requests\r\n" + "3. Courses\r\n" + "4. Participants")
	public void regression_TC02() throws Throwable {
		sgn.verify_text12();
		al = sgn.signin_Moderator();
		al.verify_Moderator_homePage();
		UtilTest.staticScreenShot("Moderator_Landing_Page");
		mrrp = al.click_Requests();
		mrrp.verify_ReassignRequest_Page();
		mrrp.click_Courses();
		mrrP = al.click_Participant();
		mrrP.verify_REGISTERED_Page();
		mccP = mrrP.click_Confirmed();
		mccP.verify_CONFIRMED_Page();
		mrrrP = mccP.click_Ready();
		mrrrP.verify_READY_Page();
		msP = mrrrP.click_assigned();
		msP.verify_ASSIGNED_Page();
		mcP = msP.click_complete();
		mcP.verify_COMPLETE_Page();
		mrP = mcP.click_Remove();
		mrP.verify_REMOVED_Page();
		mnnP = mrP.click_nocoupon();
		mnnP.verify_NOCOUPON_Page();
		UtilTest.logout();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
