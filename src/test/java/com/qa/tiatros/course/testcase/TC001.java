package com.qa.tiatros.course.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.CourseDashboardPage;
import com.qa.tiatros.pages.Course_Sessions_page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC001 extends TestBase
{
	
	SigninPage sgn;
	CourseDashboardPage cdp;
	Course_Sessions_page csp;
	
	public TC001() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		cdp = new CourseDashboardPage();	
		csp = new Course_Sessions_page();
	}
	
	@Test
	public void clickAllSession() throws Throwable
	{
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		cdp.courseDashboardVerification();
		csp = cdp.checkInCourse();
		csp.verify_CoursePage();
		csp.currentOpenSession();
	}
	
	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
