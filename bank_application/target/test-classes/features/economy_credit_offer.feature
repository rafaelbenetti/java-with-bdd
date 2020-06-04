Feature: Offer a Economy Credit Offer to the customers

  Scenario: Add/Remove VIP customers from an economy offer
    Given there is an economy credit offer
    When we have a VIP customer for an economy credit offer
    Then you can add him but cannot remove a VIP customer from an economy offer

  Scenario: Add/Remove usual customers from an economy offer
    Given there is an economy credit offer
    When we have an usual customer for an economy credit offer
    Then you can add/remove an usual customer from an economy offer

  Scenario: Add same customer for an economy offer
    Given there is an economy credit offer
    When we have an usual customer for an economy credit offer
    Then you expect to not have duplicated customers for an economy credit offer