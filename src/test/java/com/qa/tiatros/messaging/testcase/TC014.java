package com.qa.tiatros.messaging.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.CourseDashboardPage;
import com.qa.tiatros.pages.Gad7Page;
import com.qa.tiatros.pages.MessagePostPage;
import com.qa.tiatros.pages.PersonalProgress;
import com.qa.tiatros.pages.Phq15Page;
import com.qa.tiatros.pages.Phq9Page;
import com.qa.tiatros.pages.Pss10Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.pages.Stress_inventoryPage;
import com.qa.tiatros.pages.Viewable_MembersPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC014 extends TestBase {
	SignupPage sp;
	SigninPage sgn;
	CourseDashboardPage cdp;
	MessagePostPage mpp;
	Viewable_MembersPage vmp;
	PersonalProgress pp;
	Phq9Page p9;
	Gad7Page g7;
	Phq15Page p15;
	Pss10Page p10;
	Stress_inventoryPage si;

	public TC014() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sgn = new SigninPage();
		cdp = new CourseDashboardPage();
		mpp = new MessagePostPage();
		vmp = new Viewable_MembersPage();
		pp = new PersonalProgress();
		p9 = new Phq9Page();
		g7 = new Gad7Page();
		p15 = new Phq15Page();
		p10 = new Pss10Page();
		si = new Stress_inventoryPage();
	}

	@Test(invocationCount = 1, description= "User provide Personal progress section when user is assigned to a Course ")
	public void userPersonalProgressSection() throws Throwable {
		sgn.verify_text12();
		cdp = sgn.signin_Course();
		pp = cdp.myProgress();

		// Gad7 page call
		g7 = pp.gad7Question();
		g7.verify_text9();
		g7.gad7_Dynamic_Click();

		// Phq15 Page call
		p15 = pp.phq15Question();
		p15.verify_text10();
		p15.phq15_Dynamic_Click();

		// Phq10 Page call
		p10 = pp.pss10Question();
		p10.verify_text11();
		p10.pss10_Dynamic_Click();

		// Phq9 page call
		p9 = pp.phq9Question();
		p9.verify_text8();
		p9.phq9_Dynamic_Click();

//		// Stress Inventory Sections
//
//		si = pp.stress_inventoryQuestion();
//		si.verify_text12();
//		si.stress_inventory_CheckBox();

		// Logout Method
		pp.logoutM();

	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
