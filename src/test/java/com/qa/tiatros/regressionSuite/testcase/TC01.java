package com.qa.tiatros.regressionSuite.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.All_moderator_Page;
import com.qa.tiatros.pages.Moderator_Channels_Page;
import com.qa.tiatros.pages.Moderator_Coupon_Page;
import com.qa.tiatros.pages.Moderator_ReviewContent_Page;
import com.qa.tiatros.pages.Moderator_message_Page;
import com.qa.tiatros.pages.Review_goals_assessments_Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.CustomListener;
import com.qa.tiatros.util.UtilTest;

public class TC01 extends TestBase {

	// Global object declairation

	SigninPage sgn;
	All_moderator_Page al;
	Moderator_message_Page mmp;
	Moderator_Channels_Page mcp;
	Moderator_ReviewContent_Page mrcp;
	Moderator_Coupon_Page mcop;

	public TC01() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		al = new All_moderator_Page();
		mmp = new Moderator_message_Page();
		mcp = new Moderator_Channels_Page();
		mrcp = new Moderator_ReviewContent_Page();
		mcop = new Moderator_Coupon_Page();
	}

	@Test(description = "Login with nexa moderator and check the below links and pages :-\r\n" + "1. Home page\r\n"
			+ "2. Messages\r\n" + "3. Channels\r\n" + "4. Review Content\r\n" + "5. Coupons")
	public void regression_TC01() throws Throwable {
		sgn.verify_text12();
		al = sgn.signin_Moderator();
		al.verify_Moderator_homePage();
		UtilTest.staticScreenShot("Moderator_Landing_Page");
		mmp = al.click_MessageSection();
		mmp.verify_MyMessage_LandingPage();
		mcp = mmp.click_Channels();
		mcp.verify_channels_LandingPage();
		mrcp = mcp.click_ReviewContent();
		mrcp.verify_reviewContent_LandingPage();
		mcop = mrcp.click_coupons();
		UtilTest.logout();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
