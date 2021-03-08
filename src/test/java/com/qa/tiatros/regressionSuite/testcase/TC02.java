package com.qa.tiatros.regressionSuite.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.All_moderator_Page;
import com.qa.tiatros.pages.Moderator_Change_Password_Page;
import com.qa.tiatros.pages.Moderator_Directory_Page;
import com.qa.tiatros.pages.Moderator_NPS_Score_Page;
import com.qa.tiatros.pages.Moderator_Nudge_Page;
import com.qa.tiatros.pages.Moderator_Review_Respond_Page;
import com.qa.tiatros.pages.Review_goals_assessments_Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.CustomListener;
import com.qa.tiatros.util.UtilTest;

@Listeners(CustomListener.class)
public class TC02 extends TestBase {
	// Global object declaration

	SigninPage sgn;
	All_moderator_Page al;
	Moderator_NPS_Score_Page mnps;
	Moderator_Nudge_Page mnp;
	Moderator_Review_Respond_Page mrrp;
	Review_goals_assessments_Page rga;
	Moderator_Directory_Page mdp;
	Moderator_Change_Password_Page mcpp;

	public TC02() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		al = new All_moderator_Page();
		mnps = new Moderator_NPS_Score_Page();
		mnp = new Moderator_Nudge_Page();
		rga = new Review_goals_assessments_Page();
		mrrp = new Moderator_Review_Respond_Page();
		mdp = new Moderator_Directory_Page();
		mcpp = new Moderator_Change_Password_Page();
	}

	@Test(description = "Login with nexa moderator and check the below links and pages :-\r\n" + "1. Home page\r\n"
			+ "2. Facilitator Tools\r\n" + "3. Directory \r\n" + "4. Password")
	public void regression_TC02() throws Throwable {
		sgn.verify_text12();
		al = sgn.signin_Moderator();
		al.verify_Moderator_homePage();
		UtilTest.staticScreenShot("Moderator_Landing_Page");
		mnps = al.click_NPSScore();
		mnps.verify_NPS_LandingPage();
		mnp = mnps.click_Nudge();
		mnp.verify_Nudge_LandingPage();
		mrrp = mnp.click_reviewRespond();
		mrrp.verify_ReviewRespond_LandingPage();
		rga = mrrp.click_reviewGoal();
		rga.verify_ReviewGoal_LandingPage();
		mdp = rga.click_Directory();
		mdp.verify_directory_LandingPage();
		mcpp = mdp.click_pass();
		mcpp.verify_password_LandingPage();
		UtilTest.logout();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
