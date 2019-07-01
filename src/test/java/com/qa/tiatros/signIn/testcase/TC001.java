/*** Click on the forget password link and press the back button to check the UI design **/
/** Author - Krishnendu Saha **/

package com.qa.tiatros.signIn.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.PasswordPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC001 extends TestBase {
	
	// Global object declairation

	SignupPage sp;
	SigninPage sgn;
	PasswordPage pass;

	public TC001() {
		super();
	}
	
	// This Before Method will run always before any @Test.
	@BeforeMethod
	public void initobjects() throws Exception { 
		init();
		sp = new SignupPage();
		sgn = new SigninPage();
		pass = new PasswordPage();

	}

	// Method:- Click on the forget password link and press the back button to check the UI design 
	@Test
	public void tc001_signIN() throws Throwable {

		sgn.verify_text12();
		pass = sgn.click_ForgetPasswordLink();
		pass.click_BrowserBackButton();
		//sgn.signedout_success();
	}
	
	// This AfterMethod will run every time after any @Test

	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
