package com.epam.nwi.merchant_portal_at.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {
	
	public CreateAccountPage() {
		PageFactory.initElements(_driver, this);
	}

	public String getPhoneNumberPrefixEquals() {
		return _driver.findElement(By.className("prefix-input-label")).getText();
	}




}