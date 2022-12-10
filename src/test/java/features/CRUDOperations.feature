Feature: To perform all CURD opertion

  Scenario: To Perform the GET Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario: To Perform the POST Operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I pass the name "kamal" and salary "700"
    And I Perform  the Post Operation
    Then Response code should be 201
