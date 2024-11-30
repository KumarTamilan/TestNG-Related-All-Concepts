package org.expectedException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class ExpectedExceptionAttribute {

	static WebDriver driver;
	@Test(invocationTimeOut=2000,expectedExceptions=ThreadTimeoutException.class)
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
		driver.close();
	}
}
