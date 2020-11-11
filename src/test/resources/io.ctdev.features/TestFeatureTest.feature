Feature: Adding to basket

  Scenario: User is able add product to basket
    Given user search a category with product
    When user looking for "генератор"
    And user adds product to basket
    Then product should be "Генератор бензиновый RZTK G 3500E " in the basket