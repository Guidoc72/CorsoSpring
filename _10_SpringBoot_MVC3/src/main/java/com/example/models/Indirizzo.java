package com.example.models;

public class Indirizzo {

	private String viaPiazza;
	private int civico;
	
	public Indirizzo () {}

	public Indirizzo(String viaPiazza, int civico) {
		this.setViaPiazza(viaPiazza);
		this.setCivico(civico);
	}

	public String getViaPiazza() {
		return viaPiazza;
	}

	public void setViaPiazza(String viaPiazza) {
		this.viaPiazza = viaPiazza;
	}

	public int getCivico() {
		return civico;
	}

	public void setCivico(int civico) {
		this.civico = civico;
	}

	@Override
	public String toString() {
		return "Indirizzo [viaPiazza=" + viaPiazza + ", civico=" + civico + "]";
	}

}
