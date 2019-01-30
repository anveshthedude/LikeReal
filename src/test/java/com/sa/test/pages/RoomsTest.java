package com.sa.test.pages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sa.pages.LoginPage;
import com.sa.pages.Rooms;

import testbasepackage.TestBase;
import utilities.Utilities;

public class RoomsTest extends TestBase {
	Rooms room;
	Utilities utilities;
	LoginPage loginpage;
	public RoomsTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws Exception {
		initizlization();
		loginpage = new LoginPage(); 
		loginpage.ValidateloginPagetitle();
	}
	
	
	@Test
	public void VerifyRoomStatus() throws IOException {
		utilities = new Utilities();
		utilities.framehead();
		room = new Rooms();
		room.clickonRoomstab();
		driver.switchTo().defaultContent();
		utilities.frameside();
		room.clickOnaAddNewRoom();
		driver.switchTo().defaultContent();
		utilities.framemid();
		boolean status = room.roomstatusactive();
		System.out.println("Expecting False");
		Assert.assertEquals(status, true);

	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
