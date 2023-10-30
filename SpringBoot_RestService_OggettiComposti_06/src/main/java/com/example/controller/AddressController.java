package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Address;
import com.example.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/list")
	public List<Address> getAddressList(){
		return addressService.getAddressList();
	}
	
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable long id) {
		return addressService.getAddressById(id);
	}
	
}
