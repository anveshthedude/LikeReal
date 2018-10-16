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
	public static WebElement customerview;


	@FindBy(xpath = "//a[@class='fl-preview-link']")
	public static WebElement previewlink;
	

	@FindBy(xpath = "//a[@id='fl-header-toplinks-preview-id']")
	public static WebElement preview;
	

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
		return previewlink.getText();
	

	}
	public void gotocv(){
		preview.click();
		
	}
	
	
	
	

}
