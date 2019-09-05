package com.qa.tiatros.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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
public class TC003 extends TestBase {

	SignupPage sp;
	SigninPage sgn;
	DashboardPage d;
	Phq9Page p9;
	Gad7Page g7;
	Phq15Page p15;
	Pss10Page p10;
	Stress_inventoryPage si;
	User_factsPage uf;

	public TC003() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		d = new DashboardPage();
		sgn = new SigninPage();
		p9 = new Phq9Page();
		g7 = new Gad7Page();
		p15 = new Phq15Page();
		p10 = new Pss10Page();
		si = new Stress_inventoryPage();
		uf = new User_factsPage();
	}

	@Test(description = "Participents who had been terminated in profile update page not completed Dashboard page activity")
	public void direct_Dashboard() throws Throwable {

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
		d.pledge();

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
