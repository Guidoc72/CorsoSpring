package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.models.Impiegato;
import com.example.models.Indirizzo;


@Service
public class ImpiegatoService {
	
    private List<Impiegato> impiegati = new ArrayList<>();
    private List<Indirizzo> indirizzi = new ArrayList<>();

    
    public List<Impiegato> getImpiegati() {
        return impiegati;
    }

    public void addImpiegato(Impiegato impiegato) {
        impiegati.add(impiegato);
        indirizzi.add(impiegato.getIndirizzo());
    }

    public List<Indirizzo> getIndirizzi() {
        return indirizzi;
    }

    public void addIndirizzo(Indirizzo indirizzo) {
        indirizzi.add(indirizzo);
    }

}

