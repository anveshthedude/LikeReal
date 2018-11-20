package justtests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cv.pages.CustRegistration;

import testbasepackage.TestBase;

public class ExcelTest extends TestBase {
	public ExcelTest() throws IOException {
		super();

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Xls_Reader excel = new Xls_Reader(
	 * "C:\\Users\\anvesh.durgam\\git\\AutoPractice\\src\\main\\java\\com\\testdata\\Test.xlsx"
	 * );
	 * 
	 * int size = excel.getRowCount("signup");
	 * 
	 * for (int rowNum = 2; rowNum <= size; rowNum++) {
	 * 
	 * String firstname = excel.getCellData("signup", "Firstname", rowNum);
	 * System.out.println("This is second name  =" + firstname);
	 * 
	 * }
	 */

	@BeforeMethod // over laptest
	public void setup() {
		initizlization();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Create an Account']")).click();

	}

	@DataProvider
	public Iterator<Object> thisisdata() throws Exception {
		CustRegistration page = new CustRegistration();
		ArrayList<Object> datalist = page.testdata();
		// System.out.println(datalist);
		return datalist.iterator();

	}

	@Test(dataProvider = "thisisdata")
	public void signuptest(String firstname, String lastname, String email, String eveningphone) {

		driver.findElement(By.xpath("//input[@name='first_name']")).clear();
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);

		driver.findElement(By.xpath("//input[@name='last_name']")).clear();
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);

		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

		driver.findElement(By.xpath("//input[@name='night_phone']")).clear();
		driver.findElement(By.xpath("//input[@name='night_phone']")).sendKeys(eveningphone);

		WebElement dropdown = driver.findElement(By.xpath("//select[@name='lead_id']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Internet");

		driver.findElement(By.xpath("//input[@name='contact_okay' and @value='yes']")).click();
		driver.findElement(By.xpath("//input[@name='email_okay' and @value='yes']")).click();
		driver.findElement(By.xpath("//input[@name='allow_login' and @value='yes']")).click();
		driver.findElement(By
				.xpath("//*[@id='wrapper']/table[3]/tbody/tr[1]/td/table[1]/tbody/tr[2]/td/table/tbody/tr/td/input[2]"))
				.click();

		System.out.println(driver.getPageSource().contains("//font[@color='#090909']"));

		driver.navigate().refresh();

		System.out.println("Got details");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
