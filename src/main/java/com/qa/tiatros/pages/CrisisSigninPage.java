package com.qa.tiatros.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class CrisisSigninPage extends TestBase{

	/** Page factory - OR **/

	By pageHeaderText = By.xpath("//h2[contains(text(),'Welcome to Tiatros')]");
	By email = By.id("user_email");
	By pass = By.id("user_password");
	By login = By.xpath("//input[@name='commit']");

	@FindBy(xpath = "//a[contains(text(),'help@tiatros.com')]")
	WebElement mailID;

	@FindBy(xpath = "//span[@class = 'action_links'][3]")
	WebElement unlock;

	@FindBy(xpath = "//a[contains(text(),\"Didn't receive confirmation instructions?\")]")
	WebElement confirmation_instructions;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgot_pass;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement verification_text_signedoutseccess;

	@FindBy(xpath = "//div[@class='toast toast-success']")
	WebElement verification_popup_forgotpass;

	@FindBy(xpath = "//div[@class='toast toast-error']")
	WebElement verification_popup_accountlocked;

	/** All Verifications and Validations **/

	public void pageValidation() {
		UtilTest.textValidation(pageHeaderText, "Welcome to Tiatros");
	}

	public void mail_id_verification() {
		boolean vt1 = mailID.isDisplayed();
		Assert.assertEquals(vt1, true);
	}

	public void unLock_verification() {
		boolean vt2 = unlock.isDisplayed();
		Assert.assertEquals(vt2, true);
	}

	public void signedout_success() {
		boolean success = verification_text_signedoutseccess.isDisplayed();
		Assert.assertEquals(success, true);
	}

	public void forget_password_success() {
		boolean forget_password = verification_popup_forgotpass.isDisplayed();
		Assert.assertEquals(forget_password, true);
	}

	public void accountlocked_success() {
		boolean forget_password = verification_popup_accountlocked.isDisplayed();
		Assert.assertEquals(forget_password, true);
	}

	/*****************************
	 * Business Component
	 *****************************/

	public void signin() throws Exception {
		driver.navigate().to(prop.getProperty("Url1"));
		pageValidation();
		UtilTest.doSendKeys(email, prop.getProperty("Email"));
		UtilTest.doSendKeys(pass, prop.getProperty("Password"));
		UtilTest.click_js(login);
	}

}
