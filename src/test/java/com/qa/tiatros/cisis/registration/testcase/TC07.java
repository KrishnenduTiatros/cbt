package com.qa.tiatros.cisis.registration.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tiatros.base.Base;
import com.qa.tiatros.page.All_moderator_Page;
import com.qa.tiatros.page.Moderator_CONFIRMED_Page;
import com.qa.tiatros.page.PreCorseDashboardPage;
import com.qa.tiatros.page.Pss10Page;
import com.qa.tiatros.page.SigninPage;

public class TC07 extends Base {

	PreCorseDashboardPage pd;
	Pss10Page p10;
	SigninPage sp;
	All_moderator_Page almp;
	Moderator_CONFIRMED_Page mcp;

	public TC07() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SigninPage();
		pd = new PreCorseDashboardPage();
		p10 = new Pss10Page();
		almp = new All_moderator_Page();
		mcp = new Moderator_CONFIRMED_Page();
	}

	@Test(invocationCount = 1, description = "Check User able to login to the system and complete the full registration flow, who have done half registration process previously.\n"
			+ " 1. Login to Moderator \n" + " 2. Select Participants -> Confirmed section \n"
			+ " 3. Select Course name\n"
			+ " 4. Click on the \"Date Registered\"(so that latest participants comes first)\n"
			+ " 5. Pick the first Email ID and Log out\n"
			+ " 6. Login with that Email ID and complete the registration flow")
	public void pickUserFromConfirmed() throws Throwable {
		almp = sp.signin_Moderator();
		mcp = almp.gotoConfirmedParticipants();
//		
//		pd.pageValidation();
//		pd.clickAllDashboard();
//		p10 = pd.pss10Question();
//		p10.verify_text11();
//		p10.pss10_Dynamic_Click();
		pd.logoutM();
	}

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}

}
