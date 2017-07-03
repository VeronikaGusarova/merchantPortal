package com.epam.nwi.merchant_portal_at.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextFieldControl extends Control {

	private WebElement controlLabelWebElement = null;

	public TextFieldControl(By controlLocator, By controlLabelLocator) throws Exception {
		super(controlLocator);
		if (controlLabelLocator == null)
			throw new Exception("Label locator is null");
		else if (!this.isElementPresent(controlLabelLocator))
			throw new Exception("Label element not found or not displayed");

		controlLabelWebElement = driver.findElement(controlLabelLocator);
	}

	public Boolean isControlLabelTextEquals(String controlLabelText) {
		return getControlLabelWebElement().getText().equals(controlLabelText);
	}

	public Boolean isControlLabelTextContains(String controlLabelText) {
		return getControlLabelWebElement().getText().contains(controlLabelText);
	}

	public WebElement getControlLabelWebElement() {
		return controlLabelWebElement;
	}

	public Boolean isInnerTextEquals(String innerText) {
		return getControlWebElement().getAttribute("placeholder").equals(innerText);
	}

	public boolean isFieldMandatory() {
		return controlLabelWebElement.getText().endsWith("*");
	}
}
