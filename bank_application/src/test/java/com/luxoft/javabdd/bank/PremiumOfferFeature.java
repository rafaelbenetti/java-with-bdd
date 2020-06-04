package com.luxoft.javabdd.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class PremiumOfferFeature {
    private AbstractFactory creditOffer;
    private Customer customer;

    @Given("^there is a premium credit offer$")
    public void there_is_a_premium_credit_offer() throws Throwable {
        creditOffer = AbstractFactory.getFactory(CreditOfferType.PREMIUM);
    }

    @When("^we have a VIP customer for a premium credit offer$")
    public void we_have_a_VIP_customer() throws Throwable {
        customer = new Customer("Rafael", true);
    }

    @Then("^then you can add/remove a VIP customer from a premium credit offer$")
    public void validate_VIP_customer_for_premium_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and a premium credit offer",
                () -> assertTrue(creditOffer.addCustomer(customer)),
                () -> assertTrue(creditOffer.removeCustomer(customer))
        );
    }

    @When("^we have an usual customer for a premium credit offer$")
    public void we_have_an_usual_customer() throws Throwable {
        customer = new Customer("Rafael", false);
    }

    @Then("^then you cannot add but can remove him from a premium credit offer$")
    public void validate_usual_customer_for_premium_credit_offer() throws Throwable {
        assertAll("Verify all conditions for an usual customer and a premium credit offer",
                () -> assertFalse(creditOffer.addCustomer(customer)),
                () -> assertTrue(creditOffer.removeCustomer(customer))
        );
    }
}
