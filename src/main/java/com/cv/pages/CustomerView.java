package com.cv.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;

public class CustomerView extends TestBase {

	@FindBy(xpath = "//a[@class='selection-item null']")
	public static WebElement getstarted;

	@FindBy(xpath = "//input[@id='BookingUsername']")
	public static WebElement cvusername;

	@FindBy(xpath = "//input[@id='BookingPassword']")
	public static WebElement cvpassword;

	@FindBy(xpath = "//input[@id='login-screen-submit']")
	public static WebElement clickonlogin;

	@FindBy(xpath = "//a[contains(text(),'Services')]")
	public static WebElement cvservicetab;

	@FindBy(xpath = "//span[contains(text(),'1h - $20.00')]")
	public static WebElement servicecostforstaff;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-lg btn-book-appt null']")
	public static WebElement bookappts;

	@FindBy(xpath = "//div[@class='item-name']")
	public static WebElement selectchild;

	public CustomerView() throws IOException {
		PageFactory.initElements(driver, this);

	}

	public CVServicesPage clickonservicestab() throws Exception {
		
		Actions action = new Actions(driver);
		action.doubleClick(cvservicetab).build().perform();
		
		cvservicetab.click();
		//Thread.sleep(5000);
		return new CVServicesPage();

	}

	public BookNow clickonbooknow() throws IOException {
		bookappts.click();
		return new BookNow();

	}

	

	public void cvlogin() {
		getstarted.click();
		cvusername.sendKeys(read.getProperty("cvusername"));
		cvpassword.sendKeys(read.getProperty("cvpassword"));
		clickonlogin.click();
	}

}
