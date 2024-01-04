package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Currency;
import com.example.model.CurrencyDTO;

@Service
public class CurrencyService {

// 	SENZA PERSISTENZA DEI DATI
// 
//	public CurrencyDTO getById(Long id) { return new CurrencyDTO(id, "USD",
//	"Dollar", true, 2); }
//
//	public CurrencyDTO save(CurrencyDTO currencyDTO) { return currencyDTO; }
//
//	public CurrencyDTO update(CurrencyDTO currencyDTO) { return currencyDTO; }
//
//	public void delete(Long id) { // TODO Auto-generated method stub }
//
//	}
//}

	
//	AGGIUNGIAMO LA PERSISTENZA E USIAMO REPOSITORY
	CurrencyRepository repository;

	@Autowired
	public CurrencyService(CurrencyRepository repository) {
		this.repository = repository;
	}

	public Currency getById(Long id) {
		Currency response = null;
		Optional<Currency> currency = repository.findById(id);
		if (currency.isPresent()) {
			response = currency.get();
		}
		return response;
	}
	// Other existent methods without changes
}
