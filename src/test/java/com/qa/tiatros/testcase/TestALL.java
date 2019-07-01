package com.qa.tiatros.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.qa.tiatros.pages.CommonPage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestALL {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/krishnendu/Selenium/chromedriver 3");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://cbtfuture.tiatros.com/users/sign_in");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	@Test
	public void hitbutton() throws Exception {
		driver.findElement(By.id("user_email")).sendKeys("krishnendu+154817@tiatros.com");
		driver.findElement(By.id("user_password")).sendKeys("q1w2e3R$");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='col-lg-11 pull-center dashboard-new']/div[1]/ul/li[@id='course']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='collapse1']/div/div/a/div[1]/span[contains(text(),'4')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='accordion']/div/div[1]/h4/a[@aria-controls='collapse-84']/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(@for,'checkbox_227')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(@for,'checkbox_228')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(@for,'checkbox_229')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();
		Thread.sleep(3000);		
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[@class='irs js-irs-0 irs-with-grid']/span[6]"));
		action.clickAndHold(ele).moveByOffset(32,0).release();
		Thread.sleep(3000);
		
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='irs js-irs-1 irs-with-grid']/span[6]"));
		action.clickAndHold(ele1).moveByOffset(64,0).release();
		Thread.sleep(3000);
		
		WebElement ele2 = driver.findElement(By.xpath("//span[@class='irs js-irs-2 irs-with-grid']/span[6]"));
		action.clickAndHold(ele2).moveByOffset(32,0).release();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class=\"nav-label text-danger\"]")).click();
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}