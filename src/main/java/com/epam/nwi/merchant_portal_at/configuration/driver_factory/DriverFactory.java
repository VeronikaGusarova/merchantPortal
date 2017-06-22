package com.epam.nwi.merchant_portal_at.configuration.driver_factory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.epam.nwi.merchant_portal_at.configuration.Browser;
import com.epam.nwi.merchant_portal_at.helper.SystemProperties;

public class DriverFactory {

	public WebDriver Build(Browser browser) throws Exception {
		switch (browser) {
		case CHROME: {
			System.setProperty("webdriver.chrome.driver", SystemProperties.getProperty("chromeDriverPath"));

			return new ChromeDriver();
		}
		case OPERA: {
			System.setProperty("webdriver.opera.driver", SystemProperties.getProperty("operaPath"));

			return new OperaDriver();
		}
		case IE: {
			System.setProperty("webdriver.ie.driver", SystemProperties.getProperty("iePath"));

			return new InternetExplorerDriver();
		}
		case FF: {
			/*
			 * FirefoxBinary binary = new FirefoxBinary(new
			 * File(SystemProperties.getProperty("fireFoxExePath")));
			 * FirefoxProfile profile = new FirefoxProfile(new File(
			 * SystemProperties.getProperty("fireFoxProfileFolder"))); return
			 * new FirefoxDriver(binary, profile);
			 */
			System.setProperty("webdriver.firefox.marionette", SystemProperties.getProperty("firefoxDriverPath"));
			return new FirefoxDriver();
		}

		default:
			throw new Exception();
		}
	}
}
