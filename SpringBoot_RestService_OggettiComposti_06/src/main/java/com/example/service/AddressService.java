package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.model.Address;

@Service
public class AddressService {
	
	private final AtomicLong counter = new AtomicLong();
	//crea un oggetto che può essere usato da contatore tramite il metodo .incrementAndGet()

	
	private List<Address> addressList = new ArrayList<>(Arrays.asList(
			new Address (1,25, "Vicolo Corto"),
			new Address (2,12, "Viale Marco Polo"),
			new Address (3,33, "Bastioni Gran Sasso"),
			new Address (4, 1, "Test")
			));
	
	public List<Address> getAddressList(){
		return addressList;
	}
	
	public Address getAddressById(long id) {
		//return new Address(5, 22, "Via Perugia");
		return addressList.stream().filter(a -> a.getAddressId() == id).findFirst().get();
	}
	
}
