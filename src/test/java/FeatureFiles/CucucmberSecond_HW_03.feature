Feature: Verification the count of items

  Background:
    Given I navigate to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx"
    When I try try to login using Username as "Tester" and Password as "test"
    Then I am logged in


  Scenario: Testing negative test-cases
    When I entered to a "Order" screen
    And I try to fill in with following data:
      | Quantity | CustomerName    | Street        | City | State | Zip | CardNumber | ExpireDate | ErrorNextTo  |
      |          | Jason Derullo   | 110 Main str. | PH   | LA    | 100 | 100000001  | 06/08      | Quantity     |
      | 1        |                 | 111 Main str. | PH   | LA    | 101 | 100000002  | 06/08      | CustomerName |
      | 2        | Jason Stathem   |               | PH   | LA    | 102 | 100000003  | 06/08      | Street       |
      | 3        | Mickel Jackson  | 112 Main str. |      | LA    | 103 | 100000004  | 06/08      | City         |
      | 4        | Entony Hopkins  | 113 Main str. | PH   |       | 104 | 100000005  | 06/08      |              |
      | 5        | Stiven Sigal    | 114 Main str. | PH   | LA    |     | 100000006  | 06/08      | Zip          |
      | 6        | Bruce Lee       | 115 Main str. | PH   | LA    | 105 |            | 06/08      | CardNumber   |
      | 7        | Makhatma Ghandi | 116 Main str. | PH   | LA    | 106 | 100000008  |            | ExpireDate   |


