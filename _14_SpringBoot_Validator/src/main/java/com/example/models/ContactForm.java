package com.example.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ContactForm {

/*In questo caso, abbiamo utilizzato le annotazioni “base” presenti nel package jakarta.validation.constraints 
 * ma è possibile implementare annotazioni custom per definire regole e logiche di validazione più complesse	*/ 
	@NotEmpty
	@Size(max=50)
	private String firstName;
	
	@NotEmpty //utilizzata per validare che una collezione, una mappa o una stringa non sia nulla e non sia vuota.
	@NotBlank //utilizzata per validare che una stringa non sia nulla e non contenga solo spazi vuoti.
	@Size(max=100)
	private String lastName;
	
	@NotEmpty
	@Size(max=20)
	private String phone;
	
	@Email
	@Size(max=100)
	private String email;

	
	public ContactForm() {}
	
	public ContactForm(@NotEmpty @Size(max = 50) String firstName, @NotEmpty @Size(max = 100) String lastName, @NotEmpty @Size(max = 20) String phone, @Email @Size(max = 100) String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	//più getters e setters
	
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
}
