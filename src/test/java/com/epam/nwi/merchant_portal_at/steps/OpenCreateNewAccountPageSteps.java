package com.epam.nwi.merchant_portal_at.steps;


import org.testng.Assert;
import com.epam.nwi.merchant_portal_at.base.BaseUtil;
import com.epam.nwi.merchant_portal_at.configuration.driver_factory.Driver;
import com.epam.nwi.merchant_portal_at.pages.CreateAccountPage;
import com.epam.nwi.merchant_portal_at.pages.MerchantPortalHomePage;

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
	public void i_have_opened_MerchantPortal_Home_Page() throws Throwable {
		_homePage = new MerchantPortalHomePage().open();
	}

	@When("^I click StartTakingPayments button$")
	public void i_click_StartTakingPayments_button() throws Throwable {
		_createAccountPage = _homePage.clickCreateAccount();
	}

	@Then("^I see StartTakingPayments page$")
	public void i_see_StartTakingPayments_page() throws Throwable {
		String url = Driver.getWebDriver().getCurrentUrl();
		Assert.assertTrue(url.endsWith("/create-account"), "page url is wrong: " + url);
	}

}
