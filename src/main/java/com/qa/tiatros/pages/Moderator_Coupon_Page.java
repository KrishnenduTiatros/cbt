package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_Coupon_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Coupons')]")
	WebElement coupons_homepage;

	@FindBy(xpath = "//span[contains(text(),'Facilitator Tools')]")
	WebElement faci_tool;

	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	WebElement messages;

	@FindBy(xpath = "//span[contains(text(),'Channels')]")
	WebElement channels;

	@FindBy(xpath = "//span[contains(text(),'Review Content')]")
	WebElement reviewContent;

	@FindBy(xpath = "//span[contains(text(),'Coupons')]")
	WebElement coupons;

	// Initializing the page object

	public Moderator_Coupon_Page() {
			PageFactory.initElements(driver, this);
		}

	// All Verifications and Validations

	public void verify_coupons_LandingPage() {
		String vt = coupons_homepage.getText();
		Assert.assertEquals(vt, "Coupons", "Coupons Text Not Found in Coupon Page, Contact Developer");
	}

	// Business Component

	public Review_goals_assessments_Page click_coupons() throws Throwable {
		
		return new Review_goals_assessments_Page();
	}

}
