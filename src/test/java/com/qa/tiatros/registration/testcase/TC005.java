package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;


@Listeners(CustomListener.class)
public class TC005 extends TestBase {
	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;

	public TC005() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();

	}

	@Test(description = "This test will click on the NPS scale")
	public void scale_select() throws Throwable {
		sgn.verify_text12();
		d = sgn.signin();
		d.scale_click();

	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
