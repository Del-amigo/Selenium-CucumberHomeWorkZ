Feature: Verification the data

  Background:
    Given I navigate to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx"
    When I try try to login using Username as "Tester" and Password as "test"
    Then I am logged in

  Scenario: Verification data of specific person
    When I entered to a "View all orders" screen
    And Verify the data of the "Bob Feather"
    Then Data should be as following:
      | FamilyAlbum   |
      | 14, North av. |
      | Milltown, WI  |
      | US            |
      | 81734         |
      | VISA          |
      | 111222111222  |
      | 06/08         |