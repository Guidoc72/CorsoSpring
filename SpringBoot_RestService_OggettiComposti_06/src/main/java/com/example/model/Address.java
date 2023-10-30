package com.example.model;

import org.springframework.stereotype.Component;

public class Address {

	private long addressId;
	private int houseNumber;
	private String street;

	public Address(long addressId, int houseNumber, String street) {
		this.setAddressId(addressId);
		this.setHouseNumber(houseNumber);
		this.setStreet(street);
	}
	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	
	
}
