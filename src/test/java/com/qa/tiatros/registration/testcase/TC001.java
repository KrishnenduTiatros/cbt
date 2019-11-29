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
public class TC001 extends TestBase {

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

	public TC001() {
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

	//invocationCount = 6,
	@Test( invocationCount = 4, description = "This Test case will run End to END Registration without phn number")
	public void registration_E2E_WithoutPhnNum() throws Throwable {

		sp = rp.click_signupLink();
		p = sp.signup_Details();
		pp = p.verifyPin();
		fwv = pp.clickNext();
		d = fwv.inputProfileDetails();
		d.verify_text7();

		// Phq9 page call
		p9 = d.phq9Question();
		p9.verify_text8();
		p9.phq9_Dynamic_Click();

		// Gad7 page call
		g7 = d.gad7Question();
		g7.verify_text9();
		g7.gad7_Dynamic_Click();

		// Phq15 Page call
		p15 = d.phq15Question();
		p15.verify_text10();
		p15.phq15_Dynamic_Click();

		// Phq10 Page call
		p10 = d.pss10Question();
		p10.verify_text11();
		p10.pss10_Dynamic_Click();

		// User facts
		uf = d.user_factsQuestion();
		uf.verify_text13();
		uf.user_facts_details();

		// Stress Inventory Sections

		si = d.stress_inventoryQuestion();
		si.verify_text12();
		si.stress_inventory_CheckBox();

		// Pledge call
		//d.pledge();

		d.scale_click();
		d.course_complete();

		// Logout Method
		d.logoutM();

	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
