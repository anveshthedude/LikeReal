package justtests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JustTests {
	static WebDriver driver;

	@Test
	public static void main() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Softwares\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://account5.appointment-plus.com/ap/ap_admin_v2/login.php?action=log_in&login_error=yes&login_error_type=timeout");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('login').value='justlikethat';");
		js.executeScript("document.getElementById('password').value='justlikethat';");
		js.executeScript("document.querySelector(\"input[class='btn-form']\").click()");
		Thread.sleep(3000);
		driver.switchTo().frame("sidenav");

		WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

		Select select = new Select(dropdown);

		List<WebElement> options = select.getOptions();
		System.out.println(options.size());

		for (int i = 0; i < options.size(); i++) {

			System.out.println(options.get(i).getText());
			options.get(i).click();

		}

	}
}
