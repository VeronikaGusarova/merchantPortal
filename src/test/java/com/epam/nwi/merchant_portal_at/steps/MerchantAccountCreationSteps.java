package com.epam.nwi.merchant_portal_at.steps;

import java.util.Map;

import org.testng.Assert;

import com.epam.nwi.merchant_portal_at.base.BaseUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class MerchantAccountCreationSteps extends BaseUtil {
	private BaseUtil _base;

	public MerchantAccountCreationSteps(BaseUtil base) {
		this._base = base;
	}

	@Then("^prefix for mobile phone is \"([^\"]*)\"$")
	public void prefix_for_mobile_phone_is(String prefix) throws Throwable {
		String actualPrefix = _createAccountPage.getPhoneNumberPrefixEquals();
		Assert.assertEquals(actualPrefix, prefix,
				"Prefix for phone is " + actualPrefix + ". It doesn//'t match expected: " + prefix);
	}


}
