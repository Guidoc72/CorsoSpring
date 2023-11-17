package com.example.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.models.Contact;
import com.example.repositories.ContactJdbcTemplateRepository;
import java.util.List;

/*
E' possibile usare la classe service, ad esempio, per implementare la validazione dei dati
E' possibile implementare anche l'approccio @Transactional, ma questo obbligherebbe a configurare PlatformTransactionManager 
e complicherebbe abbastanza le cose.
*/

@Service
public class ContactService {

	private static final Log logger = LogFactory.getLog(ContactService.class);
	private ContactJdbcTemplateRepository repository;
	private Validator validator;

    public ContactService(ContactJdbcTemplateRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public void addContact(Contact contact) {
    	//BeanPropertyBindingResult rappresenta gli errori di validazione per il contatto.
    	//Gli eventuali errori di validazione vengono registrati nell’oggetto errors
    	Errors errors = new BeanPropertyBindingResult(contact, "contact"); 
        validator.validate(contact, errors);
        logger.info("--> checikng Errors...");
        if (errors.hasErrors()) {
            throw new IllegalArgumentException("Invalid contact data");
        }
        logger.info("--> call Repository addContact...");
    	repository.addContact(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.getAllContacts();
    }

    public Contact getContactById(int id) {
        return repository.getContactById(id);
    }

    public void deleteContactById(int id) {
        repository.deleteContactById(id);
    }

    public void updateContact(Contact contact) {
        Errors errors = new BeanPropertyBindingResult(contact, "contact");
        validator.validate(contact, errors);
        if (errors.hasErrors()) {
            throw new IllegalArgumentException("Invalid contact data");
        }
        repository.updateContact(contact);
    }
}



