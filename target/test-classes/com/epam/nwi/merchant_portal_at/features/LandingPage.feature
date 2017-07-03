#Jira story: https://jira.network.ae/jira/browse/AEMO-401
Feature: LandingPage
  I want to check that all required controls are displayed and Create New Account page can be opened from Log In panel

  Background: 
    Given I open MerchantPortal Home Page

  #Test Case https://jira.network.ae/jira/browse/AEMO-714
  Scenario: Check controls existance
    Then I see control with text
      | ControlName        | Text                             |
      | welcomeLabel       | Welcome to Network International |
      | joinLabel          | Who can join?                    |
      | startPaymentButton | Start taking payments            |
      | signIn             | Sign In                          |

  Scenario: Open Create New Account Page
    When I click StartTakingPayments button
    Then I see StartTakingPayments page

  #Test Case https://jira.network.ae/jira/browse/AEMO-715
  Scenario: Open Sign in modal window
    When I click Sign in link
    Then I see Sign In modal dialog
    And I see text field with label and inner text
      | FieldName | Label    | InnerText |
      | Login     | Email    | Email     |
      | Password  | Password | Password  |
    And I see control with text
      | ControlName           | Text                |
      | ForgottenPasswordLink | Forgotten password? |
      | SignInModalDialog     | Sign In             |

  Scenario: Sign in with empty inputs in Sign In modal window
    Given I click Sign in link
    And I see Sign In modal dialog
    When I click Sign In button
    Then I see validation message on the field
      | FieldName | Message                   |
      | Login     | Please enter the email    |
      | Password  | Please enter the password |
