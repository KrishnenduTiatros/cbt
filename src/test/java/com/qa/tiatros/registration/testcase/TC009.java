package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.Gad7Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC009 extends TestBase {
	
	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	Gad7Page g7;

	public TC009() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();
		g7 = new Gad7Page();

	}

	@Test(description = "To click the gad7 section only ")
	public void click_gad7page_after_SignIN() throws Throwable {
		sgn = new SigninPage();
		sgn.verify_text12();
		d = sgn.signin();
		g7 = d.gad7Question();
		g7.verify_text9();
		g7.gad7_Dynamic_Click();
		
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
