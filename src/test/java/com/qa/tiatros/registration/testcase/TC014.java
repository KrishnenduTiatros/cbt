package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.FromWelcomeVidPage;
import com.qa.tiatros.pages.Gad7Page;
import com.qa.tiatros.pages.Phq15Page;
import com.qa.tiatros.pages.Phq9Page;
import com.qa.tiatros.pages.PinPage;
import com.qa.tiatros.pages.ProfilePage;
import com.qa.tiatros.pages.Pss10Page;
import com.qa.tiatros.pages.RegistrationPage;
import com.qa.tiatros.pages.ReturnUserRegistrationPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.pages.Stress_inventoryPage;
import com.qa.tiatros.pages.User_factsPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC014 extends TestBase {

	// Global object declaration

	RegistrationPage rp;
	SignupPage sp;
	SigninPage sgn;
	PinPage p;
	ProfilePage pp;
	FromWelcomeVidPage fwv;
	DashboardPage d;
	Phq9Page p9;
	Gad7Page g7;
	Phq15Page p15;
	Pss10Page p10;
	Stress_inventoryPage si;
	User_factsPage uf;
	ReturnUserRegistrationPage rur;

	public TC014() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		rp = new RegistrationPage();
		sp = new SignupPage();
		p = new PinPage();
		pp = new ProfilePage();
		fwv = new FromWelcomeVidPage();
		p9 = new Phq9Page();
		g7 = new Gad7Page();
		p15 = new Phq15Page();
		p10 = new Pss10Page();
		si = new Stress_inventoryPage();
		uf = new User_factsPage();
		rur = new ReturnUserRegistrationPage();
	}

	// invocationCount = 6,
	@Test(invocationCount = 6, description = "Participent will fill up till dashboard only ")
	public void registration_E2E_WithoutPhnNum() throws Throwable {

		sp = rp.click_signupLink();
		p = sp.signup_Details();
		pp = p.verifyPin();
		fwv = pp.clickNext();
		d = fwv.inputProfileDetails();
		d.verify_text7();
		// Thread.sleep(3000);

		// Logout Method
		d.logoutM();

	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
