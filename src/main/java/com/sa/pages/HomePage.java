package com.sa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;
import utilities.Utilities;

public class HomePage extends TestBase {
	Utilities utilities;

	@FindBy(xpath = "//a[@id='fl-toplinks-customerview-id']")
	public static WebElement hoveroncustomerview;

	@FindBy(xpath = "//a[@class='fl-preview-link']")
	public static WebElement previewlinkurl;

	@FindBy(xpath = "//a[@id='fl-header-toplinks-preview-id']")
	public static WebElement preview;

	@FindBy(xpath = "//a[@id='fl-navtab-item-company-id']")
	public static WebElement settings;

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

}
