package Pages;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
	
		WebDriver driver;
		
		@Before
		public void start() {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		}
		
		@Test
		public void testAddToCart() {
		WebElement searchBox = driver.findElement(By.className("Pke_EE"));
		searchBox.sendKeys("Mobiles");
		
		WebElement searchIcon = driver.findElement(By.cssSelector("#container > div > div.q8WwEU > div > div > div > div > div > div > div > div > div._2nl6Ch > div > header > div._3ZqtNW > div._3NorZ0._3jeYYh > form > div > button > svg"));
		searchIcon.click();
		
		WebElement sectionVerify = driver.findElement(By.cssSelector("#container > div > div.nt6sNV.JxFEK3._48O0EI > div.DOjaWF.YJG4Cf > div.DOjaWF.gdgoEp.col-2-12 > div > div:nth-child(1) > div > div > section > div:nth-child(3) > div > a"));
		String str1 = sectionVerify.getText();
		assertEquals(str1, "Mobiles");
		
		WebElement item = driver.findElement(By.className("DByuf4"));
		item.click();
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        WebElement itemVerify = driver.findElement(By.className("VU-ZEz"));
        String str2 = itemVerify.getText();
		assertEquals(str2, "CMF by Nothing Phone 2 Pro (Orange, 128 GB)  (8 GB RAM)");
		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
		addToCart.click();
		
		
		}
		
		@After
		public void end() {
	       if (driver != null) {
	            driver.quit();
	        }
	    }

}
