package com.qa.tiatros.testcase;

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
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.FromWelcomeVidPage;
import com.qa.tiatros.pages.PinPage;
import com.qa.tiatros.pages.ProfilePage;
import com.qa.tiatros.pages.RegistrationPage;
import com.qa.tiatros.pages.SignupPage;

public class RegistrationTest extends TestBase 

{
	RegistrationPage rp;
	SignupPage sp;
	ProfilePage pp;
	FromWelcomeVidPage fwv;
	DashboardPage d;
	PinPage p;

	public RegistrationTest() {
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
	public void validationAndVerification() {
		
		rp = new RegistrationPage();
		rp.verify_logo_Registrationpage();
		rp.verify_text1();
	}

	@Test(enabled = true)
	public void click_Signup_Link() throws Exception {
		rp = new RegistrationPage();
		sp = new SignupPage(); 
		sp = rp.click_signupLink();

	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
