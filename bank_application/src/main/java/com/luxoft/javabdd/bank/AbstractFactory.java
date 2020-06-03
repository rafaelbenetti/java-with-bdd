package com.luxoft.javabdd.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BusinessCreditOffer extends AbstractFactory {
	private List<Customer> customersList = new ArrayList<Customer>();

	@Override
	public List<Customer> getCustomersList() {
		return Collections.unmodifiableList(customersList);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		if (customer.isVip()) {
			return customersList.add(customer);
		}
		return false;
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		if (!customer.isVip()) {
			return customersList.remove(customer);
		}
		return false;
	}
}

class EconomyCreditOffer extends AbstractFactory {
	private List<Customer> customersList = new ArrayList<Customer>();

	@Override
	public List<Customer> getCustomersList() {
		return Collections.unmodifiableList(customersList);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		return customersList.add(customer);
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		if (!customer.isVip()) {
			return customersList.remove(customer);
		}
		return false;
	}
}

class PremiumCreditOffer extends AbstractFactory {
	private List<Customer> customersList = new ArrayList<Customer>();

	@Override
	public List<Customer> getCustomersList() {
		return Collections.unmodifiableList(customersList);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		if (customer.isVip()) {
			return customersList.add(customer);
		}
		return false;
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		return customersList.remove(customer);
	}
}

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

	public abstract List<Customer> getCustomersList();

	public abstract boolean addCustomer(Customer customer);

	public abstract boolean removeCustomer(Customer customer);
}




