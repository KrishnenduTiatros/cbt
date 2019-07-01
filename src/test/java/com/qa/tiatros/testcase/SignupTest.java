package com.qa.tiatros.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.FromWelcomeVidPage;
import com.qa.tiatros.pages.PinPage;
import com.qa.tiatros.pages.ProfilePage;
import com.qa.tiatros.pages.RegistrationPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class SignupTest extends TestBase 
{	
	RegistrationPage rp;
	SignupPage sp;
	PinPage p;
	ProfilePage pp;
	FromWelcomeVidPage fwv;
	DashboardPage d;

	public SignupTest() {
		super();
	}
	
	@BeforeMethod	
	public void initobjects() throws Exception {
		init();
		rp = new RegistrationPage();
		sp = new SignupPage();
		p = new PinPage();
		pp = new ProfilePage();
		fwv = new FromWelcomeVidPage();
	}

	@Test(enabled = true)
	public void signup_TillDashboard() throws Throwable 
	{
		rp.verify_logo_Registrationpage();
		rp.verify_text1();
		sp = rp.click_signupLink();
		p = sp.signup_Details();
		p.verify_text4();
		pp = p.verifyPin();
		pp.verify_text5();
		fwv = pp.clickNext();
		d = fwv.inputProfileDetails();
	}

	@Test(enabled = true)
	public void validationAndVerification_Signup() throws Exception {
		rp.verify_logo_Registrationpage();
		rp.verify_text1();
		sp = rp.click_signupLink();
		sp.verify_text2();
		sp.verify_text3();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
