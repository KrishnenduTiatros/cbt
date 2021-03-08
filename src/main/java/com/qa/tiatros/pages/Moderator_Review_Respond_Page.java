package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_Review_Respond_Page extends TestBase {

	@FindBy(xpath = "//small[contains(text(),'Exercise Review & Respond')]")
	WebElement reviewRespond_text;

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Facilitator Tools')]")
	WebElement faci_breadcrumb;
	
	@FindBy(xpath = "//a[contains(text(),'Review Goals Assessments')]")
	WebElement r_goal_ass;

	public Moderator_Review_Respond_Page() {
		PageFactory.initElements(driver, this);
	}

// All Verifications and Validations

	public void verify_ReviewRespond_LandingPage() {
		String vt = reviewRespond_text.getText();
		Assert.assertEquals(vt, "Exercise Review & Respond",
				"Exercise Review & Respond Text Not Found in Review & Respond Page, Contact Developer");
	}

// Business Component

	public Review_goals_assessments_Page click_reviewGoal() throws Throwable {
		UtilTest.click_js(r_goal_ass);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("ReviewGoal_Landing_Page");
		return new Review_goals_assessments_Page();
	}

}
