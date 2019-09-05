package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.Phq9Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;

public class TC006 extends TestBase {
	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	Phq9Page p9;

	public TC006() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();
		p9 = new Phq9Page();

	}

	@Test(description = "This method will click the PHQ9 sectiona only")
	public void click_phq9Page_after_SignIN() throws Throwable {

		sgn.verify_text12();
		d = sgn.signin();
		p9 = d.phq9Question();
		p9.verify_text8();
		p9.phq9_Dynamic_Click();

		// Logout Method
		d.logoutM();

	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
