package com.sa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//a[@id='fl-sidenav-appointmenthistory-id']")
	public static WebElement appthistory;

	@FindBy(xpath = "//*[@id=\"shadow-container\"]/div/div/div/div/table/tbody/tr[4]/td[1]/a")
	public static WebElement thirdapptinhistory;

	@FindBy(xpath = "//input[@id='cancel-link']")
	public static WebElement clickoncancelappt;

	@FindBy(xpath = "//input[@id='send_cancel_cust']")
	public static WebElement custnotifi;

	@FindBy(xpath = "//button[@class='button-text-orange button-small']")
	public static WebElement orngcancelbutn;

	@FindBy(xpath = "//textarea[@id='reason']")
	public static WebElement canclreason;

	@FindBy(xpath = "//input[@class='button-text-blue button-small']")
	public static WebElement canclwithreasonbutn;

	@FindBy(xpath = "//span[@class='success_message']")
	public static WebElement cancelsucessmess;

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

	public boolean cancelappt(String searchhcustomer, String selectcustomername) throws Exception {
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
		driver.switchTo().defaultContent();
		utilities.frameside();
		appthistory.click();
		driver.switchTo().defaultContent();
		utilities.framemid();
		// String parent=driver.getWindowHandle();
		thirdapptinhistory.click();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> getwindow = windows.iterator();
		String mainwin = getwindow.next();
		String maw = getwindow.next();

		driver.switchTo().window(maw);

		clickoncancelappt.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector(\"button[class='button-text-orange button-small']\").click()");

		Set<String> windowsss = driver.getWindowHandles();

		Iterator<String> once = windowsss.iterator();

		String h1 = once.next();
		String h2 = once.next();
		String h3 = once.next();
		driver.switchTo().window(h3);

		System.out.println("Cancellation reason window " + driver.getTitle());
		

		canclreason.sendKeys("aptest");
		canclwithreasonbutn.click();
		// driver.switchTo().alert().accept();
		driver.switchTo().window(h2);
		boolean cancelled = cancelsucessmess.isDisplayed();
		if (cancelled == true) {
			System.out.println("Appt Cancelled");
			driver.close();
		} else {
			System.out.println("not cancelled");
			driver.close();
		}

		driver.switchTo().window(h1);
		return cancelled;
	}

}
