package com.sa.test.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sa.pages.HomePage;
import com.sa.pages.LoginPage;
import com.sa.pages.SettingsPage;

import justtests.SparkAccounts;
import testbasepackage.TestBase;
import utilities.Utilities;

public class HomePageTest extends TestBase {

	FileInputStream files;
	LoginPage loginpage;
	Utilities utilities;
	HomePage homepage;
	SettingsPage settingspage;
	HomePageTest homepagetest;
	XSSFSheet sheet;
	XSSFWorkbook book;
	boolean yes;
	boolean text;

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

	public Set<Object> accoutnums() throws IOException {
		// ArrayList<String> accounts = new ArrayList<String>();
		Set<Object> accounts = new HashSet<Object>();
		files = new FileInputStream("/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx");
		book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("spark"));
		sheet = book.getSheet("spark");
		sheet.getLastRowNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			String acct = sheet.getRow(i).getCell(0).getStringCellValue();
			String[] data = { acct };

			accounts.add(data);
		}
		return accounts;
	}

	@DataProvider
	public Iterator<Object> acountss() throws IOException {

		homepagetest = new HomePageTest();
		Set<Object> acc = homepagetest.accoutnums();
		return acc.iterator();

	}

	@Test(dataProvider = "acountss")
	public void MVT(String acct) throws Exception {

		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys(acct);

		driver.findElement(By.xpath("//input[@id='search']")).click();
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("/html/body/table[5]/tbody/tr/td/table/tbody/tr[4]/td/table[2]/tbody/tr[2]/td[1]/form/input[5]"))
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
			System.out.println("Mobile responsive is visible for " + acct + yes);
			FileInputStream files = new FileInputStream(
					"/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx");
			book = new XSSFWorkbook(files);
			sheet = book.getSheet("spark");
			sheet.getRow(0).createCell(1).setCellValue("Mobile responsive is visible for " + acct + yes);
			FileOutputStream fileout = new FileOutputStream(
					new File("/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx"));
			book.write(fileout);
			fileout.close();

		} else {
			try {
				
				boolean packg = homepage.pakage();
				if (packg == true) {
					System.out.println("Packages is enabled in this account    " + acct + packg);
					
					text = homepage.textreminder();
					System.out.println("Text Reminder is Enabled" + acct + text);

				} else
					System.out.println("Package is not Enabled in this account " + acct);
				text = homepage.textreminder();
				System.out.println("Text Reminder is Enabled" + acct + text);
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Text Reminder is NOT enabled");
				FileInputStream files = new FileInputStream(
						"/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx");
				book = new XSSFWorkbook(files);
				sheet = book.getSheet("spark");
				sheet.getRow(0).createCell(1).setCellValue("Mobile responsive is visible for " + acct + text);
				FileOutputStream fileout = new FileOutputStream(
						new File("/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx"));
				book.write(fileout);
				fileout.close();

			} 
		}

	}

	@AfterMethod
	public void tierdown() {
		driver.quit();

	}

}
