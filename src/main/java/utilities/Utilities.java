package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbasepackage.TestBase;

public class Utilities extends TestBase {

	public Utilities() throws IOException {
		super();

	}

	public static long Pageloadtime = 80;
	public static long Implicitwait = 80;

	public void framehead() {

		driver.switchTo().frame("header");

	}

	public void frameside() {

		driver.switchTo().frame("sidenav");

	}

	public void framemid() {

		driver.switchTo().frame("slots");

	}

	public void implicitwait() {

	}

	public static void takescreenshot(String screenshotOf) throws IOException {
		TakesScreenshot screnshot = ((TakesScreenshot) driver);
		File fil = screnshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fil, new File(
				"C:\\Users\\anvesh.durgam\\git\\LikeReal\\main\\resources\\screenshots\\" + screenshotOf + ".jpg"));
	}

	public static void explicitwait(WebDriver driver, int waitTime, WebElement element) {

		WebDriverWait wai = new WebDriverWait(driver, waitTime);
		wai.until(ExpectedConditions.visibilityOf(element));


	}

}
