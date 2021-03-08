package com.qa.tiatros.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;

public class AppUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;
	public static String t = "";
	public static String demail = "";
	public static WebDriverWait wait;
	public static String testCaseID = "";
	public static String messageSub = "";

	/**********************************************************************************************/

	/**** Customized Method to Genrate Message post data *****/
	public static String generate_message_subject() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmm");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "My Dear Gratitue Messanger....";
		messageSub = beforet.concat(t);
		return messageSub;
	}

	/**** Customized Method which generate message subject for moderator ****/
	public static String gnrt_msg_sub_Moderator() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmm");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "Hello Moderator/Fecilitator....";
		messageSub = beforet.concat(t);
		return messageSub;
	}

	/**** Customized Method for Message Verification *****/
	public static void message_Post_Verification() {
		String ele = driver
				.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"))
				.getText();
		Assert.assertEquals(ele, messageSub, "Message Post Not Found in The Page, Contact Developer");
	}

	/**** Customized Method for message post re-verify *****/
	public static void msg_Post_RE_VerifY() {
		String ele = driver
				.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"))
				.getText();
		String rE = "Re: ";
		String conRe = rE.concat(messageSub);
		Assert.assertEquals(ele, conRe, "Message Post Not Found in The Page, Contact Developer");
	}

	/**** Customized Method which will click a particular message post ****/
	public static void message_Post_click() {
		driver.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"))
				.click();
	}

	/**** Customized Method to click the Hamberger icon ****/
	public static void click_hambergur() {
		driver.findElement(By.xpath("//a[@class='navbar-minimalize minimalize-styl-2 btn']")).click();
	}

	/*** Logout Method for signing out user from the application. ***/
	public static void logout() throws Throwable {
		if (driver.findElement(By.xpath("//li[@class='nav-header']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[@class='nav-label text-danger']")).click();
		} else {
			click_hambergur();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='nav-label text-danger']")).click();
		}
	}

	/***
	 * Customized Method for clicking the LOVE icon in present in the JoyFul Moments
	 * and Message Post in from the application.
	 ***/
	public static void loveIcon() {
		// Take the total count of Love Hearts
		int totalheart = driver.findElements(By.xpath("//*[contains(@class,'text-danger m-r-sm')]")).size();

		// This loop will run till the number of Love Icons found in the page found
		for (int i = 1; i <= totalheart; i++) {
			try {
				driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i
						+ "]/div/child::div/div//a[contains(@class,'text-danger m-r-sm')]/i[@class='fa fa-heart-o fa-2x']"))
						.click();
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*** Customized Method to click on the tiles ****/
	public static void clickonTiles() {
		// Take the total count of the total tiles of the page
		int totalTiles = driver.findElements(By.xpath(
				"//div[contains(@id,'message_post_item')]/div/a[@class='panel-heading message-panel block clearfix']"))
				.size();

		// This loop will run till the number of Love Icons found in the page found
		for (int i = 1; i <= totalTiles; i++) {
			try {
				driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i
						+ "]/div/a[@class='panel-heading message-panel block clearfix']")).click();
				Thread.sleep(3000);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

//	/*** Customized Method for clickin all the tiles ***/
	public static void clickPagination_AllTiles() {
		// Take the total count of the total tiles of the page
		int totalPagination = driver.findElements(By.xpath("//div[@class='pagination pull-right no-margin']/div/li"))
				.size();
		totalPagination = totalPagination - 3;

		// This loop will run till the number of pagination found in the page found

		for (int j = 1; j <= totalPagination; j++) {

			// Take the total count of the total tiles of the page
			int totalTiles = driver.findElements(By.xpath(
					"//div[contains(@id,'message_post_item')]/div/a[@class='panel-heading message-panel block clearfix']"))
					.size();

			// This loop will run till the number of Love Icons found in the page found
			for (int i = 1; i <= totalTiles; i++) {
				try {
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i
							+ "]/div/a[@class='panel-heading message-panel block clearfix']")).click();
					Thread.sleep(3000);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			driver.findElement(
					By.xpath("//div[@class='pagination pull-right no-margin']/div/li/a[contains(text(),'Next →')]"))
					.click();
		}

	}

	public static void counterCheck(String icon) {
		String beforeNum = driver.findElement(By.xpath(
				"//div[contains(@class,'ibox float-e-margins')]//li//a[contains(@data-original-title,'" + icon + "')]"))
				.getText();
		int bNum = Integer.parseInt(beforeNum);
		System.out.println(bNum);
		// Navigate to the message post page
		driver.findElement(By.xpath("//a[contains(text(),'See All Messages')]")).click();

		// Take the total count of the total tiles of the page
		int totalTiles = driver.findElements(By.xpath("//div[contains(@id,'message_post_item')]")).size();

		// This loop will run till the number of Love Icons found in the page found
		for (int i = 1; i <= totalTiles; i++) {

			try {
				driver.findElement(By.xpath("//div[contains(@id,'message_post_item')][" + i + "]/div/a")).click();
				Thread.sleep(5000);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		String afterNum = driver.findElement(By.xpath(
				"//div[contains(@class,'ibox float-e-margins')]//li//a[contains(@data-original-title,'" + icon + "')]"))
				.getText();
		int aNum = Integer.parseInt(afterNum);
		System.out.println(aNum);

		if (bNum > aNum) {
			Assert.assertEquals(true, true);
		} else {
			Assert.assertEquals(false, true, "-----Notification Message not reduced-----");
		}

	}

	public static void clickReportAlert() {
		// Take the total count of the total reportAbouse of the page
		int totalreportAbouse = driver
				.findElements(By.xpath("//*[@class='btn btn-xs pull-right'][contains(text(),'Report')]")).size();

		// This loop will run till the number of Love Icons found in the page found
		for (int j = 1; j <= totalreportAbouse; j++) {
			try {
				driver.findElement(By.xpath("//*[contains(@id,'message_post_item')][" + 1
						+ "]//*[@class='btn btn-xs pull-right'][contains(text(),'Report')]")).click();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static void fetchValue(String PStage) {

		System.out.println("Data Fetched :- " + PStage);
		for (int i = 1; i <= 4; i++) {
			String value;
			switch (i) {
			case 1:
				value = driver.findElement(By
						.xpath("//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"
								+ PStage + "')]//following::*[" + i + "]"))
						.getText();
				System.out.println("PSS10 = " + value);
				break;

			case 2:
				value = driver.findElement(By
						.xpath("//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"
								+ PStage + "')]//following::*[" + i + "]"))
						.getText();
				System.out.println("GAD7 = " + value);
				break;
			case 3:
				value = driver.findElement(By
						.xpath("//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"
								+ PStage + "')]//following::*[" + i + "]"))
						.getText();
				System.out.println("PHQ9 = " + value);
				break;

			case 4:
				value = driver.findElement(By
						.xpath("//table[@class='table table-bordered validative-masure']//tbody/tr/*[contains(text(),'"
								+ PStage + "')]//following::*[" + i + "]"))
						.getText();
				System.out.println("PHQ15 = " + value);
				break;
			}
		}
	}

	public static String returnGoalColor() throws Throwable {

		String cC = "";
		try {

			String colour = driver
					.findElement(By.xpath("//table[starts-with(@id,'DataTables_Table_0')]/tbody/tr/td[6]/label"))
					.getAttribute("style");

			int index1 = colour.indexOf(" ");
			index1 = index1 + 1;
			int index2 = colour.indexOf(";");
			String cCode = colour.substring(index1, index2);

			if (cCode.equalsIgnoreCase("rgb(255, 140, 0)")) {
				System.out.println("Goals Delay Color  = ORANGE");
				cC = "Goals Delay Color  = ORANGE";
			} else if (cCode.equalsIgnoreCase("rgb(255, 0, 0)")) {
				System.out.println("Goals Delay Color  = RED");
				cC = "Goals Delay Color  = RED";
			} else if (cCode.equalsIgnoreCase("rgb(0, 128, 0)")) {
				System.out.println("Goals Delay Color  = GREEN");
				cC = "Goals Delay Color  = GREEN";
			} else if (cCode.equalsIgnoreCase("rgb(0, 0, 205)")) {
				System.out.println("Goals Delay Color  = BLUE");
				cC = "Goals Delay Color  = BLUE";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cC;
	}

	public static void verifyGratitudeText(String ms1) {
		// Message posted
		String expect = ms1;

		// This will capture the message to validate the actual message
		String actual_msg = driver
				.findElement(By.xpath("//div[@class=\"feed-activity-list journal-list\"][1]/div/div/span[1]"))
				.getText();

		// Verify error message
		Assert.assertEquals(actual_msg, expect);
	}

	// Method used for verification text, message on any web page.
	public static void textMessageValidation(WebElement we, String s) {
		WebElement we1 = we;
		String actual_Text = we1.getText();
		String expected_Text = s;
		Assert.assertEquals(actual_Text, expected_Text);
	}

	// Check edit button present and update the existing text.
	public static void editJournalcomments() throws Throwable {
		// Take the total count of the edit option present in the page
		int totaledit = driver
				.findElements(By.xpath("//div[@class=\"ibox-content gratitude-box-content\"]//div/div/div/span[2]/a/i"))
				.size();

		// This loop will run till the number of edit buttons found in the page
		for (int j = 2; j <= totaledit + 1; j++) {
			try {
				driver.findElement(By.xpath(
						"//div[@class=\"ibox-content gratitude-box-content\"]//div[" + j + "]/div/div/span[2]/a/i"))
						.click();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// add extra comments in the textbox
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date date = new Date();
			String d = sdf.format(date);
			driver.findElement(By.xpath("//div[@class=\"modal-body\"]/textarea")).clear();
			driver.findElement(By.xpath("//div[@class=\"modal-body\"]/textarea"))
					.sendKeys(prop.getProperty("JournalEdit") + "_" + d);
			Thread.sleep(2000);
			// Click on the Save button
			driver.findElement(By.xpath("//div[@class=\"modal-footer\"]/div/input[@type='submit']")).click();
			Thread.sleep(5000);

		}

	}

	/***
	 * Customized method for creating random selection of covid page checkbox
	 ****/

	public static void covidCheckBox() {
		By covidselect = By
				.xpath("//div[@data-id='" + UtilTest.generateRandomNumber(4) + "']//span[@class='rounded-tip']");
		UtilTest.click_js(covidselect);
	}

	/****
	 * Customized Method for click the "Meet Your Tiatros Guides" section in the
	 * application
	 ***/

	public static void clickGuides() {

		for (int i = 1; i <= 4; i++) {

			By firstrowGuide = By
					.xpath("//div[contains(@class,'user-leaders text-center m-b-sm')]//a[" + i + "]//img[1]");
			UtilTest.click_ele(firstrowGuide);
			popUpCloseIcon();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int j = 1; j <= 3; j++) {
			By secondrowGuide = By
					.xpath("//div[contains(@class,'user-leaders text-center col-xs-10 col-xs-offset-1')]//a[" + j
							+ "]//img[1]");
			UtilTest.click_ele(secondrowGuide);
			popUpCloseIcon();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**** Custom Method to close any pop-up in the application ***/
	public static void popUpCloseIcon() {
		By closePopUp = By.xpath("//span[contains(text(),'×')]");
		UtilTest.click_ele(closePopUp);
	}

	/**** Custom Method to choose randam background in the application ***/
	public static void selectBGColor() {
		By bgColor = By
				.xpath("//div[@id='Theme_Modal']/div/div/div[2]/div/a[" + UtilTest.generateRandomNumber(3) + "]");
		UtilTest.click_js(bgColor);
	}

	/**** Custom Method to choose tour functionlity in the pre-course dasboard ***/
	public static void tOurPrecourse(int i) {

		for (int j = 0; j <= i; j++) {
			By xpathTour = By.xpath(
					"//div[@id='step-" + j + "']/div[3]/button[@data-role='next' or contains(text(),'Finish Tour')]");
			UtilTest.click_js(xpathTour);
		}

	}

}
