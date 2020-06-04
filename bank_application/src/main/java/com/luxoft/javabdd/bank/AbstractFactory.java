package com.luxoft.javabdd.bank;

import java.util.HashSet;

public abstract class AbstractFactory {
    private static final BusinessCreditOffer BUSINESS_CREDIT_OFFER = new BusinessCreditOffer();
    private static final EconomyCreditOffer ECONOMY_CREDIT_OFFER = new EconomyCreditOffer();
    private static final PremiumCreditOffer PREMIUM_CREDIT_OFFER = new PremiumCreditOffer();

    public static AbstractFactory getFactory(CreditOfferType creditOfferType) {
        AbstractFactory factory = null;
        switch (creditOfferType) {
            case ECONOMY:
                factory = ECONOMY_CREDIT_OFFER;
                break;
            case BUSINESS:
                factory = BUSINESS_CREDIT_OFFER;
                break;
            case PREMIUM:
                factory = PREMIUM_CREDIT_OFFER;
                break;
        }
        return factory;
    }

    public HashSet<Customer> customersList = new HashSet<Customer>();

    public HashSet<Customer> getCustomersList() { return customersList; }

    public abstract boolean addCustomer(Customer customer);

    public abstract boolean removeCustomer(Customer customer);
}
