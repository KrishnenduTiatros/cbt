package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class SignupPage extends TestBase

{
	// Page factory - OR

	@FindBy(xpath = "//input[@id='user_first_name']")
	WebElement first_name;

	@FindBy(xpath = "//input[@id='user_last_name']")
	WebElement last_name;

	@FindBy(xpath = "//input[@id='user_email']")
	WebElement user_email;

	@FindBy(xpath = "//input[@id='user_password']")
	WebElement user_pass;

	@FindBy(xpath = "//input[@id='sign_up_token']")
	WebElement user_token;

	@FindBy(xpath = "//input[@id='user_terms_of_service']//following::ins[@class='iCheck-helper']")
	WebElement user_checkbox;
	
	@FindBy(xpath = "//div[@class='modal-content animated bounceInRight']//div[3]//following::button[@class='btn btn-primary m-r-xs'][2]")
	WebElement term_use;

	@FindBy(xpath = "//input[@id='register']")//div[@class='form-group text-center']//input[@id='register']
	WebElement user_register;
	
	@FindBy(xpath = "//h2[contains(text(),'Program Registration')]")
	WebElement verification_text2;
	
	@FindBy(xpath = "//p[contains(text(),'Already have an account? ')]")
	WebElement verification_text3;

	// Initializing the page object

	public SignupPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations
	
	public void verify_text2(){
		boolean vt = verification_text2.isDisplayed();
		Assert.assertEquals(vt, true);
	}
	
	public void verify_text3(){
		boolean vt = verification_text3.isDisplayed();
		Assert.assertEquals(vt, true);
	}
	
	// Business Component
	
	public PinPage signup_Details() throws Throwable
	{
		
		// Inserting all Data through xcel file for signup page
		Thread.sleep(4000);
		UtilTest.sendkeys(driver, first_name, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "FirstName"));   //  prop.getProperty("FirstName")
		UtilTest.sendkeys(driver, last_name, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "LastName") );    //  prop.getProperty("LastName")
		UtilTest.sendkeys(driver, user_email, UtilTest.emailidgenerate());
		UtilTest.sendkeys(driver, user_pass, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Password"));     // prop.getProperty("Password")
		UtilTest.sendkeys(driver, user_token, prop.getProperty("Coupon"));	  //  prop.getProperty("Coupon") UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Coupon")
		Thread.sleep(3000);
		// UtilTest.click(driver, user_checkbox);
		user_checkbox.click();
		UtilTest.element_click(driver, term_use);
		Thread.sleep(3000);
		UtilTest.element_click(driver, user_register);
		Thread.sleep(7000);
		return new PinPage();
	}
}
