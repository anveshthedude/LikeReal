package com.sa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;
import utilities.Utilities;

public class StaffTabPage extends TestBase {
	//public static TestUtil testutil;
	public static Utilities utilities;

	@FindBy(name = "screen_name")
	public static WebElement screenname;

	@FindBy(xpath = "//input[@value='a']")
	public static WebElement accestype;

	@FindBy(xpath = "//a[@id='fl-navtab-item-staff-id']")
	public static WebElement stafftab;

	/*
	 * @FindBy(linkText = "1, test (test1)") // a[contains(text(),'aapptest')]
	 * public static WebElement staffname;
	 */

	@FindBy(linkText = "Profile Information")
	public static WebElement daysoff;

	@FindBy(name = "update")
	public static WebElement update;

	@FindBy(xpath = "//img[@src='../ap_images_v2/success.gif']")

	public static WebElement sucessmessage;

	// pagemethods

	public StaffTabPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	public boolean CheckifAccesstypeIsSelected() throws InterruptedException, IOException {

		utilities = new Utilities();

		Thread.sleep(3000);

		utilities.framehead();
		// driver.switchTo().frame("header");
		stafftab.click();
		driver.switchTo().defaultContent();
		utilities.framemid();
		StaffTabPage.selectstaff("AP, TEST (TEST1)");
		System.out.println(accestype.isSelected());
		return true;

	}

	public void UpdateDaysOff() throws IOException {

		utilities = new Utilities();

		utilities.framehead();
		stafftab.click();
		driver.switchTo().defaultContent();
		utilities.framemid();
		StaffTabPage.selectstaff("aapptest");
		driver.switchTo().defaultContent();
		utilities.frameside();
		daysoff.click();
		driver.switchTo().defaultContent();
		utilities.framemid();
		update.click();
		boolean good = sucessmessage.isDisplayed();

		if (sucessmessage.isDisplayed()) {

			System.out.println(good);

		} else
			System.out.println("Schedule may be not updated");

	}

	public static void selectstaff(String staffname) {

		driver.findElement(By.xpath("//a[text()='" + staffname + "']")).click();

	}

}
