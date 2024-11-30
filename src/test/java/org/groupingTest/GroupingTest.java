package org.groupingTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupingTest {

	static WebDriver driver;
	@BeforeClass(alwaysRun=true)
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority = -9,groups= {"Smoke","Sanity","Regression"})
	public void urlLaunch() {
		driver.get("https://www.facebook.com/");
	}
	@Test(priority = -8,groups= {"Smoke","Sanity","Regression"})
	public void username() {
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
	}
	@Test(priority = -7,groups= {"Smoke","Sanity","Regression"})
	public void password() {
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Test");
	}@Test(priority = -6,groups= {"Smoke"})
	public void logInClick() {
		WebElement forgotClick = driver.findElement(By.xpath("//button[@name='login']"));
		forgotClick.click();
	}
	
	@Test(priority = -5,groups= {"Sanity"})
	public void forgotPasswordClick() {
		WebElement forgotClick = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
		forgotClick.click();
	}
	
	@Test(priority = -4,groups= {"Sanity"})
	public void forgotEmail() {
		WebElement forgotEmail = driver.findElement(By.xpath("//input[@id='identify_email']"));
		forgotEmail.sendKeys("Kumaran1234@gmail.com");
	}
	@Test(priority = -3,groups= {"Regression"})
	public void clickCreateNewAccount() {
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
	}
	@Test(priority = -2,groups= {"Regression"})
	public void firstName() {
		WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@name,'firstname')]"));
		firstName.sendKeys("Kumaran");
	}
	@Test(priority = -1,groups= {"Regression"})
	public void lastName() {
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys("Karuppannan");
	}
	@Test(priority = 0,groups= {"Regression"})
	public void day() {
		WebElement dropdown1 = driver.findElement(By.xpath("//select[starts-with(@id,'day')]"));
		Select s1 = new Select(dropdown1);
		s1.selectByValue("15");
	}
	@Test(priority = 1,groups= {"Regression"})
	public void month() {
		WebElement dropdown2 = driver.findElement(By.xpath("//select[starts-with(@id,'month')]"));
		Select s2 = new Select(dropdown2);
		s2.selectByValue("8");
	}
	@Test(priority = 2,groups= {"Regression"})
	public void year() {
		WebElement dropdown3 = driver.findElement(By.xpath("//select[starts-with(@id,'year')]"));
		Select s3 = new Select(dropdown3);
		s3.selectByValue("1993");
	}
	@Test(priority = 3,groups= {"Regression"})
	public void mobileNumber() {
		WebElement mobileNumber = driver.findElement(By.xpath("//input[starts-with(@name,'reg_email__')]"));
		mobileNumber.sendKeys("7568485767");
	}
	@Test(priority = 4,groups= {"Regression"})
	public void newPassword() {
		WebElement newPassword = driver.findElement(By.xpath("//input[starts-with(@name,'reg_passwd__')]"));
		newPassword.sendKeys("HemaHarshRithvik");
	}
	
	@AfterClass(alwaysRun=true)
	public void driverClose() {
		driver.close();
	}
}
