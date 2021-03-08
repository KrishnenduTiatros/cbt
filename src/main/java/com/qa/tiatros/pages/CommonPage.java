package com.qa.tiatros.pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class CommonPage extends TestBase {

	// Page factory - OR

	// public static WebElement cNext =
	// driver.findElement(By.xpath("//a[contains(text(),'Next')]"));

	// Initializing the page object

	

	public CommonPage() {
		PageFactory.initElements(driver, this);
	}

	public static void dynamic_Radio_Click() {

		// Take the count of number of Questions in the current page
		int total_Questions = driver
				.findElements(By.xpath(
						"(//div[@class='panel panel-success'])[1]//div[@class='vote-item pcl-item option-check']"))
				.size();

		// Take the count of number of Answers
		int total_Answers = driver.findElements(By.xpath(
				"(//div[@class='panel panel-success'])[1]//div[@class='vote-item pcl-item option-check'][1]/div/div/div"))
				.size();

		// creating object for Random Class
		Random rand = new Random();

		// This loop will run till the number of Questions in the page found
		for (int q = 1; q <= total_Questions; q++) {
			// Generating Random answers
			int to_click = rand.nextInt((total_Answers - 1) + 1) + 1;
			driver.findElement(
					By.xpath("(//div[@class='panel panel-success'])[1]//div[@class='vote-item pcl-item option-check']["
							+ q + "]/div/div/div[" + to_click + "]//ins"))
					.click();

		}
	}

	public static void dynamic_TextBox() {

		// Gather all the webelements inside the List.
		List<WebElement> elements = driver.findElements(By.xpath("//textarea[starts-with(@id,'course_question')]"));

		// Iterate the List
		for (WebElement ele : elements) {
			// Converting the dynamic driver into web element
			WebElement chk = driver.findElement(By.xpath("//textarea[@id='" + ele.getAttribute("id") + "']"));

			// Checking the web elemnent is present or not in the page
			if (chk.isDisplayed() == true) {
				UtilTest.sendkeys(driver, chk, prop.getProperty("Note"));

				// driver.findElement(By.xpath("//textarea[@id='"+ele.getAttribute("id")+"']")).sendKeys("Test
				// Data Set");

			} else {
				break;
			}

		}
	}

	public static void sessionSteps() throws Throwable {
		// Gather all the steps inside a course.
		int steps = driver
				.findElements(By.xpath(
						"//div[@id='collapse3']//span[@class='media-object sessions-number'][contains(text(),'')]"))
				.size();

		// This loop will run till as per the total steps accrued
		for (int i = 1; i <= steps; i++) {
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//div[@id='collapse3']//span[@class='media-object sessions-number'][contains(text(),'" + i
							+ "')]"))
					.click();

			UtilTest.scrollDown();
			Thread.sleep(2000);
			// if (cNext.isDisplayed()) {
			// cNext.click();

		}

	}

	public static void courseActivity() throws Throwable {
		Thread.sleep(4000);
		// UtilTest.element_click(driver, cNext);
	}

	

}
