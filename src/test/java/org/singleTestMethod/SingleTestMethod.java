package org.singleTestMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SingleTestMethod {

	@Test
	public void browserLaunch() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys("Kumaran");
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys("Kumaran@Test");
		
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@name,'firstname')]"));
		firstName.sendKeys("Kumaran");
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys("Karuppannan");
		
		WebElement dropdown1 = driver.findElement(By.xpath("//select[starts-with(@id,'day')]"));
		Select s1 = new Select(dropdown1);
		s1.selectByValue("15");
		
		WebElement dropdown2 = driver.findElement(By.xpath("//select[starts-with(@id,'month')]"));
		Select s2 = new Select(dropdown2);
		s2.selectByValue("8");
		
		WebElement dropdown3 = driver.findElement(By.xpath("//select[starts-with(@id,'year')]"));
		Select s3 = new Select(dropdown3);
		s3.selectByValue("1993");
		
		WebElement mobileNumber = driver.findElement(By.xpath("//input[starts-with(@name,'reg_email__')]"));
		mobileNumber.sendKeys("7568485767");
		WebElement newPassword = driver.findElement(By.xpath("//input[starts-with(@name,'reg_passwd__')]"));
		newPassword.sendKeys("HemaHarshRithvik");
		
		driver.close();
	}
}
