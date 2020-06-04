package com.luxoft.javabdd.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessCreditOfferFeature {
    private AbstractFactory creditOffer;
    private Customer customer;

    @Given("^there is a business credit offer$")
    public void there_is_a_business_credit_offer() throws Throwable {
        creditOffer = AbstractFactory.getFactory(CreditOfferType.BUSINESS);
    }

    @When("^we have a VIP customer for a business credit offer$")
    public void we_have_a_VIP_customer() throws Throwable {
        customer = new Customer("Rafael", true);
    }

    @Then("^you can add him but cannot remove a VIP customer from a business offer$")
    public void validate_VIP_customer_for_business_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and a business credit offer",
                () -> assertTrue(creditOffer.addCustomer(customer)),
                () -> assertFalse(creditOffer.removeCustomer(customer))
        );
    }

    @When("^we have an usual customer for a business credit offer$")
    public void we_have_an_usual_customer() throws Throwable {
        customer = new Customer("Rafael", false);
    }

    @Then("^you cannot add/remove an usual customer from a business credit offer$")
    public void validate_usual_customer_for_business_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and a business credit offer",
                () -> assertFalse(creditOffer.addCustomer(customer)),
                () -> assertFalse(creditOffer.removeCustomer(customer))
        );
    }

    @Then("^you expect to not have duplicated customers for a business credit offer$")
    public void check_for_duplicated_customer() throws Throwable {
        assertAll("Verify that we cannot add duplicated customers to a business credit offer",
                () -> assertTrue(creditOffer.addCustomer(customer)),
                () -> assertFalse(creditOffer.addCustomer(customer))
        );
    }
}
