package com.example.models;

import java.time.LocalDate;

public class Ordine {
    private int id;
    private String nomeCliente = "Nome Cliente";
    private LocalDate dataOrdine =  LocalDate.now();

    public Ordine () {}
    
    public Ordine(int id, String nomeCliente, LocalDate dataOrdine) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.dataOrdine = dataOrdine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

	@Override
	public String toString() {
		return "Ordine [id=" + id + ", nomeCliente=" + nomeCliente + ", dataOrdine=" + dataOrdine + "]";
	}
    
    
}
