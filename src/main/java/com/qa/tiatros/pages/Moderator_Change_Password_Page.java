package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.model.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_Change_Password_Page extends TestBase 
{
	// Page factory - OR

		
		@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Change Password')]")
		WebElement password_text;
		
		@FindBy(xpath = "//a[contains(text(),'Monitor & Nudge')]")
		WebElement nudge;

		// Initializing the page object

		public Moderator_Change_Password_Page() {
			PageFactory.initElements(driver, this);
		}

		// All Verifications and Validations

		public void verify_password_LandingPage() {
			String vt = password_text.getText();
			Assert.assertEquals(vt, "Change Password",
					"Change Password Text Not Found in Change Password Page, Contact Developer");
		}

		// Business Component

		public Moderator_Nudge_Page click_Nudge() throws Throwable {
			UtilTest.click_js(nudge);
			Thread.sleep(2000);
			UtilTest.staticScreenShot("Nudge_Landing_Page");
			return new Moderator_Nudge_Page();
		}

}
