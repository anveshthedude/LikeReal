package com.sa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;
import utilities.Utilities;

public class SettingsPage extends TestBase {
	Utilities utilities;
	SettingsPage settingspage;

	@FindBy(xpath = "//a[@id='fl-navtab-item-company-id']")
	public static WebElement settings;

	@FindBy(xpath = "//a[@id='fl-sidenav-customerview-id']")
	public static WebElement customerviewpref;

	@FindBy(xpath = "//input[@name='show_svc_price' and @value='yes']")
	public static WebElement custpref46;

	@FindBy(xpath = "//input[@name='update']")
	public static WebElement update;

	@FindBy(xpath = "//td[@class='success_message']")
	public static WebElement updatedsucess;

	@FindBy(xpath = "//input[@value='Edit']")
	public static WebElement editsettings;

	public SettingsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean changeprefs() throws Exception {

		driver.switchTo().defaultContent();
		utilities = new Utilities();
		utilities.frameside();
		customerviewpref.click();
		driver.switchTo().defaultContent();
		utilities.framemid();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		custpref46.click();
		update.click();
		boolean updated = updatedsucess.isDisplayed();
		System.out.println("Pref is" + updated);
		editsettings.click();
		return custpref46.isSelected();

	}
	
	
	
	
	

}
