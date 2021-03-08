package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_REMOVED_Page extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'Removed Participant List')]")
	WebElement removPage_text;

	@FindBy(xpath = "//a[contains(text(),'Others (No Coupon)')]")
	WebElement nocoup;

	// Initializing the page object

	public Moderator_REMOVED_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_REMOVED_Page() {
		String vt = removPage_text.getText();
		Assert.assertEquals(vt, "Removed Participant List",
				"Removed Participant List Text Not Found in Removed Page, Contact Developer");
	}

	// Business Component

	public Moderator_NOCOUPON_Page click_nocoupon() throws Throwable {
		UtilTest.click_js(nocoup);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("NoCoupon_Landing_Page");
		return new Moderator_NOCOUPON_Page();
	}

}
