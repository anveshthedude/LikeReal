package com.sa.test.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sa.pages.HomePage;
import com.sa.pages.LoginPage;
import com.sa.pages.SettingsPage;

import testbasepackage.TestBase;
import utilities.Utilities;

public class HomePageTest2 extends TestBase {

	static FileInputStream files;
	LoginPage loginpage;
	Utilities utilities;
	HomePage homepage;
	SettingsPage settingspage;
	HomePageTest homepagetest;
	static XSSFSheet sheet;
	static XSSFWorkbook book;
	boolean yes;
	boolean text;
	static FileOutputStream fileout;
	static boolean googcal;

	public HomePageTest2() throws IOException {
		super();

	}

	public static void excelfileread() throws IOException {
		files = new FileInputStream(
				"C:\\Users\\anvesh.durgam\\git\\LikeReal\\src\\main\\java\\com\\testdata\\spark2.xlsx");
		book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("spark"));
		sheet = book.getSheet("spark");

	}

	public static void excelfilewrite() throws IOException {
		fileout = new FileOutputStream(
				new File("C:\\Users\\anvesh.durgam\\git\\LikeReal\\src\\main\\java\\com\\testdata\\spark2.xlsx"));
		book.write(fileout);
		fileout.close();

	}

	@Test
	public void sparktest() throws Exception {

		excelfileread();
		sheet.getLastRowNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			String acct = sheet.getRow(i).getCell(0).getStringCellValue();
			initizlization();
			loginpage = new LoginPage();
			loginpage.portalLogin();

			driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys(acct);

			driver.findElement(By.xpath("//input[@id='search']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"/html/body/table[5]/tbody/tr/td/table/tbody/tr[4]/td/table[2]/tbody/tr[2]/td[1]/form/input[5]"))
					.click();
			Thread.sleep(3000);
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> win = windows.iterator();
			String portal = win.next();
			String siteadmin = win.next();
			driver.switchTo().window(siteadmin);
			homepage = new HomePage();
			homepage.clickonsettings();
			settingspage = new SettingsPage();

			yes = settingspage.mobile();
			if (yes == true) {
				System.out.println("Mobile responsive is visible for " + acct + " " + yes);
				excelfileread();
				driver.quit();
				/*
				 * files = new FileInputStream(
				 * "C:\\Users\\anvesh.durgam\\git\\LikeReal\\src\\main\\java\\com\\testdata\\Test.xlsx"
				 * ); book = new XSSFWorkbook(files); sheet = book.getSheet("spark");
				 */
				sheet.getRow(i).createCell(2).setCellValue("Mobile responsive is visible for " + acct + yes);
				excelfilewrite();

			} else {
				try {

					boolean packg = homepage.pakage();
					if (packg == true) {
						System.out.println("Packages is enabled in this account, Spark May be not alowed    " + acct
								+ " " + packg);

						text = homepage.textreminder();
						System.out.println("Text Reminder is Enabled" + acct + " " + text);
						sheet.getRow(i).createCell(2).setCellValue("Text Reminder is Enabled  " + acct + text);
						excelfilewrite();
						driver.quit();

					} else
						System.out.println("Package is NOT Enabled in this account  " + acct);

					text = homepage.textreminder();
					System.out.println("Text Reminder is Enabled" + acct + text);
					sheet.getRow(i).createCell(2).setCellValue("Text Reminder is Enabled  " + acct + " " + text);
					excelfilewrite();
					driver.quit();
				} catch (Exception e2) {
					// e2.printStackTrace();
					System.out.println("Text Reminder is NOT enabled  " + acct);
					try {
						googcal = settingspage.googleca();
						System.out.println("Google Calendar is Enabled  " + googcal + " " + acct);
						sheet.getRow(i).createCell(2)
								.setCellValue("Google Calendar is Enabled  " + acct + " " + googcal);
						excelfilewrite();
						driver.quit();
					} catch (Exception e) {

						System.out.println("Google Calendar is NOT Enabled   " + acct);
						sheet.getRow(i).createCell(2)
								.setCellValue("Google Calendar is NOT Enabled  " + acct + " " + googcal);
						excelfilewrite();
						driver.quit();

					}

				}
				driver.quit();

			}

		}

	}

}
