package com.sa.test.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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

	/*public ArrayList<String> accoutnums() throws IOException {
		ArrayList<String> accounts = new ArrayList<String>();
		files = new FileInputStream("/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("spark"));
		XSSFSheet sheet = book.getSheet("spark");
		sheet.getLastRowNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			String acct = sheet.getRow(i).getCell(0).getRawValue();

			accounts.add(acct);
		}
		return accounts;
	}*/

	@DataProvider
	public Iterator<Object> acountss() throws IOException {

		SparkAccounts homepage = new SparkAccounts();
		Set<Object> acc = homepage.accoutnums();
		return acc.iterator();

	}

	@Test(dataProvider = "acountss")
	public void MVT(String acct) throws Exception {

		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys(acct);
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
				String test = driver.findElement(By.xpath("//input[@name='contact_first_name']")).getAttribute("value");
				System.out.println(test);

			} catch (Exception e2) {

			}

		}
	}

	@AfterMethod
	public void tierdown() {
		driver.quit();

	}

}
