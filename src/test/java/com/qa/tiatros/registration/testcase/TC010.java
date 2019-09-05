package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.pages.Stress_inventoryPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC010 extends TestBase {

	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	Stress_inventoryPage si;

	public TC010() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();
		si = new Stress_inventoryPage();

	}

	@Test(description = "To click the  StressInventor section only ")
	public void click_StressInventorypage_after_SignIN() throws Throwable {
		sgn = new SigninPage();
		sgn.verify_text12();
		d = sgn.signin();
		si = d.stress_inventoryQuestion();
		si.verify_text12();
		si.stress_inventory_CheckBox();

		// Logout Method
		d.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
