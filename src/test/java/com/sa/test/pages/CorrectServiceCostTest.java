package com.sa.test.pages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sa.pages.LoginPage;
import com.sa.pages.ServicesTab;
import com.sa.pages.SettingsPage;

import testbasepackage.TestBase;

public class CorrectServiceCostTest extends TestBase {
	LoginPage loginpage;
	SettingsPage settingspage;
	ServicesTab servicestab;

	public CorrectServiceCostTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		loginpage = new LoginPage();
		initizlization();
		loginpage.ValidateloginPagetitle();

	}

	@Test
	public void updatesetting() throws Exception {
		settingspage = new SettingsPage();
		System.out.println("Prefernce  " + settingspage.changeprefs());
		Assert.assertTrue(true);

	}

	@AfterMethod
	public void close() throws Exception {
		servicestab = new ServicesTab();
		servicestab.SignOut();
		driver.quit();

	}

}
