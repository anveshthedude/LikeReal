package justtests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SparkAccounts {
	FileInputStream files;

	public Set<Object> accoutnumss() throws IOException {
		Set<Object> accounts = new HashSet<Object>();

		// ArrayList<String> accounts = new ArrayList<String>();
		files = new FileInputStream("/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("spark"));
		XSSFSheet sheet = book.getSheet("spark");
		sheet.getLastRowNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			String acct = sheet.getRow(i).getCell(0).getStringCellValue();
			String[] data = { acct };

			accounts.add(data);
		}
		return accounts;
	}

}
