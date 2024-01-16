package com.example;


import org.springframework.data.repository.CrudRepository;

import com.example.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {


	
}
