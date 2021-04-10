package com.qa.auto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='email']")
	WebElement email;

	@FindBy(xpath = "//*[@id='password']")
	WebElement pass;

	@FindBy(xpath = "//input[@value='submit']//parent::div/button[2]")
	WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String emailId, String password) {
		email.sendKeys(emailId);
		pass.sendKeys(password);
		login.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
