package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.tiatros.base.TestBase;

public class Gratitudes_Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//input[@id='gratitude_journal_message_body']")
	WebElement gratitude_textBox;

	@FindBy(xpath = "//span[@class='input-group-btn']/input[@type='submit']")
	WebElement post_TO;

}
