package com.example.models;

public class Impiegato {

	private String nome;
	private String cognome;
	private Indirizzo indirizzo;
	
	public Impiegato () {}

	public Impiegato(String nome, String cognome, Indirizzo indirizzo) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setIndirizzo(indirizzo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Impiegato [nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + "]";
	}
	
}
