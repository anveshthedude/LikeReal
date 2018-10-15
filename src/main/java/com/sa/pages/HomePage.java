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

	@FindBy(xpath = "//a[@class='fl-toplinks-dd']")
	public static WebElement customerview;

	@FindBy(xpath = "//a[@id='fl-header-toplinks-preview-id']")
	public static WebElement preview;

	@FindBy(xpath = "//a[@class='fl-preview-link']")
	public static WebElement previewlink;

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String CVlink() throws IOException {

		utilities = new Utilities();
		utilities.framehead();
		Actions act = new Actions(driver);
		act.moveToElement(customerview).build().perform();
		preview.click();
		driver.switchTo().defaultContent();
		utilities.framemid();
		String prelink = previewlink.getText();
		return prelink;

	}

}
