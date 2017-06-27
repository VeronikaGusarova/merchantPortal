package com.epam.nwi.merchant_portal_at.steps;

import java.util.List;

import org.testng.Assert;
import com.epam.nwi.merchant_portal_at.base.BaseUtil;
import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;
import com.epam.nwi.merchant_portal_at.pages.CreateAccountPage;
import com.epam.nwi.merchant_portal_at.pages.MerchantPortalHomePage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class OpenCreateNewAccountPageSteps extends BaseUtil {

	private BaseUtil _base;
	public static MerchantPortalHomePage _homePage;
	public static CreateAccountPage _createAccountPage;

	public OpenCreateNewAccountPageSteps(BaseUtil base) {
		this._base = base;
	}

	@Given("^I open MerchantPortal Home Page$")
	public void i_have_opened_MerchantPortal_Home_Page() {
		_homePage = new MerchantPortalHomePage().open();
	}

	@When("^I click StartTakingPayments button$")
	public void i_click_StartTakingPayments_button() {
		_createAccountPage = _homePage.clickCreateAccount();
	}

	@Then("^I see StartTakingPayments page$")
	public void i_see_StartTakingPayments_page() {
		String url = Driver.getWebDriver().getCurrentUrl();
		Assert.assertTrue(url.endsWith("/create-account"), "page url is wrong: " + url);
	}

	@Then("^I see control with text$")
	public void i_see_with(DataTable controls) throws Exception {
		List<List<String>> data = controls.raw();
		String controlName = data.get(0).get(0);
		String text = data.get(0).get(1);
		Assert.assertTrue(_homePage.isControlExists(controlName, text),
				"Control " + controlName + " with text " + text + " doesn't exist");
	}

	@When("^I click Sign in link$")
	public void i_click_Sign_in_link() throws Throwable {
		_homePage.clickSignIn(false);
	}

	@Then("^I see Sign In modal dialog$")
	public void i_see_Sign_In_modal_dialog() throws Throwable {
		Assert.assertTrue(_homePage.isSignInModalWinOpenedAndCorrect(), "Sign In modal window was not opened properly");
	}

	@Then("^I see text field with label and inner text$")
	public void i_see_text_field_with_inner_text(DataTable controls) throws Throwable {
		List<List<String>> data = controls.raw();
		String controlName = data.get(0).get(0);
		String text = data.get(0).get(1);
		String innerText = data.get(0).get(2);

		Assert.assertTrue(_homePage.isTextFieldExists(controlName, text, innerText), "Control " + controlName
				+ " with text " + text + " and inner text " + innerText + " doesn't exist or not displayed properly");
	}

	@When("^I click Sign In button$")
	public void i_click_Sign_In_button() throws Throwable {
		_homePage.clickSignIn(true);
	}

	@Then("^I see validation message on the field$")
	public void i_see_validation_message_on_the_field(DataTable fields) throws Throwable {
		List<List<String>> data = fields.raw();
		String fieldName = data.get(0).get(0);
		String errorText = data.get(0).get(1);

		Assert.assertTrue(_homePage.isValidationMessageShown(fieldName, errorText),
				"Validation message for " + fieldName + " field is missed or its text is improper");
	}
}
