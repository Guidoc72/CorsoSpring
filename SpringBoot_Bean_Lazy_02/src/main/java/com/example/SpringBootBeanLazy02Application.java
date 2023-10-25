package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBeanLazy02Application {

	public static void main(String[] args) {
		// .run(...) ritorna un oggetto di tipo 
		//ApplicationContext che possiamo catturare
		ApplicationContext ctx =  SpringApplication.run(
				SpringBootBeanLazy02Application.class, args);
			
		
		System.out.println("== Scritta di test ==");
		
		//effettuo una chiamata per generare il Bean a richiesta
		ctx.getBean(UsataRaramente.class);
	}
}


