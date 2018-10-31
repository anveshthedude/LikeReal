package com.sa.test.pages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sa.pages.CustomersTab;
import com.sa.pages.HomePage;
import com.sa.pages.LoginPage;

import junit.framework.Assert;
import testbasepackage.TestBase;

public class CancelApptFromApptHistory extends TestBase {

	CustomersTab customerstab;
	HomePage homepage;
	LoginPage loginpage;

	public CancelApptFromApptHistory() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {

		initizlization();
		loginpage = new LoginPage();
		loginpage.ValidateloginPagetitle();

	}

	@Test
	public void cancelapptfromappthistory() throws Exception {

		customerstab = new CustomersTab();
		boolean apptstatus = customerstab.cancelappt("aptest","tesst, aptest");
		Assert.assertEquals(true, apptstatus);

	}

	@AfterMethod
	public void teardown() throws Exception {
		homepage = new HomePage();
		homepage.signout();
		driver.quit();
	}

}
