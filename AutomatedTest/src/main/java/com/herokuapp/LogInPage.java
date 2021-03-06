/* Test automation using Java & Selenium. Set of examples. Created by Alex L. 
   Part of Page Object Models example*/

package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.alex.base.BasePageObject;

public class LogInPage extends BasePageObject {
	private String logInPageUrl = "http://the-internet.herokuapp.com/login";

	private String username = "tomsmith";
	private String password = "SuperSecretPassword!";

	By usernameLocator = By.id("username");
	By passwordLocator = By.cssSelector("input[name=password]");
	By loginButtonLocator = By.xpath("//button[@type='submit']");

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public SecurePage logIn() {
		System.out.println("Entering username and password");
		find(usernameLocator).sendKeys(username);
		find(passwordLocator).sendKeys(password);
		System.out.println("Clicking Login button");
		find(loginButtonLocator).click();
		return new SecurePage(driver);
	}

	public void open() {
		openURL(logInPageUrl);
	}

}
