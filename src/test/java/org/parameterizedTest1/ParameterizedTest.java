package org.parameterizedTest1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

	static WebDriver driver;
	@Parameters({"username","password"})
	@Test
	public void browserLaunch(String userName,String passWord) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys(userName);
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys(passWord);
		driver.close();
	}
}
