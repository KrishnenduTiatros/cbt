package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

import Thread.ResilienceDiscussion_T_Page;

public class Course_Sessions_page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//i[@class='fa fa-angle-up fa-2x more-less']")
	WebElement openSession;

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt']")
	WebElement verification_text_CoursePage;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[1]/div[@id='heading0']")
	WebElement session1;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[2]/div[@id='heading1']")
	WebElement session2;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[3]/div[@id='heading2']")
	WebElement session3;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[4]/div[@id='heading3']")
	WebElement session4;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[5]/div[@id='heading4']")
	WebElement session5;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[6]/div[@id='heading5']")
	WebElement session6;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[7]/div[@id='heading6']")
	WebElement session7;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[8]/div[@id='heading7']")
	WebElement session8;

	@FindBy(xpath = "//div[@id='collapse0']/div/div/a/div[1]/span[contains(text(),'1')]")
	WebElement team_check_IN;

	@FindBy(xpath = "//div[@id='collapse0']/div/div/a/div[1]/span[contains(text(),'2')]")
	WebElement resilience_Discussion;

	@FindBy(xpath = "//div[@id='collapse0']/div/div/a/div[1]/span[contains(text(),'3')]")
	WebElement psychoeducation_Lecture;

	@FindBy(xpath = "//div[@id='collapse0']/div/div/a/div[1]/span[contains(text(),'4')]")
	WebElement personal_Character;

	@FindBy(xpath = "//div[@id='collapse0']/div/div/a/div[1]/span[contains(text(),'5')]")
	WebElement final_Exercise;

	@FindBy(xpath = "//div[@id='collapse0']/div/div/a/div[1]/span[contains(text(),'6')]")
	WebElement Peer_Review;

	@FindBy(xpath = "//span[contains(text(),'×')]")
	WebElement cross;

	@FindBy(xpath = "//p[contains(text(),'3/3 Completed')]")
	WebElement peer_validation_message;

	@FindBy(xpath = "//div[@class='panel-collapse collapse in']//p[@class='text-danger'][contains(text(),'krishnendu s has not yet completed all activities ')]")
	WebElement peer_validation_message1;

	@FindBy(xpath = "//div[@class='i-checks clearfix accept-9']/div/ins[@class='iCheck-helper']")
	WebElement scale_click;

	@FindBy(xpath = "//div[@class='modal-footer']/div/input[@id='btn_cancel']")
	WebElement cancel;

	// Initializing the page object

	public Course_Sessions_page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_CoursePage() {
		boolean vt = verification_text_CoursePage.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public void currentOpenSession() throws Throwable {
		CommonPage.sessionSteps();
	}

}
