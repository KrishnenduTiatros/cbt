package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class PsychoeducationLecture_T_Page extends TestBase
{
	
	// Page factory - OR

	@FindBy(xpath = "//div[@class='row wrapper border-bottom white-bg page-heading']/div//li[3]//strong[contains(text(),'3: Psychoeducation Lecture')][2]")
	WebElement verification_text22;

	@FindBy(xpath = "//div[@id='wizard-p-0']")
	WebElement video1;

	@FindBy(xpath = "//li[@aria-hidden='false']/a[contains(text(),'Next')]")
	WebElement next_button;

	@FindBy(xpath = "//article[@data-question-id='1630']")
	WebElement video2;

	@FindBy(xpath = "//textarea[@id='course_question_1718']")
	WebElement textarea1;

	@FindBy(xpath = "//textarea[@id='course_question_1719']")
	WebElement textarea2;

	@FindBy(xpath = "//li[@aria-hidden='false']/a[contains(text(),'Finish')]")
	WebElement finish;

	// Initializing the page object

	public PsychoeducationLecture_T_Page() {
				PageFactory.initElements(driver, this);
			}

	// All Verifications and Validations

	public void verification_text22() {
		boolean vt = verification_text22.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public void course_tour3() throws Throwable 
	{
		Thread.sleep(5000);
		UtilTest.element_click(driver, video1);
		Thread.sleep(5000);
		UtilTest.element_click(driver, next_button);
		Thread.sleep(2000);
		UtilTest.element_click(driver, video2);
		Thread.sleep(5000);
		CommonPage.dynamic_TextBox();
		//UtilTest.sendkeys(driver, textarea1, prop.getProperty("Note"));
		//UtilTest.sendkeys(driver, textarea2, prop.getProperty("Note"));
		Thread.sleep(3000);
		UtilTest.element_click(driver, next_button);
		Thread.sleep(3000);
		CommonPage.dynamic_TextBox();
		Thread.sleep(2000);
		UtilTest.element_click(driver, finish);
		Thread.sleep(5000);
		
	}

}
