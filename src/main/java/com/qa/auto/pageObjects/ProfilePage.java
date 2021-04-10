package com.qa.auto.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.auto.emun.Stars;

public class ProfilePage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='viewport']//a[9]")
	WebElement userNav;

	@FindBy(xpath = "//nav[@id='m-user']//a[contains(text(),'Profile')]")
	WebElement profile;

	String starsXpath = "//div[@class='pr-rec-container']//a[contains(text(), '$$$$')]//parent::div//review-star//div";
	String starFilledColor = "#4ae0e1";

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToProfile() {
		driver.get("https://wallethub.com/profile");
		Actions action = new Actions(driver);
		action.moveToElement(userNav).build().perform();
		action.pause(500);
		profile.click();
	}

	public boolean validateReview(String companyName, Stars value) {
		starsXpath = starsXpath.replace("$$$$", companyName);
		WebElement stars = driver.findElement(By.xpath(starsXpath));
		List<WebElement> ratings = stars.findElements(By.tagName("svg"));
		int result = 0;
		for (WebElement rating : ratings) {
			String color = rating.findElement(By.tagName("g")).findElement(By.tagName("path")).getAttribute("fill");
			if (color.equals(starFilledColor)) {
				result += 1;
			}
		}
		System.out.println(result);
		return value.rating == result;
	}
}
