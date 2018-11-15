package justtests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

final public class Bootstrap{
	static WebDriver driver;

	public static void main(String[] args) {

		Bootstrap.boot();

	}

	public static void boot() {// teested and working

		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://account.appointment-plus.com/ap/ap_admin_v2/login.php?_ga="
				+ "2.52921185.812422054.1533807988-1345006141.1533702908");

		driver.findElement(By.id("login")).sendKeys("justlikethat");

		driver.findElement(By.id("password")).sendKeys("justlikethat");

		driver.findElement(By.className("btn-form")).click();

		driver.switchTo().frame("header");
		driver.findElement(By.xpath("//a[@id='fl-navtab-item-reports-id']")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("sidenav");
		driver.findElement(By.xpath("//a[@id='fl-sidenav-emailreport-id']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("slots");
		driver.findElement(By.xpath("//span[contains(text(),'Select Email type')]")).click();

		List<WebElement> lis = driver
				.findElements(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//li//label"));
		System.out.println("This is Final count  " + lis.size());

		/*
		 * driver.switchTo().frame("slots");
		 * driver.findElement(By.xpath("//button[@type='button']")).click();
		 * 
		 * List<WebElement> lis = driver .findElements(By.xpath(
		 * "//ul[@class='ui-multiselect-checkboxes ui-helper-reset']//li//label"
		 * ));
		 * 
		 * System.out.println(lis.size());
		 */

	}

}