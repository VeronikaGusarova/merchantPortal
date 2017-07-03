#Jira story: https://jira.network.ae/jira/browse/AEMO-650
Feature: MerchantAccountCreation
  I want to check the fields in form on positive and negative data and ensure that account is created

  Background: 
    Given I open MerchantPortal Home Page
    And I click StartTakingPayments button
    And I see StartTakingPayments page

  #Test Case https://jira.network.ae/jira/browse/AEMO-684
  Scenario: Form contains specified fields
    Then I see text field with label and inner text
      | FieldName           | Label                | InnerText                 |
      | Email               | Email                | name@mycompany.com        |
      | LegalName           | Legal name           | Legal (trade) name        |
      | AuthorizedSignatory | Authorized signatory | Authorized signatory name |
      | MobilePhone         | Mobile phone number  | 0 000 0000                |
    And prefix for mobile phone is "+9715"
    And I see control with text
      | ControlName              | Text                                                   |
      | createAccountTitle       | Start taking payments.                                 |
      | createAccountDescription | We only need to know a few details to get you started. |
      | signUpButton             | Sign up                                                |
      | termsConditionsLink      | Terms & Conditions                                     |
      | privacyPolicyLink        | Privacy Policy                                         |

  #Test Case https://jira.network.ae/jira/browse/AEMO-764
  Scenario: Mandatory fields are marked *
    Then Following mandatory fields marked *
      | FieldName           |
      | Email               |
      | LegalName           |
      | AuthorizedSignatory |
      | MobilePhone         |
