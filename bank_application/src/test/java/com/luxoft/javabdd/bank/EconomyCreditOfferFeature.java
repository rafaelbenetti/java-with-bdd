package com.luxoft.javabdd.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EconomyCreditOfferFeature {
    private AbstractFactory creditOffer;
    private Customer customer;

    @Given("^there is an economy credit offer$")
    public void there_is_an_economy_credit_offer() throws Throwable {
        creditOffer = AbstractFactory.getFactory(CreditOfferType.ECONOMY);
    }

    @When("^we have a VIP customer for an economy credit offer$")
    public void we_have_a_VIP_customer() throws Throwable {
        customer = new Customer("Rafael", true);
    }

    @Then("^you can add him but cannot remove a VIP customer from an economy offer$")
    public void validate_VIP_customer_for_economy_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and an economy credit offer",
                () -> assertTrue(creditOffer.addCustomer(customer)),
                () -> assertFalse(creditOffer.removeCustomer(customer))
        );
    }

    @When("^we have an usual customer for an economy credit offer$")
    public void we_have_an_usual_customer() throws Throwable {
        customer = new Customer("Rafael", false);
    }

    @Then("^you can add/remove an usual customer from an economy offer$")
    public void validate_usual_customer_for_economy_credit_offer() throws Throwable {
        assertAll("Verify all conditions for an usual customer and an economy credit offer",
                () -> assertTrue(creditOffer.addCustomer(customer)),
                () -> assertTrue(creditOffer.removeCustomer(customer))
        );
    }

    @Then("^you expect to not have duplicated customers for an economy credit offer$")
    public void check_for_duplicated_customer() throws Throwable {
        assertAll("Verify that we cannot add duplicated customers to an economy credit offer",
                () -> assertTrue(creditOffer.addCustomer(customer)),
                () -> assertFalse(creditOffer.addCustomer(customer))
        );
    }
}
