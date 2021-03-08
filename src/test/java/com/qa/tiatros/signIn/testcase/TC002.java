/*** Click on the forget password link and dont enter any thing in the textbox and press send button  ***/
/*** Author - Krishnendu Saha ***/


package com.qa.tiatros.signIn.testcase;

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
import com.qa.tiatros.pages.PasswordPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;


public class TC002 extends TestBase {
	
	// Global object declairation

	SignupPage sp;
	SigninPage sgn;
	PasswordPage pass;

	public TC002() {
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
	public void tc002_signIN() throws Throwable {

		sgn.verify_text12();
		pass = sgn.click_ForgetPasswordLink();
		pass.verify_passwordPage();
		pass.click_SendButton();
	}
	
	// This AfterMethod will run every time after any @Test
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
