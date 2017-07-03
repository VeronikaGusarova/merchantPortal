package com.epam.nwi.merchant_portal_at.steps;

import java.util.List;
import java.util.Map;

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

	@When("^I click Sign in link$")
	public void i_click_Sign_in_link() throws Throwable {
		_homePage.clickSignIn(false);
	}

	@Then("^I see Sign In modal dialog$")
	public void i_see_Sign_In_modal_dialog() throws Throwable {
		Assert.assertTrue(_homePage.isSignInModalWinOpenedAndCorrect(), "Sign In modal window was not opened properly");
	}

	@When("^I click Sign In button$")
	public void i_click_Sign_In_button() throws Throwable {
		_homePage.clickSignIn(true);
	}

	@Then("^I see validation message on the field$")
	public void i_see_validation_message_on_the_field(DataTable fields) throws Throwable {
		for (Map<String, String> data : fields.asMaps(String.class, String.class)) {
			Assert.assertTrue(_homePage.isValidationMessageShown(data.get("FieldName"), data.get("Message")),
					"Validation message for " + data.get("FieldName") + " field is missed or its text is improper");
		}
	}
}
