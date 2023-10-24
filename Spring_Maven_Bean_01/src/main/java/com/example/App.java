// Esempio 1. Con l'uso di @Configuratione e @Bean nella classe BeanConfig.java
// La classe Studente è una classe POJO ed è SENZA annotazioni.
package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	/* Dobbiamo accedere all'ApplicationContext, 
    	e tramite la confiturazione con annotazioni (AnnotationConfigA...) 
    	analizziamo i Beans instanziati dalla Classe BeanConfig */
    	AbstractApplicationContext ctx =  
    			new AnnotationConfigApplicationContext(BeanConfig.class);
    	
    	//Estrae tutti i nomi dei Bean istanziati nell'ApplicationContext "ctx"
    	for(String beanName : ctx.getBeanDefinitionNames()) {
    		System.out.println("BEAN ----> " + beanName);
    	}
    	
    	Studente s1 = (Studente)ctx.getBean("Studente1");
    	Studente s2 = ctx.getBean("Studente1",Studente.class);
    	System.out.println("\n" + s1);
    	System.out.println(s2);
    	
    	ctx.close(); //ctx deve essere chiuso
    }
}


