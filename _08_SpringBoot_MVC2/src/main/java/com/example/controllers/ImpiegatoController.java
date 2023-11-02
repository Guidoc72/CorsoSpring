package com.example.controllers;

import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;

import com.example.models.Impiegato;

@Controller
public class ImpiegatoController {

	//mappo la Home, sia con accesso generico che con index o home
	@GetMapping(path = {"/", "/index", "/home"}) 
	public String index(Model model) {  	//istanzio un obj "model"
		model.addAttribute("impiegato", new Impiegato());
		//passo questo obj alla pagina index in modo da avere un
		//obj "impiegato" di cui popolare i campi nel form 
		return "index";
	}
	
	@PostMapping("/")
	public String getImpiegato(@ModelAttribute Impiegato impiegato) {
		//L'oggetto "impiegato" viene recepito tramite Post ed inoltrato tramite l'annotazione @ModelAttribute

		//System.out.println(impiegato); //test per vedere se il controller riceve i dati
		return "destinazione";
	}

}





