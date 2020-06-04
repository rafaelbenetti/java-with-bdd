Feature: Offer a Business Credit Offer to the customers

  Scenario: Add/Remove VIP customers for a business offer
    Given there is a business credit offer
    When we have a VIP customer for a business credit offer
    Then you can add him but cannot remove a VIP customer from a business offer

  Scenario: Add/Remove usual customers for a business offer
    Given there is a business credit offer
    When we have an usual customer for a business credit offer
    Then you cannot add/remove an usual customer from a business credit offer

  Scenario: Add same customer for a business offer
    Given there is a business credit offer
    When we have a VIP customer for a business credit offer
    Then you expect to not have duplicated customers for a business credit offer