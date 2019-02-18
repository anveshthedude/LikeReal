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

	@Test(priority =1, groups = {"rooms"},description = "Room status is fine")
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
		Assert.assertEquals(status, false);

	}

	@Test(priority =2,groups = {"rooms"}, description = "Room title is fine")
	public void verifyRoomisVisible() throws IOException {
		utilities = new Utilities();
		utilities.framehead();
		room = new Rooms();
		room.clickonRoomstab();
		driver.switchTo().defaultContent();
		utilities.framemid();
		room.roomnameinlist();
		driver.switchTo().defaultContent();
		utilities.frameside();
		boolean roomnameAtLeft = room.roomname();
		driver.switchTo().defaultContent();
		utilities.framemid();
		boolean roomScreenname = room.roomscreenname();
		Assert.assertEquals(roomnameAtLeft, roomScreenname);

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
