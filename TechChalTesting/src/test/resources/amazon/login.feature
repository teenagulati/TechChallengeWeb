Feature: Logging into your Amazon Account

  Scenario Outline: Log in to your Amazon Account with valid Credentials


    Given User lauches the URL
    When User enters username as "<username>"
    When User enters Password as "<password>"
    Then  User is navigated to Amazon portal home page


    Examples:
      | username                | password |
      | chhabra.teena@gmail.com | 123456   |

