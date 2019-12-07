Feature: Login in Yandex disk with uncorrected credentials

  Scenario Outline: Login yandex disk with uncorrected login name
    Given User opens yandex disk page
    When User types <login> in filed for login name
    And User clicks button login
    Then User sees error message with text <message>

    Examples:
      | login  | message                   |
      | ""     | "Логин не указан"         |
      | "den." | "Такой логин не подойдет" |