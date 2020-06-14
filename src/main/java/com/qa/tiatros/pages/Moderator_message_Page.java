package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_message_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'My Messages')]")
	WebElement mYmessage_homepage;

	@FindBy(xpath = "//span[contains(text(),'Facilitator Tools')]")
	WebElement faci_tool;

	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	WebElement messages;

	@FindBy(xpath = "//span[contains(text(),'Channels')]")
	WebElement channels;

	@FindBy(xpath = "//a[@id='option_message']//img[@class='camera-icon-message']")
	WebElement message_Post_Button;

	@FindBy(xpath = "//input[@id='message_post_title']")
	WebElement subject_message;

	@FindBy(xpath = "//textarea[@id='message_post_content']")
	WebElement message_Body;

	@FindBy(xpath = "//button[contains(text(),'Post')]")
	WebElement post_btn;

	@FindBy(xpath = "//select[@id='select_batch_id']")
	WebElement select_Group;

	// Initializing the page object

	public Moderator_message_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_MyMessage_LandingPage() {
		boolean vt = mYmessage_homepage.isDisplayed();
		Assert.assertEquals(vt, true, "My Message Landing Page Not Found Check With Developer");
	}

	// Business Component

	public Moderator_Channels_Page click_Channels() throws Throwable {
		UtilTest.click_js(channels);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("Channels_Landing_Page");
		return new Moderator_Channels_Page();
	}

	public MessagePostPage add_MessagePost() throws Throwable {
		UtilTest.click_js(message_Post_Button);
		UtilTest.select_DrpDwn_ByValue(select_Group, "99");
		UtilTest.sendkeys(driver, subject_message, UtilTest.generate_message_subject());
		UtilTest.sendkeys(driver, message_Body, prop.getProperty("Note1"));
		Thread.sleep(3000);
		UtilTest.click_js(post_btn);
		Thread.sleep(3000);
		return new MessagePostPage();
	}
	
	
}
