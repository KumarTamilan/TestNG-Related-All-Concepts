package org.dataProviderTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WithDataProviderTes3 {

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
	public String[][] qaData() {
		PropertyReaderClass3 reader = new PropertyReaderClass3(".\\Excel\\FBData.xlsx","Sheet6");
		int row = reader.findRow();
		int cell = reader.findCell();
		return reader.findValues(row, cell);
	}
}
