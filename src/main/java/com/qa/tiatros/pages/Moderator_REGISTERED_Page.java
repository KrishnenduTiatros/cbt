package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_REGISTERED_Page extends TestBase {
	
	// Page factory - OR
	
	@FindBy(xpath = "//small[contains(text(),'Registered Participant List')]")
	WebElement registerPage_text;

	@FindBy(xpath = "//a[contains(text(),'Confirmed')]")
	WebElement confirmed;

	@FindBy(xpath = "//a[contains(text(),'Course List')]")
	WebElement courses_List;

	@FindBy(xpath = "//a[contains(text(),'Course Preview')]")
	WebElement courses_Preview;

	// Initializing the page object

	public Moderator_REGISTERED_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_REGISTERED_Page() {
		String vt = registerPage_text.getText();
		Assert.assertEquals(vt, "Registered Participant List",
				"Registered Participant List Text Not Found in Registered Participant List Page, Contact Developer");
	}

	// Business Component

	public Moderator_CONFIRMED_Page click_Confirmed() throws Throwable {
		UtilTest.click_js(confirmed);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("ConfirmedParticipant_Page");
		return new Moderator_CONFIRMED_Page();
	}

}
