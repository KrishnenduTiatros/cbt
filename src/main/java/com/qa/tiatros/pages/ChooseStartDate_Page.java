package com.qa.tiatros.pages;

import org.openqa.selenium.By;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class ChooseStartDate_Page extends TestBase {

	/*** Page Factory - OR ***/
	By selectDate = By.xpath("//select[@id='schedule_date']");
	By neXt = By.xpath("//input[@id='submit_btn']");
	By pageHeaderText = By.xpath("//h2[contains(text(),'Watch Your Welcome Video & Choose Your Start Date')]");
	By playVideo = By.xpath("//span[@class='large-play']");
	By pageStartDateText = By.xpath("//h2[contains(text(),'Choose Your Start Date')]");
	By abotstdate = By.xpath("//a[@id='info_lnk']");
	By chooseStartDate = By.xpath(
			"//div[@id='display_modal_content']//button[@class='btn btn-primary-green m-t-sm'][contains(text(),'Choose Start')]");
	By notifyLaterBtn = By.xpath("//button[@class='confirm']");
	By availableNow = By.xpath("//button[@class='cancel']");
	By notifyLatrTextpopup = By.xpath("//h2[contains(text(),'We Hope To See You Soon')]");
	By logOut = By.xpath("//a[contains(text(),'Log out')]");

	/*** Validation and Verification ***/
	public void pageValidation() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilTest.textValidation(pageHeaderText, "Watch Your Welcome Video & Choose Your Start Date");
		UtilTest.textValidation(pageStartDateText, "Choose Your Start Date");
	}

	/**
	 * Business Component
	 * 
	 * @throws Throwable
	 **/

	public Covid19_check_Page goToCovidPage() throws Throwable {
		UtilTest.click_ele(playVideo);
		UtilTest.click_js(abotstdate);
		UtilTest.click_ele(chooseStartDate);
		UtilTest.selDrpDwn_Index(selectDate, 1);
		UtilTest.click_js(neXt);
		return new Covid19_check_Page();
	}

}
