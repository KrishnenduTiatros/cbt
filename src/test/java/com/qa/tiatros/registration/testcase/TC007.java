package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.Pss10Page;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC007 extends TestBase {
	
	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	Pss10Page p10;
	
	public TC007() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();
		
	}

	@Test(description = "To click the pss10 section only")
	public void click_pss10Page_after_SignIN() throws Exception 
	{

		sgn.verify_text12();
		d = sgn.signin();
		p10 = d.pss10Question();
		p10.verify_text11();
		p10.pss10_Dynamic_Click();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
