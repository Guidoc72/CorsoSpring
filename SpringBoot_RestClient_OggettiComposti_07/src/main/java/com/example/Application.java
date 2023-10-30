/* CLIENT PORT 8081
Una volta completato il SERVER, dobbiamo creare un'app che sia in grado di recuperare ed usare i dati forniti dal server.
Per fare ciò, una volta scritta questa APP, Client, metteremo in esecuzione il Server sulla porta 8080 ed eseguiremo il 
Client sulla porta 8081. Questa differenza è necessaria perché altrimenti i due servizi andrebbero in conflitto ed il secondo, 
trovando la porta impegnata, non partirebbe.
Al Client dovremo fornire gli indirizzi corretti a cui chiedere i dati
- Per recuperare i dati non via borswer (operazione inutile) ma via App Web Rest, Spring ci fornisce una classe RestTemplate 
per semplificare le cose.

- Dobbiamo anche ricreare le classi model che dovranno consumare i dati recuperati per generare oggetti.
	Queste classi model possono essere annotate con @JsonIgnoreProperties(ignoreUnkown = true) che indicherà alla classe di non 
	considerare i vaori recuperati, che non trovano corrispondenza nella classe stessa.
	
- Per associare direttamente i dati recuperati, i nomi delle varibili letti e quelli delle classi Model nel Client devono 
	corrispondere esattamente. In caso contrario è possibile usare un'altra annotazione: @JsonProperty e @JsonCreator
	
Per vedere i dati recuperati dobbiamo ancora aggiungere alcuni elementi al progetto direttamente nella classe Application:
	• Un logger per inviare l'output al log(verso la console o altri output)
	• Un RestTemplate che usa la libreria Jackson JSON per elaborare i dati in ingresso
	• Un CommandLineRunner che esegue il RestTemplate all'avvio e recupera quindi i dati delle nostre classi
*/
package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.example.model.Person;

@SpringBootApplication
public class Application {

	
	//LOGGER (import da org.slf4j.Logger)
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	
	//Metodo MAIN	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		

	
	//REST Template (import da org.springframework.web.client.RestTemplate)
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
		
		
	//COMMAND Line Runner (import da org.springframework.context.annotation.Profile)
	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			Person person = restTemplate.getForObject("http://localhost:8080/person/2", Person.class); //Ovviamente questa è una stringa e può essere passata in qualsiasi modo che ne permetta la personalizzazione
			log.info(person.toString());
		};
	}

// Dovremmo ottenere un output come:
//2023-10-22T12:37:58.035+02:00  INFO 21872 --- [main] com.example.Application      : Person [personId=2, firstName=Lisa, lastName=Rossi, address=Address [addressId=2, houseNumber=12, street=Viale Marco Polo]]

//Mentre sulla console del server apparirà questo:
/*
2023-10-22T12:37:57.998+02:00 DEBUG 15516 --- [nio-8080-exec-4] o.s.web.servlet.DispatcherServlet        : GET "/person/2", parameters={}
2023-10-22T12:37:57.999+02:00 DEBUG 15516 --- [nio-8080-exec-4] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to com.example.controller.PersonController#getPersonById(long)
2023-10-22T12:37:58.000+02:00 DEBUG 15516 --- [nio-8080-exec-4] m.m.a.RequestResponseBodyMethodProcessor : Using 'application/json', given [application/json, application/*+json] and supported [application/json, application/*+json]
2023-10-22T12:37:58.000+02:00 DEBUG 15516 --- [nio-8080-exec-4] m.m.a.RequestResponseBodyMethodProcessor : Writing [com.example.model.Person@491b8082]
2023-10-22T12:37:58.001+02:00 DEBUG 15516 --- [nio-8080-exec-4] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
 */
		

}
