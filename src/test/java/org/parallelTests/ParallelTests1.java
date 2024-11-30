package org.parallelTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTests1 {

	static WebDriver driver;
	@Test
	public static void main() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("kumaran123@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Tester");
	}
}
