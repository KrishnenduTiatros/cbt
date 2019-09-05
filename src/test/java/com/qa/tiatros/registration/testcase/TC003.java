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

	@Test(enabled = true) // This test will check for inventory stress sector message and also click on it
	public void inventory_Your_Stress() throws Exception {
		sgn.verify_text12();
		d = sgn.signin();
		d.verify_text15();
		d.click_inventory_your_stress();
		d.verify_text17();
	}

	@Test(enabled = true) // This test will click on the NPS scale
	public void scale_select() throws Throwable {
		sgn.verify_text12();
		d = sgn.signin();
		d.scale_click();

	}

	@Test(enabled = true)
	public void click_phq9Page_after_SignIN() throws Exception // to run this test first change the URL to URL1 in
																// TestBase class and insert the mail-id in properties
																// file and save it
	{

		sgn.verify_text12();
		d = sgn.signin();
		p9 = d.phq9Question();
		p9.verify_text8();
		p9.phq9_Dynamic_Click();

	}

	@Test(enabled = true)
	public void click_pss10Page_after_SignIN() throws Exception // to run this test first change the URL to URL1 in
																// TestBase class and insert the mail-id in properties
																// file and save it
	{

		sgn.verify_text12();
		d = sgn.signin();
		p10 = d.pss10Question();
		p10.verify_text11();
		p10.pss10_Dynamic_Click();
	}

	@Test(enabled = true)
	public void click_phq15page_after_SignIN() throws Exception // to run this test first change the URL to URL1 in
																// TestBase class and insert the mail-id in properties
																// file and save it
	{

		sgn.verify_text12();
		d = sgn.signin();
		p15 = d.phq15Question();
		p15.verify_text10();
		p15.phq15_Dynamic_Click();
	}

	@Test(enabled = true)
	public void click_gad7page_after_SignIN() throws Exception // to run this test first change the URL to URL1 in
																// TestBase class and insert the mail-id in properties
																// file and save it
	{
		sgn = new SigninPage();
		sgn.verify_text12();
		d = sgn.signin();
		g7 = d.gad7Question();
		g7.verify_text9();
		g7.gad7_Dynamic_Click();
	}

	@Test(enabled = true)
	public void click_StressInventorypage_after_SignIN() throws Exception // to run this test first change the URL to
																			// URL1 in TestBase class and insert the
																			// mail-id in properties file and save it
	{
		sgn = new SigninPage();
		sgn.verify_text12();
		d = sgn.signin();
		si = d.stress_inventoryQuestion();
		si.verify_text12();
		si.stress_inventory_CheckBox();
	}

	@Test(enabled = true)
	public void click_userfactspage_after_SignIN() throws 
Throwable
																	// TestaBase class and insert the mail-id in
																	// properties file and save it
	{
		sgn = new SigninPage();
		sgn.verify_text12();
		d = sgn.signin();
		uf = d.user_factsQuestion();
		uf.verify_text13();
		uf.user_facts_details();
	}
	

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}
}
