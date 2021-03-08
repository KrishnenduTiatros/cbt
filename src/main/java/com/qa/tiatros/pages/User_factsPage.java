package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class User_factsPage extends TestBase {

	@FindBy(xpath = "//label[starts-with(text(),'We look forward to meeting you,')]")
	WebElement verification_text13;

	@FindBy(xpath = "//textarea[@id='user_fact_response']")
	WebElement input_text;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement click_save;
	
	@FindBy(xpath = "//button[@class='confirm']")
	WebElement confirmation;

	// Initializing the page object

	public User_factsPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text13() {
		boolean vt = verification_text13.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public void user_facts_details() throws Throwable {

		UtilTest.sendkeys(driver, input_text, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration() , "User_facts")); //prop.getProperty("TestCase")
		Thread.sleep(2000);
		UtilTest.element_click(driver, click_save);
		Thread.sleep(2000);
//		UtilTest.element_click(driver, confirmation);
//		Thread.sleep(3000);
	}
}
