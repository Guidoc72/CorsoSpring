//Per ottenere una stampa degli oggetti a console dobbiamo aggiungere il ToString() nelle classi Model.

package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//indicherà alla classe di non considerare i vaori recuperati, che non trovano corrispondenza nella classe stessa
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

//@JsonProperty insieme a @JsonCreator, ci permettono di specificare il nome corretto del campo che stiamo leggendo, nel caso sia diverso da quello riportato nella classe Model del Client
	//@JsonCreator marca il costruttore
	//@JsonProperty("nomeCorretto") precede il parametro in ingresso nel costruttore
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


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNumber=" + houseNumber + ", street=" + street + "]";
	}
	
	
	
}
