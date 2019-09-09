package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class FromWelcomeVidPage extends TestBase {

	// Page factory - OR

	@FindBy(id = "date_month")
	WebElement month;

	@FindBy(id = "date_day")
	WebElement day;

	@FindBy(id = "date_year")
	WebElement year;

	@FindBy(id = "user_gender")
	WebElement gender;

	@FindBy(id = "zip_code")
	WebElement zip;

	@FindBy(id = "submit_profile")
	WebElement submit_profile;

	@FindBy(xpath = "//span[@class='switchery switchery-default']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phnNumber;

	@FindBy(xpath = "//h2[contains(text(),'Complete Your Profile')]")
	WebElement verification_text6;

	@FindBy(xpath = "//*[starts-with(@class,'col-xs-8 col-sm-7')]//following::div[@class='form-group accept-1']/div//ins")
	WebElement check_box;

	@FindBy(xpath = "//*[starts-with(@class,'col-xs-8 col-sm-7')]//following::div[@class='form-group action-btn-1']/div//ins")
	WebElement notify_me;

	@FindBy(xpath = "//input[@id='submit_profile']")
	WebElement save;
	
	@FindBy(xpath ="//button[@class='cancel']")
	WebElement notify_cancel_button;
	
	@FindBy(xpath ="//button[@class='confirm']")
	WebElement notify_confirm_button;

	// Initializing the page object

	public FromWelcomeVidPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text6() {
		boolean vt = verification_text6.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public DashboardPage inputProfileDetails() throws Throwable {

		UtilTest.sendkeys(driver, zip, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Zip")); // prop.getProperty("Zip")
		UtilTest.select_dropdown(month, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Month")); // prop.getProperty("Month")
		UtilTest.select_dropdown(day, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Day")); // prop.getProperty("Day")
		UtilTest.select_dropdown(year, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Year"));
		UtilTest.select_dropdown(gender, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Gender"));
		Thread.sleep(2000);
		check_box.click();
		Thread.sleep(2000);
		UtilTest.element_click(driver, save);
		Thread.sleep(5000);
		return new DashboardPage();
	}

	public DashboardPage inputProfileDetails_PhoneNumber() throws Throwable {

		UtilTest.sendkeys(driver, zip, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Zip")); // prop.getProperty("Zip")
		UtilTest.select_dropdown(month, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Month")); // prop.getProperty("Month")
		UtilTest.select_dropdown(day, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Day")); // prop.getProperty("Day")
		UtilTest.select_dropdown(year, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Year"));
		UtilTest.select_dropdown(gender, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Gender"));
		Thread.sleep(1000);
		UtilTest.element_click(driver, mobile);
		Thread.sleep(1000);
		UtilTest.element_click(driver, check_box);
		Thread.sleep(2000);
		UtilTest.element_click(driver, save);
		Thread.sleep(5000);
		return new DashboardPage();
	}
	
	public DashboardPage profile_notifycancelButton() throws Throwable {
		
		UtilTest.sendkeys(driver, zip, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Zip")); // prop.getProperty("Zip")
		UtilTest.select_dropdown(month, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Month")); // prop.getProperty("Month")
		UtilTest.select_dropdown(day, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Day")); // prop.getProperty("Day")
		UtilTest.select_dropdown(year, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Year"));
		UtilTest.select_dropdown(gender, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Gender"));
		Thread.sleep(2000);
		notify_me.click();
		Thread.sleep(2000);
		notify_cancel_button.click();
		Thread.sleep(3000);
		UtilTest.element_click(driver, save);
		Thread.sleep(5000);
		return new DashboardPage();
	}
	
	public void profile_notifySubmitButton() throws Throwable {
		
		UtilTest.sendkeys(driver, zip, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Zip")); // prop.getProperty("Zip")
		UtilTest.select_dropdown(month, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Month")); // prop.getProperty("Month")
		UtilTest.select_dropdown(day, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Day")); // prop.getProperty("Day")
		UtilTest.select_dropdown(year, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Year"));
		UtilTest.select_dropdown(gender, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Gender"));
		Thread.sleep(2000);
		notify_me.click();
		Thread.sleep(2000);
		notify_confirm_button.click();
		Thread.sleep(3000);
	}
	

}
