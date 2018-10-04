package testbasepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Utilities;

public class TestBase {

	public static WebDriver driver = null;
	public static Properties read;

	public TestBase() throws IOException {

		String file = "air";

		if (file.equals("air")) {
			read = new Properties();
			FileInputStream pi = new FileInputStream(
					"/Users/anveshdurgam/git/anveshmain8/siteadmin/src/newpackage/My.properties");
			read.load(pi);
		} else {
			read = new Properties();

			FileInputStream pi = new FileInputStream(
					"C:\\Users\\anvesh.durgam\\git\\anveshmain3\\siteadmin\\src\\newpackage\\My.properties");
			read.load(pi);

		}

	}

	public static void initizlization() {

		String browsername = read.getProperty("browser");

		String laptop = read.getProperty("system");

		if (browsername.equals("chrome")) {
			if (laptop.equals("mac")) {
				System.setProperty("webdriver.chrome.driver",

						"/Users/anveshdurgam/Downloads/chromedriver");
				driver = new ChromeDriver();

			} else
				System.setProperty("webdriver.chrome.driver",
						"D:\\Softwares\\Chromedriver\\chromedriver_win32\\chromedriver.exe");

			// System.setProperty("webdriver.chrome.driver",
			//
			// "/Users/anveshdurgam/Downloads/chromedriver");

			driver = new ChromeDriver();
			// github.com/anveshthedude/anveshmain2.git

		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilities.Pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.Implicitwait, TimeUnit.SECONDS);
		driver.get(read.getProperty("url"));

	}

}
