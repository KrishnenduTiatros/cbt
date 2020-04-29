package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_Nudge_Page extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'Monitor & Nudge')]")
	WebElement nudge_text;

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Facilitator Tools')]")
	WebElement faci_breadcrumb;
	
	@FindBy(xpath = "//a[contains(text(),'Exercise Review & Respond')]")
	WebElement reviewRespond;

	public Moderator_Nudge_Page() {
			PageFactory.initElements(driver, this);
		}

	// All Verifications and Validations

	public void verify_Nudge_LandingPage() {
		String vt = nudge_text.getText();
		Assert.assertEquals(vt, "Monitor & Nudge", "Monitor & Nudge Text Not Found in Nudge Page, Contact Developer");
	}

	// Business Component

	public Moderator_Review_Respond_Page click_reviewRespond() throws Throwable {
		UtilTest.click_js(reviewRespond);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("ReviewRespond_Landing_Page");
		return new Moderator_Review_Respond_Page();
	}

}
