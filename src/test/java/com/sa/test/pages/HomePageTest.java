package com.sa.test.pages;

import java.io.IOException;

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

	LoginPage loginpage;
	Utilities utilities;
	HomePage homepage;
	SettingsPage settingspage;

	public HomePageTest() throws IOException {
		super();

	}

	// @BeforeMethod
	public void setup() throws Exception {

		initizlization();
		loginpage = new LoginPage();
		loginpage.portalLogin();

	}

	@BeforeMethod
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
		// Assert.assertEquals(Pkgvisible, true);

	}

	@Test
	public void MVT() throws Exception {
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
