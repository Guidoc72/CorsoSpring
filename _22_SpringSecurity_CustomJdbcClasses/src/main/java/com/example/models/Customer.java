package com.example.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String pwd;
	private String role;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private Set<Authority> authorities;
	
	
	//getters e setters ed eventuale .toString() 

	public Set<Authority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Customer [id=" + Long.valueOf(id) + ", email=" + email + ", pwd=" + pwd + ", role=" + role + ", authorities="
				+ authorities + "]";
	}


//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", email=" + email + ", pwd=" + pwd + ", role=" + role + "]";
//	}
	
	
	
}
