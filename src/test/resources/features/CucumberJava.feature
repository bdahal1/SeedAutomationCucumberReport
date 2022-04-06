Feature: CucumberJava

  Background:
    Given user opens the app

  @test
  Scenario: Verify that user is correct
    And user checks true app

  @test
  Scenario: Verify that user is incorrect
    And user checks false app

  @test
  Scenario: Verify that user is always incorrect
    And user checks false app

  @test
  Scenario: Verify that user is always correct
    And user checks true app
