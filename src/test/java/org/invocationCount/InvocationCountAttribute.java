package org.invocationCount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InvocationCountAttribute {

	static WebDriver driver;
	@BeforeClass(alwaysRun=true)
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void urlLaunch() {
		driver.get("https://www.facebook.com/");
	}
	@Test(dependsOnMethods="urlLaunch",invocationCount=5)
	public void username() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
		Thread.sleep(1000);
		username.clear();
		
		
	}
	@AfterClass(alwaysRun=true)
	public void driverClose() {
		driver.close();
	}
}
