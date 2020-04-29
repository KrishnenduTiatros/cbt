package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_NPS_Score_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'NPS Score')]")
	WebElement nps_text;
	
	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Facilitator Tools')]")
	WebElement faci_breadcrumb;
	
	@FindBy(xpath = "//a[contains(text(),'Monitor & Nudge')]")
	WebElement nudge;

	// Initializing the page object

	public Moderator_NPS_Score_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_NPS_LandingPage() {
		String vt = nps_text.getText();
		Assert.assertEquals(vt, "NPS Score",
				"NPS Score Text Not Found in NPS Page, Contact Developer");
	}

	// Business Component

	public Moderator_Nudge_Page click_Nudge() throws Throwable {
		UtilTest.click_js(nudge);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("Nudge_Landing_Page");
		return new Moderator_Nudge_Page();
	}

}
