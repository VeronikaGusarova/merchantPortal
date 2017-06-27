package com.epam.nwi.merchant_portal_at.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;

public class BasePage {
	protected WebDriver _driver = Driver.getWebDriver();

	public BasePage() {
		Driver.getWebDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		Driver.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

}
