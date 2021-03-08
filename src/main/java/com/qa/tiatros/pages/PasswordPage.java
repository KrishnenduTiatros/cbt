package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class PasswordPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//img[@class='logo']")
	WebElement tiatros_logo;

	@FindBy(xpath = "//label[@for='user_email']")
	WebElement verification_text_pass2;

	@FindBy(xpath = "//h2[contains(text(),'Forgot your password?')]")
	WebElement verification_text_pass1;

	@FindBy(xpath = "//strong[contains(text(),'2017, 2018, 2019 © Tiatros® Inc. All Rights Reserv')]")
	WebElement verification_text_pass3;

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement pass_email;

	@FindBy(xpath = "//input[@value='SEND']")
	WebElement send_button;

	@FindBy(xpath = "//a[contains(text(),'Didn't receive confirmation instructions?')]")
	WebElement verification_link_pass1;

	// Initializing the page object

	public PasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_passwordPage() throws Exception {
	
		boolean vt = tiatros_logo.isDisplayed();
		Assert.assertEquals(vt, true);
	
		boolean vt1 = verification_text_pass2.isDisplayed();
		Assert.assertEquals(vt1, true);
		
		boolean vt2 = verification_text_pass1.isDisplayed();
		Assert.assertEquals(vt2, true);
	
		boolean vt3 = verification_text_pass3.isDisplayed();
		Assert.assertEquals(vt3, true);
		
//		boolean vt4 = verification_link_pass1.isDisplayed();
//		Assert.assertEquals(vt4, true);
	}

	// Business Component

	public void click_BrowserBackButton() throws Throwable {

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	public void click_SendButton() throws Throwable {

		Thread.sleep(1000);
		UtilTest.element_click(driver, send_button);
		Thread.sleep(3000);
	}
	
	public void click_WithValidemail() throws Throwable {

		Thread.sleep(1000);
		UtilTest.sendkeys(driver, pass_email, prop.getProperty("Email"));
		UtilTest.element_click(driver, send_button);
		Thread.sleep(3000);
	}

	public void click_WithINValidemail() throws Throwable {

		Thread.sleep(1000);
		UtilTest.sendkeys(driver, pass_email, prop.getProperty("InValidEmail"));
		UtilTest.element_click(driver, send_button);
		Thread.sleep(3000);
	}
}
