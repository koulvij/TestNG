package com.vkoul.testng.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vkoul.testng.util.Constants;

public class TestNGGmailLogin {

	@Test
	public void gmailLogin() {

		System.setProperty(Constants.WEBDRIVER_NAME, Constants.CHROME_EXE_PATH);

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(Constants.GMAIL_SIGNIN_URL);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));

		// put you Phone or EmailId here
		email_phone.sendKeys(Constants.USER_NAME);
		driver.findElement(By.id("identifierNext")).click();

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(password));

		// put you password here
		password.sendKeys(Constants.PASSWORD);
		driver.findElement(By.id("passwordNext")).click();

		// close the web browser
		driver.close();
	}
}
