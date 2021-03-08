package com.qa.tiatros.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class CrisisSign_up_Page extends TestBase {

	/** Page Factory - OR **/

	By email = By.xpath("//input[@id='user_email']");
	By firstName = By.xpath("//input[@id='user_first_name']");
	By lastName = By.xpath("//input[@id='user_last_name']");
	By passWord = By.xpath("//input[@id='user_password']");
	By couponCode = By.xpath("//input[@id='sign_up_token']");
	By checkBox = By.xpath("//input[@id='user_terms_of_service']//following::ins[@class='iCheck-helper']");
	By next = By.xpath("//input[@id='register']");
	By registrationGuidance = By.xpath("//a[@id='video_lnk']");
	By acceptUserAgreemnet = By.xpath("//button[@id='accept_btn']");
	By underStoodBack = By.xpath("//button[@class='confirm']");
	By scrolldowntoaccept = By.xpath("//p[contains(text(),'Thank you!')]");
	By closeVideoButton = By.xpath("//button[@id='video_close']");
	By backFYPC = By.xpath(
			"//div[@id='display_modal_content']//button[@class='btn btn-primary-green btn-rounded m-t-sm w40'][contains(text(),'Back')]");
	By fPCLink = By.xpath("//a[@id='info_lnk']");
	By pageHeaderText = By.xpath("//div[@class='ibox-title reg-card-crisis']");

	/** Validation and Verification **/

	public void pageValidation() {
		UtilTest.textValidation(pageHeaderText, "Let's create your account");
	}

	/**
	 * Business Component
	 * 
	 * @throws Throwable
	 **/

	public CrisisPinPage goToPinPage() throws Throwable {
		UtilTest.type(firstName, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "FirstName"));
		UtilTest.type(lastName, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "LastName"));
		UtilTest.type(email, UtilTest.emailidgenerate());
		UtilTest.type(passWord, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Password"));
		UtilTest.type(couponCode, prop.getProperty("Coupon"));
		UtilTest.click_js(checkBox);
		WebElement ele = driver.findElement(scrolldowntoaccept);
		Thread.sleep(4000);
		UtilTest.scrollDown(driver, ele);
		UtilTest.click_js(acceptUserAgreemnet);
		// UtilTest.click_js(underStoodBack);
		UtilTest.click_js(next);
		return new CrisisPinPage();
	}

	public CrisisPinPage goToPinPageWithAllClick() throws Throwable {
		
		UtilTest.type(firstName, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "FirstName"));
		UtilTest.type(lastName, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "LastName"));
		UtilTest.type(email, UtilTest.emailidgenerate());
		UtilTest.type(passWord, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Password"));
		UtilTest.type(couponCode, prop.getProperty("Coupon"));
		UtilTest.click_ele(fPCLink);
		UtilTest.click_ele(backFYPC);
		UtilTest.click_js(checkBox);
		WebElement ele = driver.findElement(scrolldowntoaccept);
		Thread.sleep(4000);
		UtilTest.scrollDown(driver, ele);
		UtilTest.click_js(acceptUserAgreemnet);
		// UtilTest.click_js(underStoodBack);
		UtilTest.click_js(next);
		return new CrisisPinPage();
	}
}
