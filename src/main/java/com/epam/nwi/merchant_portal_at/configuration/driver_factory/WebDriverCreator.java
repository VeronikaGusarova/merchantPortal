package com.epam.nwi.merchant_portal_at.configuration.driver_factory;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
	protected WebDriver driver;

	public abstract WebDriver FactoryMethod();
}
