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
public class TC004 extends TestBase {

	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	Stress_inventoryPage si;

	public TC004() {
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

	@Test(description = "To check the inventory stress sector message and also click on it") 
	public void inventory_Your_Stress() throws Throwable {
		sgn.verify_text12();
		d = sgn.signin();
		d.verify_text15();
		d.click_inventory_your_stress();
		d.verify_text17();

		// Logout Method
		d.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
