package com.sa.test.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sa.pages.HomePage;
import com.sa.pages.LoginPage;
import com.sa.pages.SettingsPage;

import testbasepackage.TestBase;
import utilities.Utilities;

public class HomePageTest extends TestBase {

	FileInputStream files;
	LoginPage loginpage;
	Utilities utilities;
	HomePage homepage;
	SettingsPage settingspage;

	public HomePageTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {

		initizlization();
		loginpage = new LoginPage();
		loginpage.portalLogin();

	}

	// @BeforeMethod
	public void setup1() throws Exception {

		initizlization();
		loginpage = new LoginPage();
		loginpage.ValidateloginPagetitle();

	}

	// @Test
	public void calendar() throws IOException, InterruptedException {
		utilities = new Utilities();
		utilities.frameside();
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"staffform\"]/select")));
		select.selectByValue(HomePage.calendar().get(2));
		Thread.sleep(3000);

	}

	// @Test
	public void pakg() throws IOException {
		homepage = new HomePage();

		boolean Pkgvisible = homepage.pakage();
		// System.out.println("package is visible");
		Assert.assertEquals(Pkgvisible, true);

	}

	@Test
	public void MVT() throws Exception {
		files = new FileInputStream("/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("spark"));
		XSSFSheet sheet = book.getSheet("spark");
		sheet.getLastRowNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			String accountnumber = sheet.getRow(i).getCell(0).getStringCellValue();

			driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys(accountnumber);
			driver.findElement(By.xpath("//input[@id='search']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='account_login']")).click();
			

			Set<String> windows = driver.getWindowHandles();
			Iterator<String> win = windows.iterator();
			String portal = win.next();
			String siteadmin = win.next();
			driver.switchTo().window(siteadmin);
			homepage = new HomePage();
			homepage.clickonsettings();
			settingspage = new SettingsPage();

			try {

				settingspage.mobile();
				
			} catch (Exception e) {
				e.printStackTrace();
				try {
					String test = driver.findElement(By.xpath("//input[@name='contact_first_name']"))
							.getAttribute("value");
					System.out.println(test);

				} catch (Exception e2) {

				}

			}
		}

	}

	@AfterMethod
	public void tierdown() {
		driver.quit();

	}

}
