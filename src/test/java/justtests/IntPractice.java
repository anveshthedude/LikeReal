package justtests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class IntPractice {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("afjk")).sendKeys(Keys.ENTER);

		FileInputStream file = new FileInputStream("jaf;lsdjfa;i");

		XSSFWorkbook workbok = new XSSFWorkbook(file);

		XSSFSheet she = workbok.getSheet("sheetname");

		String ni = she.getRow(3).getCell(2).getStringCellValue();
		// --------------------------------------

		FileInputStream st = new FileInputStream("path");
		Properties pro = new Properties();

		pro.getProperty("url");

		// <test> name = "adtest" </Test>
		// <Classes>

		// <Class> name = "package.classname" </Class>
		// </Classes>

		// ----------------------------

		driver.manage().window().maximize();

		Set<String> ows = driver.getWindowHandles();

		Iterator<String> it = ows.iterator();
		String one = it.next();
		driver.switchTo().window("one");

		// ----------------------------------------
		driver.switchTo().frame("ajf");
		// ---------------------------------------
		WebElement target = driver.findElement(By.xpath("ajfd"));
		WebElement source = driver.findElement(By.xpath("ajfd"));

		Actions act = new Actions(driver);
		act.moveToElement(target).build().perform();
		act.dragAndDrop(source, target).build().perform();

		// --------------------------
		Select sel = new Select(target);
		sel.selectByValue("12");
		sel.selectByVisibleText("test");

		// --------------------------

		TakesScreenshot take = (TakesScreenshot) driver;
		File fil = take.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fil, new File("path"));

	}

}
