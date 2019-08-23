/*** Click on the mailid  link  **/
/** Author - Krishnendu Saha **/

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
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.util.CustomListener;

@Listeners(CustomListener.class)
public class TC013 extends TestBase {

	SignupPage sp;
	SigninPage sgn;

	public TC013() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		sp = new SignupPage();
		sgn = new SigninPage();
	}

	@Test 
	public void mail_Verification() throws Throwable
	{
		sgn.verify_text12();
		//sgn.unLock_verification();
		sgn.mail_id_verification();
		sgn.click_mailID();
		sgn.unLock_verification();
	}
	

	@AfterMethod
	public void tearDown() // This AfterMethod will run every time after any @Test
	{
		driver.quit();
	}
}
