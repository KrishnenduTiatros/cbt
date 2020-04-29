package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_COMPLETE_Page extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'Completed Participant List')]")
	WebElement complPage_text;

	@FindBy(xpath = "//a[contains(text(),'Removed')]")
	WebElement remov;

	// Initializing the page object

	public Moderator_COMPLETE_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_COMPLETE_Page() {
		String vt = complPage_text.getText();
		Assert.assertEquals(vt, "Completed Participant List",
				"Completed Participant List Text Not Found in Complete Page, Contact Developer");
	}

	// Business Component

	public Moderator_REMOVED_Page click_Remove() throws Throwable {
		UtilTest.click_js(remov);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("RemovedParticipant_Page");
		return new Moderator_REMOVED_Page();
	}

}
