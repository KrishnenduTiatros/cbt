package com.qa.tiatros.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.JavaScriptUtil;
import com.qa.tiatros.util.UtilTest;

public class CrisisPinPage extends TestBase {

	/** Page Factory - OR **/

	By verify_pin = By.xpath("//input[@type=\"submit\"]");// div[@id="verify_pin"]//div[@class='ibox-content
															// reg-card-crisis']//div[@class='form-group text-center
															// m-t-sm m-b-none']//input[2]
	By pinTextBx = By.xpath(
			"//div[@id=\"verify_pin\"]//div//div[@class='form-group textinput m-b-xs m-t-sm']//input[@id='user_pin']");
	By pageHeaderText = By.xpath("//h2[contains(text(),'Please Check Your Email')]");

	/*** All Verifications and Validations **/

	public void pageValidation() {
		UtilTest.textValidation(pageHeaderText, "Please Check Your Email");
	}

	/***** Business Component ****/

	public ChooseStartDate_Page verifyPin() throws Throwable {
		String pin = UtilTest.fetchGmailPin("krishnendu@tiatros.com", "q1w2e3R$");
		JavaScriptUtil.sendKeysUsingJSWithId("user_pin", pin);
		UtilTest.enableButton(verify_pin);
		UtilTest.click_js(verify_pin);
		return new ChooseStartDate_Page();
	}
}