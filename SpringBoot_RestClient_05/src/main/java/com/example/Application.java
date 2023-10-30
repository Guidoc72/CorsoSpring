//CLIENT on PORT 8081
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Person;
import com.example.utility.PersonClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		//Get List
		PersonClient pc = new PersonClient();
	 	System.out.println("GET LIST");
		System.out.println(pc.getPersonList());
	 	
	 	//Get One by Id
		System.out.println("GET ONE BY ID");
	 	System.out.println(pc.getPersonById(2));
		
		//Add new
	 	Person newPerson = new Person(5, "Francesco", "Bianchi");
	 	pc.addPerson(newPerson);
		//controlliamo...
	 	System.out.println("AFTER ADDING NEW");
	 	System.out.println(pc.getPersonList()); 
		
		//Update 
	 	Person personToUpdate = new Person(2, "X", "Y");
	 	pc.updatePerson(personToUpdate);
		//controlliamo...
	 	System.out.println("AFTER UPDATE");
	 	System.out.println(pc.getPersonList()); 
	 	
	 	//Delete
	 	pc.deletePersonById(2);
		//controlliamo...
	 	System.out.println("AFTER DELETE");
	 	System.out.println(pc.getPersonList()); 
		pc.getPersonList();
	}
}
