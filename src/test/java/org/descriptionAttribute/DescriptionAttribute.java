package org.descriptionAttribute;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DescriptionAttribute {

	static WebDriver driver;
	@BeforeClass
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=-5,description="This method is used to launch the url")
	public void urlLaunch() {
		driver.get("https://www.facebook.com/");
	}
	@Test(priority=-4,description = "This method is used to enter the username in username field")
	public void username() {
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
	}
	@Test(priority=-3,description = "This method is used to enter the password in password field")
	public void password() {
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Test");
	}
	@Test(priority=-2,description = "This method is used to click the createNew account Button")
	public void clickCreateNewAccount() {
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
	}
	@Test(priority=-1,description = "This method is used to enter the firstname in firstname field")
	public void firstName() {
		WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@name,'firstname')]"));
		firstName.sendKeys("Kumaran");
	}
	@Test(priority=-0,description = "This method is used to enter the lastname in lastname field")
	public void lastName() {
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys("Karuppannan");
	}
	@AfterClass
	public void driverClose() {
		driver.close();
	}
}
