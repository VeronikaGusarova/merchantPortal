package com.epam.nwi.merchant_portal_at.pages;

import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;
import com.epam.nwi.merchant_portal_at.helper.SystemProperties;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantPortalHomePage extends BasePage {
	@FindBy(className = "btn-primary1")
	public WebElement createAccountLink;

	public MerchantPortalHomePage() {
		PageFactory.initElements(Driver.getWebDriver(), this);
	}

	public CreateAccountPage clickCreateAccount() {
		createAccountLink.click();
		return new CreateAccountPage();
	}

	public boolean isPageViewableFrom(URL proposedUrl) {
		return proposedUrl.getPath().startsWith("/"); // may be corrected
	}

	public MerchantPortalHomePage open() {
		Driver.getWebDriver().navigate().to(SystemProperties.getProperty("homePageUrl"));
		return this;
	}
}
