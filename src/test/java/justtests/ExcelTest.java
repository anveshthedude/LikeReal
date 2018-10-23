package justtests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class ExcelTest {

	public static void main(String[] args) {

		Xls_Reader excel = new Xls_Reader(
				"C:\\Users\\anvesh.durgam\\git\\AutoPractice\\src\\main\\java\\com\\testdata\\Test.xlsx");

		int size = excel.getRowCount("signup");

		for (int rowNum = 2; rowNum <= size; rowNum++) {

			String firstname = excel.getCellData("signup", "Firstname", rowNum);
			System.out.println("This is second name  =" + firstname);

		}

	}

	@Test
	public void testdata() throws Exception {

		FileInputStream files = new FileInputStream(
				"C:\\Users\\anvesh.durgam\\git\\AutoPractice\\src\\main\\java\\com\\testdata\\Test.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("signup"));
		XSSFSheet sheet = book.getSheet("signup");
		System.out.println("Data in sheet  " + sheet.getRow(1).getCell(2));
		System.out.println("This is size    =" + sheet.getLastRowNum());
		System.out.println("first name  "+sheet.getRow(1).getCell(0));
		System.out.println("lastname  "+sheet.getRow(1).getCell(1));
		

	}

}
