package com.sa.test.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sa.pages.LoginPage;

import testbasepackage.TestBase;
import utilities.Utilities;

public class ZendeskPageLinks extends TestBase {

	LoginPage loginpage;
	Utilities utilities;

	public ZendeskPageLinks() throws IOException {
		super();

	}

	@Test
	public void links() throws Exception {

		initizlization();
		/*
		 * loginpage = new LoginPage(); loginpage.ValidateloginPagetitle(); utilities =
		 * new Utilities(); utilities.framehead();
		 */
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.size();

		System.out.println("All links  " + links.size());

		List<WebElement> activelinks = new ArrayList<WebElement>();

		for (int a = 0; a < links.size(); a++) {
			WebElement li = links.get(a);
			String alllinks = li.getAttribute("href");
			URL url = new URL(alllinks);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			if (connection.getResponseCode() == 200) {
				activelinks.add(links.get(a));

				System.out.println("Sucess code --->    " + alllinks);
			} else {
				System.out.println("Links is not working");
			}
			System.out.println("activelinks are here ===>" + activelinks.size());

		}

	}

}
