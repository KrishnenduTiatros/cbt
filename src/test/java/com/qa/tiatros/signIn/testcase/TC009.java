/*** Check the unlock functionlity with wrong password for 5 times and check the validation message in last hit   ***/
/*** Author - Krishnendu Saha  ***/

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
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.pages.UnlockPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC009 extends TestBase {
	
	// Global object declairation

	SignupPage sp;
	SigninPage sgn;
	UnlockPage unlp;

	public TC009() {
		super();
	}

	// This Before Method will run always before any @Test.
	@BeforeMethod
	public void initobjects() throws Exception {
		init();
		sp = new SignupPage();
		sgn = new SigninPage();
		unlp = new UnlockPage();
	}

	// Method:- Click on the Didn't receive confirmation instructions link and press
	// the back button to check
	// the UI design
	@Test
	public void tc009_signIN() throws Throwable {

		sgn.verify_text12();
		sgn.lock_account();
		sgn.accountlocked_success();
		unlp = sgn.click_Unlock_Link();
		unlp.verify_UnlockPage();
		
	}

	// This AfterMethod will run every time after any @Test
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
