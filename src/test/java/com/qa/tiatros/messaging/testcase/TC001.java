/*** Add a new message post and verify the subject which is being uploaded. ***/
/*** Author - Krishnendu Saha ***/

package com.qa.tiatros.messaging.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.CourseDashboardPage;
import com.qa.tiatros.pages.MessagePostPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC001 extends TestBase {
	
	SignupPage sp;
	SigninPage sgn;
	CourseDashboardPage cdp;
	MessagePostPage mpp;

	public TC001() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		cdp = new CourseDashboardPage();
		mpp = new MessagePostPage();
	}

	@Test(invocationCount=1, description= "To add message post in Messaging section")
	public void addNewMessage() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		cdp.courseDashboardVerification();
		mpp = cdp.add_MessagePost();
		mpp.check_messagePost();
		mpp.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}
}
