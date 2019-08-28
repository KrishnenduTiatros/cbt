package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class SigninPage extends TestBase {

	String Url1 = "https://cbtfuture.tiatros.com/users/sign_in";

	/** Page factory - OR **/

	@FindBy(xpath = "//h2[contains(text(),'Welcome to Tiatros ')]")
	WebElement verification_text12;

	@FindBy(id = "user_email")
	WebElement email;

	@FindBy(id = "user_password")
	WebElement pass;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement sub;

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

	/** Initializing the page object **/

	public SigninPage() {
		PageFactory.initElements(driver, this);
	}

	/** All Verifications and Validations **/

	public void verify_text12() throws Exception {
		driver.navigate().to(Url1);
		Thread.sleep(2000);
		boolean vt = verification_text12.isDisplayed();
		Assert.assertEquals(vt, true);
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

	/** Business Component **/

	public DashboardPage signin() throws Exception {
		UtilTest.sendkeys(driver, email, prop.getProperty("Email"));
		UtilTest.sendkeys(driver, pass, prop.getProperty("Password"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		return new DashboardPage();
	}

	public CourseDashboardPage signin_Course() throws Exception {
		UtilTest.sendkeys(driver, email, prop.getProperty("Email"));
		UtilTest.sendkeys(driver, pass, prop.getProperty("Password"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		return new CourseDashboardPage();
	}

	public All_moderator_Page signin_Moderator() throws Exception {
		UtilTest.sendkeys(driver, email, prop.getProperty("M_username"));
		UtilTest.sendkeys(driver, pass, prop.getProperty("M_password"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		return new All_moderator_Page();

	}

	public void click_mailID() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, mailID);
		Thread.sleep(5000);
	}

	public PasswordPage click_ForgetPasswordLink() {
		UtilTest.element_click(driver, forgot_pass);
		return new PasswordPage();
	}

	public ConfirmationPage click_ConfirmationInstructionsLink() {
		UtilTest.element_click(driver, confirmation_instructions);
		return new ConfirmationPage();
	}

	public UnlockPage click_Unlock_Link() {
		UtilTest.element_click(driver, unlock);
		return new UnlockPage();
	}

	public void lock_account() throws Throwable {
		UtilTest.sendkeys(driver, email, prop.getProperty("Email"));
		UtilTest.sendkeys(driver, pass, prop.getProperty("InValidPass"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, pass, prop.getProperty("InValidPass"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, pass, prop.getProperty("InValidPass"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, pass, prop.getProperty("InValidPass"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, pass, prop.getProperty("InValidPass"));
		Thread.sleep(2000);
		UtilTest.element_click(driver, sub);
		Thread.sleep(3000);
	}

}
