package com.luxoft.javabdd.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditOfferUnitTests {

    @Nested
    @DisplayName("Given there is a business credit offer")
    class BusinessCreditOfferTest {
        AbstractFactory businessCreditOffer = AbstractFactory.getFactory(CreditOfferType.BUSINESS);

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            Customer customerVIP = new Customer("John", true);

            @Test
            @DisplayName("Then you can add him but cannot remove him from an business credit offer")
            void should_Add_But_Not_Remove() {
                assertAll("Business credit offer -> VIP customer CAN be added but CANNOT be removed",
                        () -> assertTrue(businessCreditOffer.addCustomer(customerVIP)),
                        () -> assertFalse(businessCreditOffer.removeCustomer(customerVIP))
                );
            }
        }

        @Nested
        @DisplayName("When we have an usual customer")
        class UsualCustomer {
            Customer customer = new Customer("John", false);

            @Test
            @DisplayName("Then you can add and remove him from a business credit offer")
            void should_Add_And_Remove() {
                assertAll("Business credit offer -> Usual customer CANNOT be add/removed",
                        () -> assertFalse(businessCreditOffer.addCustomer(customer)),
                        () -> assertFalse(businessCreditOffer.removeCustomer(customer))
                );
            }
        }
    }

    @Nested
    @DisplayName("Given there is an economy credit offer")
    class EconomyCreditOfferTest  {
        AbstractFactory economyCreditOffer = AbstractFactory.getFactory(CreditOfferType.ECONOMY);

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            Customer customerVIP = new Customer("John", true);

            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy credit offer")
            void should_Add_But_Not_Remove() {
                assertAll("Economy credit offer -> VIP customer CAN be added but CANNOT be removed",
                        () -> assertTrue(economyCreditOffer.addCustomer(customerVIP)),
                        () -> assertFalse(economyCreditOffer.removeCustomer(customerVIP))
                );
            }
        }

        @Nested
        @DisplayName("When we have an usual customer")
        class UsualCustomer {
            Customer customer = new Customer("John", false);

            @Test
            @DisplayName("Then you can add and remove him from an economy credit offer")
            void should_Add_And_Remove() {
                assertAll("Economy credit offer -> Usual customer CAN be added/removed",
                        () -> assertTrue(economyCreditOffer.addCustomer(customer)),
                        () -> assertTrue(economyCreditOffer.removeCustomer(customer))
                );
            }
        }
    }

    @Nested
    @DisplayName("Given there is a premium credit offer")
    class PremiumCreditOfferTest  {
        AbstractFactory premiumCreditOffer = AbstractFactory.getFactory(CreditOfferType.PREMIUM);

        @Nested
        @DisplayName("When we have a VIP customer")
        class VipCustomer {
            Customer customerVIP = new Customer("John", true);

            @Test
            @DisplayName("Then you can add or remove him from a premium credit offer")
            void should_Add_But_Not_Remove() {
                assertAll("Premium credit offer -> VIP customer CAN be added/removed",
                        () -> assertTrue(premiumCreditOffer.addCustomer(customerVIP)),
                        () -> assertTrue(premiumCreditOffer.removeCustomer(customerVIP))
                );
            }
        }

        @Nested
        @DisplayName("When we have an usual customer")
        class UsualCustomer {
            Customer customer = new Customer("John", false);

            @Test
            @DisplayName("Then you cannot add but you can remove him from a premium credit offer")
            void should_Add_And_Remove() {
                assertAll("Premium credit offer -> Usual customer CANNOT be added but CAN be removed",
                        () -> assertFalse(premiumCreditOffer.addCustomer(customer)),
                        () -> assertTrue(premiumCreditOffer.removeCustomer(customer))
                );
            }
        }
    }
}