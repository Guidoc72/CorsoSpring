package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration		//annotata per il SECONDO ESEMPIO  @Component  (con AppComponent.java)
public class BeanConfig {

	//@Bean	  senza specificare (name =...) l'oggetto si chiamerà "getStudente" come il metodo
	@Bean(name = "Studente1")      //   annotata per il SECONDO ESEMPIO  @Component (con AppComponent.java)
	public Studente getStudente() {
		return new Studente("Mario", "Rossi"); 
		//posso anche valorizzare l'oggetto tramite costruttore
	}
}


