package example;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {
	WebDriver driver;
	
	@BeforeTest
	public void start() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLogin() {
		WebElement number = driver.findElement(By.id("email"));
		number.sendKeys("9603898666");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("123456@123");
		
		WebElement button = driver.findElement(By.name("login"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		WebElement welcomeMsg = driver.findElement(By.cssSelector("#mount_0_0_he > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x9f619.x1ja2u2z.x78zum5.x2lah0s.x1n2onr6.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1t2pt76.x17upfok > div > div.x9f619.x1ja2u2z.x78zum5.x1n2onr6.x1iyjqo2.xs83m0k.xeuugli.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1iplk16.x1xfsgkm.xqmdsaz.x1mtsufr.x1w9j1nh > div > div > div.xg87l8a.x1iymm2a > span"));
		String str = welcomeMsg.getText();
		System.out.println(str);
		
		assertEquals(str, "Welcome to Facebook, Simple");
	}
	
	@AfterTest
	public void end() {
	       if (driver != null) {
	            driver.quit();
	        }
	    }
}
