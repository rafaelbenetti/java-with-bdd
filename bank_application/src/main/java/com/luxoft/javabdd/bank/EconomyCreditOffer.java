package com.luxoft.javabdd.bank;

public class EconomyCreditOffer extends AbstractFactory {

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
