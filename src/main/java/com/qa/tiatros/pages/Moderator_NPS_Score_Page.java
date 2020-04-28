package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_NPS_Score_Page extends TestBase {
	
	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Flagged Contents')]")
	WebElement reviewContent_homepage;

	// Initializing the page object

	public Moderator_NPS_Score_Page() {
			PageFactory.initElements(driver, this);
		}

	// All Verifications and Validations

	public void verify_reviewContent_LandingPage() {
		String vt = reviewContent_homepage.getText();
		Assert.assertEquals(vt, "Flagged Contents",
				"Flagged Contents Text Not Found in Review Content Page, Contact Developer");
	}

	// Business Component

	public Moderator_Coupon_Page click_coupons() throws Throwable {
		
		Thread.sleep(2000);
		UtilTest.staticScreenShot("Coupon_Landing_Page");
		return new Moderator_Coupon_Page();
	}

}
