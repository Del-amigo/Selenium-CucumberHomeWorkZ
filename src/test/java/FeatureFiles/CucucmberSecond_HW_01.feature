Feature: Verification the count of items

  Background:
    Given I navigate to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx"
    When I try try to login using Username as "Tester" and Password as "test"
    Then I am logged in

  Scenario: Verification the count of items are deleted successfully
    When I entered to a "View all orders" screen
    And Verify items are displayed
      | Expected |
      | 8        |
    And I delete all items from the table
    Then Verify items are displayed
      | Expected | Actual |
      | 0        | 0      |
