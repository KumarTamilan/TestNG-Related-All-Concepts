package org.dataProviderTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WithoutDataProvider {

	static WebDriver driver;
	static PropertyReaderClass reader = new PropertyReaderClass(".\\Excel\\FBData.xlsx", "Sheet5");

	@Test
	public static void main() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys(reader.findValue(0, 0));
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys(reader.findValue(0, 1));
		Thread.sleep(4000);
		driver.close();
	}
}
