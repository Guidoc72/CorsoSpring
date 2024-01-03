package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.Prodotto;
import com.example.repositories.ProdottoRepository;

@Service
public class ProdottoService {
    private final ProdottoRepository prodottoRepository;

    public ProdottoService(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public void insertProdotto(Prodotto prodotto) {
        prodottoRepository.insertProdotto(prodotto);
    }

    public List<Prodotto> findAllProdotti() {
        return prodottoRepository.findAllProdotti();
    }

    public Prodotto findProdottoById(int id) {
        return prodottoRepository.findProdottoById(id);
    }

    public void updateProdotto(Prodotto prodotto) {
        prodottoRepository.updateProdotto(prodotto);
    }

    public void deleteProdotto(int id) {
        prodottoRepository.deleteProdotto(id);
    }
}
