package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Moderator_Channels_Page extends TestBase  {
	
	// Page factory - OR

			@FindBy(xpath = "//strong[@class='hidden-xs-cbt' and contains(text(),'Channels')]")
			WebElement channel_homepage;

			@FindBy(xpath = "//span[contains(text(),'Facilitator Tools')]")
			WebElement faci_tool;
			
			@FindBy(xpath="//span[contains(text(),'Messages')]")
			WebElement messages;
			
			@FindBy(xpath="//span[contains(text(),'Channels')]")
			WebElement channels;
			
			@FindBy(xpath="//span[contains(text(),'Review Content')]")
			WebElement reviewContent;
			


			// Initializing the page object

			public Moderator_Channels_Page() {
				PageFactory.initElements(driver, this);
			}

			// All Verifications and Validations

			public void verify_channels_LandingPage() {
				boolean vt = channel_homepage.isDisplayed();
				Assert.assertEquals(vt, true, "Channel Landing Page Not Found Check With Developer");
			}
			
			
			// Business Component

			public Moderator_ReviewContent_Page click_ReviewContent() throws Throwable
			{
				UtilTest.click_js(reviewContent);
				Thread.sleep(2000);
				UtilTest.staticScreenShot("ReviewContent_Landing_Page");
				return new Moderator_ReviewContent_Page();
			}

}
