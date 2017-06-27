package com.epam.nwi.merchant_portal_at.pages;

import com.epam.nwi.merchant_portal_at.helper.SystemProperties;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantPortalHomePage extends BasePage {
	@FindBy(className = "btn-primary")
	public WebElement createAccountLink;

	final String SIGN_IN_BUTTON_MODAL_WIN = "form.login-modal button.btn-primary";
	final String SIGN_IN_BUTTON_LANDING_PAGE = "p.sign-section a";

	public MerchantPortalHomePage() {
		PageFactory.initElements(_driver, this);
	}

	public CreateAccountPage clickCreateAccount() {
		createAccountLink.click();
		return new CreateAccountPage();
	}

	public boolean isPageViewableFrom(URL proposedUrl) {
		return proposedUrl.getPath().startsWith("/"); // may be corrected
	}

	public MerchantPortalHomePage open() {
		_driver.navigate().to(SystemProperties.getProperty("homePageUrl"));
		return this;
	}

	public boolean isControlExists(String controlName, String text) throws Exception {
		By controlLocator = null;
		switch (controlName) {
		case "welcomeLabel": {
			controlLocator = By.className("landing-title");
			break;
		}
		case "joinLabel": {
			controlLocator = By.className("start-panel-title");
			break;
		}
		case "startPaymentButton": {
			controlLocator = By.className("btn-primary");
			break;
		}
		case "signIn": {
			controlLocator = By.cssSelector(SIGN_IN_BUTTON_LANDING_PAGE);
			break;
		}
		case "ForgottenPasswordLink": {
			controlLocator = By.cssSelector("div.modal-dialog a");
			break;
		}
		case "SignInModalDialog": {
			controlLocator = By.cssSelector(SIGN_IN_BUTTON_MODAL_WIN);
			break;
		}
		default:
			throw new Exception("Unexpected control name " + controlName);
		}
		if (controlName.equals("SignInModalDialog")) {
			System.out.println("Count of found elements" + _driver.findElements(controlLocator).size());
			System.out.println("Label" + _driver.findElement(controlLocator).getText());
		}
		return _driver.findElements(controlLocator).size() == 1
				&& _driver.findElement(controlLocator).getText().equals(text);
	}

	public void clickSignIn(boolean isModalWin) {
		By locator = null;
		if (isModalWin)
			locator = By.cssSelector(SIGN_IN_BUTTON_MODAL_WIN);
		else
			locator = By.cssSelector(SIGN_IN_BUTTON_LANDING_PAGE);

		_driver.findElement(locator).click();
	}

	public boolean isSignInModalWinOpenedAndCorrect() {
		return _driver.findElements(By.className("modal-dialog")).size() == 1
				&& _driver.findElement(By.cssSelector("div.modal-dialog h3.modal-title")).getText().equals("Sign in");

	}

	public boolean isTextFieldExists(String controlName, String label, String innerText) throws Exception {
		By controlLocator = null;
		By controlLabelLocator = null;
		switch (controlName) {
		case "Email": {
			controlLocator = By.id("login");
			controlLabelLocator = By.cssSelector("label[for='login']");
			break;
		}
		case "Password": {
			controlLocator = By.id("password");
			controlLabelLocator = By.cssSelector("label[for='password']");
			break;
		}
		default:
			throw new Exception("Unexpected control name " + controlName);
		}

		return _driver.findElements(controlLocator).size() == 1
				&& _driver.findElement(controlLabelLocator).getText().contains(label)
				&& _driver.findElement(controlLocator).getAttribute("placeholder").equals(innerText);
	}

	public boolean isValidationMessageShown(String fieldName, String errorText) throws Exception {
		By controlLocator = null;
		By controlErrorLocator = null;
		switch (fieldName) {
		case "Email": {
			controlLocator = By.id("login");
			controlErrorLocator = By.xpath("input[@id='login']/following::small");
			break;
		}
		case "Password": {
			controlLocator = By.id("password");
			controlErrorLocator = By.cssSelector("input[@id='password']/following::small");
			break;
		}
		default:
			throw new Exception("Unexpected field name " + fieldName);
		}
		System.out.println("errors count" + _driver.findElements(controlErrorLocator).size());
		System.out.println("error text " + _driver.findElement(controlErrorLocator).getText());
		System.out.println(
				"class text " + _driver.findElement(controlLocator).findElement(By.xpath("/..")).getAttribute("class"));
		return _driver.findElements(controlLocator).size() == 1 && _driver.findElements(controlErrorLocator).size() == 1
				&& _driver.findElement(controlErrorLocator).getText().equals(errorText)
				&& _driver.findElement(controlLocator).findElement(By.xpath("/..")).getAttribute("class")
						.contains("field-error");
	}
}
