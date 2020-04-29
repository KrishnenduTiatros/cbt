package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_CONFIRMED_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'Confirmed Participant List')]")
	WebElement confirmPage_text;

	@FindBy(xpath = "//a[contains(text(),'Ready')]")
	WebElement ready;

	// Initializing the page object

	public Moderator_CONFIRMED_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_CONFIRMED_Page() {
		String vt = confirmPage_text.getText();
		Assert.assertEquals(vt, "Confirmed Participant List",
				"Confirmed Participant List Text Not Found in Confirmed Page, Contact Developer");
	}

	// Business Component

	public Moderator_READY_Page click_Ready() throws Throwable {
		UtilTest.click_js(ready);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("ReadyParticipant_Page");
		return new Moderator_READY_Page();
	}

}
