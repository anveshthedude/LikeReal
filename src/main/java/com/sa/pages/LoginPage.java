package com.sa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;

public class LoginPage extends TestBase { // incridible111112222222

	// WebDriver driver;

	// page factory

	// Page constants
	@FindBy(id = "login")
	static WebElement username;

	@FindBy(id = "password")
	static WebElement password;

	@FindBy(className = "btn-form")
	static WebElement loginbtn;

	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this); // homepage as well

	}

	// Test methods
	public String ValidateloginPagetitle() {

		username.sendKeys(read.getProperty("username"));
		password.sendKeys(read.getProperty("password"));
		loginbtn.click();

		return driver.getTitle();

	}

}
