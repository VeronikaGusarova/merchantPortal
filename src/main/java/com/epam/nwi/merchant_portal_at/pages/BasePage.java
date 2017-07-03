package com.epam.nwi.merchant_portal_at.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;
import com.epam.nwi.merchant_portal_at.ui.Control;
import com.epam.nwi.merchant_portal_at.ui.TextFieldControl;

public class BasePage {
	protected WebDriver _driver = Driver.getWebDriver();

	public BasePage() {
		Driver.getWebDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		Driver.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getWebDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	public boolean isControlExists(String controlName, String text) throws Exception {
		Control control = null;

		switch (controlName) {
		case "welcomeLabel": {
			control = new Control(By.className("landing-title"));
			break;
		}
		case "joinLabel": {
			control = new Control(By.className("start-panel-title"));
			break;
		}
		case "startPaymentButton": {
			control = new Control(By.className("btn-primary"));
			break;
		}
		case "signIn": {
			control = new Control(By.cssSelector("p.sign-section a"));
			break;
		}
		case "ForgottenPasswordLink": {
			control = new Control(By.cssSelector("div.modal-dialog a"));
			break;
		}
		case "SignInModalDialog": {
			control = new Control(By.cssSelector("form.login-modal button.btn-primary"));
			break;
		}
		case "createAccountTitle": {
			control = new Control(By.className("page-title"));
			break;
		}
		case "createAccountDescription": {
			control = new Control(By.className("page-subtitle"));
			break;
		}
		case "signUpButton": {
			control = new Control(By.className("btn-primary"));
			break;
		}
		case "termsConditionsLink": {
			control = new Control(By.cssSelector("div.agreements-info a:nth-child(1)"));
			break;
		}
		case "privacyPolicyLink": {
			control = new Control(By.cssSelector("div.agreements-info a:nth-child(2)"));
			break;
		}
		default:
			throw new Exception("Unexpected control name " + controlName);
		}

		return control.isControlTextEquals(text);
	}

	public boolean isTextFieldExists(String controlName, String label, String innerText) throws Exception {
		TextFieldControl control = null;

		switch (controlName) {
		case "Login": {
			control = new TextFieldControl(By.id("login"), By.cssSelector("label[for='login']"));
			break;
		}
		case "Password": {
			control = new TextFieldControl(By.id("password"), By.cssSelector("label[for='password']"));
			break;
		}
		case "Email": {
			control = new TextFieldControl(By.id("email"), By.cssSelector("label[for='email']"));
			break;
		}
		case "LegalName": {
			control = new TextFieldControl(By.id("company"), By.cssSelector("label[for='company']"));
			break;
		}
		case "AuthorizedSignatory": {
			control = new TextFieldControl(By.id("name"), By.cssSelector("label[for='name']"));
			break;
		}
		case "MobilePhone": {
			control = new TextFieldControl(By.id("phone"), By.cssSelector("label[for='phone']"));
			break;
		}
		default:
			throw new Exception("Unexpected control name " + controlName);
		}

		return control.isControlLabelTextContains(label) && control.isInnerTextEquals(innerText);
	}

	public boolean isValidationMessageShown(String fieldName, String errorText) throws Exception {
		By controlLocator = null;
		By controlErrorLocator = null;
		switch (fieldName) {
		case "Login": {
			controlLocator = By.id("login");
			controlErrorLocator = By.xpath("//input[@id='login']/following::small");
			break;
		}
		case "Password": {
			controlLocator = By.id("password");
			controlErrorLocator = By.xpath("//input[@id='password']/following::small");
			break;
		}
		default:
			throw new Exception("Unexpected field name " + fieldName);
		}

		return _driver.findElements(controlLocator).size() == 1
				&& _driver.findElement(controlErrorLocator).getText().equals(errorText)
				&& _driver.findElement(controlLocator).findElement(By.xpath("..")).getAttribute("class")
						.contains("field-error");
	}
	
	public boolean isFieldMandatory(String fieldName) throws Exception {
		TextFieldControl control = null;
		switch (fieldName) {
		case "Email": {
			control = new TextFieldControl(By.id("email"), By.cssSelector("label[for='email']"));
			break;
		}
		case "LegalName": {
			control = new TextFieldControl(By.id("company"), By.cssSelector("label[for='company']"));
			break;
		}
		case "AuthorizedSignatory": {
			control = new TextFieldControl(By.id("name"), By.cssSelector("label[for='name']"));
			break;
		}
		case "MobilePhone": {
			control = new TextFieldControl(By.id("phone"), By.cssSelector("label[for='phone']"));
			break;
		}
		default:
			throw new Exception("Unexpected control name " + fieldName);
		}
		
		return control.isFieldMandatory();
	}

}
