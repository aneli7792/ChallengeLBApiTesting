Feature: Consult Service

  Background: Get info of service
    Given the user wants consume the service

  Scenario: Consult the list of employee
    When he consult the service
    Then his should by see the list of employees

  Scenario: Create a employee
    When he call the service and create the employee
    Then he should see that the employee has been saved

  Scenario Outline: Consult a employee specific
    When he consult the service for employee specific <employeeid>
    Then his should by see all information of employee
      | id           | employee_name | employee_salary | employee_age | profile_image |
      | <employeeid> | <name>        | <salary>        | <age>        | <image>       |
    Examples:
      | employeeid | name            | salary | age | image |
      | 1          | Tiger Nixon     | 320800 | 61  |       |
      | 2          | Garrett Winters | 170750 | 63  |       |

  Scenario Outline: Delete a employee
    When he call the service for delete employee with <employeeId>
    Then should by see the employee is delete
    Examples:
      | employeeId |
      | 2          |