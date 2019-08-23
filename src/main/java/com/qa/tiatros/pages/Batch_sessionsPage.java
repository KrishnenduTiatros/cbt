package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;

public class Batch_sessionsPage extends TestBase {
	
	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt']")
	WebElement peerReviewText;

	// Initializing the page object

	public Batch_sessionsPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void peerReviewTextVerification() {
		boolean vt = peerReviewText.isDisplayed();
		Assert.assertEquals(vt, true, "My Message Text Not Found");
	}
	
	// Business Component
	
	
	
}
