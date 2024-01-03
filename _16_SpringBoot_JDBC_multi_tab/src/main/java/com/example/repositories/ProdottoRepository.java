package com.example.repositories;

import java.util.List;

import com.example.models.Prodotto;

public interface ProdottoRepository {
	
    void insertProdotto(Prodotto prodotto);
    
    List<Prodotto> findAllProdotti();
    
    Prodotto findProdottoById(int id);
    
    void updateProdotto(Prodotto prodotto);
    
    void deleteProdotto(int id);
}
