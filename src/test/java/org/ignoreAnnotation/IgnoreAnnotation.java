package org.ignoreAnnotation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreAnnotation {

	static WebDriver driver;
	@BeforeClass
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	@Test(priority=-5)
	public void urlLaunch() {
		driver.get("https://www.facebook.com/");
	}
	@Ignore
	@Test(priority=-4)
	public void username() {
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
	}
	@Test(priority=-3)
	public void password() {
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Test");
	}
	@Test(priority=-2)
	public void clickCreateNewAccount() {
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
	}
	@Ignore
	@Test(priority=-1,enabled=false)
	public void firstName() {
		WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@name,'firstname')]"));
		firstName.sendKeys("Kumaran");
	}
	@Test(priority=-0,enabled=false)
	public void lastName() {
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys("Karuppannan");
	}
	@AfterClass
	public void driverClose() {
		driver.close();
	}
}
