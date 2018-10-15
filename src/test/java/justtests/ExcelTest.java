package justtests;

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

}
