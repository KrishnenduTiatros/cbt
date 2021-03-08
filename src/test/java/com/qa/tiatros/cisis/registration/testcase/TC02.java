package com.qa.tiatros.cisis.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tiatros.base.Base;
import com.qa.tiatros.page.ChooseStartDate_Page;
import com.qa.tiatros.page.Covid19_check_Page;
import com.qa.tiatros.page.PersonalizeYourProfilePage;
import com.qa.tiatros.page.PinPage;
import com.qa.tiatros.page.PreCorseDashboardPage;
import com.qa.tiatros.page.ProfilePage;
import com.qa.tiatros.page.Pss10Page;
import com.qa.tiatros.page.Sign_up_Page;

public class TC02 extends Base {
	Sign_up_Page su;
	PinPage pp;
	ChooseStartDate_Page csdp;
	Covid19_check_Page c19;
	ProfilePage p;
	PersonalizeYourProfilePage pyp;
	PreCorseDashboardPage pd;
	Pss10Page p10;

	public TC02() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		su = new Sign_up_Page();
		pp = new PinPage();
		csdp = new ChooseStartDate_Page();
		c19 = new Covid19_check_Page();
		p = new ProfilePage();
		pyp = new PersonalizeYourProfilePage();
		pd = new PreCorseDashboardPage();
		p10 = new Pss10Page();
	}

	@Test(invocationCount = 1, description = "User registration with all links and pop-up clicked to complete registration process.")
	public void allLinkRegistration_TC02() throws Throwable {
		su.pageValidation();
		pp = su.goToPinPageWithAllClick();
		pp.pageValidation();
		csdp = pp.verifyPin();
		csdp.pageValidation();
		c19 = csdp.goToCovidPage();
		c19.pageValidation();
		p = c19.gotoProfilePage();
		p.pageValidation();
		pyp = p.gotoProfilePersonalizePage();
		pyp.pageValidation();
		pd = pyp.gotodashboard();
		pd.pageValidation();
		pd.clickAllDashboard();
		p10 = pd.pss10Question();
		p10.verify_text11();
		p10.pss10_Dynamic_Click();

		// Logout Method
		pd.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
