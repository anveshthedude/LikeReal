package com.sa.test.pages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sa.pages.CustomersTab;
import com.sa.pages.HomePage;
import com.sa.pages.LoginPage;

import junit.framework.Assert;
import testbasepackage.TestBase;
import utilities.Utilities;
@Listeners(utilities.ScreenshotListener.class)
public class UpdataCusLoginPassTest extends TestBase {
	LoginPage loginpage;
	CustomersTab customertab;
	HomePage homepage;

	public UpdataCusLoginPassTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		initizlization();
		loginpage = new LoginPage();
		loginpage.ValidateloginPagetitle();

	}

	@Test
	public void updateuserlogin() throws Exception {
		customertab = new CustomersTab();
		boolean updatedone = customertab.updatepass("aptest", "Customer, Test", "test9");
		Assert.assertEquals(true, updatedone);
	}

	@AfterMethod
	public void teardown() throws Exception {
		homepage = new HomePage();
		homepage.signout();
		driver.quit();
	}

}
