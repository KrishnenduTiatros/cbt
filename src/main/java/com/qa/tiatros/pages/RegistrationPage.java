package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class RegistrationPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//img[@alt='Tiatros Logo']")
	WebElement logo1;

	@FindBy(xpath = "//h2[contains(text(),'Program Registration')]")
	WebElement verification_text1;

	@FindBy(linkText = "Sign Up")
	WebElement signup_link;
	
	@FindBy(xpath = "//input[@id='user_email']")
	WebElement user_name;
	
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement user_pass;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;

	// Initializing the page object
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_logo_Registrationpage() {
		boolean vt = logo1.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	public void verify_text1() {
		boolean vt = verification_text1.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public SignupPage click_signupLink() throws Exception {
		Thread.sleep(2000);
		UtilTest.element_click(driver, signup_link);
		return new SignupPage();

	}
	
	public ReturnUserRegistrationPage click_login() throws Throwable { // This login for returned user
		Thread.sleep(5000);
		UtilTest.sendkeys(driver, user_name,prop.getProperty("R_username")); //UtilTest.readExcel("ReturnUser", prop.getProperty("TestCase"), "R_username")
		UtilTest.sendkeys(driver, user_pass,prop.getProperty("R_userpass")); //  UtilTest.readExcel("ReturnUser", prop.getProperty("TestCase"), "R_userpass")
		UtilTest.element_click(driver, login);
		return new ReturnUserRegistrationPage();

	}
}
