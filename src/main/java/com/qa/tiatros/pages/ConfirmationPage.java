package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class ConfirmationPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement email;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement resend;

	@FindBy(xpath = "//h2[contains(text(),'Resend confirmation instructions')]")
	WebElement verification_text_confirmation1;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement verification_text_con2;

	@FindBy(xpath = "//strong[contains(text(),'2017, 2018, 2019 © Tiatros® Inc. All Rights Reserv')]")
	WebElement con3;

	@FindBy(xpath = "//img[@class='logo']")
	WebElement tiatros_logo;

	// Initializing the page object

	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_ConfirmationPage() throws Exception {

		boolean vt = tiatros_logo.isDisplayed();
		Assert.assertTrue(true, "Logo Not Displayed !!! ");

		boolean vt1 = verification_text_confirmation1.isDisplayed();
		Assert.assertTrue(true, "Resend confirmation instructions--- Text Not Found");

		boolean vt3 = verification_text_con2.isDisplayed();
		Assert.assertTrue(true, "Forgot your password? --- Text Not Found");

		boolean vt4 = con3.isDisplayed();
		Assert.assertTrue(true, "Footer Not Found Error!!!");
		Assert.assertTrue(vt4, "Footer Not Found Error!!!");

	}

	// Business Component

	public void click_BrowserBackButton() throws Throwable {
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(3000);
	}

	public void click_ResendButton() throws Throwable {

		Thread.sleep(2000);
		UtilTest.element_click(driver, resend);
		Thread.sleep(3000);
	}

	public void click_WithValidemail() throws Throwable {

		Thread.sleep(1000);
		UtilTest.sendkeys(driver, email, prop.getProperty("Email"));
		UtilTest.element_click(driver, resend);
		Thread.sleep(3000);
	}

	public void click_WithINValidemail() throws Throwable {

		Thread.sleep(1000);
		UtilTest.sendkeys(driver, email, prop.getProperty("InValidEmail"));
		UtilTest.element_click(driver, resend);
		Thread.sleep(3000);
	}

}
