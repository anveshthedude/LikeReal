package utilities;

import java.io.IOException;

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
	
	public  void implicitwait() {
		
	}
	
	
	
}
