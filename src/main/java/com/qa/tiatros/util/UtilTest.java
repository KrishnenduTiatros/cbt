package com.qa.tiatros.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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

	// This method used to scroll down a web page
	public static void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Ele = element;
		js.executeScript("arguments[0].scrollIntoView();", Ele);
	}

	// This method to select element from the drop down
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

	public static void by_click(WebDriver driver, By element1) {
		int timeout = Integer.parseInt(prop.getProperty("Explicitwait"));
		WebElement element = driver.findElement(element1);
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
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
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		String t = dateFormat.format(date);
		String beforet = "My Dear Messengers .... ";
		String messageSub = beforet.concat(t);
		return messageSub;
	}

	public static void message_Post_Verification() {
		WebElement ele = driver
				.findElement(By.xpath("//div[contains(@id,'message_post_item')]//h3[contains(text(),'" + t + "')]"));
		boolean vt = ele.isDisplayed();
		Assert.assertEquals(vt, true, "Uploaded Text Not Found");

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

	public static void logout() {
		driver.findElement(By.xpath("//span[@class='nav-label text-danger']")).click();
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

	public static String fetchGmailPin(String email, String pass) throws Throwable {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://mail.google.com/");

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("krishnendu@tiatros.com");
		driver.findElement(By.xpath("//div[@class='dG5hZc']//div/div[@id='identifierNext']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("q1w2e3R$");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@aria-label='Search mail']")).sendKeys(demail);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@aria-label='Search Mail']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='ae4 UI UJ']")).click();
		Thread.sleep(3000);
		String s = driver
				.findElement(
						By.xpath("//span[contains(text(),'Your pin:')]/following-sibling::span[starts-with(@id,'m_')]"))
				.getText();
		System.out.println(s);
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[starts-with(@class,'gb_ja') and @role='button']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[starts-with(@id,'gb_')]")).click();
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().accept();
		} catch (Exception e) {

			e.printStackTrace();
		}
		driver.close();
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		return s;
	}

	public static void returnGoalColor() {
		String colour = driver
				.findElement(By.xpath("//table[starts-with(@id,'DataTables_Table_0')]/tbody/tr/td[6]/label"))
				.getAttribute("style");

		int index1 = colour.indexOf(" ");
		index1 = index1 + 1;
		int index2 = colour.indexOf(";");
		String cCode = colour.substring(index1, index2);

		if (cCode.equalsIgnoreCase("rgb(255, 140, 0)")) {
			System.out.println("Goals Delay Color  = ORANGE");
		} else if (cCode.equalsIgnoreCase("rgb(255, 0, 0)")) {
			System.out.println("Goals Delay Color  = RED");
		} else if (cCode.equalsIgnoreCase("rgb(0, 128, 0)")) {
			System.out.println("Goals Delay Color  = GREEN");
		} else if (cCode.equalsIgnoreCase("rgb(0, 0, 205)")) {
			System.out.println("Goals Delay Color  = PURPLE");
		}
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
	public static String staticScreenShot(String imageName) {
		// Fetching current system time for unique image identification
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		String t = dateFormat.format(date);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(
					"/Users/krishnendu/eclipse-workspace/Tiatros/Screenshots/" + imageName + "_" + t + ".png"));
		} catch (IOException e) {
			System.out.println("File Exception- " + e.getMessage());
			e.printStackTrace();
		}
		
		String imagePath = "/Users/krishnendu/eclipse-workspace/Tiatros/Screenshots/" + imageName + "_" + t + ".png";
		return imagePath;
	}

	public static void sendEmailNotification(String sendTo, String mailSubject, String path1) throws Throwable {
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
		msgBody.setText("This is Automated Mail through Selenium Project.");

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
		transport.connect("smtp.gmail.com", 465, "krishnendu@tiatros.com", "q1w2e3R$");
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
		System.out.println("Mail Sent successfully");

	}

}
