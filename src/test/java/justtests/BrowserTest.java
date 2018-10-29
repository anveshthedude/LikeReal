package justtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
		
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","/Users/anveshdurgam/Applications/Chrome Apps.localized/chromedriver");
		WebDriver driver= null;
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
	}
}
