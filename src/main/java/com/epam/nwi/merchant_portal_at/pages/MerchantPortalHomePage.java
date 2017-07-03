package com.epam.nwi.merchant_portal_at.pages;

import com.epam.nwi.merchant_portal_at.helper.SystemProperties;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantPortalHomePage extends BasePage {
	@FindBy(className = "btn-primary")
	public WebElement createAccountLink;

	final String SIGN_IN_BUTTON_MODAL_WIN = "form.login-modal button.btn-primary";
	final String SIGN_IN_BUTTON_LANDING_PAGE = "p.sign-section a";

	public MerchantPortalHomePage() {
		PageFactory.initElements(_driver, this);
	}

	public CreateAccountPage clickCreateAccount() {
		createAccountLink.click();
		return new CreateAccountPage();
	}

	public boolean isPageViewableFrom(URL proposedUrl) {
		return proposedUrl.getPath().startsWith("/"); // may be corrected
	}

	public MerchantPortalHomePage open() {
		_driver.navigate().to(SystemProperties.getProperty("homePageUrl"));
		return this;
	}

	

	public void clickSignIn(boolean isModalWin) {
		By locator = null;
		if (isModalWin)
			locator = By.cssSelector(SIGN_IN_BUTTON_MODAL_WIN);
		else
			locator = By.cssSelector(SIGN_IN_BUTTON_LANDING_PAGE);

		_driver.findElement(locator).click();
	}

	public boolean isSignInModalWinOpenedAndCorrect() {
		return _driver.findElements(By.className("modal-dialog")).size() == 1
				&& _driver.findElement(By.cssSelector("div.modal-dialog h3.modal-title")).getText().equals("Sign in");

	}

	
	

}
