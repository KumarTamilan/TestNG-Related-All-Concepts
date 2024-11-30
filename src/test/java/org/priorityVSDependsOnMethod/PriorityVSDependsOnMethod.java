package org.priorityVSDependsOnMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriorityVSDependsOnMethod {

	//If we use Priority and DependsOnMethod The all @Test Method will be followed by
	//DependsOnMethod attribute.
	
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
	@Test(priority=1,dependsOnMethods="urlLaunch")
	public void username() {
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
	}
	@Test(priority=4,dependsOnMethods="username")
	public void password() {
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Test");
	}
	
	@Test(priority=3,dependsOnMethods="password")
	public void clickCreateNewAccount() {
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
	}
	
	@Test(priority=2,dependsOnMethods="clickCreateNewAccount")
	public void firstName() {
		WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@name,'firstname')]"));
		firstName.sendKeys("Kumaran");
	}
	@Test(priority=10,dependsOnMethods="firstName")
	public void lastName() {
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys("Karuppannan");
	}
	@Test(priority=9,dependsOnMethods="lastName")
	public void day() {
		WebElement dropdown1 = driver.findElement(By.xpath("//select[starts-with(@id,'day')]"));
		Select s1 = new Select(dropdown1);
		s1.selectByValue("15");
	}
	@Test(priority=8,dependsOnMethods="day")
	public void month() {
		WebElement dropdown2 = driver.findElement(By.xpath("//select[starts-with(@id,'month')]"));
		Select s2 = new Select(dropdown2);
		s2.selectByValue("8");
	}
	@Test(priority=7,dependsOnMethods="month")
	public void year() {
		WebElement dropdown3 = driver.findElement(By.xpath("//select[starts-with(@id,'year')]"));
		Select s3 = new Select(dropdown3);
		s3.selectByValue("1993");
	}
	@Test(priority=6,dependsOnMethods="year")
	public void mobileNumber() {
		WebElement mobileNumber = driver.findElement(By.xpath("//input[starts-with(@name,'reg_email__')]"));
		mobileNumber.sendKeys("7568485767");
	}
	@Test(priority=5,dependsOnMethods="mobileNumber")
	public void newPassword() {
		WebElement newPassword = driver.findElement(By.xpath("//input[starts-with(@name,'reg_passwd__')]"));
		newPassword.sendKeys("HemaHarshRithvik");
	}
	
	@AfterClass(alwaysRun=true)
	public void driverClose() {
		driver.close();
	}
}
