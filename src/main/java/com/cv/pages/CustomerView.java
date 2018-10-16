package com.cv.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testbasepackage.TestBase;

public class CustomerView extends TestBase {

	public CustomerView() throws IOException {
		super();

	}

	@FindBy(xpath = "//a[@class='selection-item null']")
	public static WebElement getstarted;

	@FindBy(xpath = "//input[@id='BookingUsername']")
	public static WebElement cvusername;

	@FindBy(xpath = "//input[@id='BookingPassword']")
	public static WebElement cvpassword;

	@FindBy(xpath = "//small[contains(text(),'1h - $20.00')]")
	public static WebElement servicecost;

	@FindBy(xpath = "//a[contains(text(),'Services')]")
	public static WebElement cvservicetab;

	@FindBy(xpath = "//span[contains(text(),'1h - $20.00')]")
	public static WebElement servicecostforstaff;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-lg btn-book-appt null']")
	public static WebElement bookappts;

	@FindBy(xpath = "//div[@class='item-name']")
	public static WebElement selectchild;

	public void servicecosttest() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> win = windows.iterator();
		String custview = win.next();
		String siteadmi = win.next();
		driver.switchTo().window(custview);

	}

}
