package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_READY_Page extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'Ready Participant List')]")
	WebElement readyPage_text;

	@FindBy(xpath = "//a[contains(text(),'Assigned')]")
	WebElement assigned;

	// Initializing the page object

	public Moderator_READY_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_READY_Page() {
		String vt = readyPage_text.getText();
		Assert.assertEquals(vt, "Ready Participant List",
				"Ready Participant List Text Not Found in READY Page, Contact Developer");
	}

	// Business Component

	public Moderator_ASSIGNED_Page click_assigned() throws Throwable {
		UtilTest.click_js(assigned);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("AssignedParticipant_Page");
		return new Moderator_ASSIGNED_Page();
	}

}
