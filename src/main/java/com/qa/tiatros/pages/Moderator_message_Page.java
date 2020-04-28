package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_message_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'My Messages')]")
	WebElement mYmessage_homepage;

	@FindBy(xpath = "//span[contains(text(),'Facilitator Tools')]")
	WebElement faci_tool;

	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	WebElement messages;

	@FindBy(xpath = "//span[contains(text(),'Channels')]")
	WebElement channels;

	// Initializing the page object

	public Moderator_message_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_MyMessage_LandingPage() {
		boolean vt = mYmessage_homepage.isDisplayed();
		Assert.assertEquals(vt, true, "My Message Landing Page Not Found Check With Developer");
	}

	// Business Component

	public Moderator_Channels_Page click_Channels() throws Throwable {
		UtilTest.click_js(channels);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("Channels_Landing_Page");
		return new Moderator_Channels_Page();
	}

}
