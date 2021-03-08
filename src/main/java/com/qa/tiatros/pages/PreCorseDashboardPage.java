package com.qa.tiatros.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.AppUtil;
import com.qa.tiatros.util.UtilTest;

public class PreCorseDashboardPage extends TestBase {

	By selectTheme = By.xpath("//a[@id='theme_btn']");
	By stateMyPurpose = By.xpath("//div[@class='ibox-content crisis-gray-border-top']/div/a");
	By messureMyStress = By.xpath("//div[@class='ibox-content']/div/a");
	By cpoptions = By.xpath("//div[@id='div_checkboxes']//div[3]//div[1]//ins[1]");
	By cpoptions1 = By.xpath("//div[@id='div_checkboxes']//div[1]//div[1]//ins[1]");
	By cpoptions2 = By.xpath("//div[@id='div_checkboxes']//div[2]//div[1]//ins[1]");
	By neXtSpan = By.xpath("//button[@id='next_span']");
	By fact_response = By.xpath("//textarea[@id='user_fact_response']");
	By shar_Preference = By.xpath("//div[@id='div_others']//div[2]//div[1]//ins[1]");
	By finish = By.xpath("//input[contains(@name,'commit')]");
	By takePledgeVideo = By.xpath("//span[@class='large-play']");
	By pageHeaderText = By.xpath("//small[@class='text-primary' and contains(text(),'Welcome')]");
	By popUpClose = By.xpath("//span[contains(text(),'×')]");
	By homeIcon = By.xpath("//ol[@class='breadcrumb']//li[@class='active']");
	By whyStressLinc = By.xpath("//a[contains(text(),'Why measure my stress?')]");
	By whyChosLinc = By.xpath("//a[contains(text(),'Why choose a purpose?')]");
	By meetGuidLinc = By.xpath("//a[contains(text(),'Why meet my guides?')]");
	By whyPeerLinc = By.xpath("//a[contains(text(),'Why peer groups?')]");
	By whyCommunityLinc = By.xpath("//span[@class='text-center pull-right']");
	By backgrdpopUP = By.xpath("//a[@id='close_btn']");
	By guidesDone = By.xpath("//button[contains(text(),'Done')]");
	By sIgnPleadge = By.xpath("//button[@id='pledge_accept_btn']");
	By textBoxPleadge = By.xpath("//div[@class='col-md-12']/div/input[@id='user_pledge']");
	//div[@id="step-0"]/div[3]/button[@data-role='next']
	//div[@id="step-3"]/div[3]/button[@data-role="next" or contains(text(),'Finish Tour')]
	
	
	/** Validation and Verification **/

	public void pageValidation() {
		try {
			Thread.sleep(4000);
			UtilTest.click_ele(backgrdpopUP);
			Thread.sleep(5000);
			UtilTest.textValidateUsingSubString(pageHeaderText, "Welcome");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void completeDashboard() throws Throwable {
		try {
			Thread.sleep(5000);
			AppUtil.selectBGColor();
			UtilTest.click_js(backgrdpopUP);
			Thread.sleep(4000);
			AppUtil.tOurPrecourse(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilTest.click_js(guidesDone);
		UtilTest.type(textBoxPleadge, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "User_facts"));
		UtilTest.click_js(sIgnPleadge);
		UtilTest.click_js(stateMyPurpose);
		UtilTest.click_js(cpoptions);
		UtilTest.click_js(cpoptions1);
		UtilTest.click_js(cpoptions2);
		UtilTest.click_js(neXtSpan);
		UtilTest.type(fact_response, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "User_facts"));
		UtilTest.click_js(shar_Preference);
		UtilTest.click_js(finish);
		
	}
	
	public void clickAllDashboard() throws Throwable {
		Thread.sleep(4000);
		try {
			AppUtil.selectBGColor();
			UtilTest.click_js(backgrdpopUP);
			AppUtil.tOurPrecourse(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilTest.click_js(guidesDone);
		UtilTest.type(textBoxPleadge, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "User_facts"));
		UtilTest.click_js(sIgnPleadge);
		AppUtil.clickGuides();
		UtilTest.click_js(takePledgeVideo);
		UtilTest.click_ele(whyChosLinc);
		AppUtil.popUpCloseIcon();
		UtilTest.click_ele(whyStressLinc);
		AppUtil.popUpCloseIcon();
		UtilTest.click_ele(meetGuidLinc);
		AppUtil.popUpCloseIcon();
		UtilTest.click_ele(whyPeerLinc);
		AppUtil.popUpCloseIcon();
		UtilTest.click_js(whyCommunityLinc);
		AppUtil.popUpCloseIcon();
		UtilTest.click_js(stateMyPurpose);
		UtilTest.click_js(cpoptions);
		UtilTest.click_js(cpoptions1);
		UtilTest.click_js(cpoptions2);
		UtilTest.click_js(neXtSpan);
		UtilTest.type(fact_response, UtilTest.readExcel("SignUP", UtilTest.dYnamicTestCaseGeneration(), "User_facts"));
		UtilTest.click_js(shar_Preference);
		UtilTest.click_js(finish);
	}

	public CrisisPss10Page pss10Question() throws Exception {
		Thread.sleep(5000);
		UtilTest.click_js(messureMyStress);
		Thread.sleep(5000);
		return new CrisisPss10Page();
	}

	public void logoutM() throws Throwable {
		Thread.sleep(5000);
		AppUtil.logout();
	}
}