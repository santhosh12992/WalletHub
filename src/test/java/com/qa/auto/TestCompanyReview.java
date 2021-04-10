package com.qa.auto;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qa.auto.base.WebDriverBase;
import com.qa.auto.emun.InsuranceCompany;
import com.qa.auto.emun.Stars;
import com.qa.auto.testHelper.ConfigSettings;

@Test
public class TestCompanyReview extends WebDriverBase {

	public void TC001_create_and_validate_review() {
		// the email id and password can be made to read from excel sheet, refer apache
		// poi
		String emailId = ConfigSettings.getEmailId();
		String password = ConfigSettings.getPassword();
		String reviewContent = ConfigSettings.getReviewContent();

		loginPage.login(emailId, password);
		testInsurancePage.getTestInsuranceCompany();
		testInsurancePage.navigateToReview();

		boolean result = testInsurancePage.mouseHover(Stars.FOUR);
		assertTrue(result, "Color do not change after hovering on the star");

		testInsurancePage.selectStar(Stars.FOUR);
		createReviewPage.selectDD(InsuranceCompany.HEALTH_INSURANCE);
		createReviewPage.submitReviewText(reviewContent);

		profilePage.navigateToProfile();
		boolean validateReview = profilePage.validateReview("Test Insurance Company", Stars.FOUR);
		assertTrue(validateReview, "Stars do not match after posting the review");
	}
}
