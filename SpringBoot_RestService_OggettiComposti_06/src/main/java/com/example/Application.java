/* SERVER PORT 8080
 	Questo progetto "consumerà" i dati forniti da un Restful WebService.
 	Anche questo progetto, come il primo, viene creato usando solo lo starter Spring WEB.

 	
 	
*/
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
