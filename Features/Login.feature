Feature: Login page

Background: List of steps run before each of the scenarios
    Given User Lunch Chrome Browser
    When User Open URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
@sanity

  Scenario: Successful Login with Valid Credentials
    And Click on login  
    When User click on log out link
    And Close Browser
    
