    //VERSIONE DI BASE SENZA DATABASE DEGLI UTENTI
package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class BasicSecurity {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //NoOpPasswordEncoder.getInstance()  mantiene la password in chiaro
	}

/**
 * Definisco 2 utenti: uno 'user' e uno 'admin' con i rispettivi ruoli USER e ADMIN
 * @return
 */
	@Bean 
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("user")  //import: ***.security.core.userdetails.User;
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("adminPass"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
		
	
	
//	VERSIONE SENZA LAMBDA
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
	  http
	    .authorizeHttpRequests()
		    .requestMatchers("/users/**").hasAnyRole("USER", "ADMIN") 
	    	.requestMatchers("/admin/**").hasRole("ADMIN")
	    	.requestMatchers("/**").permitAll()  //il più permissivo deve stare per ultimo perché altrimenti intercetta tutte le altre chiamate
	        .and()
        .formLogin()
	        .and()
        .logout()
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/")
	        .invalidateHttpSession(true)
	        .deleteCookies("JSESSIONID");
	    return http.build();
	}
	
	
//	Versione Utente singolo
//	@Bean
//	public UserDetailsService userDetailsService() {
//	
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER").build());
//		return manager;
//	}	
	
	
	
//	VERSIONE LAMBDA	
//	@Bean
//	SecurityFilterChain securityFilterChainLambda (HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/users/**").hasRole("USER")
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/**").permitAll())
//                .formLogin(withDefaults())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID"));
//	    return http.build();
//	}
	
	

	
}
