package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class TeamCheckIn_T_Page extends TestBase {

	@FindBy(xpath = "//div[@class='row wrapper border-bottom white-bg page-heading']/div//li[3]//strong[contains(text(),'1: Team Check-In')][2]")
	WebElement verification_text20;

	@FindBy(xpath = "//video[@class='visible']/source[@type='video/mp4']")
	WebElement video;

	@FindBy(xpath = "//li[@aria-hidden=\"false\"]/a[contains(text(),'Next')]")
	WebElement next_button;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[2]/td/textarea[@id='course_question_1813']")
	WebElement thought_Prompt1;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[4]/td/textarea[@id='course_question_1814']")
	WebElement thought_Prompt2;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[6]/td/textarea[@id='course_question_1815']")
	WebElement thought_Prompt3;

	@FindBy(xpath = "//div[@class='actions clearfix']/ul/li[3]")
	WebElement finish;

	// Initializing the page object

	public TeamCheckIn_T_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verification_text20() {
		boolean vt = verification_text20.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public void course_tour1() throws Throwable {

		Thread.sleep(5000);
		// UtilTest.element_click(driver, video);
		// Thread.sleep(5000);
		UtilTest.element_click(driver, next_button);
		Thread.sleep(2000);
		UtilTest.element_click(driver, next_button);
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, thought_Prompt1, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, thought_Prompt2, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, thought_Prompt3, prop.getProperty("Note"));
		Thread.sleep(3000);
		UtilTest.element_click(driver, finish);
		Thread.sleep(4000);
		
	}
}
