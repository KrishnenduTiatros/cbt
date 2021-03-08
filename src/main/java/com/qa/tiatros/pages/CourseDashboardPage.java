package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class CourseDashboardPage extends TestBase {

	// Page factory - OR

	@FindBy(xpath = "//h2[@id='msg_title']")
	WebElement myMessage_title;

	@FindBy(xpath = "//ol[@class='breadcrumb']//li[@class='active']")
	WebElement home_Icon;

	@FindBy(xpath = "//a[@id='option_message']//img[@class='camera-icon-message']")
	WebElement new_Message;

	@FindBy(xpath = "//a[@id='option_moj']//img[@class='camera-icon-message']")
	WebElement new_photo;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-circle btn-lg dropdown-toggle']")
	WebElement addPhoto;

	@FindBy(xpath = "//a[@id='camera_btn']")
	WebElement capture_image;

	@FindBy(xpath = "//div[@class=\"ibox-title clearfix message-ibox-title\"]//li[4]//a[1]//img")
	WebElement peer_review;

	@FindBy(xpath = "//div[@id='page-wrapper']//li[3]//a[1]//img[1]")
	WebElement notification;

	// @FindBy(xpath = "//li[1]//a[1]//img[1]")
	@FindBy(xpath = "//ul[@class='nav navbar-top-links messenger-links']/li/a/img[@alt='Facilitator Message']")
	WebElement fecilitetor;

	@FindBy(xpath = "//div[@id='page-wrapper']//li[2]//a[1]//img[1]")
	WebElement group_message;

	@FindBy(xpath = "//a[contains(text(),'See All Messages')]")
	WebElement seeAllMessages;

	@FindBy(xpath = "//input[@id='message_post_title']")
	WebElement subject_message;

	@FindBy(xpath = "//input[@id='title']")
	WebElement subject_joyful;

	@FindBy(xpath = "//button[@id='snap']")
	WebElement capture;

	@FindBy(xpath = "//textarea[@id='message_post_content']")
	WebElement body_message;

	@FindBy(xpath = "//button[contains(@class,'btn btn-danger close-form')]")
	WebElement cancel_btn;

	@FindBy(xpath = "//button[contains(text(),'Post')]")
	WebElement post_btn;

	@FindBy(xpath = "//button[@id='save-item']")
	WebElement post;

	@FindBy(xpath = "//div[contains(@class,'ibox float-e-margins')]//li[1]//a[1]")
	WebElement facilitator_icon;

	@FindBy(xpath = "//h2[@id='msg_title']")
	WebElement my_message_Text;

	@FindBy(xpath = "//a[@class='navbar-minimalize minimalize-styl-2 btn']")
	WebElement hambarger;

	@FindBy(xpath = "//span[@class='nav-label text-danger']")
	WebElement logOut;

	@FindBy(xpath = "//a[contains(text(),'My Group')]")
	WebElement myGroup;

	@FindBy(xpath = "//span[@class='custom-nav-label m-l-xs']")
	WebElement myPrograms;

	@FindBy(xpath = "//a[contains(text(),'Joyful Moments')]")
	WebElement joyMoments;

	@FindBy(xpath = "//a[contains(text(),'Peer Review')]")
	WebElement peerReview;

	@FindBy(xpath = "//a[contains(text(),'Program Overview')]")
	WebElement programOverview;

	@FindBy(xpath = "//span[@class='custom-nav-label']")
	WebElement settings;

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	WebElement profile;

	@FindBy(xpath = "//input[@id='user_first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='user_last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='user_current_password']")
	WebElement cPassword;

	@FindBy(xpath = "//input[@id='submit_profile']")
	WebElement submitProfile;

	@FindBy(xpath = "//button[@class='confirm']")
	WebElement continueDialogbox;

	@FindBy(xpath = "//span[contains(text(),'My Progress')]")
	WebElement mYProgress;

	@FindBy(xpath = "//a[contains(text(),'peer')]")
	WebElement peerDetails;

	@FindBy(xpath = "//input[@id='gratitude_journal_message_body']")
	WebElement gratitude_textBox;

	@FindBy(xpath = "//span[@class='input-group-btn']/input[@type='submit']")
	WebElement post_TO;

	@FindBy(xpath = "//div[@class='ibox-title clearfix message-ibox-title']/form/div/div[2]/child::ins")
	WebElement groupIcon;

	@FindBy(xpath = "//div[@class='ibox-title clearfix message-ibox-title']/form/div/div[3]/child::ins")
	WebElement mYOrganisationIcon;

	@FindBy(xpath = "//div[@class='ibox-title clearfix message-ibox-title']/form/div/div[4]/child::ins")
	WebElement worldIcon;

	@FindBy(xpath = "//div[@class='input-group gratitude-form']//label")
	WebElement validationMessage;
	
	@FindBy(xpath = "//span[@class=\"col-xs-12 text-center\"]/a/i")
	WebElement seeAll;
	
	@FindBy(xpath = "//div[@class='radio radio-inline no-padding']//div[@class='iradio_square-blue']/ins[@class=\"iCheck-helper\"]")
	WebElement facilitator;	
	

	// Initializing the page object

	public CourseDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// All Verifications and Validations

	public void courseDashboardVerification() {
		boolean vt = myMessage_title.isDisplayed();
		Assert.assertEquals(vt, true, "My Message Text Not Found");
		boolean vt1 = home_Icon.isDisplayed();
		Assert.assertEquals(vt1, true, "Home Icon Not Found");
	}
	

	// Business Component

	public MessagePostPage add_MessagePost() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, new_Message);
		Thread.sleep(3000);
		UtilTest.sendkeys(driver, subject_message, UtilTest.generate_message_subject());
		UtilTest.sendkeys(driver, body_message, prop.getProperty("Note1"));
		UtilTest.element_click(driver, post_btn);
		Thread.sleep(5000);
		return new MessagePostPage();
	}
	
	public MessagePostPage postMsg_Moderator() throws Throwable {
		UtilTest.click_js(new_Message);
		Thread.sleep(3000);
		UtilTest.click_js(facilitator);
		UtilTest.sendkeys(driver, subject_message, UtilTest.gnrt_msg_sub_Moderator());
		UtilTest.sendkeys(driver, body_message, prop.getProperty("Note1"));
		UtilTest.element_click(driver, post_btn);
		Thread.sleep(5000);
		return new MessagePostPage();
	}
	
	

	public MessagePostPage add_MultiplePost() throws Throwable {
		int limit = Integer.parseInt(prop.getProperty("NumberMP"));

		for (int i = 1; i <= limit; i++) {
			Thread.sleep(5000);
			UtilTest.element_click(driver, new_Message);
			Thread.sleep(3000);
			UtilTest.sendkeys(driver, subject_message, UtilTest.generate_message_subject());
			UtilTest.sendkeys(driver, body_message, prop.getProperty("Note1"));
			UtilTest.element_click(driver, post_btn);
			Thread.sleep(5000);
		}

		return new MessagePostPage();
	}

	public MessagePostPage add_JoyfulMoments() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, new_photo);
		Thread.sleep(3000);
		UtilTest.sendkeys(driver, subject_joyful, UtilTest.generate_message_subject());
		UtilTest.element_click(driver, addPhoto);
		Thread.sleep(3000);
		UtilTest.element_click(driver, capture_image);
		// Thread.sleep(5000);
		// UtilTest.acceptPopUP();
		Thread.sleep(6000);
		UtilTest.element_click(driver, capture);
		Thread.sleep(3000);
		UtilTest.element_click(driver, post);
		Thread.sleep(5000);
		return new MessagePostPage();
	}

	public void click_HeartIconAll() throws Throwable {
		Thread.sleep(5000);
		UtilTest.loveIcon();
	}

	public void click_all_notificationIcons() throws Throwable {
		Thread.sleep(5000);
		UtilTest.element_click(driver, facilitator_icon);
		Thread.sleep(3000);
		UtilTest.element_click(driver, notification);
		Thread.sleep(3000);
		UtilTest.element_click(driver, group_message);
		Thread.sleep(3000);
		UtilTest.element_click(driver, peer_review);
	}

	public void logoutM() throws Throwable {
		Thread.sleep(5000);
		UtilTest.click_hambergur();
		Thread.sleep(2000);
		UtilTest.logout();
	}

	public MessagePostPage click_SeeAllMessage() throws Throwable {
		Thread.sleep(4000);
		UtilTest.element_click(driver, seeAllMessages);
		Thread.sleep(4000);
		return new MessagePostPage();
	}

	public Viewable_MembersPage clickMyGroup() {
		UtilTest.element_click(driver, hambarger);
		UtilTest.click_js(myPrograms);
		UtilTest.click_js(myGroup);
		return new Viewable_MembersPage();
	}

	public MessagePostPage addMessageFromJMF() throws Throwable {
		UtilTest.element_click(driver, hambarger);
		UtilTest.click_js(myPrograms);
		UtilTest.click_js(joyMoments);
		Thread.sleep(5000);
		UtilTest.element_click(driver, new_Message);
		Thread.sleep(3000);
		UtilTest.sendkeys(driver, subject_message, UtilTest.generate_message_subject());
		UtilTest.sendkeys(driver, body_message, prop.getProperty("Note1"));
		UtilTest.element_click(driver, post_btn);
		Thread.sleep(5000);
		return new MessagePostPage();
	}

	public void clickReport() {
		UtilTest.clickReportAlert();
	}

	public void notificationCounterCheck() {
		UtilTest.counterCheck("Notification");
	}

	public void groupMessageCounterCheck() {
		UtilTest.counterCheck("Group Message");
	}

	public void changeProfileDetails() throws Throwable {
		UtilTest.element_click(driver, hambarger);
		UtilTest.element_click(driver, settings);
		UtilTest.element_click(driver, profile);
		firstName.clear();
		UtilTest.sendkeys(driver, firstName, prop.getProperty("CfName"));
		lastName.clear();
		UtilTest.sendkeys(driver, lastName, prop.getProperty("ClName"));
		Thread.sleep(3000);
		UtilTest.sendkeys(driver, cPassword, prop.getProperty("Password"));
		UtilTest.element_click(driver, submitProfile);
		Thread.sleep(4000);
		UtilTest.element_click(driver, continueDialogbox);
		Thread.sleep(4000);
	}

	public PersonalProgress myProgress() {
		UtilTest.element_click(driver, hambarger);
		UtilTest.element_click(driver, mYProgress);
		return new PersonalProgress();
	}

	public void clickPeerReview() throws Throwable {
		UtilTest.element_click(driver, peer_review);
		Thread.sleep(5000);
		UtilTest.element_click(driver, peerDetails);
		Thread.sleep(5000);
	}

	public Course_Sessions_page checkInCourse() {
		UtilTest.element_click(driver, hambarger);
		UtilTest.element_click(driver, myPrograms);
		UtilTest.element_click(driver, programOverview);
		return new Course_Sessions_page();
	}

	public void addGratitudeInDashboard_ME() throws Throwable {
		String mS = UtilTest.generate_message_subject();
		UtilTest.sendkeys(driver, gratitude_textBox, mS);
		UtilTest.element_click(driver, post_TO);
		Thread.sleep(3000);
		UtilTest.verifyGratitudeText(mS);
		
		
	}

	public void addGratitudeInDashboard_Group() throws Throwable {
		String mS = UtilTest.generate_message_subject();
		UtilTest.click_js(groupIcon);
		UtilTest.sendkeys(driver, gratitude_textBox, mS);
		UtilTest.element_click(driver, post_TO);
		Thread.sleep(3000);
		UtilTest.verifyGratitudeText(mS);
	}

	public void addGratitudeInDashboard_MyOrganisation() throws Throwable {
		String mS = UtilTest.generate_message_subject();
		UtilTest.click_js(mYOrganisationIcon);
		UtilTest.sendkeys(driver, gratitude_textBox, mS);
		UtilTest.element_click(driver, post_TO);
		Thread.sleep(3000);
		UtilTest.verifyGratitudeText(mS);
	}

	public void addGratitudeInDashboard_World() throws Throwable {
		String mS = UtilTest.generate_message_subject();
		UtilTest.click_js(worldIcon);
		UtilTest.sendkeys(driver, gratitude_textBox, mS);
		UtilTest.element_click(driver, post_TO);
		Thread.sleep(3000);
		UtilTest.verifyGratitudeText(mS);
	}

	public void validateBlankPost() {
		UtilTest.element_click(driver, post_TO);
		String actual_msg = validationMessage.getText();
		String expect_msg = "This field is required."; 
		// Verify error message
		Assert.assertEquals(actual_msg, expect_msg);
	}
	
	public Gratitudes_Page seeAllMessage ()
	{
		UtilTest.click_js(seeAll);
		return new Gratitudes_Page();
	}
	
}