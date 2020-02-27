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
public class TC012 extends TestBase{
	
	SignupPage sp;
	SigninPage sgn;
	CourseDashboardPage cdp;
	MessagePostPage mpp;
	Viewable_MembersPage vmp;

	public TC012() {
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

	@Test(invocationCount = 1, description= "Click on the Notification icon and click all the tiles present in that section , \n" + 
			"check the count before and after notification. ")
	public void checkAllNotificationDetails() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		cdp.notificationCounterCheck();
		cdp.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}


}
