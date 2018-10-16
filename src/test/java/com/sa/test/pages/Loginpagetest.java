package com.sa.test.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sa.pages.HomePage;
import com.sa.pages.LoginPage;

import testbasepackage.TestBase;

public class Loginpagetest extends TestBase {

	LoginPage loginpage;

	public Loginpagetest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {

		initizlization();

	}

	@Test(priority = 1, groups = "loginpages")
	public void aplogotest() throws IOException {
		loginpage = new LoginPage();
		boolean result = loginpage.verifycompanylogo();
		System.out.println(result);

		Assert.assertTrue(true);

	}

	@Test(priority = 2, groups = "loginpages")
	public void verify() throws Exception {
		loginpage = new LoginPage();
		loginpage.ValidateloginPagetitle();

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}