package com.epam.nwi.merchant_portal_at.configuration.driver_factory;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.epam.nwi.merchant_portal_at.configuration.Browser;
import com.epam.nwi.merchant_portal_at.helper.SystemProperties;

public final class Driver {
private static WebDriver _driver;

public static WebDriver getWebDriver()
{
	if (ShouldCreateDriver())
    {
		DriverFactory driverFactory = new DriverFactory();

        try {
			_driver = driverFactory.Build(
			    Browser.valueOf(SystemProperties.getProperty("browser")));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    return _driver;
}

private static Boolean ShouldCreateDriver()
{
    if (_driver == null)
        return true;

    try
    {
        return StringUtils.isBlank(_driver.getWindowHandle());
    }
    catch (WebDriverException we)
    {
        return true;
    }            
}
}
