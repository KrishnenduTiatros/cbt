package com.qa.tiatros.modertor.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.All_moderator_Page;
import com.qa.tiatros.pages.Review_goals_assessments_Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC01 extends TestBase {

	// Global object declairation

	SigninPage sgn;
	All_moderator_Page al;
	Review_goals_assessments_Page rga;

	public TC01() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		al = new All_moderator_Page();
		rga = new Review_goals_assessments_Page();
	}

	@Test(description = "To check the review goal setting section colour")
	public void review_goal_setting_color() throws Throwable {
		sgn.verify_text12();
		al = sgn.signin_Moderator();
		al.verify_Moderator_homePage();		
		rga = al.click_Review_Goal();
		rga.check_review();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
