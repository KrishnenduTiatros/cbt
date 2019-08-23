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

	@FindBy(xpath = "//div[@class='row wrapper border-bottom white-bg page-heading']/div//li[2]//strong[contains(text(),'course')][2]")
	WebElement verification_text18;

	@FindBy(xpath = "//div[@class='col-lg-11 pull-center dashboard-new']/div[2]/div/div/div/div[1]/div[@id='heading0']")
	WebElement session1;
	
	//h2[contains(text(),'Session 1: Recognizing the Power in Your Story')]

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
	
	@FindBy (xpath = "//div[@id='collapse0']/div/div/a/div[1]/span[contains(text(),'6')]")
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

	public void verify_text18() {
		boolean vt = verification_text18.isDisplayed();
		Assert.assertEquals(vt, true);
	}
	
	public void verify_complete_message() {
		
		boolean vt = peer_validation_message.isDisplayed();
		String Text = peer_validation_message.getText();
		System.out.println("Inner text is :" + Text);
		int index = Text.indexOf("d");
		String ret = Text.substring(3, index);
		if (ret == "Completed")
		{
			Assert.assertEquals(vt, true);
		}
		else 
		{
			Assert.assertEquals(vt, false);	
		}
	}

	// Business Component

	public TeamCheckIn_T_Page click_1() throws Throwable {
		Thread.sleep(3000);
		UtilTest.element_click(driver, team_check_IN);
		Thread.sleep(10000);
		return new TeamCheckIn_T_Page();
	}

	public ResilienceDiscussion_T_Page click_2() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, resilience_Discussion);
		Thread.sleep(10000);
		return new ResilienceDiscussion_T_Page();
	}

	public PsychoeducationLecture_T_Page click_3() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, psychoeducation_Lecture);
		if(scale_click.isDisplayed()== true)
		{
			cancel.click();
		}
		else 
		
		Thread.sleep(10000);
		return new PsychoeducationLecture_T_Page();
	}

	public PersonalCharacter_T_Page click_4() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, personal_Character);
		Thread.sleep(10000);
		//UtilTest.element_click(driver, cross);
		Thread.sleep(5000);
		return new PersonalCharacter_T_Page();
	}

	public FinalExercise_T_Page click_5() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, final_Exercise);
		Thread.sleep(10000);
		return new FinalExercise_T_Page();
	}
	
	public PeerReviewPage click_6() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, Peer_Review);
		Thread.sleep(10000);
		return new PeerReviewPage();
	}
	
	public void clickOn_Session1() throws Throwable
	{
		Thread.sleep(5000);
		UtilTest.element_click(driver, session1);
	}

}
