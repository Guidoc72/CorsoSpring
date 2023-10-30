package com.example.utility;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.model.Person;

public class PersonClient {

	//Devo impostare l'URL del server e se sono sulla stessa macchina, 
	//modificare la porta di questa App in application.properties
	private static final String SERVER_URL = "http://localhost:8080/person/";
	
	private RestTemplate restTemplate; //Può essere sostituito da WebClient
	
	public PersonClient() {
		this.restTemplate = new RestTemplate();
	}
	
	//GetList
	public List<Person> getPersonList(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
		String getListUrl = SERVER_URL + "list";
		
		ResponseEntity<Person[]> response = restTemplate.exchange(
				getListUrl,
				HttpMethod.GET,
				entity,
				Person[].class); //Riceve un array di oggetti della classe Person
		
		return Arrays.asList(response.getBody());
	}
		
	//Get ONE by Id
	public Person getPersonById(int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Person> response = restTemplate.exchange(
        		SERVER_URL + id,
                HttpMethod.GET,
                entity,
                Person.class); //Riceve un oggetto della classe Person

        return response.getBody();
    }

	//Add new Element to List - Per non complicare troppo il metodo, che dovrebbe ricevere e gestire la risposta del server, il metodo add() sul server è stato modificato in void.
    public void addPerson(Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Person> entity = new HttpEntity<>(person, headers);
        //qui per completezza, bisognerebbe cercare il primo ID disponibile nella lista esistente
        String add = SERVER_URL+"add";
        restTemplate.postForObject(
        		add, 
        		entity, 
        		Person.class);
    }

    //Update one Object
    public void updatePerson(Person person) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Person> entity = new HttpEntity<>(person, headers);

        restTemplate.put(SERVER_URL + person.getId(), entity);
    }

    //Delete One by Id
    public void deletePersonById(int id) {
        restTemplate.delete(SERVER_URL + id);
    }
	


	
	

	
}
