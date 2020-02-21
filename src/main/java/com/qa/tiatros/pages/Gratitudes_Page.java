package com.qa.tiatros.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Gratitudes_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//input[@id='gratitude_journal_message_body']")
	WebElement gratitude_textBox;

	@FindBy(xpath = "//span[@class='input-group-btn']/input[@type='submit']")
	WebElement post_TO;

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt']")
	WebElement text_mygratitude;

	@FindBy(xpath = "//div[@class=\"ibox-content gratitude-box-content\"]/div/li[1]/a")
	WebElement live_ME;

	@FindBy(xpath = "//div[@class=\"ibox-content gratitude-box-content\"]/div/li[2]/a")
	WebElement live_MyGroup;

	@FindBy(xpath = "//div[@class=\"ibox-content gratitude-box-content\"]/div/li[3]/a")
	WebElement live_MyOrga;

	@FindBy(xpath = "//div[@class=\"ibox-content gratitude-box-content\"]/div/li[4]/a")
	WebElement live_World;

	// Initializing the page object

	public Gratitudes_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	// Business Component

	public void clickAll_LiveIcon() {
		UtilTest.textMessageValidation(text_mygratitude, "My Gratitudes");
		UtilTest.click_js(live_MyGroup);
		UtilTest.click_js(live_MyOrga);
		UtilTest.click_js(live_World);

	}

	public void logoutM() throws Throwable {
		Thread.sleep(5000);
		UtilTest.click_hambergur();
		Thread.sleep(2000);
		UtilTest.logout();

	}
	
	public void editMe_JournalAll() throws Throwable
	{
		UtilTest.textMessageValidation(text_mygratitude, "My Gratitudes");
		UtilTest.editJournalcomments();
	}

	public void editGroup_JournalAll() throws Throwable
	{
		UtilTest.textMessageValidation(text_mygratitude, "My Gratitudes");
		UtilTest.click_js(live_MyGroup);
		UtilTest.editJournalcomments();
	}
	public void editMyOrga_JournalAll() throws Throwable
	{
		UtilTest.textMessageValidation(text_mygratitude, "My Gratitudes");
		UtilTest.click_js(live_MyOrga);
		UtilTest.editJournalcomments();
	}
	public void editWorld_JournalAll() throws Throwable
	{
		UtilTest.textMessageValidation(text_mygratitude, "My Gratitudes");
		UtilTest.click_js(live_World);
		UtilTest.editJournalcomments();
	}
}
