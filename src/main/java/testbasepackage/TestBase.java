package testbasepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import utilities.Utilities;

public class TestBase {

	public static WebDriver driver;
	public static Properties read; // teset

	public TestBase() throws IOException {

		String file = "win";

		if (file.equals("air")) {
			read = new Properties();
			FileInputStream pi = new FileInputStream(
					"/Users/anveshdurgam/git/LikeReal/src/main/java/com/properties/Properties");
			read.load(pi);
		} else {
			read = new Properties();

			FileInputStream pi = new FileInputStream(
					"C:\\Users\\anvesh.durgam\\git\\LikeReal\\src\\main\\java\\com\\properties\\Properties");
			read.load(pi);

		}

	}

	public static void initizlization() {

		String laptop = read.getProperty("laptop");

		if (laptop.equalsIgnoreCase("mac")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/anveshdurgam/Applications/Chrome Apps.localized/chromedriver");
			driver = new ChromeDriver();

		} else {
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("headless");
			 * options.addArguments("window-size=1200x600");
			 */
			/*System.setProperty("webdriver.chrome.driver",
					"D:\\Softwares\\Chromedriver\\chromedriver_win32\\chromedriver.exe");*/
			driver = new HtmlUnitDriver();
		}

		// driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilities.Pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.Implicitwait, TimeUnit.SECONDS);
		driver.get(read.getProperty("testurl"));
		driver.manage().deleteAllCookies();

	}

}
