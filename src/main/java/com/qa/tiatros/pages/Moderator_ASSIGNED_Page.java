package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_ASSIGNED_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'Assigned Participant List')]")
	WebElement assiPage_text;

	@FindBy(xpath = "//a[contains(text(),'Completed')]")
	WebElement complet;

	// Initializing the page object

	public Moderator_ASSIGNED_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_ASSIGNED_Page() {
		String vt = assiPage_text.getText();
		Assert.assertEquals(vt, "Assigned Participant List",
				"Assigned Participant List Text Not Found in Assigned Page, Contact Developer");
	}

	// Business Component

	public Moderator_COMPLETE_Page click_complete() throws Throwable {
		UtilTest.click_js(complet);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("CompleteParticipant_Page");
		return new Moderator_COMPLETE_Page();
	}

}
