package justtests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testbasepackage.TestBase;

public class IframeTest extends TestBase {

	public IframeTest() throws IOException {
		super();

	}

	@Test
	public void iframe() {
		initizlization();
		driver.switchTo().frame("blockrandom");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Create an Account']")).click();
		System.out.println("found button");

	}

}
