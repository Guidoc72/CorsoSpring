//Dipendenza usata in _01_FieldInjection
package com.example.field;

import org.springframework.stereotype.Component;

@Component
public class Dipendenza_A {

	private String elemA = "aaaa"; //lo inizializiamo così possiamo stampare qualcosa, altrimenti ritorna "null"

//	public Dipendenza_A(String elemA) {
//		this.elemA = elemA;
//	}

	public String getElemA() {
		return elemA;
	}

	public void setElemA(String elemA) {
		this.elemA = elemA;
	}
	
	
}
