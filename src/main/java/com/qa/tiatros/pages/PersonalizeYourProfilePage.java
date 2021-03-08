package com.qa.tiatros.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class PersonalizeYourProfilePage extends TestBase {

	/** Page Factory - OR **/
	By nickname = By.xpath("//input[@id='user_nickname']");
	By submitProfile = By.xpath("//input[@id='submit_profile']");
	By pageHeaderText = By.xpath(
			"//div[@class='ibox-title text-center reg-card-crisis']//h2[contains(text(),'Personalize Your Profile')]");
	By bacK = By.xpath("//a[contains(text(),'< Back')]");
	By skiP = By.xpath("//a[contains(text(),'Skip >')]");
	By uploadImageText = By.xpath("//h3[contains(text(),'Upload Image (Optional)')]");

	/*** All Verifications and Validations **/

	public void pageValidation() {
		UtilTest.textValidation(pageHeaderText, "Personalize Your Profile");
		UtilTest.textValidation(uploadImageText, "Upload Image (Optional)");
	}

	/***** Business Component ****/
	public PreCorseDashboardPage gotodashboard() throws Throwable {

		UtilTest.type(nickname, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Nickname"));
		UtilTest.enableButton(submitProfile);
		UtilTest.click_js(submitProfile);
		return new PreCorseDashboardPage();
	}
}
