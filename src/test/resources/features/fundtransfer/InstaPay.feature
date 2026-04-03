Feature: Fund Transfer - Insta Pay (Within Bank)

  Background:
    Given user is logged into retail internet banking
    And user is on dashboard

  @FundTransfer @InstaPay @Within
  Scenario: Successful insta pay transaction within bank
    When user navigates to fund transfer menu
    And user selects insta pay option
    And user selects within bank tab
    And user enters valid beneficiary and amount details
    And user submits insta pay transaction
    And user enters valid otp fetched from api
    Then transaction should be completed successfully

  @FundTransfer @InstaPay @Negative
  Scenario: Insta pay failure due to insufficient balance
    When user navigates to fund transfer menu
    And user selects insta pay option
    And user selects within bank tab
    And user enters amount more than available balance
    And user submits insta pay transaction
    Then insufficient balance message should be displayed

  @FundTransfer @InstaPay @Negative
  Scenario: Insta pay failure due to CBS issue after OTP
    When user navigates to fund transfer menu
    And user selects insta pay option
    And user selects within bank tab
    And user enters valid beneficiary and amount details
    And user submits insta pay transaction
    And user enters valid otp fetched from api
    Then transaction failure message should be displayed
