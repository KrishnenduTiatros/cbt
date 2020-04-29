package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Review_goals_assessments_Page extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//small[contains(text(),'Review Goals Assessments')]")
	WebElement verification_text;

	@FindBy(xpath = "//select[@id='course_id_select']")
	WebElement select_drop;

	@FindBy(xpath = "//input[contains(@class,'form-control input-sm')]")
	WebElement search_textBox;

	@FindBy(xpath = "//span[contains(text(),'Directory')]")
	WebElement directory;

	// Initializing the page object

	public Review_goals_assessments_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_ReviewGoal_LandingPage() {
		String vt = verification_text.getText();
		Assert.assertEquals(vt, "Review Goals Assessments",
				"Review Goals Assessments Text Not Found in Review Goal Page, Contact Developer");
	}

	// Business Component

	public void check_review() throws Throwable {
		try {
			UtilTest.select_dropdown(select_drop, prop.getProperty("CourseDetails"));
			Thread.sleep(2000);
			UtilTest.sendkeys(driver, search_textBox, prop.getProperty("GoalReviewEmailID"));
			Thread.sleep(5000);
			String s1 = UtilTest.returnGoalColor();
			String path = UtilTest.staticScreenShot("GoalReview");
			UtilTest.sendEmailNotification(prop.getProperty("SendEmail"), prop.getProperty("EmailSubject"), path, s1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			UtilTest.logout();
		}
	}

	public Moderator_Directory_Page click_Directory() throws Throwable {
		UtilTest.click_js(directory);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("Directory_Landing_Page");
		return new Moderator_Directory_Page();
	}

}
