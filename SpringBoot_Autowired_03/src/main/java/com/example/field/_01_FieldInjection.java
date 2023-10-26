package com.example.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class _01_FieldInjection {

	//per non usare la D.I. dovrei fare così, creando un forte
	//accoppiamento con le classi dipendenti.
	//private Dipendenza_A dipA = new Dipendenza_A("test A");
	
	@Autowired
	private Dipendenza_A dipA;

//	public _01_FieldInjection() {}
//	
//	public _01_FieldInjection(Dipendenza_A dipA) {
//		this.dipA = dipA;
//	}

	public Dipendenza_A getDipA() {
		return dipA;
	}

	public void setDipA(Dipendenza_A dipA) {
		this.dipA = dipA;
	}
	
}
