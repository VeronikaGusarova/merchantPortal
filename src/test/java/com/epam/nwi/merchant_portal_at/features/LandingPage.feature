Feature: LandingPage
  I want to check that all required controls are displayed and Create New Account page can be opened from Log In panel

  Background: 
    Given I open MerchantPortal Home Page

  #Test Case https://jira.network.ae/jira/browse/AEMO-714
  Scenario: Check controls existance
    Then I see control with text
      | welcomeLabel | Welcome to Network International |
    And I see control with text
      | joinLabel | Who can join? |
    And I see control with text
      | startPaymentButton | Start taking payments |
    And I see control with text
      | signIn | Sign In |

  Scenario: Open Create New Account Page
    When I click StartTakingPayments button
    Then I see StartTakingPayments page

  #Test Case https://jira.network.ae/jira/browse/AEMO-715
  Scenario: Open Sign in modal window
    When I click Sign in link
    Then I see Sign In modal dialog
    And I see text field with label and inner text
      | Email | Email | Email |
    And I see text field with label and inner text
      | Password | Password | Password |
    And I see control with text
      | ForgottenPasswordLink | Forgotten password? |
    And I see control with text
      | SignInModalDialog | Sign In |

  Scenario: Sign in with empty inputs in Sign In modal window
    Given I click Sign in link
    And I see Sign In modal dialog
    When I click Sign In button
    Then I see validation message on the field
      | Email    | Please enter the email    |
      | Password | Please enter the password |
