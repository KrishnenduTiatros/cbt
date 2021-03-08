package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class LandingPage extends TestBase

{
	// UtilTest ut = new UtilTest();

	// Page factory - OR

	@FindBy(xpath = "//h1[contains(text(),'Welcome to CBT')]")
	WebElement validationText1;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement register;

	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	WebElement signin;

	@FindBy(xpath = "//img[@alt='Tiatros Logo']")
	WebElement logo;

	// Initializing the page object
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	// All Verifications and Validations

		public void verify_loginpage_title() {
			String title = driver.getTitle();
			Assert.assertEquals("Program - Tiatros", title);
		}

		public void verify_logo_landingpage() {
			boolean l = logo.isDisplayed();
			Assert.assertEquals(l, true);
		}
	
	
	
	// Business Component

	public void register_Button(){
		UtilTest.element_click(driver, signin);

	}

	public void signin_Button() {
		UtilTest.element_click(driver, register);

	}

	

}
