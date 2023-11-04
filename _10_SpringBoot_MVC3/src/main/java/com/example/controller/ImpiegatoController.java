package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.models.Impiegato;
import com.example.models.Indirizzo;
import com.example.service.ImpiegatoService;

@Controller
public class ImpiegatoController {
    private ImpiegatoService impiegatoService;

    @Autowired
    public ImpiegatoController(ImpiegatoService impiegatoService) {
        this.impiegatoService = impiegatoService;
    }

     
    @GetMapping(path = {"/", "/gestione"})
    public String getImpiegati(Model model) {
    	model.addAttribute("impiegato", new Impiegato());
    	model.addAttribute("indirizzo", new Indirizzo());
        return "gestione";
    }

    @PostMapping("/impiegati")
    public String addImpiegato(	@ModelAttribute Impiegato impiegato, 
    							Model model) {
/*      salva l'impiegato - siccome usando gestione.html abbiamo un solo oggetto "impiegato" 
    	l'indirizzo passa come suoi campi interni e non popola un oggetto separato, 
    	è necessario aggiungerlo manualmente alla lista "indirizzi"   */    	
        impiegatoService.addImpiegato(impiegato);
        impiegatoService.addIndirizzo(impiegato.getIndirizzo());
        //invia la lista di impiegati
        model.addAttribute("listaImpiegati", impiegatoService.getImpiegati());       
        return "tabellaimpiegati";
    }
/*	Quando si utilizza return "redirect:/impiegati", il browser effettua una nuova richiesta HTTP 
 	alla pagina “/impiegati”. 
 	Quando si utilizza return "impiegati", la pagina “impiegati” viene restituita direttamente 
 	al browser senza effettuare una nuova richiesta HTTP.
  	Se si desidera eseguire un’azione prima di visualizzare la pagina, è possibile utilizzare 
  	return "redirect:/impiegati". Se si desidera visualizzare la pagina immediatamente senza 
  	eseguire alcuna azione, è possibile utilizzare return "impiegati".
 */
    
    //Pulsanti navigazione
    @GetMapping("/navigatabella")
    public String vaiTabella(Model model) {
    	model.addAttribute("listaImpiegati", impiegatoService.getImpiegati());
    	return "tabellaimpiegati";
    }    
   
}

