Feature: Clear trash

  Background:
    Given User opens yandex disk page
    And User login with correct credentials
    And User creates new folder "test"
    And User deletes file with name "test"

  Scenario: User want clear trash
    Given User click on trash link
    And User clears trash
    Then Trash is empty