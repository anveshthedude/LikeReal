package com.sa.test.pages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cv.pages.CVServicesPage;
import com.cv.pages.CustomerView;
import com.sa.pages.CVLinkpage;
import com.sa.pages.HomePage;
import com.sa.pages.LoginPage;
import com.sa.pages.ServicesTab;
import com.sa.pages.SettingsPage;

import testbasepackage.TestBase;

public class CorrectServiceCostTest extends TestBase {
	LoginPage loginpage;
	SettingsPage settingspage;
	ServicesTab servicestab;
	HomePage homepage;
	CVLinkpage cvlinkpage;
	CustomerView customerview;
	CVServicesPage cvservicespage;
	public CorrectServiceCostTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		initizlization();
		loginpage = new LoginPage();	
		homepage=loginpage.ValidateloginPagetitle();

	}

	@Test
	public void updatesetting() throws Exception {
		homepage = new HomePage();
		settingspage=homepage.clickonsettings();
		settingspage = new SettingsPage();
		System.out.println("Prefernce  " + settingspage.changeprefs());
		Assert.assertTrue(true);

	}
	
	@Test(dependsOnMethods={"updatesetting"})
	public void servicecosttest() throws Exception{
		homepage = new HomePage();
		homepage.CVlink();
		cvlinkpage = new CVLinkpage();
		cvlinkpage.gotocv();	
		customerview = new CustomerView();
		customerview.clickonservicestab();
		cvservicespage.verifyservicecost();
		customerview.clickonbooknow();
		
		
		
		
	}

	@AfterMethod
	public void close() throws Exception {
		servicestab = new ServicesTab();
		driver.switchTo().defaultContent();
		servicestab.SignOut();
		driver.quit();
		
		

	}

}
