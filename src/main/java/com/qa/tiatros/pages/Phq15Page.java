package com.qa.tiatros.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Phq15Page extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//h2[contains(text(),'Physical Health Personal Assessment')]")
	WebElement verification_text10;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[2]/div/div/div[1]")
	WebElement stomach_pain;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[3]/div/div/div[2]")
	WebElement back_pain;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[4]/div/div/div[3]")
	WebElement pain_in_your_arms;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[5]/div/div/div[2]")
	WebElement menstrual;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[6]/div/div/div[2]")
	WebElement headaches;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[7]/div/div/div[1]")
	WebElement chest_pain;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[8]/div/div/div[2]")
	WebElement dizziness;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[9]/div/div/div[3]")
	WebElement fainting_spells;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[10]/div/div/div[3]")
	WebElement feeling_your;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[11]/div/div/div[1]")
	WebElement shortness;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[12]/div/div/div[2]")
	WebElement pain_or_problems;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[13]/div/div/div[3]")
	WebElement constipation;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[14]/div/div/div[2]")
	WebElement nausea;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[15]/div/div/div[1]")
	WebElement feeling_tired;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/div/div[16]/div/div/div[3]")
	WebElement trouble_sleeping;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit;

	// Initializing the page object
	public Phq15Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations
	public void verify_text10() {
		boolean vt = verification_text10.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component
	public void phq15_Static_CheckBox() throws Exception {
		UtilTest.element_click(driver, stomach_pain);
		UtilTest.element_click(driver, back_pain);
		UtilTest.element_click(driver, pain_in_your_arms);
		UtilTest.element_click(driver, menstrual);
		UtilTest.element_click(driver, headaches);
		UtilTest.element_click(driver, chest_pain);
		UtilTest.element_click(driver, dizziness);
		UtilTest.element_click(driver, fainting_spells);
		UtilTest.element_click(driver, feeling_your);
		UtilTest.element_click(driver, shortness);
		UtilTest.element_click(driver, pain_or_problems);
		UtilTest.element_click(driver, constipation);
		UtilTest.element_click(driver, nausea);
		UtilTest.element_click(driver, feeling_tired);
		UtilTest.element_click(driver, trouble_sleeping);
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);
	}

	public void phq15_Dynamic_Click() throws Exception {
		CommonPage.dynamic_Radio_Click();
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);
	}
}
