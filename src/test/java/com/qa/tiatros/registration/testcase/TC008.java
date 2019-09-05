package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.Phq15Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC008 extends TestBase {
	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	Phq15Page p15;

	public TC008() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();
		p15 = new Phq15Page();

	}

	@Test(description = "To click the pss10 section only")
	public void click_phq15page_after_SignIN() throws Throwable {
		sgn.verify_text12();
		d = sgn.signin();
		p15 = d.phq15Question();
		p15.verify_text10();
		p15.phq15_Dynamic_Click();
		Thread.sleep(3000);
		
		// Logout Method
		d.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
