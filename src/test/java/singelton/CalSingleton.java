package singelton;

import org.openqa.selenium.WebDriver;

public class CalSingleton {

	public static void main(String[] args) {
		// WebDriver driver = SingletonClass.driver();

		SingletonClass singleeee = SingletonClass.singeclass();
		singleeee.test();
	}
}
