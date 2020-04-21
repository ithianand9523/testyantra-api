package links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	public static void main(String []args)  throws Throwable
	{

	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///C:/Users/Prathika/Desktop/brokenlinks.html");
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	
	for(WebElement ele:links)
	{
		String link=ele.getAttribute("href");
		
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
