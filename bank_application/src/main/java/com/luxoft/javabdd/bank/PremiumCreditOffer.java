package com.luxoft.javabdd.bank;

public class PremiumCreditOffer extends AbstractFactory {

	@Override
	public boolean addCustomer(Customer customer) {
		if (customer.isVip()) {
			return customersList.add(customer);
		}
		return false;
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		return true;
	}
}
