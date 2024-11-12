Feature: Testing different request on product


  Scenario: Check if the product end point can be accessed by the users
    When I send the GET request on the product end point
    Then  I must get back the valid status code 200

  Scenario Outline: create a new product Update and delete
    When  I create a new product by providing information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    Then  I verify the product with product id
    And I update the created product by providing information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    And I delete the created product from the product list
    Examples:
      | name    | type | price     | shipping | upc | description | manufacturer | model | url | image |
      | product | star | 123456789 | 145      | xyz | xyz         | xyz          | aav1    | aa.com  | aaa.jpg   |

