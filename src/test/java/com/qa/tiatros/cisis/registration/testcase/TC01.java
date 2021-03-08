package com.qa.tiatros.cisis.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.ChooseStartDate_Page;
import com.qa.tiatros.pages.Covid19_check_Page;
import com.qa.tiatros.pages.CrisisPinPage;
import com.qa.tiatros.pages.CrisisProfilePage;
import com.qa.tiatros.pages.CrisisPss10Page;
import com.qa.tiatros.pages.CrisisSign_up_Page;
import com.qa.tiatros.pages.PersonalizeYourProfilePage;
import com.qa.tiatros.pages.PreCorseDashboardPage;


public class TC01 extends TestBase {

	CrisisSign_up_Page su;
	CrisisPinPage pp;
	ChooseStartDate_Page csdp;
	Covid19_check_Page c19;
	CrisisProfilePage p;
	PersonalizeYourProfilePage pyp;
	PreCorseDashboardPage pd;
	CrisisPss10Page p10;

	public TC01() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		su = new CrisisSign_up_Page();
		pp = new CrisisPinPage();
		csdp = new ChooseStartDate_Page();
		c19 = new Covid19_check_Page();
		p = new CrisisProfilePage();
		pyp = new PersonalizeYourProfilePage();
		pd = new PreCorseDashboardPage();
		p10 = new CrisisPss10Page();
	}

	@Test(invocationCount = 1, description = "Signup user with just basic required process to complete registration process.")
	public void registrationFlow_TC01() throws Throwable {
		pp = su.goToPinPage();
		csdp = pp.verifyPin();
		c19 = csdp.goToCovidPage();
		p = c19.gotoProfilePage();
		pyp = p.gotoProfilePersonalizePage();
		pd = pyp.gotodashboard();
		pd.completeDashboard();
		p10 = pd.pss10Question();
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