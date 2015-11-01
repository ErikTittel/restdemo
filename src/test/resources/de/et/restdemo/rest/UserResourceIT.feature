Feature: Save and get user

Scenario: Save and get user
  Given the user 'John'
  When he is saved
  Then his name should be retrievable from the system