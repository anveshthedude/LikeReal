package justtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
		static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		//System.setProperty("webdriver.chrome.driver","Users/anveshdurgam/Downloads/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
	}
}
