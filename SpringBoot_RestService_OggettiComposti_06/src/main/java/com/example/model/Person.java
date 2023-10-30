package com.example.model;

import org.springframework.stereotype.Component;

public class Person {

	private long personId;
	private String firstName;
	private String lastName;
	private Address address;
	
	public Person(long personId, String firstName, String lastName, Address address) {
		this.setPersonId(personId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	
	
	
}
