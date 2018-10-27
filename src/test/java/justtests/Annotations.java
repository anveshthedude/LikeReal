package justtests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeTest
	public void beforemethod() {

		System.out.println("this is beforemethod");

	}

	@Test(priority = 2)
	public void apple() {
		System.out.println("this is apple");
	}

	@Test(priority = 1, groups = { "group1" })
	public void grapes() {
		// Assert.assertEquals(false, true);
		System.out.println("this is grape");
	}

	@Test(priority = 3, dependsOnMethods = { "grapes" }, groups = { "group1" })
	public void beetroot() {
		System.out.println("this is beetroot");

	}

	@AfterTest
	public void aftermethod() {
		System.out.println("this is after method");
	}

}
