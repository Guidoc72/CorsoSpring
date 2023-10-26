//Dipendenza usata in _01_ConstructorInjection
package com.example.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dipendenza_B {

	
	private String elemB = "BBBB" ; //lo inizializiamo così possiamo stampare qualcosa, altrimenti ritorna "null"

	public Dipendenza_B() {}
	
	public Dipendenza_B(String elemB) {
		this.elemB = elemB;
	}

	public String getElemB() {
		return elemB;
	}

	public void setElemB(String elemB) {
		this.elemB = elemB;
	}

	
}
