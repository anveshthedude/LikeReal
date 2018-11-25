package com.sa.pages;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;
import utilities.Utilities;

public class HomePage extends TestBase {
	Utilities utilities;
	HomePage homepage;

	@FindBy(xpath = "//a[@id='fl-toplinks-customerview-id']")
	public static WebElement hoveroncustomerview;

	@FindBy(xpath = "//a[@class='fl-preview-link']")
	public static WebElement previewlinkurl;

	@FindBy(xpath = "//a[@id='fl-header-toplinks-preview-id']")
	public static WebElement preview;

	@FindBy(xpath = "//a[@id='fl-navtab-item-company-id']")
	public static WebElement settings;

	@FindBy(xpath = "//a[@id='fl-header-toplinks-signout-id']")
	public static WebElement signout;

	@FindBy(xpath = "//a[contains(text(),'Packages')]")
	public static WebElement packge;

	@FindBy(xpath = "//a[@id='fl-navtab-item-packages-id']")
	public static WebElement packgeid;

	@FindBy(xpath = "//a[@id='fl-sidenav-plugin-Text Message Reminders-id']")
	public static WebElement textremind;

	@FindBy(xpath = "//a[@id='fl-toplinks-marketplace-id']")
	public static WebElement marketplace;

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public CVLinkpage CVlink() throws IOException {

		utilities = new Utilities();
		utilities.framehead();
		Actions act = new Actions(driver);
		act.moveToElement(hoveroncustomerview).build().perform();
		preview.click();
		return new CVLinkpage();

	}

	public SettingsPage clickonsettings() throws Exception {
		utilities = new Utilities();
		utilities.framehead();
		settings.click();
		return new SettingsPage();
	}

	public void signout() throws Exception {
		driver.switchTo().defaultContent();
		utilities = new Utilities();
		utilities.framehead();
		signout.click();

	}

	public static HashMap<Integer, String> calendar() {

		HashMap<Integer, String> selectcal = new HashMap<Integer, String>();

		selectcal.put(1, "1920");
		selectcal.put(2, "1942");
		selectcal.put(3, "617");

		return selectcal;
	}

	public boolean pakage() throws IOException {
		utilities = new Utilities();
		utilities.framehead();
		return driver.getPageSource().contains("Packages");

	}

	public boolean textreminder() {
		marketplace.click();
		driver.switchTo().defaultContent();
		utilities.frameside();
		return textremind.isDisplayed();

	}

}
