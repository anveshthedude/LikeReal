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

	@FindBy(xpath = "//img[@alt='AppointmentPlus Enterprise Scheduling Software']")
	static WebElement logo;

	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this); // homepage as well

	}

	// Test methods
	public HomePage ValidateloginPagetitle() throws Exception {
		System.out.println("name is    " + read.getProperty("username"));
		username.sendKeys(read.getProperty("username"));
		password.sendKeys(read.getProperty("password"));
		loginbtn.click();

		return new HomePage();

	}

	public boolean verifycompanylogo() {
		return logo.isDisplayed();

	}

}