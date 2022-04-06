Feature: CucumberJavaAppium

  Background:
    Given user opens the app

  @test
  Scenario: Verify that user is sometime correct
    And user checks true app

  @test
  Scenario: Verify that user is sometime incorrect
    And user checks false app

  @test
  Scenario: Verify that user is sometime always incorrect
    And user checks false app

  @test
  Scenario: Verify that user is sometime always correct
    And user checks true app
