package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Person;

@Service
public class PersonService {

	private List<Person> personsList = new ArrayList<>(Arrays.asList(
			new Person(1, "Mario", "Rossi"),
			new Person(2, "Luca", "Bianchi"),
			new Person(3, "Sabrina", "Verdi")));
	
	public List<Person> getPersonsList(){
		return personsList;
	}
	
	
	public Person getPersonById(Long id) {
		return personsList.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	
    public boolean createPerson(Person person)  {
    	if ( !personsList.stream().anyMatch(p->p.getId() == person.getId()) ) {
    		personsList.add(person);
    		return true;
    	} else {
    		return false;
    	}
    }


	public void deletePersonById(Long id) {
		personsList.remove(
				personsList.stream().filter(p->p.getId() == id).findFirst().get()
				);
	}


	public void updatePerson(Long id, Person updatedPerson) {
		Person person = getPersonById(id);
		int position = personsList.indexOf(person);
		person.setFirstName(updatedPerson.getFirstName());
		person.setLastName(updatedPerson.getLastName());
		personsList.set(position, person);
	} 



	
}


