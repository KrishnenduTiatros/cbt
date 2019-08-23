package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class ReturnUserRegistrationPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//h2[contains(text(),'Program Registration')]")
	WebElement verify_text14;

	@FindBy(xpath = "//input[@id='coupon_code']")
	WebElement return_coupon_code;

	@FindBy(xpath = "//button[@id='validate']")
	WebElement validate_coupon;
	
	@FindBy(xpath = "//*[@class='col-xs-8 col-sm-7 no-padding m-t-md m-b-lg']//following::div[@class=\"form-group accept-1\"]/div")//h3[contains(text(),'Select a Start Date')]//following-sibling::div[1]/div[1]/div
	WebElement check_box;

	@FindBy(xpath = "//input[@id='submit_profile']")
	WebElement save;
	
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
	
	// Initializing the page object
	public ReturnUserRegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text14() {
		boolean vt = verify_text14.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public DashboardPage click_signupLink() throws Throwable {
		
		zip.clear();
		UtilTest.sendkeys(driver, zip, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Zip")); // prop.getProperty("Zip")
		UtilTest.select_dropdown(month, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Month")); // prop.getProperty("Month")
		UtilTest.select_dropdown(day, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Day")); // prop.getProperty("Day")
		UtilTest.select_dropdown(year, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Year"));
		UtilTest.select_dropdown(gender, UtilTest.readExcel("SignUP", prop.getProperty("TestCase"), "Gender"));	
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, return_coupon_code,prop.getProperty("R_Coupon") ); // Reading data from xlsx file // UtilTest.readExcel("ReturnUser", prop.getProperty("TestCase"), "R_Coupon")    //prop.getProperty("R_Coupon")
		Thread.sleep(2000);
		UtilTest.element_click(driver, validate_coupon);
		Thread.sleep(3000);
		UtilTest.element_click(driver, check_box);
		Thread.sleep(2000);
		UtilTest.element_click(driver, save);
		return new DashboardPage();
	}
}
