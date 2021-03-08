package com.qa.tiatros.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.LandingPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class LandingTest extends TestBase

{
	
	LandingPage lp;
	
	@Test(enabled=true)
	public void setupTest()
	{
		lp = new LandingPage();
		lp.verify_loginpage_title();
		lp.verify_logo_landingpage();
		
	}
	
	
	@Test(enabled=true)
	public void click_Register()
	{
		lp = new LandingPage();
		lp.register_Button();
		
	}

	@Test(enabled=true)
	public void click_login()
	{
		lp = new LandingPage();
		lp.signin_Button();
	}
}
