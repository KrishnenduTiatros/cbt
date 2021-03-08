package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_Directory_Page extends TestBase
{
		
	@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Directory')]")
	WebElement directory_text;
	
	@FindBy(xpath = "//span[contains(text(),'Password')]")
	WebElement pass;

	// Initializing the page object

	public Moderator_Directory_Page() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void verify_directory_LandingPage() {
		String vt = directory_text.getText();
		Assert.assertEquals(vt, "Directory",
				"Directory Text Not Found in Directory Page, Contact Developer");
	}

	// Business Component

	public Moderator_Change_Password_Page click_pass() throws Throwable {
		UtilTest.click_js(pass);
		Thread.sleep(2000);
		UtilTest.staticScreenShot("Passowrd_Landing_Page");
		return new Moderator_Change_Password_Page();
	}
	

}
