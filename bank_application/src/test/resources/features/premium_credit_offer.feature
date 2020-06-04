Feature: Offer a Premium Credit Offer to the customers

  Scenario: Add/Remove VIP customers from a premium offer
    Given there is a premium credit offer
    When we have a VIP customer for a premium credit offer
    Then then you can add/remove a VIP customer from a premium credit offer

  Scenario: Add/Remove usual customers from a premium offer
    Given there is a premium credit offer
    When we have an usual customer for a premium credit offer
    Then then you cannot add but can remove him from a premium credit offer