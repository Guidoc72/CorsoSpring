package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration		//rende questa la classe di configurazione
@ComponentScan		//obbliga Spring alla scansione delle classi in cerca di Componenti 
					//senza ComponentScan, BeanConfig viene disattivata naturalmente
public class AppComponent 
{
    public static void main( String[] args )
    {
    	/* La classe di configurazione che passiamo, ora è proprio QUESTA
    	 Classe principale */
    	AbstractApplicationContext ctx =  
    			new AnnotationConfigApplicationContext(AppComponent.class);
    	
    	//Estrae tutti i nomi dei Bean istanziati nell'ApplicationContext "ctx"
    	for(String beanName : ctx.getBeanDefinitionNames()) {
    		System.out.println("BEAN ----> " + beanName);
    	}
    	
//		NEL SECONDO ESEMPIO @Component    	
    	Studente s3 = (Studente)ctx.getBean("studente");
    	Studente s4 = ctx.getBean("studente",Studente.class);
    	System.out.println("\n" + s3);
    	System.out.println(s4);
    	
    	ctx.close(); //ctx deve essere chiuso
    }
}


