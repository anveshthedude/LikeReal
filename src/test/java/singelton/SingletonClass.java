package singelton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingletonClass {

	public static WebDriver driver = null;
	public static SingletonClass clas = null;

	
	@FindBy(xpath = "//input[@id='account_number']")
	static WebElement putaccnum;
	
	private SingletonClass() {
		PageFactory.initElements(driver, this);
	}

	public static WebDriver driver() {

		if (driver == null) {
			driver = new ChromeDriver();

		}
		return driver;

	}

	public static SingletonClass singeclass() {
		if (clas == null) {
			clas = new SingletonClass();
		}
		return clas;
	}

	public void test() {
		System.out.println("innitialize login");
	}

}
