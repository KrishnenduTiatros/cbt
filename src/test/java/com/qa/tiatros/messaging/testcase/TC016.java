package com.qa.tiatros.messaging.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.CourseDashboardPage;
import com.qa.tiatros.pages.MessagePostPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.pages.Viewable_MembersPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC016 extends TestBase{
	
	SignupPage sp;
	SigninPage sgn;
	CourseDashboardPage cdp;
	MessagePostPage mpp;
	Viewable_MembersPage vmp;
	
	public TC016() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		cdp = new CourseDashboardPage();
		mpp = new MessagePostPage();
		vmp = new Viewable_MembersPage();
	}

	@Test(invocationCount = 1, description="Click on the Peer Review icon and click the first peer review if available ")
	public void peerReview() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		cdp.clickPeerReview();
		cdp.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
