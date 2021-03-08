package com.qa.tiatros.cisis.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tiatros.base.Base;
import com.qa.tiatros.page.PreCorseDashboardPage;
import com.qa.tiatros.page.ProfilePage;
import com.qa.tiatros.page.Pss10Page;
import com.qa.tiatros.page.Sign_up_Page;
import com.qa.tiatros.page.SigninPage;

public class TC11 extends Base {
	PreCorseDashboardPage pd;
	Pss10Page p10;
	SigninPage sp;

	public TC11() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SigninPage();
		pd = new PreCorseDashboardPage();
		p10 = new Pss10Page();
	}

	@Test(invocationCount = 1, description = "Check User able to login to the Pre-Course Dashboard and complete the registration flow.\n"
			+ " 1. Login as Participant\n"
			+ " 2. Complete all the task which required a participant to be in READY state.\n" + " 3. Logout")
	public void logInDashboadAndCompleteRegistration() throws Throwable {
		sp.signin();
		//pd.pageValidation();
		pd.completeDashboard();
		p10 = pd.pss10Question();
		p10.verify_text11();
		p10.pss10_Dynamic_Click();
		pd.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
