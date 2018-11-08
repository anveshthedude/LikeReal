package com.sa.test.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sa.pages.LoginPage;

import testbasepackage.TestBase;
import utilities.Utilities;

public class HomePageLinks extends TestBase {

	LoginPage loginpage;
	Utilities utilities;

	public HomePageLinks() throws IOException {
		super();

	}

	@Test
	public void links() throws Exception {

		initizlization();
		/*loginpage = new LoginPage();
		loginpage.ValidateloginPagetitle();
		utilities = new Utilities();
		utilities.framehead();*/
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.size();
		System.out.println(links.size());
		for (int a = 0; a<links.size(); a++) {
			WebElement li = links.get(a);
			String the = li.getAttribute("href");
			System.out.println("This is href ---->"+the);

		}

	}

}
