package org.dependsOnMethodVSAlwaysRun;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependsOnMethodVSAlwaysRun {

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
	@Test(dependsOnMethods="urlLaunch")
	public void username() {
		WebElement username = driver.findElement(By.xpath("//inpt[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
	}
	@Test(dependsOnMethods="username",alwaysRun=true)
	public void password() {
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Test");
	}
	
	@Test(dependsOnMethods="password")
	public void clickCreateNewAccount() {
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
	}
	
	@Test(dependsOnMethods="clickCreateNewAccount")
	public void firstName() {
		WebElement firstName = driver.findElement(By.xpath("//inpt[starts-with(@name,'firstname')]"));
		firstName.sendKeys("Kumaran");
	}
	@Test(dependsOnMethods="firstName",alwaysRun=true)
	public void lastName() {
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys("Karuppannan");
	}
	@Test(dependsOnMethods="lastName")
	public void day() {
		WebElement dropdown1 = driver.findElement(By.xpath("//select[starts-with(@id,'day')]"));
		Select s1 = new Select(dropdown1);
		s1.selectByValue("15");
	}
	@Test(dependsOnMethods="day")
	public void month() {
		WebElement dropdown2 = driver.findElement(By.xpath("//selct[starts-with(@id,'month')]"));
		Select s2 = new Select(dropdown2);
		s2.selectByValue("8");
	}
	@Test(dependsOnMethods="month",alwaysRun=true)
	public void year() {
		WebElement dropdown3 = driver.findElement(By.xpath("//select[starts-with(@id,'year')]"));
		Select s3 = new Select(dropdown3);
		s3.selectByValue("1993");
	}
	@Test(dependsOnMethods="year")
	public void mobileNumber() {
		WebElement mobileNumber = driver.findElement(By.xpath("//inpt[starts-with(@name,'reg_email__')]"));
		mobileNumber.sendKeys("7568485767");
	}
	@Test(dependsOnMethods="mobileNumber",alwaysRun=true)
	public void newPassword() throws InterruptedException {
		WebElement newPassword = driver.findElement(By.xpath("//input[starts-with(@name,'reg_passwd__')]"));
		newPassword.sendKeys("HemaHarshRithvik");
		Thread.sleep(5000);
	}
	
	@AfterClass(alwaysRun=true)
	public void driverClose() {
		driver.close();
	}
}
