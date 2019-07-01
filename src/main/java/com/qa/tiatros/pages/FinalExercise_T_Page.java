package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class FinalExercise_T_Page extends TestBase {
	
	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt']")
	WebElement verification_text24;

	@FindBy(xpath = "//img[@class='dash-logo']")
	WebElement page_logo;

	@FindBy(xpath = "//textarea[@id='course_question_2186']")
	WebElement textarea1;

	@FindBy(xpath = "//a[contains(text(),'Next')]")
	WebElement next;

	@FindBy(xpath = "//textarea[@id='course_question_1817']")
	WebElement textarea2;

	@FindBy(xpath = "//div[@id='accordion']/div/div[1]/h4/a[@aria-controls=\"collapse-83\"]/i")
	WebElement anger_click;

	@FindBy(xpath = "//label[contains(@for,'checkbox_202')]")
	WebElement anger_affonted;

	@FindBy(xpath = "//div[@id='accordion']/div/div[1]/h4/a[@aria-controls='collapse-84']/i")
	WebElement disgust_click;

	@FindBy(xpath = "//label[contains(@for,'checkbox_227')]")
	WebElement disgust_abhorrance;

	@FindBy(xpath = "//label[contains(@for,'checkbox_244')]")
	WebElement disgust_Odious;

	@FindBy(xpath = "//div[contains(@class,'emotional-selection')]")
	WebElement verification_text25;

	@FindBy(xpath = "//textarea[@id='course_question_2203']")
	WebElement textarea3;

	@FindBy(xpath = "//textarea[@id='course_question_2204']")
	WebElement textarea4;

	@FindBy(xpath = "//textarea[@id='course_question_2205']")
	WebElement textarea5;

	@FindBy(xpath = "//textarea[@id='course_question_2647']")
	WebElement textarea6;

	@FindBy(xpath = "//h2[contains(text(),'Congratulations! You’re officially done for the we')]")
	WebElement verification_text26;

	@FindBy(xpath = "//a[contains(text(),'Finish')]")
	WebElement finish;

	// Initializing the page object

	public FinalExercise_T_Page() {
		PageFactory.initElements(driver, this);
	}

	// Business Component

	public void course_tour5() throws Throwable
	{
		boolean vt = verification_text24.isDisplayed();
		Assert.assertEquals(vt, true);
		boolean vt1 = page_logo.isDisplayed();
		Assert.assertEquals(vt1, true);
		UtilTest.sendkeys(driver, textarea1, prop.getProperty("Note"));
		UtilTest.element_click(driver, next);
		UtilTest.sendkeys(driver, textarea2, prop.getProperty("Note"));
		UtilTest.element_click(driver, next);
		Thread.sleep(2000);
		UtilTest.element_click(driver, next);
		Thread.sleep(2000);
		UtilTest.element_click(driver, anger_click);
		Thread.sleep(3000);
		UtilTest.element_click(driver, anger_affonted);
		Thread.sleep(3000);
		UtilTest.element_click(driver, disgust_click);
		Thread.sleep(4000);
		UtilTest.element_click(driver, disgust_abhorrance);
		Thread.sleep(2000);
		UtilTest.element_click(driver, disgust_Odious);
		boolean vt2 = verification_text25.isDisplayed();
		Assert.assertEquals(vt2, true);
		UtilTest.element_click(driver, next);
		Thread.sleep(10000);
		UtilTest.element_click(driver, next);
		UtilTest.sendkeys(driver, textarea3, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, textarea4, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, textarea5, prop.getProperty("Note"));
		Thread.sleep(4000);
		UtilTest.element_click(driver, next);
		Thread.sleep(3000);
		UtilTest.element_click(driver, next);
		Thread.sleep(3000);
		UtilTest.sendkeys(driver, textarea6, prop.getProperty("Note"));
		UtilTest.element_click(driver, next);
		Thread.sleep(2000);
		UtilTest.element_click(driver, finish);
		Thread.sleep(10000);

	}
}
