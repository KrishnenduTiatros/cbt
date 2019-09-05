package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.pages.User_factsPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC011 extends TestBase {

	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	User_factsPage uf;

	public TC011() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();
		uf = new User_factsPage();

	}

	@Test(enabled = true)
	public void click_userfactspage_after_SignIN() throws Throwable
	{
		sgn = new SigninPage();
		sgn.verify_text12();
		d = sgn.signin();
		uf = d.user_factsQuestion();
		uf.verify_text13();
		uf.user_facts_details();
		
		// Logout Method
		d.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
