package com.qa.tiatros.regressionSuite.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.All_moderator_Page;
import com.qa.tiatros.pages.MessagePostPage;
import com.qa.tiatros.pages.Moderator_ReassignRequests_Page;
import com.qa.tiatros.pages.Moderator_message_Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.CustomListener;
import com.qa.tiatros.util.UtilTest;

@Listeners(CustomListener.class)
public class TC04 extends TestBase {
	// Global object declaration

	SigninPage sgn;
	All_moderator_Page al;
	Moderator_ReassignRequests_Page mrrp;
	Moderator_message_Page mmp;
	MessagePostPage mpp;

	public TC04() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		al = new All_moderator_Page();
		mmp = new Moderator_message_Page();
		mpp = new MessagePostPage();
	}

	@Test(description = "Login with nexa moderator and post a new message for a particular group and also click on the Image icon for posting New Joyful Moments.")
	public void regression_TC04() throws Throwable {
		sgn.verify_text12();
		al = sgn.signin_Moderator();
		al.verify_Moderator_homePage();
		UtilTest.staticScreenShot("Moderator_Landing_Page");
		mmp = al.click_MessageSection();
		mmp.verify_MyMessage_LandingPage();
		mpp = mmp.add_MessagePost();
		Thread.sleep(4000);
		mpp.check_messagePost();
		UtilTest.logout();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
