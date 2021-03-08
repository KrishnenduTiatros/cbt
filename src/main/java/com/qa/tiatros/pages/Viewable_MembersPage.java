package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class Viewable_MembersPage extends TestBase {
	// Page factory - OR

	@FindBy(xpath = "//strong[@class='hidden-xs-cbt']")
	WebElement mYGroup;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeIcon;

	public void mYGroupVerification() {
		boolean vt = mYGroup.isDisplayed();
		Assert.assertEquals(vt, true, "My Message Text Not Found");
	}

	// Initializing the page object

	public Viewable_MembersPage() {
		PageFactory.initElements(driver, this);
	}

	// Business Component

	public CourseDashboardPage clickHomeIcon() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, homeIcon);
		Thread.sleep(5000);
		return new CourseDashboardPage();
	}
}
