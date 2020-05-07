package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class MessagePostPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//div[@class='row wrapper border-bottom white-bg page-heading']//li[1]")
	WebElement home_icon;

//	@FindBy(xpath = "//a[@class='navbar-minimalize minimalize-styl-2 btn']")
//	WebElement hambarger;
//
//	@FindBy(xpath = "//span[@class='nav-label text-danger']")
//	WebElement logOut;

	@FindBy(xpath = "//span[@class='bottom-label-link']")
	WebElement back_to_home;

	// Initializing the page object

	public MessagePostPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void courseDashboardVerification() {
		boolean vt = back_to_home.isDisplayed();
		Assert.assertEquals(vt, true, "Back To Home not displayed");
	}

	// Business Component

	public void check_messagePost() throws Throwable {
		Thread.sleep(3000);
		UtilTest.message_Post_Verification();
	}

	public Message_post_commentsPage reply_message_post() {
		UtilTest.message_Post_Verification();
		UtilTest.message_Post_click();
		return new Message_post_commentsPage();
	}
	
	public Message_post_commentsPage rply_msg_moderatort() {
		UtilTest.msg_Post_RE_VerifY();
		UtilTest.message_Post_click();
		return new Message_post_commentsPage();
	}

	public void logoutM() throws Throwable {
		Thread.sleep(5000);
		UtilTest.click_hambergur();
		Thread.sleep(1000);
		UtilTest.logout();
		Thread.sleep(1000);
	}

	public void clickOnTiles() {

		// UtilTest.clickonTiles();
		UtilTest.clickPagination_AllTiles();

	}
}
