package justtests;

import java.io.FileInputStream;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

import testbasepackage.TestBase;

public class ExcelTest extends TestBase {
	@FindBy(xpath = "//input[@name='first_name']")
	public static WebElement firstname;

	@FindBy(xpath = "//input[@name='last_name']")
	public static WebElement lastname;

	@FindBy(xpath = "//input[@name='night_phone']")
	public static WebElement evenphon;

	@FindBy(xpath = "//input[@name='email']")
	public static WebElement email;

	public ExcelTest() throws IOException {
		PageFactory.initElements(driver, this);
		
	}

	/*public static void main(String[] args) {

		Xls_Reader excel = new Xls_Reader(
				"C:\\Users\\anvesh.durgam\\git\\AutoPractice\\src\\main\\java\\com\\testdata\\Test.xlsx");

		int size = excel.getRowCount("signup");

		for (int rowNum = 2; rowNum <= size; rowNum++) {

			String firstname = excel.getCellData("signup", "Firstname", rowNum);
			System.out.println("This is second name  =" + firstname);

		}*/



	@Test
	public static ArrayList<Object> testdata() throws Exception {

		ArrayList<Object> gotdata = new ArrayList<Object>();

		FileInputStream files = new FileInputStream(
				"C:\\Users\\anvesh.durgam\\git\\AutoPractice\\src\\main\\java\\com\\testdata\\Test.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("signup"));
		XSSFSheet sheet = book.getSheet("signup");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			String firstname = sheet.getRow(i).getCell(0).getStringCellValue();
			String lastname = sheet.getRow(i).getCell(1).getStringCellValue();
			String email = sheet.getRow(i).getCell(2).getStringCellValue();
			String eveningphone = sheet.getRow(i).getCell(3).getStringCellValue();
			String notes = sheet.getRow(i).getCell(4).getStringCellValue();

			Object[] data = { firstname, lastname, email, eveningphone, notes };
			System.out.println(firstname + lastname + email + eveningphone + notes);
			gotdata.add(data);

		}

		return gotdata;

	}

	// @DataProvider
	public Iterator<Object> thisisdata() throws Exception {
		ArrayList<Object> datalist = ExcelTest.testdata();
		return datalist.iterator();

	}

	@Test(dataProvider = "thisisdata")
	public void signuptest(String firstname, String lastname, String email, String eveningphone, String notes) {
		
		
	

	}

}
