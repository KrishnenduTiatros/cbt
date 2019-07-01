package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Gad7Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//h2[contains(text(),'Anxiety Personal Assessment')]")
	WebElement verification_text9;

	@FindBy(xpath = "//div[@class='step-content']/div/div/div[2]/div/div/div[2]")
	WebElement feeling_nervous;

	@FindBy(xpath = "//div[@class='step-content']/div/div/div[3]/div/div/div[1]")
	WebElement not_being;

	@FindBy(xpath = "//div[@class='step-content']/div/div/div[4]/div/div/div[3]")
	WebElement worrying;

	@FindBy(xpath = "//div[@class='step-content']/div/div/div[5]/div/div/div[4]")
	WebElement trouble_relaxing;

	@FindBy(xpath = "//div[@class='step-content']/div/div/div[6]/div/div/div[3]")
	WebElement being_so;

	@FindBy(xpath = "//div[@class='step-content']/div/div/div[7]/div/div/div[2]")
	WebElement becoming_easily;

	@FindBy(xpath = "//div[@class='step-content']/div/div/div[8]/div/div/div[4]")
	WebElement feeling_afraid;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit;

	// Initializing the page object
	public Gad7Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations
	public void verify_text9() {
		boolean vt = verification_text9.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component
	public void gad7_static_CheckBox() throws Exception {

		UtilTest.element_click(driver, feeling_nervous);
		UtilTest.element_click(driver, not_being);
		UtilTest.element_click(driver, worrying);
		UtilTest.element_click(driver, trouble_relaxing);
		UtilTest.element_click(driver, being_so);
		UtilTest.element_click(driver, becoming_easily);
		UtilTest.element_click(driver, feeling_afraid);
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);
	}
	
	public void gad7_Dynamic_Click()throws Exception
	{
		CommonPage.dynamic_Radio_Click();
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);		
	}
	

}
