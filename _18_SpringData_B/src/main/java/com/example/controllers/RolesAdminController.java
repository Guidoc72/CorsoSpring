package com.example.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.models.User;
import com.example.services.RoleService;
import com.example.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RolesAdminController {

	private UserService userService;
	private RoleService roleService;
	
	public RolesAdminController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
/**
 * Se un utente è amministratore permette di accedere alla pagina Roles_admin altrimenti manda alla pagina1	
 * @param session
 * @param model
 * @return String page
 */
	@GetMapping("/roles_admin")
	public String getRolesAministration(HttpSession session, Model model) {
		if((boolean) session.getAttribute("userIsAdmin")) {
			List<User> usersList = userService.getUsersList();
			model.addAttribute("usersList", usersList);
			model.addAttribute("allRoles", roleService.getAllRoles());
			return "roles_admin";
		} else {
			return "internal_page1";
		
		}
		
	}
	
	
/**
 * Invia alla pagina di modifica "user" tramite lo userID. Se la richiesta arriva da un amministratore accetta l'aggiornamento, altrimenti rimanda alla pagina1
 * @param id
 * @param session
 * @param model
 * @return String page
 */
	@GetMapping("/edit/{id}")
	public String editUser (@PathVariable(name = "id") Long id, HttpSession session, Model model){ 
		System.out.println("===================================== @GetMapping( /EDIT ) ==================================");
		if((boolean) session.getAttribute("userIsAdmin")) {
			User dbUserToEdit =  userService.getUserById(id);
			model.addAttribute("dbUserToEdit", dbUserToEdit);
//			List<User> usersList = userService.getUsersList();				//lista completa con i Roles
			model.addAttribute("allRoles", roleService.getAllRoles());
			return "edit_user";
		} else {
			return "internal_page1";
		}
	}

	
/**
 * Esegue l'aggionramento dello "user", ricevendo i dati dal form di modifica	
 * @param userToUpdate
 * @return String rimanda alla pagina di amministrazione utenti
 */
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("dbUserToEdit") User userToUpdate) {
		System.out.println("===================================== @GetMapping( /UPDATE ) ==================================");
		userService.updateUser(userToUpdate);
		return "redirect:roles_admin"; 
	}
	
/**
 * Cancella un utente attraverso lo userID se la richiesta arriva da un amministratore, altrimenti skip e rimanda a pagina1
 * @param id
 * @param session
 * @param model
 * @return String page
 */
	@GetMapping("/delete/{id}")
	public String deleteUser (@PathVariable(name = "id") Long id, HttpSession session, Model model){ 
		System.out.println("===================================== @GetMapping( /DELETE ) ==================================");
		if((boolean) session.getAttribute("userIsAdmin")) {
			userService.deleteUserById(id);
			return "redirect:/roles_admin";
		} else {
			return "internal_page1";
		}
	}

	
}
