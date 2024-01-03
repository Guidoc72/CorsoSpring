package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.Ordine;
import com.example.repositories.OrdineRepository;

@Service
public class OrdineService {
    private final OrdineRepository ordineRepository;

    public OrdineService(OrdineRepository ordineRepository) {
        this.ordineRepository = ordineRepository;
    }

    public void insertOrdine(Ordine ordine) {
        ordineRepository.insertOrdine(ordine);
    }

    public List<Ordine> findAllOrdini() {
        return ordineRepository.findAllOrdini();
    }

    public Ordine findOrdineById(int id) {
        return ordineRepository.findOrdineById(id);
    }

    public void updateOrdine(Ordine ordine) {
        ordineRepository.updateOrdine(ordine);
    }

    public void deleteOrdine(int id) {
        ordineRepository.deleteOrdine(id);
    }
}
