package com.example;

import org.springframework.stereotype.Component;

@Component	//ANNOTAZIONE DA COMMENTARE COL 1. ESEMPIO  (App.java)
			//ANNOTAZIONE DA S-COMMENTARE COL 2. ESEMPIO (AppComponent.java)	
public class Studente {

	private String nome;
	private String cognome;
	
	public Studente() {}

	public Studente(String nome, String cognome) {
		setNome(nome);
		setCognome(cognome);
	}

	// getters, setters e ToString() 
		
	
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

	@Override
	public String toString() {
		return "Studente [nome=" + nome + ", cognome=" + cognome + "]";
	}

	
}
