package com.qa.tiatros.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.tiatros.base.TestBase;

/**
 * The class WaitCondition.
 */

public class WaitCondition extends TestBase {
	
	    /**
	     * The constant DELAY. This is delay for WebDriverWait is seconds.
	     */
	    public int DELAY = 15;

	    /**
	     * The private value webDriverWait.
	     */
	    public static  WebDriverWait webDriverWait;
	    /**
	     * The value for WebDriver.
	     */
	   
	    public WaitCondition() {
	        webDriverWait = new WebDriverWait(driver, DELAY);
	    }

	    /**
	     * Wait for visibility of element located by web element.
	     *
	     * @param locator the locator.
	     * @return the web element.
	     */
	    public static WebElement waitForElementToBeClickable(WebElement element) {
	        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	    
	    //WaitCondition wc = new WaitCondition();
		//wc.waitForElementToBeClickable(element).click();


}
