package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class DashboardPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Dashboard')]")
	WebElement verification_text7;

	@FindBy(xpath = "//h3[contains(text(),'Inventory Your Stress')]")
	WebElement verification_text15;

	@FindBy(xpath = "//div[@class='row nw-provider-dashboard']//following::div[1]//div[2]//div[@class='col-xs-9'][1]//a[@class='btn btn-primary-blue btn-md btn-block p-sm m-b-md onclick-link']")
	WebElement phq9;

	@FindBy(xpath = "//div[@class='row nw-provider-dashboard']//following::div[1]//div[2]//div[@class='col-xs-9'][2]//a[@class='btn btn-primary-blue btn-md btn-block p-sm m-b-md onclick-link']")
	WebElement gad7;

	@FindBy(xpath = "//div[@class='row nw-provider-dashboard']//following::div[1]//div[2]//div[@class='col-xs-9'][3]//a[@class='btn btn-primary-blue btn-md btn-block p-sm m-b-md onclick-link']")
	WebElement phq15;

	@FindBy(xpath = "//div[@class='row nw-provider-dashboard']//following::div[1]//div[2]//div[@class='col-xs-9'][4]//a[@class='btn btn-primary-blue btn-md btn-block p-sm m-b-md onclick-link']")
	WebElement pss10;

	@FindBy(xpath = "//div[@class='row nw-provider-dashboard']//following::div[@class='col-lg-4'][2]//div[2]//div[@class='col-xs-12 text-center dash-middle-btn']//a[@class='btn btn-primary-blue btn-md btn-block p-sm']")
	WebElement Pledge;

	@FindBy(xpath = "//div[@class='row nw-provider-dashboard']//following::div[3]//div[2]//div[@class='col-xs-9'][1]")
	WebElement stress_inventory;

	@FindBy(xpath = "//div[@class='row nw-provider-dashboard']//following::div[3]//div[2]//div[@class='col-xs-9'][2]")
	WebElement user_facts;

	@FindBy(xpath = "//video[@id='video1']")
	WebElement play_video;

	@FindBy(xpath = "//input[@id='user_pledge']")
	WebElement text1;

	@FindBy(xpath = "//button[@type='button']") //button[@id='pledge_accept_btn']
	WebElement accept_button;

	@FindBy(xpath = "//div[@class='i-checks clearfix accept-9']/div/ins[@class='iCheck-helper']")
	WebElement scale_click;

	@FindBy(xpath = "//div[@class='modal-footer']/div/input[@id='btn_cancel']")
	WebElement cancel;

	@FindBy(xpath = "//h1[@class='m-b-sm font-bold text-center']/small[contains(text(),' You have completed all of the pre-program tasks!')]")
	WebElement completion;

	@FindBy(linkText = "Why Inventory Your Stress?")
	WebElement why_stress;

	@FindBy(xpath = "//div[@class='modal-content']/div/h3[contains(text(),'Take Your Stress Inventory')]")
	WebElement verification_text17;

	@FindBy(xpath = "//input[@value='SUBMIT']")
	WebElement submit;

	@FindBy(xpath = "//textarea[@id='nps_score_comment']")
	WebElement nps_textarea;

	// Initializing the page object

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text7() {
		boolean vt = verification_text7.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	public void verify_text15() {
		boolean vt = verification_text15.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	public void verify_text17() {
		boolean vt = verification_text17.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public Phq9Page phq9Question() throws Exception {
		Thread.sleep(5000);
		UtilTest.element_click(driver, phq9);
		Thread.sleep(5000);
		return new Phq9Page();
	}

	public Gad7Page gad7Question() throws Exception {
		Thread.sleep(5000);
		UtilTest.element_click(driver, gad7);
		Thread.sleep(5000);
		return new Gad7Page();
	}

	public Phq15Page phq15Question() throws Exception {
		Thread.sleep(5000);
		UtilTest.element_click(driver, phq15);
		Thread.sleep(5000);
		return new Phq15Page();
	}

	public Pss10Page pss10Question() throws Exception {
		Thread.sleep(5000);
		UtilTest.element_click(driver, pss10);
		Thread.sleep(5000);
		return new Pss10Page();
	}

	public void pledge() throws Throwable {

		Thread.sleep(4000);
		UtilTest.element_click(driver, Pledge);
		Thread.sleep(5000);
		UtilTest.element_click(driver, play_video);
		Thread.sleep(3000);
		//UtilTest.sendkeys(driver, text1, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "PledgeName")); // prop.getProperty("PledgeName")
		//Thread.sleep(2000);
		//UtilTest.element_click(driver, accept_button);
	}

	public Stress_inventoryPage stress_inventoryQuestion() throws Exception {
		Thread.sleep(5000);
		UtilTest.element_click(driver, stress_inventory);
		Thread.sleep(5000);
		return new Stress_inventoryPage();
	}

	public User_factsPage user_factsQuestion() throws Exception {
		Thread.sleep(5000);
		UtilTest.element_click(driver, user_facts);
		Thread.sleep(5000);
		return new User_factsPage();
	}

	public void scale_click() throws Throwable {
		Thread.sleep(5000);
		// UtilTest.element_click(driver, scale_click);
		scale_click.click();
		UtilTest.sendkeys(driver, nps_textarea,
				UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "PledgeName")); //prop.getProperty("TestCase")
		submit.click();
		Thread.sleep(3000);
		// UtilTest.element_click(driver, cancel);
		Thread.sleep(4000);
	}

	public void course_complete() {
		boolean vt = completion.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	public void click_inventory_your_stress() throws Exception {
		Thread.sleep(2000);
		UtilTest.element_click(driver, why_stress);
		Thread.sleep(3000);
	}

	public void logoutM() throws Throwable {
		Thread.sleep(2000);
		UtilTest.logout();
	}
}
