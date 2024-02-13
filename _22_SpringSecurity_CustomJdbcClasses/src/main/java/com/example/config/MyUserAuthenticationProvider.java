package com.example.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.models.Authority;
import com.example.models.Customer;
import com.example.repository.CustomerRepository;

@Service
public class MyUserAuthenticationProvider implements AuthenticationProvider{

	private CustomerRepository customerRepository;
		
	public MyUserAuthenticationProvider(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		//carico l'utente corrispondente allo username
		List<Customer> customer = customerRepository.findByEmail(username);
		
		if (customer.size() > 0) {
			//Tutte le stampe di test vanno eliminate!!!
			System.out.println("password insertita: "+pwd);		//controllo la pwd in ingresso dal form
			System.out.println("password in DB: "+customer.get(0).getPwd()); //e quella codificata nel DB
			
			if(passwordEncoder().matches(pwd, customer.get(0).getPwd())) { //faccio il check delle password
				System.out.println("Autenticazione ok"); 
				//inserisco qualche stampa a console per controllare se ci sono errori e dove si verificano
				return new UsernamePasswordAuthenticationToken(
						username, pwd, getGrantedAuthorities(customer.get(0).getAuthorities()));
			}else {
				System.out.println("Password non valida");//altra stampa di controllo
				throw new BadCredentialsException("Password non valida");
			}
		}else {
			System.out.println("Utente non trovato");//altra stampa di controllo
			throw new BadCredentialsException("Utente non trovato");
		}
	}
	
	//Estraggo la lista completa delle Authorities presenti nel Set collegato all'utente
	private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities){
		List<GrantedAuthority> grantedAuthorities =  new ArrayList<>();
		for(Authority authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return grantedAuthorities;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}

