package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {


	
}
