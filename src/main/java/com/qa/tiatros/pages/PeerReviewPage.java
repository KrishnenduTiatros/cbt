package com.qa.tiatros.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tiatros.base.TestBase;
import com.qa.tiatros.util.UtilTest;

public class PeerReviewPage extends TestBase {

	@FindBy(xpath = "//form[@id='new-comment-2049']//input[@id='comment_body']")
	WebElement peer_text1;

	@FindBy(xpath = "//form[@id='new-comment-2049']//input[@value='Post']")
	WebElement post1;

	@FindBy(xpath = "//form[@id='new-comment-2022']//input[@id='comment_body']")
	WebElement peer_text2;

	@FindBy(xpath = "//form[@id='new-comment-2022']//input[@value='Post']")
	WebElement post2;

	@FindBy(xpath = "//form[@id='new-comment-2002']//input[@id='comment_body']")
	WebElement peer_text3;

	@FindBy(xpath = "//form[@id='new-comment-2002']//input[contains(@value,'Post')]")
	WebElement post3;
	
	@FindBy(xpath = "//button[contains(@class,'cancel')]")
	WebElement peer_no;
	
	@FindBy(xpath = "//button[contains(@class,'confirm')]")
	WebElement peer_yes;
	
	@FindBy(xpath = "//h2[contains(text(),'You have finished your Peer Review!')]")
	WebElement verification_text27;
	
	@FindBy(xpath = "//h2[contains(text(),'You are Done!')]")
	WebElement verification_text28;
	
	@FindBy(xpath = "//button[contains(@class,'confirm')]")
	WebElement ok_button;
	

	// Initializing the page object

	public PeerReviewPage() {
			PageFactory.initElements(driver, this);
		}

	public void peerReviewClick() throws Throwable
	{
		UtilTest.sendkeys(driver, peer_text1, "PeerReview");
		Thread.sleep(2000);
		UtilTest.element_click(driver, post1);
		Thread.sleep(4000);
		UtilTest.sendkeys(driver, peer_text2, "PeerReview");
		Thread.sleep(2000);
		UtilTest.element_click(driver, post2);
		Thread.sleep(4000);
		UtilTest.sendkeys(driver, peer_text3, "PeerReview");
		Thread.sleep(2000);
		UtilTest.element_click(driver, post3);
		Thread.sleep(4000);
		UtilTest.element_click(driver, peer_no);
		Thread.sleep(3000);
		UtilTest.element_click(driver, ok_button);	
		
	}	
}
