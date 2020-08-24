Feature: Verification the count of items

  Background:
    Given I navigate to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx"
    When I try try to login using Username as "Tester" and Password as "test"
    Then I am logged in

  Scenario: Successfully creation an order
    When I entered to a "Order" screen
    And I create order with arbitary fields:
      | Quantity     | 1             |
      | CustomerName | Bruce Lee     |
      | Street       | 110 Main str. |
      | City         | PH            |
      | State        | LA            |
      | Zip          | 19116         |
      | CardNumber   | 100000004     |
      | ExpireDate   | 06/08         |
    Then Order is successfully added
    When I entered to a "View all orders" screen
    And Verify the data of the "Bruce Lee"
    Then Data should be as following:
      | MyMoney       |
      | 110 Main str. |
      | PH            |
      | LA            |
      | 19116         |
      | Visa          |
      | 100000004     |
      | 06/08         |
    And I entered to a "View all orders" screen
    Then Verify items are displayed
      | Expected |
      | 9        |
    # Because items are 8 by default, U can see first.feature* file
    And Verify the data of the "Bruce Lee"
    Then Create an orders with different product Type in the dropdown




