//Per ottenere una stampa degli oggetti a console dobbiamo aggiungere il ToString() nelle classi Model.

package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//indicherà alla classe di non considerare i vaori recuperati, che non trovano corrispondenza nella classe stessa
@JsonIgnoreProperties(ignoreUnknown = true)
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

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + "]";
	}
	
	
	
	
}
