package com.cv.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;

public class CVServicesPage extends TestBase {

	@FindBy(xpath = "//small[contains(text(),'1h - $20.00')]")
	public static WebElement servicecost;

	public CVServicesPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	public String verifyservicecost() {
		String price = servicecost.getText();
		return price;

	}

}
