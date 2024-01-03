package com.example.repositories;

import java.util.List;

import com.example.models.Ordine;

public interface OrdineRepository {
	
    void insertOrdine(Ordine ordine);
    
    List<Ordine> findAllOrdini();
    
    Ordine findOrdineById(int id);
    
    void updateOrdine(Ordine ordine);
    
    void deleteOrdine(int id);
}
