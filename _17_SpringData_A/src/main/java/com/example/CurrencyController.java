package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Currency;
import com.example.model.CurrencyDTO;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

	private CurrencyService currencyService;
	
	
	@Autowired
	public CurrencyController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@GetMapping(value = "/{id}")
	//public ResponseEntity<CurrencyDTO> getById(@PathVariable Long id) {			//senza DB
	public ResponseEntity<Currency> getById(@PathVariable Long id) {
		//CurrencyDTO response = currencyService.getById(id);						//senza DB
		Currency response = currencyService.getById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//	METODI NON IMPLEMENTATI NELLA VERSIONE CON DB - DOBBIAMO COMMENTARLI PERCHE' NON HANNO UN CORRISPETTIVO IN CurrencyService	
//	@PostMapping
//	public ResponseEntity<CurrencyDTO> save(@RequestBody CurrencyDTO currencyDTO) {
//		CurrencyDTO response = currencyService.save(currencyDTO);
//		return new ResponseEntity<>(response, HttpStatus.CREATED);
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<CurrencyDTO> update(@RequestBody CurrencyDTO currencyDTO) {
//		CurrencyDTO response = currencyService.update(currencyDTO);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
//
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Long id) {
//		currencyService.delete(id);
//		return ResponseEntity.accepted().build();
//	}

}

