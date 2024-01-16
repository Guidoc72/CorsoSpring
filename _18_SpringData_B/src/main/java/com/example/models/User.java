//Aggiungo Hibernate Validator agli starter per poter usare le annotazioni relative
package com.example.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name="Users", schema="UsersManagement")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="user_name", nullable = false, length = 15, unique = true)
	private String username;
	
	@Pattern(regexp = "[a-zA-Z\\s]{3,30}", message = "La stringa deve contenere almeno 3 caratteri diversi da numeri e simboli")
	@NotEmpty(message = "First name can't be empty")	
	@Column(name="first_name", nullable = false, length = 40)
    private String firstName;
	
	@Pattern(regexp = "[a-zA-Z\\s]{3,30}", message = "La stringa deve contenere almeno 3 caratteri diversi da numeri e simboli")
	@NotEmpty(message = "Last name can't be empty")	
	@Column(name="last_name", nullable = false, length = 40)
    private String lastName;

	@Column(nullable = false, length = 30)
	private String password;
    
	@Column(nullable = true, length = 15)
	private String phone;

	@Column(nullable = true, length = 15)
	private String mobile;

	@Email //controlla che il formato sia Email valido
	@Column(nullable = false, length = 40)
	private String email;
   
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",		//questo indica che le tabelle di cui fare la junction sono users e roles
            joinColumns = @JoinColumn(name = "user_id"),  //è stato necessario importare a mano: import jakarta.persistence.JoinColumn;
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();  
//    private Set<Role> roles = new HashSet<>(Collections.singletonList(new Role(2L, "user")));  //imposto un valore di default

	public User() {	}

	//costruttore con il Set
	public User(Long id, String username, String firstName, String lastName, String password, String phone,
			String mobile, String email, Set<Role> roles) {
		setId(id);
		setUsername(Objects.requireNonNull(username));
		setFirstName(Objects.requireNonNull(firstName));
		setLastName(Objects.requireNonNull(lastName));
		setPassword(Objects.requireNonNull(password));
		setPhone(phone);
		setMobile(mobile);
		setEmail(email);
		setRoles(roles);
	}

	//Costruttore senza Set
	public User(Long id, String username, String firstName, String lastName, String password, String phone,
			String mobile, String email) {
		setId(id);
		setUsername(Objects.requireNonNull(username));
		setFirstName(Objects.requireNonNull(firstName));
		setLastName(Objects.requireNonNull(lastName));
		setPassword(Objects.requireNonNull(password));
		setPhone(phone);
		setMobile(mobile);
		setEmail(email);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", phone=" + phone + ", mobile=" + mobile + ", email=" + email + ", roles="
				+ roles + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, mobile, password, phone, roles, username);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(mobile, other.mobile) && Objects.equals(password, other.password)
//				&& Objects.equals(phone, other.phone) && Objects.equals(roles, other.roles)
//				&& Objects.equals(username, other.username);
//	}
//	
	
	
	
	
}
