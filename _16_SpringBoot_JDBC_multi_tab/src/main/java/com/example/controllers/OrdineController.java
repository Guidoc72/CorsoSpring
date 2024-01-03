package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.models.Ordine;
import com.example.models.Prodotto;
import com.example.services.OrdineService;
import com.example.services.ProdottoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrdineController {
    private final OrdineService ordineService;
    private final ProdottoService prodottoService;

    public OrdineController(OrdineService ordineService, ProdottoService prodottoService) {
        this.ordineService = ordineService;
        this.prodottoService = prodottoService;
    }

    
//	ADD NEW 	
//	@GetMapping("/ordini")
//	public ModelAndView getOrdini() {
//		return new ModelAndView("/ordini")
//				.addObject("ordine", new Ordine());
//	}

	@GetMapping("/ordini")
	public String getOrdini(HttpSession session, Model model) {
		Ordine ordine = new Ordine();
		session.setAttribute("ordine", ordine);
		model.addAttribute("ordine", ordine);
		System.out.println("ORDINE: " + ordine);
		return "ordini";
	}
	
	List<Prodotto> listaProdottiInOrdine = new ArrayList<>();
	List<Prodotto> listaProdottiDisponibili = new ArrayList<>();

	@PostMapping("/aggiungiordine")
	public String createOrdine(@ModelAttribute Ordine ordine, Model model /*, HttpSession session */) {
		System.out.println("AGGIUNGI ORDINE: " + ordine);
		ordineService.insertOrdine(ordine);
		List<Ordine> ordini = ordineService.findAllOrdini();
		String nomeCliente = ordine.getNomeCliente();
		String dataOrdine = ordine.getDataOrdine().toString();
		Ordine recuperaOrdine = ordini.stream()
			    .filter(o -> o.getNomeCliente().equals(nomeCliente) && o.getDataOrdine().toString().equals(dataOrdine))
			    .findFirst()
			    .orElse(null);
		ordine=recuperaOrdine;
		System.out.println("ORDINE DAL DATABASE: " + ordine);  
//		model.addAttribute("ordine", ordine);
//		session.setAttribute("ordine", ordine);
		listaProdottiDisponibili = prodottoService.findAllProdotti();
		model.addAttribute("listaprodotti", listaProdottiInOrdine);
		model.addAttribute("listaprodottiselect", listaProdottiDisponibili);
		return "ordine_add_prodotti";
	}
    
/*	Questo metodo riceve l'aggiunta all'ordine, del prodotto dal form. Reindirizza alla stessa pagina
	mantenendo i dati dell'ordine, la lista dei prodotti disponibili e la lista aggiornata dei 
	prodotti in ordine */	
	@PostMapping("/aggiungi_prodotto_ordine")
	public String addProductToOrder(/*@ModelAttribute Ordine ordine,*/ 
									@RequestParam ("prodotto_in_aggiunta") int idProdotto,
									Model model//,
									/*HttpSession session*/) {
		Prodotto prodotto = prodottoService.findProdottoById(idProdotto);
		listaProdottiInOrdine.add(prodotto);
		System.out.println("PRODOTTO: " + prodotto);
//		model.addAttribute("ordine", ordine);
//		session.setAttribute("ordine", ordine);
//		System.out.println("ORDINE: " + ordine);
		model.addAttribute("listaprodottiselect", listaProdottiDisponibili);
		System.out.println("LISTA SELECT: " + listaProdottiDisponibili);
		model.addAttribute("listaprodotti", listaProdottiInOrdine);
		System.out.println("LISTA ORDINE: " + listaProdottiInOrdine);
		return "ordine_add_prodotti";
	}
	
	
//	LIST / TABLE    
    @GetMapping("/listaordini")
    public String getOrdini(Model model) {
        List<Ordine> ordini = ordineService.findAllOrdini();
        model.addAttribute("ordini", ordini);
        return "listaordini";
    }

    @GetMapping("/ordini/{id}")
    public String getOrdine(@PathVariable int id, Model model) {
        Ordine ordine = ordineService.findOrdineById(id);
        model.addAttribute("ordine", ordine);
        return "ordine";
    }



    @GetMapping("/ordini/{id}/edit")
    public String editOrdine(@PathVariable int id, Model model) {
        Ordine ordine = ordineService.findOrdineById(id);
        model.addAttribute("ordine", ordine);
        return "edit_ordine";
    }

    @PostMapping("/ordini/{id}")
    public String updateOrdine(@PathVariable int id, @ModelAttribute Ordine ordine) {
        ordine.setId(id);
        ordineService.updateOrdine(ordine);
        return "redirect:/ordini";
    }

    @GetMapping("/ordini/{id}/delete")
    public String deleteOrdine(@PathVariable int id) {
        ordineService.deleteOrdine(id);
        return "redirect:/ordini";
    }
}

