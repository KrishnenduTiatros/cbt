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

	@FindBy(xpath = "//h3[contains(text(),'Select a Start Date')]//following-sibling::div[1]/div[1]/div")
	WebElement check_box;

	@FindBy(xpath = "//input[@id='submit_profile']")
	WebElement save;

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
		Thread.sleep(1000);
		UtilTest.element_click(driver, check_box);
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
	
}
