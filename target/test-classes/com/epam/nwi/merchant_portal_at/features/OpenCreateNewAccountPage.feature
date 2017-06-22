@closeDriver
Feature: OpenCreateNewAccountPage
  I want to check that Create New Account page can be opened from Log In panel

  Scenario: Open Create New Account Page
    Given I open MerchantPortal Home Page
    When I click StartTakingPayments button
    Then I see StartTakingPayments page
