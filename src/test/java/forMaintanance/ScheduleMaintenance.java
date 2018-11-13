<<<<<<< HEAD
package forMaintanance;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScheduleMaintenance {
	FileInputStream files;

	@Test
	public void test() throws IOException, InterruptedException {

		files = new FileInputStream(
				"C:\\Users\\anvesh.durgam\\git\\LikeRealP\\src\\main\\java\\com\\testdata\\Test.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(files);
		System.out.println("this is sheet" + book.getSheet("signup"));
		XSSFSheet sheet = book.getSheet("signup");
		sheet.getLastRowNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			String firstname = sheet.getRow(i).getCell(0).getStringCellValue();

			System.setProperty("webdriver.chrome.driver",
					"D:\\Softwares\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.get("https://portal.appointment-plus.com/ap/ap_control_v2/account_search.php");
			driver.findElement(By.xpath("//input[@name='login']")).clear();
			driver.findElement(By.xpath("//input[@name='login']")).sendKeys("adurge@appointmentplus.com");
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("m54D_QFM");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.findElement(By.xpath("//input[@id='account_number']")).clear();
			driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys(firstname);

			String button1 = "//*[@id=\"loginform-appointplus";

			String button2 = "-0\"]/input[5]";

			driver.findElement(By.xpath("//input[@id='search']")).click();
			driver.findElement(By.xpath(button1 + firstname + button2)).click();

			Set<String> windows = driver.getWindowHandles();

			Iterator<String> getwindow = windows.iterator();
			String portal = getwindow.next();
			String siteadmin = getwindow.next();

			driver.switchTo().window(siteadmin);
			Thread.sleep(3000);
			driver.switchTo().frame("header");
			//driver.manage().window().maximize();
			Thread.sleep(2000);
			boolean Repotabvisible = driver.findElement(By.xpath("//a[@id='fl-navtab-item-reports-id']")).isDisplayed();
			if (Repotabvisible == true)	{
				System.out.println("AP" + firstname + "  Test is Pass");
			} else {
				System.out.println("AP" + firstname + "  Test is Fail");
			}

			driver.quit();

		}

	}
}
=======
package forMaintanance;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.Utilities;

public class ScheduleMaintenance {
	FileInputStream files;
	
	
	@Test
	public void test() throws IOException, InterruptedException {//as usual

		
		  
			files = new FileInputStream("/Users/anveshdurgam/git/LikeReal/src/main/java/com/testdata/testdatamac.xlsx");
		

			XSSFWorkbook book = new XSSFWorkbook(files);
			System.out.println("this is sheet" + book.getSheet("signup"));
			XSSFSheet sheet = book.getSheet("signup");
			sheet.getLastRowNum();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				String firstname = sheet.getRow(i).getCell(0).getStringCellValue();

				System.setProperty("webdriver.chrome.driver",
						"/Users/anveshdurgam/Applications/Chrome Apps.localized/chromedriver");
				ChromeDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.get("https://portal.appointment-plus.com/ap/ap_control_v2/account_search.php");
				driver.findElement(By.xpath("//input[@name='login']")).clear();
				driver.findElement(By.xpath("//input[@name='login']")).sendKeys("adurge@appointmentplus.com");
				driver.findElement(By.xpath("//input[@name='password']")).clear();
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("m54D_QFM");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				driver.findElement(By.xpath("//input[@id='account_number']")).clear();
				driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys(firstname);
				driver.findElement(By.xpath("//input[@id='search']")).click();
				driver.findElement(By.xpath("//input[@name='account_login']")).click();
				
				Set<String> windows = driver.getWindowHandles();

				Iterator<String> getwindow = windows.iterator();
				String portal = getwindow.next();
				String siteadmin = getwindow.next();

				driver.switchTo().window(siteadmin);
				
				driver.switchTo().window("header");
				Thread.sleep(3000);
				boolean cvtabvisible= driver.findElement(By.xpath("//a[@id='fl-navtab-item-reports-id']")).isDisplayed();
				if(cvtabvisible==true){
					System.out.println("Test is pass");
				}else {
					System.out.println("Test is fail");
				}
				
				driver.quit();
				
				
			}

		}
	}
>>>>>>> branch 'master' of https://github.com/anveshthedude/LikeReal.git
