/* Test automation using Java & Selenium. Set of examples. Created by Alex L. 
   Handling Hidden Elements - example*/

package com.alex.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test06 {

	@Test
	public void visibilityTest() {
		// Creating driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Opening page
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		System.out.println("Page opened!");

		// Clicking start button
		WebElement startButton = driver.findElement(By.xpath("//button"));
		System.out.println("Is Start button visible before click: " + startButton.isDisplayed());
		startButton.click();

		// Waiting for Hello World! text
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

		// Verifying Hello World text
		WebElement finishText = driver.findElement(By.id("finish"));
		String text = finishText.getText();
		Assert.assertTrue(text.equals("Hello World!"), "'Hello World! text is not present on the page.'");

		System.out.println("Is Start button visible after click: " + startButton.isDisplayed());

		// Closing browser
		driver.quit();
	}

}
