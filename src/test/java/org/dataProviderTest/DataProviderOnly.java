package org.dataProviderTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderOnly {

	static WebDriver driver;

	@Test(dataProvider="qaTestData")
	public static void main(String userName,String passWord) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");

		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys(userName);
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys(passWord);
		Thread.sleep(4000);
		driver.close();
	}
	@DataProvider(name="qaTestData")
	public Object[][] qaData() {
		Object [][] data = {{"kumaran12@gmail.com","Rithvik@Test"},
										{"karuppannan@gmail.com","Harshanth@Test"},
										{"amutha@gmail.com","Karuppannan@Test"},
										{"hemalatha12@gmail.com","Amutha@Test"},
										{"karthick@gmail.com","Hema@Test"},
										{"harshanth@gmail.com","Karthick@Test"},
										{"rithvik@gmail.com","Kumaran@Test"}
										};
		return data;
	}
}
