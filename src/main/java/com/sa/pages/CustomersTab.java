package com.sa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testbasepackage.TestBase;
import utilities.Utilities;

public class CustomersTab extends TestBase {

	Utilities utilities;

	@FindBy(xpath = "//a[@id='fl-navtab-item-customers-id']")
	public static WebElement customerstab;

	@FindBy(xpath = "//select[@name='search_by']")
	public static WebElement searchby;

	@FindBy(xpath = "//input[@name='search_text']")
	public static WebElement searchtext;

	@FindBy(xpath = "//input[@name='custsearch']")
	public static WebElement searchbutton;

	@FindBy(xpath = "//input[@value='New Login/Password']")
	public static WebElement newloginpassbtn;

	@FindBy(xpath = "//input[@id='current_password']")
	public static WebElement currentpass;

	@FindBy(xpath = "//input[@name='change_requested_password']")
	public static WebElement newpass;

	@FindBy(xpath = "//input[@name='change_retyped_password']")
	public static WebElement newpassretype;

	@FindBy(xpath = "//input[@id='updatePasswordBtn']")
	public static WebElement savechanges;

	@FindBy(xpath = "//input[@value='Update']")
	public static WebElement update;

	@FindBy(xpath = "//div[@id='customerEnterPassword']")
	public static WebElement updatesucess;

	public CustomersTab() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public boolean updatepass(String searchhcustomer, String selectcustomername, String newpassd) throws Exception {
		// Alert alert = driver.switchTo().alert();

		utilities = new Utilities();
		utilities.framehead();
		customerstab.click();
		driver.switchTo().defaultContent();
		utilities.framemid();
		Select select = new Select(searchby);
		select.selectByVisibleText("All fields in list");
		searchtext.sendKeys(searchhcustomer);
		searchbutton.click();
		String cusxpath = "//a[contains(text(),'";
		String cusxpath1 = "')]";
		WebElement name = driver.findElement(By.xpath(cusxpath + selectcustomername + cusxpath1));
		name.click();
		newloginpassbtn.click();
		currentpass.sendKeys(read.getProperty("username"));
		newpass.sendKeys(newpassd);
		newpassretype.sendKeys(newpassd);
		savechanges.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		boolean updatedsussfully = updatesucess.isDisplayed();
		driver.manage().window().maximize();
		update.click();		
		return updatedsussfully;

	}

}
