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

	public SettingsPage() throws IOException {
		PageFactory.initElements(driver, SettingsPage.class);
	}

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

	public boolean changeprefs() {

		utilities.framehead();
		settings.click();
		driver.switchTo().defaultContent();
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
		return custpref46.isSelected();

	}

}
