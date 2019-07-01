package com.qa.tiatros.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.DashboardPage;
import com.qa.tiatros.pages.FromWelcomeVidPage;
import com.qa.tiatros.pages.Gad7Page;
import com.qa.tiatros.pages.Phq15Page;
import com.qa.tiatros.pages.Phq9Page;
import com.qa.tiatros.pages.PinPage;
import com.qa.tiatros.pages.ProfilePage;
import com.qa.tiatros.pages.Pss10Page;
import com.qa.tiatros.pages.RegistrationPage;
import com.qa.tiatros.pages.ReturnUserRegistrationPage;
import com.qa.tiatros.pages.SigninPage;
import com.qa.tiatros.pages.SignupPage;
import com.qa.tiatros.pages.Stress_inventoryPage;
import com.qa.tiatros.pages.User_factsPage;
import com.qa.tiatros.util.UtilTest;

public class DataProviderRegistration extends TestBase {

	RegistrationPage rp;
	SignupPage sp;
	SigninPage sgn;
	PinPage p;
	ProfilePage pp;
	FromWelcomeVidPage fwv;
	DashboardPage d;
	Phq9Page p9;
	Gad7Page g7;
	Phq15Page p15;
	Pss10Page p10;
	Stress_inventoryPage si;
	User_factsPage uf;

	public DataProviderRegistration() {
		super();
	}

	@BeforeMethod
	public void initobjects() throws Exception { // This Before Method will run always before any @Test.
		init();
		rp = new RegistrationPage();
		sp = new SignupPage();
		p = new PinPage();
		pp = new ProfilePage();
		fwv = new FromWelcomeVidPage();
		p9 = new Phq9Page();
		g7 = new Gad7Page();
		p15 = new Phq15Page();
		p10 = new Pss10Page();
		si = new Stress_inventoryPage();
		uf = new User_factsPage();
	}

	@Test(dataProvider = "Registration")
	public void readDataFromExcel(String firstName, String lastName, String password, String coupon, String month,
			String day, String year, String gender, String zip, String PledgeName, String User_facts) throws Throwable {
		sp = rp.click_signupLink();
		driver.findElement(By.xpath("//input[@id='user_first_name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys(lastName);
		WebElement em = driver.findElement(By.xpath("//input[@id='user_email']"));
		UtilTest.sendkeys(driver, em, UtilTest.emailidgenerate());
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='user_terms_of_service']//following::ins[@class='iCheck-helper']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//div[@class='modal-content animated bounceInRight']//div[3]//following::button[@class='btn btn-primary m-r-xs'][2]"))
				.click();
		driver.findElement(By.xpath("//input[@id='register']")).click();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "Registration")
	public static Object[][] getDataFromDataprovider() throws Throwable {
		Object r[][] = UtilTest.readExcel("DP");
		
		System.out.println(r[1][0]);
		return r;
	}

}
