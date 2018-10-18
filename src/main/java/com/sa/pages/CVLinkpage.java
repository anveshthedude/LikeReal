package com.sa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cv.pages.CustomerView;

import testbasepackage.TestBase;
import utilities.Utilities;

public class CVLinkpage extends TestBase {
	Utilities utilities;

	@FindBy(xpath = "//a[@class='fl-preview-link']")
	public static WebElement previewlinkurl;

	public CVLinkpage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public CustomerView gotocv() throws IOException {
		utilities = new Utilities();
		driver.switchTo().defaultContent();
		utilities.framemid();
		previewlinkurl.click();
		//System.out.println(driver.getWindowHandle());
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> s1 = windows.iterator();
		String siteadmin = s1.next();
		//driver.switchTo().window(siteadmin);
		 System.out.println("this is site   "+driver.getTitle());
		String custom = s1.next();
		driver.switchTo().window(custom);
		System.out.println("this is cus   "+driver.getTitle());
		return new CustomerView();

	}
}
