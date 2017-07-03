package com.epam.nwi.merchant_portal_at.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.epam.nwi.merchant_portal_at.base.BaseUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class CommonForForms extends BaseUtil {

	private BaseUtil _base;

	public CommonForForms(BaseUtil base) {
		this._base = base;
	}

	@Then("^I see text field with label and inner text$")
	public void i_see_text_field_with_inner_text(DataTable controls) throws Throwable {
		for (Map<String, String> data : controls.asMaps(String.class, String.class)) {
			Assert.assertTrue(
					_homePage.isTextFieldExists(data.get("FieldName"), data.get("Label"), data.get("InnerText")),
					"Control " + data.get("FieldName") + " with text " + data.get("Label") + " and inner text "
							+ data.get("InnerText") + " doesn't exist or not displayed properly");
		}
	}

	@Then("^I see control with text$")
	public void i_see_with(DataTable controls) throws Exception {
		for (Map<String, String> data : controls.asMaps(String.class, String.class)) {
			Assert.assertTrue(_homePage.isControlExists(data.get("ControlName"), data.get("Text")),
					"Control " + data.get("ControlName") + " with text " + data.get("Text") + " doesn't exist");
		}
	}

	@Then("^Following mandatory fields marked \\*$")
	public void following_mandatory_fields_marked(DataTable fields) throws Throwable {
		for (Map<String, String> data : fields.asMaps(String.class, String.class)) {
			Assert.assertTrue(_createAccountPage.isFieldMandatory(data.get("FieldName")),
					"The required field " + data.get("FieldName") + " doesn't marked as mandatory");
		}
	}
}
