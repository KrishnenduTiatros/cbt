package com.qa.tiatros.pages;

import org.openqa.selenium.By;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class CrisisProfilePage extends TestBase {
	/** Page Factory - OR **/

	By month = By.xpath("//select[@id='date_month']");
	By day = By.xpath("//select[@id='date_day']");
	By year = By.xpath("//select[@id='date_year']");
	By gender = By.xpath("//select[@id='user_gender']");
	By otherGender = By.xpath("//input[@id='other_gender']");
	By pronouns = By.xpath("//select[@id='pronouns']");
	By pregnentSwitch = By.xpath("//div[@id='pregnant_div']//span[@class='switchery switchery-default']");
	By otherPronoun = By.xpath("//input[@id='other_pronoun']");
	By job = By.xpath("//select[@id='job']");
	By othrjob = By.xpath("//input[@id='other_department']");
	By country = By.xpath("//select[@id='user_locations_country_code']");
	By zipCode = By.xpath("//input[@id='zip_code']");
	By mobileNotification = By.xpath("//div[6]//span[1]");
	By phnNumber = By.xpath("//input[@id='phone']");
	By neXt = By.xpath("//input[@id='submit_profile']");
	By back = By.xpath("//a[contains(@class,'link-no-underline m-t-xs')]");
	By pageHeaderText = By.xpath("//div[@class='ibox-title text-center reg-card-crisis']//h2[@class='m-b-xs']");
	By bacK = By.xpath("//a[@class='link-no-underline m-t-xs']");

	/*** Validation and Verification ***/
	public void pageValidation() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilTest.textValidation(pageHeaderText, "Build Your Profile");
	}

	/**
	 * Business Component
	 * 
	 * @throws Throwable
	 **/

	public PersonalizeYourProfilePage gotoProfilePersonalizePage() throws Throwable {
		Thread.sleep(7000);
		UtilTest.type(zipCode, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Zip"));
		UtilTest.select_DrpDwn_ByValue(month,
				UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Month"));
		UtilTest.select_DrpDwn_ByValue(day, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Day"));
		UtilTest.select_DrpDwn_ByValue(year,
				UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Year"));
		UtilTest.select_DrpDwn_ByValue(gender,
				UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Gender"));
		UtilTest.select_DrpDwn_ByValue(pronouns,
				UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Pronouns"));
		UtilTest.select_DrpDwn_ByValue(job, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "Job"));
		UtilTest.click_js(neXt);
		return new PersonalizeYourProfilePage();
	}
}
