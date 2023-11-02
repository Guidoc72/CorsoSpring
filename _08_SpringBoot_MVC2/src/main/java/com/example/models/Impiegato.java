package com.example.models;

public class Impiegato {

	private int id;
	private String nome;
	private String cognome;
	
	public Impiegato() {}

	public Impiegato(int id, String nome, String cognome) {
		this.setId(id);
		this.setNome(nome);
		this.setCognome(cognome);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
		
}
