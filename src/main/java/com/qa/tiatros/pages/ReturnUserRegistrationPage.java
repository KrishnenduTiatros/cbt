package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class ReturnUserRegistrationPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//h2[contains(text(),'Program Registration')]")
	WebElement verify_text14;

	@FindBy(xpath = "//input[@id='coupon_code']")
	WebElement return_coupon_code;

	@FindBy(xpath = "//button[@id='validate']")
	WebElement validate_coupon;
	
	@FindBy(xpath = "//h3[contains(text(),'Select a Start Date')]//following-sibling::div[1]/div[1]/div")
	WebElement check_box;

	@FindBy(xpath = "//input[@id='submit_profile']")
	WebElement save;
	
	// Initializing the page object
	public ReturnUserRegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text14() {
		boolean vt = verify_text14.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public DashboardPage click_signupLink() throws Throwable {
	
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, return_coupon_code, UtilTest.readExcel("ReturnUser", prop.getProperty("TestCase"), "R_Coupon")); // Reading data from xlsx file     //prop.getProperty("R_Coupon")
		Thread.sleep(2000);
		UtilTest.element_click(driver, validate_coupon);
		Thread.sleep(4000);
		UtilTest.element_click(driver, check_box);
		Thread.sleep(2000);
		UtilTest.element_click(driver, save);
		return new DashboardPage();
	}
}
