package com.qa.tiatros.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Pss10Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//h2[contains(text(),'Perceived Stress Assessment')]")
	WebElement verification_text11;
	
	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[2]//div//div/div[4]")
	WebElement chk1;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[3]//div//div/div[5]")
	WebElement chk2;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[4]//div//div/div[3]")
	WebElement chk3;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[5]//div//div/div[2]")
	WebElement chk4;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[6]//div//div/div[1]")
	WebElement chk5;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[7]//div//div/div[5]")
	WebElement chk6;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[8]//div//div/div[2]")
	WebElement chk7;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[9]//div//div/div[1]")
	WebElement chk8;

	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[10]//div//div/div[4]")
	WebElement chk9;
	
	@FindBy(xpath = "//form[@id='form_submit']//div[1]/div/div/div[11]//div//div/div[5]")
	WebElement chk10;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit;	

	// Initializing the page object

	public Pss10Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_text11() {
		boolean vt = verification_text11.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component
	
	public void pss10_Static_CheckBox() throws Exception {

		UtilTest.element_click(driver, chk1);
		UtilTest.element_click(driver, chk2);
		UtilTest.element_click(driver, chk3);
		UtilTest.element_click(driver, chk4);
		UtilTest.element_click(driver, chk5);
		UtilTest.element_click(driver, chk6);
		UtilTest.element_click(driver, chk7);
		UtilTest.element_click(driver, chk8);
		UtilTest.element_click(driver, chk9);
		UtilTest.element_click(driver, chk10);
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);
	}
	
	public void pss10_Dynamic_Click()throws Exception
	{
		CommonPage.dynamic_Radio_Click();
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);		
	}
}
