package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Phq9Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//h2[contains(text(),'Low Moods Personal Assessment')]")
	WebElement verification_text8;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[2]/div/div/div[2]")
	WebElement little;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[3]/div/div/div[3]")
	WebElement feeling;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[4]/div/div/div[4]")
	WebElement trouble;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[5]/div/div/div[2]")
	WebElement tired;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[6]/div/div/div[3]")
	WebElement poor;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[7]/div/div/div[3]")
	WebElement bad;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[8]/div/div/div[4]")
	WebElement concentrating;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[9]/div/div/div[4]")
	WebElement moving;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[10]/div/div/div[2]")
	WebElement thoughts;

	@FindBy(xpath = "//div[@class=\"step-content\"]/div/div/div[1]/div/div/div[3]")
	WebElement checked;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit;

	// Initializing the page object
	public Phq9Page() {
		PageFactory.initElements(driver, this);
	}

	
	// All Verifications and Validations
	public void verify_text8() {
		boolean vt = verification_text8.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component	
	public void phq9_static_CheckBox() throws Exception {
		
		UtilTest.element_click(driver, little);
		UtilTest.element_click(driver, feeling);
		UtilTest.element_click(driver, trouble);
		UtilTest.element_click(driver, tired);
		UtilTest.element_click(driver, poor);
		UtilTest.element_click(driver, bad);
		UtilTest.element_click(driver, concentrating);
		UtilTest.element_click(driver, moving);
		UtilTest.element_click(driver, thoughts);
		UtilTest.element_click(driver, checked);
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);
	}
	
	public void phq9_Dynamic_Click()throws Exception
	{
		CommonPage.dynamic_Radio_Click();
		UtilTest.element_click(driver, checked);
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);		
	}
}