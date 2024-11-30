package org.enabledFalseVSAlwaysRun;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnabledFalseVSAlwaysRun {

	//If we use enabled=false and alwaysRun The all @Test method will be 
	//		followed by enabled=false.
	
	static WebDriver driver;
	@BeforeClass(alwaysRun=true)
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(priority=1)
	public void urlLaunch() {
		driver.get("https://www.facebook.com/");
	}
	@Test(enabled=false,alwaysRun=true)
	public void username() {
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
	}
	@Test(priority=2,alwaysRun=true)
	public void password() throws InterruptedException {
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Test");
		Thread.sleep(5000);
	}
	
	@Test(enabled=false,alwaysRun=true)
	public void clickCreateNewAccount() {
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
	}
	
	@Test(enabled=false,alwaysRun=true)
	public void firstName() {
		WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@name,'firstname')]"));
		firstName.sendKeys("Kumaran");
	}
	@Test(enabled=false,alwaysRun=true)
	public void lastName() {
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys("Karuppannan");
	}
	@Test(enabled=false,alwaysRun=true)
	public void day() {
		WebElement dropdown1 = driver.findElement(By.xpath("//select[starts-with(@id,'day')]"));
		Select s1 = new Select(dropdown1);
		s1.selectByValue("15");
	}
	@Test(enabled=false,alwaysRun=true)
	public void month() {
		WebElement dropdown2 = driver.findElement(By.xpath("//select[starts-with(@id,'month')]"));
		Select s2 = new Select(dropdown2);
		s2.selectByValue("8");
	}
	@Test(enabled=false,alwaysRun=true)
	public void year() {
		WebElement dropdown3 = driver.findElement(By.xpath("//select[starts-with(@id,'year')]"));
		Select s3 = new Select(dropdown3);
		s3.selectByValue("1993");
	}
	@Test(enabled=false,alwaysRun=true)
	public void mobileNumber() {
		WebElement mobileNumber = driver.findElement(By.xpath("//input[starts-with(@name,'reg_email__')]"));
		mobileNumber.sendKeys("7568485767");
	}
	@Test(enabled=false,alwaysRun=true)
	public void newPassword() {
		WebElement newPassword = driver.findElement(By.xpath("//input[starts-with(@name,'reg_passwd__')]"));
		newPassword.sendKeys("HemaHarshRithvik");
	}
	
	@AfterClass(alwaysRun=true)
	public void driverClose() {
		driver.close();
	}
}
