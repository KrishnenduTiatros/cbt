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
public class TC006 extends TestBase{
	
	SignupPage sp;
	SigninPage sgn;
	CourseDashboardPage cdp;
	MessagePostPage mpp;

	public TC006() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		cdp = new CourseDashboardPage();
		mpp = new MessagePostPage();
	}

	@Test(invocationCount=1, description = "Click all the tiles in the my messages and also pagination")
	public void clickAllTilesInMessages() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		mpp = cdp.click_SeeAllMessage();
		mpp.clickOnTiles();
		cdp.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}
	
}
