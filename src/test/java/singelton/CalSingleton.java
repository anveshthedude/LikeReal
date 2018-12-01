package singelton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalSingleton {

	public static void main(String[] args) {
		WebDriver driver = SingletonClass.driver();

		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("faltu");

		SingletonClass singleeee = SingletonClass.singeclass();
		singleeee.test();
	}
}
