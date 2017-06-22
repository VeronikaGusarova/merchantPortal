package com.epam.nwi.merchant_portal_at.steps;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.*;

import com.epam.nwi.merchant_portal_at.base.BaseUtil;
import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;
import com.epam.nwi.merchant_portal_at.pages.CreateAccountPage;
import com.epam.nwi.merchant_portal_at.pages.MerchantPortalHomePage;

public class Hook {

	public static WebDriver _webDriver;

	@Before
	public static void init() {
		_webDriver = Driver.getWebDriver();
	}

	@After("@closeDriver")
	public static void close() {
		Driver.getWebDriver().close();
	}
}
