package com.example.controllers;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


@Configuration
public class Esternalizzazione {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages", "messages_es", "messages_en");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
/*    
Il metodo messageSource() configura l’esternalizzazione dei messaggi utilizzando la classe 
ResourceBundleMessageSource. Questa classe viene utilizzata per recuperare i messaggi da file 
di proprietà esterni. 
In questo caso, i file di proprietà sono denominati messages.properties, messages_es.properties 
e messages_en.properties. 
Il metodo setDefaultEncoding() viene utilizzato per impostare l’encoding predefinito dei 
file di proprietà su UTF-8.
*/

    
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.getDefault());
        return resolver;
    }
/*    
Il metodo localeResolver() configura la risoluzione della lingua utilizzando la classe 
AcceptHeaderLocaleResolver. Questa classe viene utilizzata per risolvere la lingua corretta in 
base all’header Accept-Language inviato dal browser. 
Il metodo setDefaultLocale() viene utilizzato per impostare la lingua predefinita sulla lingua 
del sistema.
*/	
}
