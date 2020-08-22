Feature: Verification the count of items

  Background:
    Given I navigate to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx"
    When I try try to login using Username as "Tester" and Password as "test"
    Then I am logged in

    Scenario: Successfully creation an order
      When I entered to a "Order" screen