package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Stress_inventoryPage extends TestBase {
	
	// Page factory - OR

	@FindBy(xpath = "//h2[contains(text(),'Stress Inventory')]")
	WebElement verification_text12;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/table//tbody/tr[2]//tr[1]/td/input")
	WebElement routine_Stress;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/table//tbody/tr[4]//tr[1]/td/input")
	WebElement relationship_Stress;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/table//tbody/tr[6]//tr[1]/td/input")
	WebElement physical_Stress;

	@FindBy(xpath = "//form[@id='form_submit']//div/div/table//tbody/tr[8]//tr[1]/td/input")
	WebElement situational_Stress;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submit;

	// Initializing the page object

	public Stress_inventoryPage() {
			PageFactory.initElements(driver, this);
		}

	// All Verifications and Validations

	public void verify_text12() {
		boolean vt = verification_text12.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public void stress_inventory_CheckBox() throws Exception {

		UtilTest.element_click(driver, routine_Stress);
		UtilTest.element_click(driver, relationship_Stress);
		UtilTest.element_click(driver, physical_Stress);
		UtilTest.element_click(driver, situational_Stress);
		UtilTest.element_click(driver, submit);
		Thread.sleep(3000);

	}

}
