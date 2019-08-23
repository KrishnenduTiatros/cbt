package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class PersonalProgress extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//div[contains(@class,'wrapper wrapper-content animated fadeIn')]//a[2]")
	WebElement pss10;

	@FindBy(xpath = "//div[contains(@class,'wrapper wrapper-content animated fadeIn')]//a[3]")
	WebElement gad7;

	@FindBy(xpath = "//div[contains(@class,'wrapper wrapper-content animated fadeIn')]//a[4]")
	WebElement phq9;

	@FindBy(xpath = "//div[contains(@class,'wrapper wrapper-content animated fadeIn')]//a[5]")
	WebElement phq15;

	@FindBy(xpath = "//div[@class='ibox-content no-padding']//a[1]")
	WebElement stressInve;

	// Initializing the page object

	public PersonalProgress() {
		PageFactory.initElements(driver, this);
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
	
	
	public Stress_inventoryPage stress_inventoryQuestion() throws Exception {
		Thread.sleep(5000);
		UtilTest.element_click(driver, stressInve);
		Thread.sleep(5000);
		return new Stress_inventoryPage();
	}
	
	public void logoutM() throws Throwable {
		Thread.sleep(5000);
		UtilTest.click_hambergur();
		Thread.sleep(2000);
		UtilTest.logout();

	}
	
	public void fetchMyProgressData()
	{
		UtilTest.scrollDown();
		UtilTest.fetchValue("Assignment");
	}

}
