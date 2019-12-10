Feature: Clear trash

  Background:
    Given User opens yandex disk page
    And User logins with correct credentials
    And User creates new folder "test"
    And User deletes file with name "test"

  Scenario: User wants clear trash
    Given User clicks on trash link
    And User clears trash
    Then Trash is empty