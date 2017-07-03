package com.epam.nwi.merchant_portal_at.base;

import org.openqa.selenium.WebDriver;

import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;
import com.epam.nwi.merchant_portal_at.pages.CreateAccountPage;
import com.epam.nwi.merchant_portal_at.pages.MerchantPortalHomePage;

public class BaseUtil {

	public String stepInfo;
	public WebDriver driver;
	public static MerchantPortalHomePage _homePage;
	public static CreateAccountPage _createAccountPage;
	
}
