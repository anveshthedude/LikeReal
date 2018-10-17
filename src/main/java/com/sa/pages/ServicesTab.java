package com.sa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;
import utilities.Utilities;

public class ServicesTab extends TestBase {
	Utilities utilities;

	@FindBy(xpath = "//a[@id='fl-navtab-item-services-id']")
	public static WebElement servicestab;

	@FindBy(linkText = "test service 2")
	public static WebElement secondservice;

	@FindBy(id = "default_cost")
	public static WebElement costfield;

	@FindBy(name = "update")
	public static WebElement clickupdate;

	@FindBy(xpath = "//input[@value='10.00']")
	public static WebElement currentcost;

	@FindBy(name = "edit")
	public static WebElement clickedit;

	@FindBy(linkText = "test1")
	public static WebElement firstservice;

	@FindBy(xpath = "//textarea[@name='internalDescription']")
	public static WebElement internalDescription;

	@FindBy(xpath = "//a[@id='fl-header-toplinks-signout-id']")
	public static WebElement signout;

	public ServicesTab() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void ClickOnServiceTab() throws IOException {
		utilities = new Utilities();
		utilities.framehead();
		servicestab.click();
		driver.switchTo().defaultContent();

	}

	public String UpdateServiceCost() {
		utilities.framemid();
		secondservice.click();
		costfield.clear();
		costfield.sendKeys("20");
		clickupdate.click();
		clickedit.click();
		String price = costfield.getAttribute("value");
		driver.switchTo().defaultContent();
		return price;
	}

	public String UpdateDescription() throws IOException {

		ClickOnServiceTab();
		utilities.framemid();
		firstservice.click();
		internalDescription.clear();
		internalDescription.sendKeys("frommac");
		clickupdate.click();
		clickedit.click();
		String getdata = internalDescription.getText();
		driver.switchTo().defaultContent();
		return getdata;

	}

	public void SignOut() throws IOException {
		utilities = new Utilities();
		
		utilities.framehead();
		signout.click();

	}

}
