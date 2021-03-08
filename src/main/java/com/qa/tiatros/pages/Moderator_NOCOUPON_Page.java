package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_NOCOUPON_Page extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'No Coupon Participant List')]")
	WebElement noPage_text;

	@FindBy(xpath = "//a[contains(text(),'Others (No Coupon)')]")
	WebElement nocoup;

	// Initializing the page object

	public Moderator_NOCOUPON_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_NOCOUPON_Page() {
		String vt = noPage_text.getText();
		Assert.assertEquals(vt, "No Coupon Participant List",
				"No Coupon Participant List Text Not Found in NoCoupon Page, Contact Developer");
	}

	// Business Component

}
