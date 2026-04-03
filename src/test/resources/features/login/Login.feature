Feature: PSB Login with Two Factor Authentication

  @Login @Positive
  Scenario: Successful login with valid OTP
    Given user opens PSB application
    When user enters valid username and password
    And user enters captcha manually
    And user clicks login
    Then otp page should be displayed
    When user fetches otp from api
    And user clicks submit otp
    Then dashboard should be displayed


  @Login @Negative
  Scenario: Login fails with invalid OTP
    Given user opens PSB application
    When user enters valid username and password
    And user enters captcha manually
    And user clicks login
    Then otp page should be displayed
    When user enters invalid otp
    And user clicks submit otp
    Then invalid otp error message should be displayed


  @Login @Negative
  Scenario: OTP expired and resend option should be enabled
    Given user opens PSB application
    When user enters valid username and password
    And user enters captcha manually
    And user clicks login
    Then otp page should be displayed
    When otp expires
    Then resend otp button should be enabled
