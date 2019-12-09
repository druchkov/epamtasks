Feature: Login in Yandex disk with correct credentials

  Scenario: Login yandex disk with correct login name
    Given User opens yandex disk page
    When User logins with parameters:
      | loginName         | password |
      | qaAutomationGomel | gomelQa  |
    Then User riches yandex disk