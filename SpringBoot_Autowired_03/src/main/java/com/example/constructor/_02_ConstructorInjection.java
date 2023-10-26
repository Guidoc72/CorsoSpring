//Questa è la modalità di riferimento quando è necessario avere delle diependenze obbligatorie
// ovvero delle dipendenze che DEVONO essere presenti e diverse da null.
package com.example.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class _02_ConstructorInjection {

	private final Dipendenza_B dipB;

	//public _02_ConstructorInjection() {} //se marco il campo "final" deov togliere il costruttore di default e il setter
	
	@Autowired  //questa è implicita e non serve scrivere l'annotazione
	public _02_ConstructorInjection(Dipendenza_B dipB) {
		this.dipB = dipB;
	}

	public Dipendenza_B getDipB() {
		return dipB;
	}

//	public void setDipB(Dipendenza_B dipB) {
//		this.dipB = dipB;
//	}
	
	
}
