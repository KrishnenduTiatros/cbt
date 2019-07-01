package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class ProfilePage extends TestBase {
	
	// Page factory - OR

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement ok_button;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement next_button;

	@FindBy(xpath = "//h2[starts-with(text(),'Welcome to Tiatros')]")
	WebElement verification_text5;

	// Initializing the page object

	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text5() {
		boolean vt = verification_text5.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public FromWelcomeVidPage clickNext() throws InterruptedException {
		UtilTest.element_click(driver, ok_button);
		Thread.sleep(3000);
		UtilTest.element_click(driver, next_button);
		return new FromWelcomeVidPage();
		

	}

}
