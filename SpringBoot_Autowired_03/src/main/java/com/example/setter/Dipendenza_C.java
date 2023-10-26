package com.example.setter;

import org.springframework.stereotype.Component;

@Component
public class Dipendenza_C {

	private String elemC = "CCCC"; //lo inizializiamo così possiamo stampare qualcosa, altrimenti ritorna "null"

	public Dipendenza_C () {}
	
	public Dipendenza_C (String elemC) {
		this.elemC = elemC;
	}

	public String getElemC() {
		return elemC;
	}

	public void setElemC(String elemC) {
		this.elemC = elemC;
	}
	
	

}