package com.cv.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import testbasepackage.TestBase;

public class CustRegistration extends TestBase {

	public CustRegistration() throws IOException {
		super();

	}

	@Test
	public ArrayList<Object> testdata() throws Exception {

		ArrayList<Object> gotdata = new ArrayList<Object>();

		FileInputStream files = new FileInputStream(
				"C:\\Users\\anvesh.durgam\\git\\AutoPractice\\src\\main\\java\\com\\testdata\\Test.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("signup"));
		XSSFSheet sheet = book.getSheet("signup");

		for (int i = 1; i <= 4; i++) {

			String firstname = sheet.getRow(i).getCell(0).getStringCellValue();
			String lastname = sheet.getRow(i).getCell(1).getStringCellValue();
			String email = sheet.getRow(i).getCell(2).getStringCellValue();
			String eveningphone = sheet.getRow(i).getCell(3).getStringCellValue();
			Object[] data = { firstname, lastname, email, eveningphone };
			// System.out.println(firstname + lastname + email + eveningphone +
			// notes);
			gotdata.add(data);

		}
		return gotdata;

	}

}
