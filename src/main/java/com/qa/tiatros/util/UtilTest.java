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
import javax.mail.internet.AddressException;
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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.sun.org.apache.xpath.internal.operations.Equals;

public class UtilTest extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;
	public static String t = "";
	public static String demail = "";
	public static WebDriverWait wait;
	public static String testCaseID = "";
	public static String messageSub = "";

	/***** Methods for click and sendKeys using explicit wait and JsExecutor *****/

	/***** Method to type any charrecter using BY class *****/
	public static void type(By locator, String value) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		WebElement wait = new WebDriverWait(driver, timeout)
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.sendKeys(value);
	}

	// This Method used to type any given word in fields
	public static void sendkeys(WebDriver driver, WebElement element, String value) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	// This Method used to click any element in the application
	public static void element_click(WebDriver driver, WebElement element) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void click_js(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", locator);
	}

	/***** Method to click any object using By Class and Javascript *****/
	public static void click_js(By locator) {
		WebElement ele = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	/**** Method used for verification text, message on any web page. ***/
	public static void textValidation(By locator, String s) {
		WebElement we1 = UtilTest.returnElement(locator);
		String actual_Text = we1.getText();
		String expected_Text = s;
		Assert.assertEquals(actual_Text, expected_Text,
				expected_Text + "Text Validation Miss-Match, Please Contact Developer!!");
	}

	/***** Method to click any object using By Class *****/
	public static void click_ele(By locator) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		WebElement wait = new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
		wait.click();
	}

	/***** Customized Method which will return a WebElement ****/
	public static WebElement returnElement(By locator) {
		WebElement ele = driver.findElement(locator);
		return ele;
	}

	/***** Customized method to select By Value from the drop down ****/
	public static void selDrpDwn_Index(By locator, int value) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement ele = driver.findElement(locator);
		Select os = new Select(ele);
		os.selectByIndex(value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/***** Method to type any charrecter using BY class *****/
	public static void doSendKeys(By locator, String value) {
		try {
			// wait visible
			WebElement ele = driver.findElement(locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception got occurred while entering value in a field.....");
		}
	}

	// Wait
	public static void waitVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	// This method used to scroll down a web page
	public static void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Ele = element;
		js.executeScript("arguments[0].scrollIntoView();", Ele);
	}

	// This method to select By Text from the drop down
	public static void select_dropdown(WebElement element, String value) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select os = new Select(element);
		os.selectByVisibleText(value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// This method to select By Value from the drop down
	public static void select_DrpDwn_ByValue(WebElement element, String value) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select os = new Select(element);
		os.selectByValue(value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** ****************************************** **/

	// This method will generate dynamic mail id with the help of current time
	public static String emailidgenerate() {
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "krishnendu+";
		String aftert = "@tiatros.com";
		demail = beforet.concat(t).concat(aftert);
		System.out.println(demail);
		return demail;
	}

	// This method will return dynamic testcase id for fetching data
	public static String dYnamicTestCaseGeneration() {
		// creating object for Random Class
		Random r = new Random();
		int totaltc = 20;

		// Generating Random TestCase
		int testCaseGeneration = r.nextInt((totaltc - 1) + 1) + 1;
		String tcadd = "TD";
		testCaseID = tcadd + testCaseGeneration;
		return testCaseID;

	}

	public static void by_click(WebDriver driver, By element1) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element1));
		WebElement element = driver.findElement(element1);
		element.click();
	}

	// This Method read data from the excel file
	@SuppressWarnings("deprecation")
	public static String readExcel(String sheetName, String rowName, String colNum) throws Throwable {

		Cell cell;
		Row row;
		File src = new File(prop.getProperty("ExcelPath"));
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();
		row = sheet.getRow(0);
		int col_Num = -1;
		String ret = "";

		// Create a loop to read the column number from which user want to read.
		for (int i = 0; i < numCols; i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colNum.trim()))
				col_Num = i;
		}

		for (int j = 1; j <= numRows; j++) {
			if (rowName.equals(sheet.getRow(j).getCell(0).getStringCellValue())) {
				cell = sheet.getRow(j).getCell(col_Num);

				if (cell.getCellTypeEnum() == CellType.STRING) {
					ret = cell.getStringCellValue();
					// System.out.println(ret);
					break;
				}

				else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {

					String cellText = String.valueOf(cell.getNumericCellValue());
//					if (HSSFDateUtil.isCellDateFormatted(cell)) {
//						// format in form of M/D/YY
//						double d = cell.getNumericCellValue();
//						Calendar cal = Calendar.getInstance();
//						cal.setTime(HSSFDateUtil.getJavaDate(d));
//						cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
//						cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
					int index = cellText.indexOf(".");
					ret = cellText.substring(0, index);
					// System.out.println(ret);
					break;

				}
			}
			wb.close();
		}
		return ret;
	}

	// This Method will write data in the excel
	@SuppressWarnings("deprecation")
	public static void writeExcel(String sheetName, String rowName, String colNum) throws Throwable {
		Cell cell;
		Row row;
		File src = new File(prop.getProperty("ExcelPath"));
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();
		row = sheet.getRow(0);
		int col_Num = -1;
		String ret = "";

		// Create a loop to read the column number from which user want to read.
		for (int i = 0; i < numCols; i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colNum.trim()))
				col_Num = i;
		}
		for (int j = 1; j <= numRows; j++) {
			if (rowName.equals(sheet.getRow(j).getCell(0).getStringCellValue())) {

				cell = row.createCell(col_Num);
				cell.setCellValue(demail);
				break;

			}
			wb.close();
		}

	}

	public static Object[][] readExcel(String sheetName) throws Throwable {

		XSSFCell cell;
		File src = new File(prop.getProperty("ExcelPath"));
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = 11;// sheet.getRow(0).getLastCellNum();
		Object[][] ob = new Object[numRows][numCols];

		// Create a loop to read the row values
		for (int i = 1; i < numRows; i++) {
			Row row = sheet.getRow(i);

			// Create a loop to read cell values in a row
			for (int j = 0; j < numCols; j++) {

				cell = (XSSFCell) row.getCell(j);
				System.out.print(cell + "|");
				ob[i][j] = cell;
			}
			System.out.println();
		}
		wb.close();
		return ob;

	}

	public static String title() {
		String t = driver.getTitle();
		return t;
	}

	public static String generate_message_subject() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmm");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "My Dear Gratitue Messanger....";
		messageSub = beforet.concat(t);
		return messageSub;
	}

	public static String gnrt_msg_sub_Moderator() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmm");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "Hello Moderator/Fecilitator....";
		messageSub = beforet.concat(t);
		return messageSub;
	}

	public static void message_Post_Verification() {
		String ele = driver
				.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"))
				.getText();
		Assert.assertEquals(ele, messageSub, "Message Post Not Found in The Page, Contact Developer");
	}

	public static void msg_Post_RE_VerifY() {
		String ele = driver
				.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"))
				.getText();
		String rE = "Re: ";
		String conRe = rE.concat(messageSub);
		Assert.assertEquals(ele, conRe, "Message Post Not Found in The Page, Contact Developer");
	}

	public static void message_Post_click() {
		driver.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"))
				.click();

	}

	public static void acceptPopUP() {
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void dismissPopUP() {
		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void click_hambergur() {
		driver.findElement(By.xpath("//a[@class='navbar-minimalize minimalize-styl-2 btn']")).click();
	}

	// Logout Method for signing out user from the application.
	public static void logout() throws Throwable {
		if (driver.findElement(By.xpath("//li[@class='nav-header']")).isDisplayed()) {
			driver.findElement(By.xpath("//span[@class='nav-label text-danger']")).click();

		} else {
			click_hambergur();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='nav-label text-danger']")).click();

		}
	}

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

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
	}

	/**** Customized Method for retriving PIN fro Gmail Account ***/
	public static String fetchGmailPin(String email, String pass) throws Throwable {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://mail.google.com/");

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("krishnendu@tiatros.com");
		driver.findElement(By.xpath("//div[@class='dG5hZc']//div/div[@id='identifierNext']")).click();
		Thread.sleep(2000);

		By password = By.xpath("//input[@type='password']");
		UtilTest.type(password, "");
		By next = By.xpath("//span[contains(text(),'Next')]");
		UtilTest.click_js(next);

		// driver.findElement(By.xpath("//input[@type='password']")).sendKeys("q1w2e3R$");
		// driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(7000);
		By searchMail = By.xpath("//input[@aria-label='Search mail']");
		UtilTest.type(searchMail, demail);
		//driver.findElement(By.xpath("//input[@aria-label='Search mail']")).sendKeys(demail);
		Thread.sleep(3000);
		By searchMailClick = By.xpath("//button[@aria-label='Search mail']");
		UtilTest.click_js(searchMailClick);
		//driver.findElement(By.xpath("//button[@aria-label='Search mail']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ae4 UI UJ nH oy8Mbf id']")).click(); // //div[@class='ae4 UI UJ']
		Thread.sleep(3000);
		String s = driver
				.findElement(
						By.xpath("//span[contains(text(),'ACCOUNT SETUP CODE: ')]/following-sibling::span[starts-with(@id,'m_')]"))
				.getText();
		System.out.println(s);
		try {

			driver.findElement(By.xpath("//div[starts-with(@class,'gb_ja') and @role='button']")).click();

			//driver.findElement(By.xpath("//a[starts-with(@id,'gb_')]")).click();
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

			e.printStackTrace();
		}
		driver.close();
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		return s;
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

	public static void takeScreenshot(String testMethodName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(prop.getProperty("SCPath") + testMethodName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Screenshot Capture on a particular situation
	public static String staticScreenShot(String imageName) { // imageName represent what will be the starting name of
																// the image, it can be testcase/projectname/etc as per
																// user requirement

		// Fetching current system time for unique image identification
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmm");
		Date date = new Date();
		String t = dateFormat.format(date);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File((prop.getProperty("SCPath")) + imageName + "_" + t + ".png"));
		} catch (IOException e) {
			System.out.println("File Exception- " + e.getMessage());
			e.printStackTrace();
		}

		String imagePath = (prop.getProperty("SCPath")) + imageName + "_" + t + ".png";
		return imagePath;
	}

	public static void sendEmailNotification(String sendTo, String mailSubject, String path1, String bodyText)
			throws Throwable {
		// Recipient's Mail id
		String receipientTo = sendTo;

		// Sender's Mail id
		String senderFrom = "krishnendu@tiatros.com";

		// Path of PDF test report
		String path = path1;

		// Getting System properties
		Properties prop = System.getProperties();

		// Setting up smtp host
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");

		// Creating a new session for smtp
		Session session = Session.getDefaultInstance(prop);
		MimeMessage msg = new MimeMessage(session);

		// Instance of From Internet address
		InternetAddress frmAddress = new InternetAddress(senderFrom);

		// Instance of To Internet address
		InternetAddress toAddress = new InternetAddress(receipientTo);

		// Setting up sender's address
		msg.setFrom(frmAddress);

		// Setting up recipient's address
		msg.addRecipient(Message.RecipientType.TO, toAddress);

		// Setting email's subject
		msg.setSubject(mailSubject);
		BodyPart msgBody = new MimeBodyPart();

		// Setting email's message body
		msgBody.setText(bodyText);
		// msgBody.setText("This is Automated Mail through Selenium Project.");

		// Instance of second part
		Multipart multiPart = new MimeMultipart();
		multiPart.addBodyPart(msgBody);

		// Another mail body
		msgBody = new MimeBodyPart();

		// Path to pdf file for attachment
		DataSource source = new FileDataSource(path);
		DataHandler dataHandler = new DataHandler(source);
		msgBody.setDataHandler(dataHandler);
		msgBody.setFileName(path);
		multiPart.addBodyPart(msgBody);
		msg.setContent(multiPart);

		// Authentication and connection establishment to the sender's mail
		Transport transport = session.getTransport("smtps");
		transport.connect("smtp.gmail.com", 465, "krishnendu@tiatros.com", "");
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		System.out.println("Mail Sent successfully");
	}

	/***** Customized method to select By Value from the drop down ****/
	public static void select_DrpDwn_ByValue(By locator, String value) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement element = driver.findElement(locator);
		Select os = new Select(element);
		os.selectByVisibleText(value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/****
	 * Method used for validation of a particular word/text message on any web page
	 * using SubString.
	 ***/
	public static void textValidateUsingSubString(By locator, String s) {
		WebElement we1 = UtilTest.returnElement(locator);
		String actual_Text = we1.getText();
		String subtext = actual_Text.substring(0, 7);
		String expected_Text = s;
		Assert.assertEquals(subtext, expected_Text, "Text Validation Miss-Match, Please Contact Developer!! ");
	}

	/**** Customized method enables a button when it is disabled in nature ***/
	public static void enableButton(By locator) {
		WebElement ele = UtilTest.returnElement(locator);
		String className = ele.getAttribute("name");
		// System.out.println(className);

		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		String toenable = "document.getElementsByName('" + className + "')[0].removeAttribute('disabled');";
		javascript.executeScript(toenable);
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
	 * Customized Method to generate Random Number by accepting upper limit and
	 * lower limit
	 ***/
	public static int generateRandomNumber(int upperlimit) {
		int number = 0;
		// creating object for Random Class
		Random r = new Random();
		number = r.nextInt((upperlimit - 1) + 1) + 1;
		return number;
	}

}
