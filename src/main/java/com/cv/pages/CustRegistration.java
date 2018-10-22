package com.cv.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;

public class CustRegistration extends TestBase {

	@FindBy(xpath = "//input[@value='Create an Account']")
	public static WebElement signupbtn;

	@FindBy(xpath = "//input[@name='first_name']")
	public static WebElement firstname;

	@FindBy(xpath = "//input[@name='last_name']")
	public static WebElement lastname;

	@FindBy(xpath = "//input[@name='night_phone']")
	public static WebElement evenphon;

	@FindBy(xpath = "//input[@name='email']")
	public static WebElement email;

	@FindBy(xpath = "//option[@value='1067']")
	public static WebElement heards;

	@FindBy(xpath = "//input[@name='contact_okay' and @value='yes']")
	public static WebElement contactokQ;

	@FindBy(xpath = "//input[@name='email_okay' and @value='no']")
	public static WebElement emailokQ;

	public CustRegistration() throws IOException {
		PageFactory.initElements(driver, this);

	}
	
	public void addcust(String firstname, String lastname, String evenphon, 
			String email, String heards, String contactokQ,String emailokQ ){
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
