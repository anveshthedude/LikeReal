package com.cv.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;

public class BookNow extends TestBase{
	
	@FindBy(xpath = "//div[@class='item-name']")
	public static WebElement selectchild;
	
	@FindBy(xpath = "//span[contains(text(),'1h - $20.00')]")
	public static WebElement servicecostforstaff;
	
	public BookNow() throws IOException{
		PageFactory.initElements(driver, this);
		
	}
	
	public void checkstaffprice(){
		selectchild.click();
		servicecostforstaff.getText();
		
	}

}
