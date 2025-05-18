package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Random {
	WebDriver driver;
	@BeforeTest
	public void start() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testCart() {
		WebElement item = driver.findElement(By.cssSelector("#container > div > div.q8WwEU > div > div > div > div > div > div > div > div > div.yAlKeh > div._2L0uxW > div > div:nth-child(1) > div > div > div > div > div._3sdu8W.emupdz > a:nth-child(6) > div > div > div > div > img"));
		item.click();
		
		WebElement banner = driver.findElement(By.cssSelector("#container > div > div.JxFEK3._48O0EI > div:nth-child(2) > div > div.DFBRyT > div:nth-child(2) > div > a > div > img.xTaogf"));
		banner.click();
		
		String str = driver.getTitle();
		System.out.println(str);
		
		assertEquals(str, "Flipkart Cooling Days: Huge Discounts on TVs & Appliances");
	}
	
	@AfterTest
	public void end() {
		if(driver != null) {
			driver.quit();
		}
	}
}
