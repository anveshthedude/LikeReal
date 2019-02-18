package com.sa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbasepackage.TestBase;
import utilities.Utilities;

public class Rooms extends TestBase {

	@FindBy(xpath = "//a[@id='fl-navtab-item-rooms-id']")
	public static WebElement roomstab;

	@FindBy(xpath = "//a[@id='fl-sidenav-addroom-id']")
	public static WebElement roomsatleft;

	@FindBy(xpath = "//a[@id='fl-sidenav-addroom-id']")
	public static WebElement addnewroom;

	@FindBy(xpath = "//input[@value='Active']")
	public static WebElement statusactive;

	@FindBy(xpath = "//div[contains(text(),'Testing for Brian')]")
	public static WebElement roomname;

	@FindBy(xpath = "//input[@name='screen_name']")
	public static WebElement roomscreenname;

	@FindBy(xpath = "//*[contains(text(),'Test ROOM')]")
	public static WebElement roomnameinlist;

	public Rooms() throws IOException {
		PageFactory.initElements(driver, this);

	}

	public void clickonRoomstab() {
		roomstab.click();
	}

	public void clickonallrooms() {
		roomsatleft.click();

	}

	public void clickOnaAddNewRoom() {
		addnewroom.click();

	}

	public boolean roomstatusactive() throws IOException {

		Utilities.explicitwait(driver, 5, statusactive);
		return statusactive.isSelected();
	}

	public boolean roomname() {
		Utilities.explicitwait(driver, 5, roomname);
		return roomname.isDisplayed();

	}

	public boolean roomscreenname() {
		return roomscreenname.isDisplayed();
	}

	public void roomnameinlist() {
		roomnameinlist.click();

	}

}
