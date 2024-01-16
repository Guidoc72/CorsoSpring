package com.example.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.models.User;
import com.example.services.RoleService;
import com.example.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("authenticatedUser")
public class LoginController {

	private UserService userService;
	
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
/**
 * Controller che cattura gli accessi alla home sui percorsi "/"  e  "/index"	
 * @param model Model
 * @return String: pagina index
 */
	@GetMapping(path = {"/", "/index"})
	public String getLogin(Model model) {

		model.addAttribute("user", new User());
		return "index";
	}
	
	
/**
 * Controller che cattura i dati dal form di Login, controlla se l'utente è presente nel DB e se la password corrisponde a quella salvata	
 * @param formUser	User
 * @param session	HttpSession
 * @return String:	pagina interna se l'accesso funziona,<br>
 * 					rimanda alla pagina di Login se le credenziali sono errate
 */
	@PostMapping("/login")
		public String login(@ModelAttribute("user") User formUser, HttpSession session) {
			String username = formUser.getUsername();
			if(userService.authorizedUser(formUser)) { //se l'utente esiste nel DB e la password coincide...
				session.setAttribute("authenticatedUser", username);
				User dbUser = userService.getUserByUsername(formUser.getUsername());
				
				//controllo se l'utente è admin:
				boolean isAdmin = dbUser.getRoles().stream()
												   .filter(role->role.getRoleName().equals("Admin"))
												   .findFirst()
												   .isPresent();
				if(isAdmin)
					session.setAttribute("userIsAdmin", isAdmin); 

				return "redirect:internal_page1";
			} else {
				return "redirect:/index?error";
			}
	}


	
}
