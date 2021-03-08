package com.qa.tiatros.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.AppUtil;
import com.qa.tiatros.util.UtilTest;

public class Covid19_check_Page extends TestBase {

	/** Page Factory - OR **/

	By selectCircle = By.xpath("//div[@class='covid-check-link covid-link-3 link-margin']//span[@class='rounded-tip']");
	By neXt = By.xpath("//input[@id='submit_covid']");
	By pageHeadertext = By.xpath("//div[@class=\"ibox-title reg-card-crisis\"]//h2[contains(text(),\"Help Us Understand COVID-19's Impact On Your Life\")]");
	By journeyGuid = By.xpath("//a[@id='jrney_lnk']");
	By journeypupupBack = By.xpath(
			"//div[@id='display_modal_content']//button[@class='btn btn-primary-green m-t-sm w40'][contains(text(),'Back')]");
	By journeypopuptext = By.xpath("//div[@id='display_modal_content']//h2[contains(text(),'Your Journey Guide')]");
	By skiP = By.xpath("//a[contains(text(),'Skip >')]");
	By bacK = By.xpath("//a[contains(text(),'< Back')]");
	

	/*** Validation and Verification ***/
	public void pageValidation() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilTest.textValidation(pageHeadertext, "Help Us Understand COVID-19's Impact On Your Life");
	}

	/**
	 * Business Component
	 * 
	 * @throws Throwable
	 **/
	public CrisisProfilePage gotoProfilePage() throws Throwable {
		Thread.sleep(3000);
		UtilTest.click_js(journeyGuid);
		UtilTest.click_js(journeypupupBack);
		AppUtil.covidCheckBox();
		UtilTest.click_js(neXt);
		Thread.sleep(3000);
		return new CrisisProfilePage();

	}
}
