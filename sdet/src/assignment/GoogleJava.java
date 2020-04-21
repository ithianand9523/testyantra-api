package assignment;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleJava {
	@Test
	public void java() throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("java",Keys.ENTER);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println(count);
		
		List<WebElement> s = driver.findElements(By.xpath("//a[contains(@href,'http')]"));
		int count1 = links.size();
		System.out.println(count1);
		
		for(WebElement ele:s)
		{
			String link=ele.getAttribute("href");
			System.out.println(link);
			
			URL u= new URL(link);
			
			HttpURLConnection conn = (HttpURLConnection)u.openConnection();
			
			System.out.println(conn.getURL());
			if(conn.getResponseCode()==200)
			{
				System.out.println(conn.getResponseCode());
				System.out.println(conn.getResponseMessage());
				System.out.println("Link is not Broken");
			}
			else
			{
				System.out.println(conn.getResponseCode());
				System.out.println(conn.getResponseMessage());
				System.out.println("Link is Broken");
			}
			System.out.println("=================================================================");
		}
		driver.close();
		
	}

}
