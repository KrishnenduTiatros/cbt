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
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC004 extends TestBase 
{
	SignupPage sp;
	SigninPage sgn;
	CourseDashboardPage cdp;
	MessagePostPage mpp;

	public TC004() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		cdp = new CourseDashboardPage();
		mpp = new MessagePostPage();
	}

	@Test(invocationCount=1, description = "Click all the heart Icons in the dashboard page.")
	public void heartIconClick() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		cdp.courseDashboardVerification();
		cdp.click_HeartIconAll();
		cdp.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
