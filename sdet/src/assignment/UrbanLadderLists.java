package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UrbanLadderLists {
	@Test
	public void urbanLadder()
			throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		//Workbook wb = WorkbookFactory.create(new FileInputStream("./testData/input.xlsx"));

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Thread.sleep(6000);
		// driver.findElement(By.xpath("(//a[contains(.,'Close')])[2]")).click();

		Thread.sleep(10000);

		List<WebElement> modules = driver.findElements(By.xpath("//span[@class='topnav_itemname']"));
		int count = modules.size();
		System.out.println(count);

		for (WebElement ele : modules) {
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			Thread.sleep(2000);
			String s = ele.getText();
			System.out.println(s);
			ele.click();
			Thread.sleep(2000);

			List<WebElement> subheadings = driver.findElements(
					By.xpath("//span[contains(.,'" + s + "')]/parent::li/descendant::div[@class='taxontype']"));
			for (WebElement list : subheadings) {
				String t = list.getText();

				System.out.println(t);
				Thread.sleep(3000);

				List<WebElement> content = driver.findElements(By.xpath(
						"//span[contains(.,'" + s + "')]/parent::li/descendant::div[@class='taxontype']/a[contains(.,'"
								+ t + "')]/../following-sibling::ul/descendant::a[@class='inverted']/span"));
				for (WebElement con : content) {
					String t1 = con.getText();
//					for (int i = 0; i >= 0; i++) {
//						for (int j = 0; j < 10; j++) {
//							wb.getSheet("Sheet1").createRow(i).createCell(j).setCellValue(s);
//						 	wb.getSheet("Sheet1").createRow(i + 1).getCell(j).setCellValue(t);
//							wb.getSheet("Sheet1").createRow(i + 2).getCell(j).setCellValue(t1);
//						}
//					}
					System.out.println(t1);
					Thread.sleep(2000);
				}
			}
		}
		//wb.write(new FileOutputStream("./testData/input.xlsx"));
		driver.close();
	}
}
