package com.qa.auto.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.auto.emun.Stars;

public class TestInsuranceCompanyPage {
	WebDriver driver;
	String testInsurnaceURL = "http://wallethub.com/profile/test_insurance_company/";
	String starFilledColor = "#4ae0e1";

	@FindBy(xpath = "//nav//span[contains(text(), 'Reviews')]")
	WebElement review;

	@FindBy(xpath = "//*[@id='reviews-section']/div[1]/div[3]/review-star/div")
	WebElement stars;

	@FindBy(xpath = "//*[@id='reviews-section']/modal-dialog//*[contains(text(), 'Submit')]")
	WebElement reviewSubmit;

	public TestInsuranceCompanyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getTestInsuranceCompany() {
		driver.get(testInsurnaceURL);
	}

	public void navigateToReview() {
		review.click();
	}

	public boolean mouseHover(Stars value) {
		List<WebElement> allStars = stars.findElements(By.tagName("svg"));
		Actions action = new Actions(driver);
		WebElement we = allStars.get(value.rating - 1);
		action.moveToElement(we).build().perform();
		String color = we.findElement(By.tagName("g")).findElement(By.tagName("path")).getAttribute("fill");
		return color.equals(starFilledColor);
	}

	public void selectStar(Stars value) {
		List<WebElement> allStars = stars.findElements(By.tagName("svg"));
		Actions action = new Actions(driver);
		WebElement targetStar = allStars.get(value.rating - 1);
		action.pause(1000);
		action.moveToElement(targetStar).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(reviewSubmit));
	}
}
