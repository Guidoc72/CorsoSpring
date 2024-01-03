package com.example.models;

import java.math.BigDecimal;

public class Prodotto {
    private int id;
    private String nome;
    private String descrizione;
    private BigDecimal prezzo;

    public Prodotto() {}
    
    public Prodotto(int id, String nome, String descrizione, BigDecimal prezzo) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}
    
    
}
