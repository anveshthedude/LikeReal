package com.sa.test.pages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sa.pages.LoginPage;

import testbasepackage.TestBase;

public class Loginpagetest extends TestBase {

	LoginPage loginpage;

	public Loginpagetest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() {

		initizlization();

	}

	@Test
	public void verify() {
		System.out.println("At last done");

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}