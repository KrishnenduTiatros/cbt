package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class All_moderator_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt']")
	WebElement home_page_landing_text;

	@FindBy(xpath = "//span[contains(text(),'Facilitator Tools')]")
	WebElement faci_tool;

	@FindBy(xpath = "//a[contains(text(),'Review Goals Assessments')]")
	WebElement r_goal_ass;

	// Initializing the page object

	public All_moderator_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text2() {
		boolean vt = home_page_landing_text.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public Review_goals_assessments_Page click_Review_Goal() throws Throwable {
		Thread.sleep(3000);
		UtilTest.element_click(driver, faci_tool);
		Thread.sleep(2000);
		UtilTest.element_click(driver, r_goal_ass);
		Thread.sleep(1000);
		return new Review_goals_assessments_Page();
	}

}
