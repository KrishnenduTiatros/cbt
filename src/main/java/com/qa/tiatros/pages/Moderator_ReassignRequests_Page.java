package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_ReassignRequests_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Reassign Requests')]")
	WebElement reassign_text;

	@FindBy(xpath = "//small[contains(text(),'Reassign Request Participant List')]")
	WebElement reassign_Parti_text;

	@FindBy(xpath = "//span[contains(text(),'Courses')]")
	WebElement courses;

	@FindBy(xpath = "//a[contains(text(),'Course List')]")
	WebElement courses_List;

	@FindBy(xpath = "//a[contains(text(),'Course Preview')]")
	WebElement courses_Preview;

	// Initializing the page object

	public Moderator_ReassignRequests_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_ReassignRequest_Page() {
		String vt = reassign_text.getText();
		Assert.assertEquals(vt, "Reassign Requests",
				"Reassign Requests Text Not Found in Reassign Requests Page, Contact Developer");
	}

	// Business Component

	public Moderator_course_Page click_Courses() throws Throwable {
		UtilTest.click_js(courses);
		UtilTest.click_js(courses_List);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("CoursesList_Landing_Page");
		UtilTest.click_js(courses_Preview);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("CoursesPreview_Landing_Page");
		return new Moderator_course_Page();
	}

}
