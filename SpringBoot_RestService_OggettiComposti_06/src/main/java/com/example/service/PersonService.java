package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public class PersonService {

	private final AtomicLong personCounter = new AtomicLong();
	
	//in questo caso non posso usare @autowired perché mi genererebbe un null pinter exception quando creo un oggetto tramite "new" perché "new" viene gestito dalla JVM e sfugge al controllo della Dependency Injection di Spring.
	private AddressService addressService = new AddressService();
	
	private List<Person> personList = new ArrayList<>(Arrays.asList(
			new Person(personCounter.incrementAndGet(), "Mario", "Rossi", addressService.getAddressById(2)),
			new Person(personCounter.incrementAndGet(), "Lisa", "Rossi", addressService.getAddressById(2)),
			new Person(personCounter.incrementAndGet(), "Franco", "Verdi", addressService.getAddressById(1)),
			new Person(personCounter.incrementAndGet(), "Mara", "Bianchi", addressService.getAddressById(3)),
			new Person(personCounter.incrementAndGet(), "Lucio", "Bianchi", addressService.getAddressById(3))
			));
	
//	private List<Person> personList = new ArrayList<>(Arrays.asList(
//			new Person(personCounter.incrementAndGet(), "Mario", "Rossi",	new Address(1, 22, "Via Prima")		),
//			new Person(personCounter.incrementAndGet(), "Lisa", "Rossi",	new Address(1, 22, "Via Prima")		),
//			new Person(personCounter.incrementAndGet(), "Franco", "Verdi",	new Address(1, 22, "Via Terza")		),
//			new Person(personCounter.incrementAndGet(), "Mara", "Bianchi",	new Address(1, 22, "Via Seconda")		),
//			new Person(personCounter.incrementAndGet(), "Lucio", "Bianchi",	new Address(1, 22, "Via Seconda")		)
//			));

	public List<Person> getPersonList(){
		return personList;
	}
	
	public Person getPersonById(long id) {
		return personList.stream().filter(p -> p.getPersonId() == id).findFirst().get();
	}
	
	
}
