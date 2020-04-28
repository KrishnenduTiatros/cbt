package com.qa.tiatros.regressionSuite.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.All_moderator_Page;
import com.qa.tiatros.pages.Moderator_NPS_Score_Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.UtilTest;

public class TC02 extends TestBase {
	// Global object declaration

	SigninPage sgn;
	All_moderator_Page al;
	Moderator_NPS_Score_Page mnps;

	public TC02() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		al = new All_moderator_Page();
		mnps = new Moderator_NPS_Score_Page();
	}

	@Test(description = "Login with nexa moderator and check the below links and pages :-\r\n" + "1. Home page\r\n"
			+ "2. Facilitator Tools\r\n" + "3. Directory \r\n" + "4. Password")
	public void regression_TC02() throws Throwable {
		sgn.verify_text12();
		al = sgn.signin_Moderator();
		al.verify_Moderator_homePage();
		UtilTest.staticScreenShot("Moderator_Landing_Page");
		al.click_NPSScore();
		UtilTest.logout();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
