/*** Click on the Didn't receive confirmation instructions link and press the back button to check the UI design    **/
/** Author - Krishnendu Saha **/

package com.qa.tiatros.signIn.testcase;

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
import com.qa.tiatros.pages.ConfirmationPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC005 extends TestBase {
	// Global object declairation

	SignupPage sp;
	SigninPage sgn;
	ConfirmationPage conp;

	public TC005() {
		super();
	}

	// This Before Method will run always before any @Test.
	@BeforeMethod
	public void initobjects() throws Exception {
		init();
		sp = new SignupPage();
		sgn = new SigninPage();
		conp = new ConfirmationPage();
	}

	// Method:- Click on the Didn't receive confirmation instructions link and press
	// the back button to check
	// the UI design
	@Test
	public void tc005_signIN() throws Throwable {

		sgn.verify_text12();
		conp = sgn.click_ConfirmationInstructionsLink();
		conp.verify_ConfirmationPage();
		conp.click_BrowserBackButton();
	}

	// This AfterMethod will run every time after any @Test
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
