package com.example.models;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "role_name", nullable = false, length = 20)
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
	public Role () {}

	//Costruttore con Set
	public Role(Long id, String roleName, Set<User> users) {
		setId(id);
		setRoleName(Objects.requireNonNull(roleName));
		setUsers(users);
	}
	
	//Costruttore senza Set
	public Role(Long id, String roleName) {
		setId(id);
		setRoleName(Objects.requireNonNull(roleName));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName  + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id, roleName, users);
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
//		Role other = (Role) obj;
//		return Objects.equals(id, other.id) && Objects.equals(roleName, other.roleName)
//				&& Objects.equals(users, other.users);
//	}	
	
	
	
	
	
	
	
}
