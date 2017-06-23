$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("OpenCreateNewAccountPage.feature");
formatter.feature({
  "line": 2,
  "name": "OpenCreateNewAccountPage",
  "description": "I want to check that Create New Account page can be opened from Log In panel",
  "id": "opencreatenewaccountpage",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@closeDriver"
    }
  ]
});
formatter.before({
  "duration": 2599993469,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Open Create New Account Page",
  "description": "",
  "id": "opencreatenewaccountpage;open-create-new-account-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I open MerchantPortal Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I click StartTakingPayments button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I see StartTakingPayments page",
  "keyword": "Then "
});
formatter.match({
  "location": "OpenCreateNewAccountPageSteps.i_have_opened_MerchantPortal_Home_Page()"
});
formatter.result({
  "duration": 837036565,
  "status": "passed"
});
formatter.match({
  "location": "OpenCreateNewAccountPageSteps.i_click_StartTakingPayments_button()"
});
formatter.result({
  "duration": 1488016384,
  "status": "passed"
});
formatter.match({
  "location": "OpenCreateNewAccountPageSteps.i_see_StartTakingPayments_page()"
});
formatter.result({
  "duration": 250482523,
  "status": "passed"
});
formatter.after({
  "duration": 70682250,
  "status": "passed"
});
});