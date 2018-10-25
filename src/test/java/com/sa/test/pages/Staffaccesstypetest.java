package com.sa.test.pages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sa.pages.LoginPage;
import com.sa.pages.StaffTabPage;

import testbasepackage.TestBase;

public class Staffaccesstypetest extends TestBase {

	LoginPage loginpage;
	StaffTabPage stafftabpage;
	// StaffTabPage stafftabpage1;

	public Staffaccesstypetest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup2() throws Exception {

		initizlization();
		loginpage = new LoginPage();
		loginpage.ValidateloginPagetitle();
		stafftabpage = new StaffTabPage();

	}

	@Test(priority = 0)
	public void verifyifaccesstypeselected() throws IOException, InterruptedException {

		boolean nine = stafftabpage.CheckifAccesstypeIsSelected();
		Assert.assertEquals(nine, true);

	}

	@Test(priority = 1)
	public void VerifyStaffDaysUpdatetest() throws IOException {
		// stafftabpage = new StaffTabPage();
		stafftabpage.UpdateDaysOff();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
