package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class PinPage extends TestBase {

	// Page factory - OR
	
	@FindBy(xpath = "//input[@id='verify_pin_link']")
	WebElement verify_pin;

	@FindBy(xpath = "//h2[contains(text(),'Check Your Email!')]")
	WebElement verification_text4;
	
	@FindBy(xpath = "//input[@placeholder='Enter your PIN']")
	WebElement enterPin;
	

	// Initializing the page object

	public PinPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text4() {
		boolean vt = verification_text4.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public ProfilePage verifyPin() throws Throwable {
		String pin = UtilTest.fetchGmailPin("krishnendu@tiatros.com", "q1w2e3R$");
		UtilTest.sendkeys(driver, enterPin, pin);
		UtilTest.click_js(verify_pin);
		//UtilTest.writeExcel("SignUP", prop.getProperty("TestCase"), "Email");
		return new ProfilePage();
	}
}