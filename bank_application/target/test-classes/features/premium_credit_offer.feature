Feature: Offer a Premium Credit Offer to the customers

  Scenario: Add/Remove VIP customers from a premium offer
    Given there is a premium credit offer
    When we have a VIP customer for a premium credit offer
    Then you can add/remove a VIP customer from a premium credit offer

  Scenario: Add/Remove usual customers from a premium offer
    Given there is a premium credit offer
    When we have an usual customer for a premium credit offer
    Then you cannot add but can remove him from a premium credit offer

  Scenario: Add same customer for a premium offer
    Given there is a premium credit offer
    When we have a VIP customer for a premium credit offer
    Then you expect to not have duplicated customers for a premium credit offer