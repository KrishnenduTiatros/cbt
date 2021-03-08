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

	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	WebElement messages;

	@FindBy(xpath = "//a[contains(text(),'Review Goals Assessments')]")
	WebElement r_goal_ass;

	@FindBy(xpath = "//span[contains(text(),'Channels')]")
	WebElement channels;

	@FindBy(xpath = "//span[contains(text(),'Review Content')]")
	WebElement reviewContent;

	@FindBy(xpath = "//span[contains(text(),'Coupons')]")
	WebElement coupons;

	@FindBy(xpath = "//a[contains(text(),'NPS Score')]")
	WebElement nps;

	@FindBy(xpath = "//span[contains(text(),'Reassign Requests')]")
	WebElement reassign;

	@FindBy(xpath = "//span[@class='custom-nav-label']")
	WebElement participants;
	
	@FindBy(xpath = "//a[contains(text(),'Registered')]")
	WebElement regis;
	
	
	// Initializing the page object

	public All_moderator_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_Moderator_homePage() {
		String vmh = home_page_landing_text.getText();
		Assert.assertEquals(vmh, "Peer Groups", "Peer Groups Text Not Found Contact Developer");
	}

	// Business Component

	public Review_goals_assessments_Page click_Review_Goal() throws Throwable {
		Thread.sleep(3000);
		UtilTest.click_js(faci_tool);
		Thread.sleep(2000);
		UtilTest.click_js(r_goal_ass);
		Thread.sleep(1000);
		return new Review_goals_assessments_Page();
	}

	public Moderator_message_Page click_MessageSection() throws Throwable {
		UtilTest.click_js(messages);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("MyMessage_Landing_Page");
		return new Moderator_message_Page();
	}

	public Moderator_NPS_Score_Page click_NPSScore() throws Throwable {
		UtilTest.click_js(faci_tool);
		UtilTest.click_js(nps);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("NPSScore_Landing_Page");
		return new Moderator_NPS_Score_Page();
	}

	public Moderator_ReassignRequests_Page click_Requests() throws Throwable {
		UtilTest.click_js(reassign);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("Reassign_Landing_Page");
		return new Moderator_ReassignRequests_Page();
	}
	
	public Moderator_REGISTERED_Page click_Participant() throws Throwable
	{
		UtilTest.click_js(participants);
		UtilTest.click_js(regis);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("RegisterParticipant_Page");
		return new Moderator_REGISTERED_Page();
	}

}
