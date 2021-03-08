package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class UnlockPage extends TestBase {
	
	// Page factory - OR

	@FindBy(xpath = "//img[@class='logo']")
	WebElement tiatros_logo;

	@FindBy(xpath = "//h2[contains(text(),'Resend unlock instructions')]")
	WebElement verification_text_unlock1;

	@FindBy(xpath = "//strong[contains(text(),'2017, 2018, 2019 © Tiatros® Inc. All Rights Reserv')]")
	WebElement con3;

	@FindBy(xpath = "//p[@class='registertxt']")
	WebElement already_account;

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement email;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement resend;
	
	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement verification_message_sucess;

	// Initializing the page object

	public UnlockPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_UnlockPage() throws Exception {

		boolean vt = tiatros_logo.isDisplayed();
		Assert.assertEquals(vt, true);

		boolean vt1 = verification_text_unlock1.isDisplayed();
		Assert.assertEquals(vt1, true);

		boolean vt3 = already_account.isDisplayed();
		Assert.assertEquals(vt3, true);

		boolean vt4 = con3.isDisplayed();
		Assert.assertEquals(vt4, true);
		
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
		boolean vt4 = verification_message_sucess.isDisplayed();
		Assert.assertEquals(vt4, true);
		Thread.sleep(3000);
	}

	public void click_WithINValidemail() throws Throwable {

		Thread.sleep(1000);
		UtilTest.sendkeys(driver, email, prop.getProperty("InValidEmail"));
		UtilTest.element_click(driver, resend);
		Thread.sleep(3000);
	}
}