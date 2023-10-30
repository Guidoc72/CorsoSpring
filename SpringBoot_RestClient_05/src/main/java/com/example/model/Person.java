//Per ottenere una stampa degli oggetti a console dobbiamo aggiungere il ToString() nelle classi Model.
package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//indicherà alla classe di non considerare i valori recuperati, che non trovano corrispondenza nella classe stessa
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	private int id;
	private String firstName;
	private String lastName;
	
	public Person() {}

/*	
	@JsonProperty insieme a @JsonCreator, ci permettono di specificare il nome corretto del campo che stiamo leggendo, nel caso sia diverso da quello riportato nella classe Model del Client
	@JsonCreator marca il costruttore
	@JsonProperty("nomeCorretto") precede il parametro in ingresso nel costruttore	private int id;
	
	ESEMPIO:	
	@JsonCreator
    public Person(@JsonProperty("id") Long id,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
*/	
	public Person(int id, String firstName, String lastName) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
