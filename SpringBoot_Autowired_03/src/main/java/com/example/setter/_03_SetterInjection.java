package com.example.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class _03_SetterInjection {

	private Dipendenza_C dipC;

//L'utilizzo della setter injection è riservato ai casi in cui le dipendenze sono OPZIONALI
//e quindi creiamo l'oggetto con il costruttore di default e iniettimo le dipendenze in un secondo momento tramite setter	
//	public _03_SetterInjection(Dipendenza_C dipC) {
//		this.dipC = dipC;
//	}

	public Dipendenza_C getDipC() {
		return dipC;
	}

	@Autowired
	public void setDipendenza_C(Dipendenza_C dipC) {
		this.dipC = dipC;
	}
	
}