package com.qa.tiatros.regressionSuite.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.All_moderator_Page;
import com.qa.tiatros.pages.CourseDashboardPage;
import com.qa.tiatros.pages.MessagePostPage;
import com.qa.tiatros.pages.Message_post_commentsPage;
import com.qa.tiatros.pages.Moderator_ReassignRequests_Page;
import com.qa.tiatros.pages.Moderator_message_Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.CustomListener;
import com.qa.tiatros.util.UtilTest;

@Listeners(CustomListener.class)
public class TC05 extends TestBase {
	// Global object declaration

	SigninPage sgn;
	All_moderator_Page al;
	Moderator_ReassignRequests_Page mrrp;
	Moderator_message_Page mmp;
	MessagePostPage mpp;
	CourseDashboardPage cdp;
	MessagePostPage mppp;
	Message_post_commentsPage mpcp;

	public TC05() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		al = new All_moderator_Page();
		mmp = new Moderator_message_Page();
		mpp = new MessagePostPage();
		cdp = new CourseDashboardPage();
		mppp = new MessagePostPage();
		mpcp = new Message_post_commentsPage();
	}

	@Test(description = "Login with participant and post a message for facilitator, login with moderator and check that particular participants message is visible in the moderator section and also reply on that too.")
	public void regression_TC05() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		cdp.courseDashboardVerification();
		mppp = cdp.postMsg_Moderator();
		mpcp = mppp.reply_message_post();
		mpcp.add_reply_messageText();
		sgn.verify_text12();
		al = sgn.signin_Moderator();
		al.verify_Moderator_homePage();
		UtilTest.staticScreenShot("Moderator_Landing_Page");
		mmp = al.click_MessageSection();
		mmp.verify_MyMessage_LandingPage();
		mpcp = mpp.rply_msg_moderatort();
		mpcp.modrt_reply_Mesg();
		UtilTest.staticScreenShot("ModeratorReplyPost_Page");
		UtilTest.logout();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
