package com.example.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Prodotto;
import com.example.services.ProdottoService;

@Controller
public class ProdottoController {
    private final ProdottoService prodottoService;

    public ProdottoController(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }
    
//	ADD NEW 
	@GetMapping("/prodotti")
	public ModelAndView getProdotti() {
		return new ModelAndView("/prodotti")
				.addObject("prodotto", new Prodotto());
	}
	
    @PostMapping("/aggiungiprodotto")
    public String createProdotto(@ModelAttribute Prodotto prodotto , @RequestParam("prezzoProdotto") String prezzoProdotto) throws Exception {
    	BigDecimal prezzo;
    	try {
    		prezzo = new BigDecimal(prezzoProdotto);
    	} catch (NumberFormatException e) {
    		prezzo = BigDecimal.ZERO;
            throw new Exception("Formato errato");
    	}
    	prodotto.setPrezzo(prezzo);
    	prodottoService.insertProdotto(prodotto);
    	return "redirect:/prodotti";
    }


//	LIST / TABLE    
    @GetMapping("/listaprodotti")
    public String getProdotti(Model model) {
        List<Prodotto> prodotti = prodottoService.findAllProdotti();
        //System.out.println(prodotti);
        model.addAttribute("prodotti", prodotti);
        return "listaprodotti";
    }

    
//	FIND BY ID    
    @GetMapping("/prodotti/{id}")
    public String getProdotto(@PathVariable int id, Model model) {
        Prodotto prodotto = prodottoService.findProdottoById(id);
        model.addAttribute("prodotto", prodotto);
        return "prodotto";
    }

    
//	EDIT / UPDATE    
    @GetMapping("/prodotti/{id}/edit")
    public String editProdotto(@PathVariable int id, Model model) {
        Prodotto prodotto = prodottoService.findProdottoById(id);
        model.addAttribute("prodotto", prodotto);
        return "edit_prodotto";
    }

    @PostMapping("/prodotti/{id}")
    public String updateProdotto(@PathVariable int id, @ModelAttribute Prodotto prodotto) {
        prodotto.setId(id);
        prodottoService.updateProdotto(prodotto);
        return "redirect:/listaprodotti";
    }

    
//	DELETE
    @GetMapping("/prodotti/{id}/delete")
    public String deleteProdotto(@PathVariable int id) {
        System.out.println("---> Elimina prodotto con ID: " + id);
    	prodottoService.deleteProdotto(id);
        return "redirect:/listaprodotti";
    }
    
    
  
    
}

