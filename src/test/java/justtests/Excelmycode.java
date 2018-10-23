package justtests;

import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class Excelmycode {

	// @Test(dataProvider="getsdata")
	public void excel() throws Exception {

		/*
		 * // WebDriver driver = new ChromeDriver();
		 * 
		 * // // System.setProperty("webdriver.chrome.driver",
		 * "/Users/anveshdurgam/Downloads/chromedriver"); //
		 * driver.get("https://booknow.appointment-plus.com/7pjszd9k/"); // //
		 * // driver.findElement(By.xpath("//input[@value=Create an //
		 * Account']")).click();
		 * 
		 * // File file = new // File(
		 * "/Users/anveshdurgam/git/LikeReal1/src/main/java/com/testdata/Test.xlsx"
		 * );
		 */

	}

	// @DataProvider(name="getsdata")
	@Test
	public void data(){
		
		Xls_Reader xlreader = new Xls_Reader("/Users/anveshdurgam/git/LikeReal1/src/main/java/com/testdata/Test.xlsx");

		
		String firstname = 	xlreader.getCellData("signup1", "firstname", 2);
		String lastname = 	xlreader.getCellData("signup1", "lastname", 2);

		System.out.println("this is the name  "+firstname);
		System.out.println("this is the name  "+lastname);

	}
}


