package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Message_post_commentsPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//textarea[@id='message_post_comment_body']")
	WebElement reply_text_box;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement post;

	// Initializing the page object

	public Message_post_commentsPage() {
		PageFactory.initElements(driver, this);
	}

	// Business Component

	public void add_reply_messageText() throws Throwable {
		UtilTest.sendkeys(driver, reply_text_box, prop.getProperty("Note3"));
		UtilTest.click_js(post);
		Thread.sleep(5000);
		UtilTest.click_hambergur();
		Thread.sleep(3000);
		UtilTest.logout();
	}

	public void modrt_reply_Mesg() throws Throwable {
		UtilTest.sendkeys(driver, reply_text_box, prop.getProperty("Note4"));
		UtilTest.click_js(post);
		Thread.sleep(5000);
	}

}
