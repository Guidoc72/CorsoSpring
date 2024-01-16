package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.models.Role;
import com.example.models.User;
import com.example.repositories.RoleRepository;
import com.example.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
/**
 * Aggiunge un utente al database e ritorna una stringa contenente la l'esito del salvataggio
 * Imposta un Role di default che è Guest.
 * @param user User object
 * @return String: "Ok" se il salvataggio è stato effettuato<br>"Fail" se il salvataggio non ha avuto successo
 */
	public String addNewUser(User user) {
		userRepository.save(user); 								//salvo l'utente senza Role
		Optional<User> optionalToSetRole = userRepository.findByUsername(user.getUsername()); //recupero l'utente appena salvato
		User userToSetRole = null;
		if(optionalToSetRole.isPresent()) { 					//controllo se l'utente è stato correttamente recuperato
			userToSetRole = optionalToSetRole.get();
		} 
		Role role = roleRepository.findById(3L).get(); 			//recupero il ruolo di default che sarà "guest" e lo assegno
		userToSetRole.getRoles().add(role);
		User savedUser = userRepository.save(userToSetRole);  	//ritorna l'oggetto salvato compreso l'id
		if(savedUser != null && savedUser.getId() != null) 
			return "Ok";
		else 
			return "Fail";
	}
	
	
/**
 * Controlla se l'utente è presente nel Database e restituisce un booleano come risultato
 * @param formUser User object 
 * @return boolean
 */
	public boolean authorizedUser(User formUser) {
		Optional<User> searchResult = userRepository.findByUsername(formUser.getUsername());
		if (!searchResult.isEmpty() ) {
			User dbUser = searchResult.orElseThrow();  				//se l'oggetto non viene trovata lancia NoSuchElementException
			if ( dbUser.getPassword().equals(formUser.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else 
			return false;
	}
	
/**
 * Metodo inutilizzato creato per vedere come si crea una query personalizzata in HQL
 * @param userId Long
 * @return User object
 */
	public User getUserWithRoles(Long userId) {
		return userRepository.findByIdWithRoles(userId);
	}
	
/**
 * Recupera un utente cercandolo per Username. Lancia {@code NoSuchElementException} se non trova alcun elemento
 * @param username
 * @throws NoSuchElementException se non trova elementi
 * @return User object
 */
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow();
	}
	
/**
 * Ritorna la lista di tutti gli utenti nel Database
 * @return List<User> 
 */
	public List<User> getUsersList (){
		return (List<User>) userRepository.findAll();
	}
	
/**
 * Recupera un utente cercandolo per ID. Lancia {@code NoSuchElementException} se non trova alcun elemento
 * @param id Long
 * @throws NoSuchElementException se non trova elementi
 * @return User object
 */
	public User getUserById (Long id) {
		return userRepository.findById(id).orElseThrow();
	}
	
/**
 * Esegue l'aggiornamento di un oggetto "User". 
 * Metodo {@code void} che non ritorna nulla
 * @param user User
 */
	public void updateUser (User user) {
		userRepository.save(user);
	}
	
/**
 * Elimina l'utente di cui riceve l'ID in ingresso come parametro, senza effettuare controlli, né chiedere conferma 
 * Elimina preventivamente le relazioni nella Junction Table, in modo da svincolare l'oggetto User da eliminare.
 * Metodo {@code void} che non ritorna nulla
 * @param id Long
 */
	public void deleteUserById (Long id) {
		User userToDelete = userRepository.findById(id).orElseThrow();
		userToDelete.getRoles().clear(); //serve per eliminare le relazioni tra lo User e i suoi Roles
		userRepository.delete(userToDelete);
	}
	
}
