package com.epam.nwi.merchant_portal_at.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;

public class Control {
	protected WebDriver driver = Driver.getWebDriver();
	protected WebElement controlWebElement;

	public Control(By controlLocator) throws Exception {
		if (controlLocator == null)
			throw new Exception("Control locator is null");
		else if (!this.isElementPresent(controlLocator))
			throw new Exception("Element not found or not displayed");

		controlWebElement = driver.findElement(controlLocator);
	}

	public Boolean isElementPresent(By controlLocator) {
		return driver.findElements(controlLocator).size() == 1 && driver.findElement(controlLocator).isDisplayed();
	}

	public Boolean isControlTextEquals(String controlText) {
		return controlWebElement.getText().equals(controlText);
	}

	public Boolean isControlTextContains(String controlText) {
		return controlWebElement.getText().contains(controlText);
	}

	public WebElement getControlWebElement() {
		return controlWebElement;
	}

}
