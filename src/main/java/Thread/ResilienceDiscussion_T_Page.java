package Thread;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.pages.Course_Sessions_page;
import com.qa.tiatros.util.UtilTest;

public class ResilienceDiscussion_T_Page extends TestBase 
{
	// Page factory - OR
	
	@FindBy(xpath = "//div[@class='row wrapper border-bottom white-bg page-heading']/div//li[3]//strong[contains(text(),'2: Resilience Discussion')][2]")
	WebElement verification_text21;

	@FindBy(xpath = "//div[@id='wizard-p-0']")
	WebElement video;

	@FindBy(xpath = "//li[@aria-hidden=\"false\"]/a[contains(text(),'Next')]")
	WebElement next_button;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[2]/td/textarea[@id='course_question_1728']")
	WebElement thought_Prompt1;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[4]/td/textarea[@id='course_question_1729']")
	WebElement thought_Prompt2;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[6]/td/textarea[@id='course_question_1731']")
	WebElement thought_Prompt3;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[6]/td/textarea[@id='course_question_1732']")
	WebElement thought_Prompt4;

	@FindBy(xpath = "//table[@class='table table-bordered table-thoughtprompt']/tbody//tr[6]/td/textarea[@id='course_question_1733']")
	WebElement thought_Prompt5;

	@FindBy(xpath = "//div[@class='actions clearfix']/ul/li[3]")
	WebElement finish;

	// Initializing the page object

	public ResilienceDiscussion_T_Page() {
			PageFactory.initElements(driver, this);
		}

	// All Verifications and Validations

	public void verification_text21() {
		boolean vt = verification_text21.isDisplayed();
		Assert.assertEquals(vt, true);
	}

	// Business Component

	public Course_Sessions_page course_tour2() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, video);
		Thread.sleep(5000);
		UtilTest.element_click(driver, next_button);
		Thread.sleep(2000);
		UtilTest.sendkeys(driver, thought_Prompt1, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, thought_Prompt2, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, thought_Prompt3, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, thought_Prompt4, prop.getProperty("Note"));
		UtilTest.sendkeys(driver, thought_Prompt5, prop.getProperty("Note"));
		Thread.sleep(3000);
		UtilTest.element_click(driver, finish);
		Thread.sleep(4000);
		return new Course_Sessions_page();
	}

}
