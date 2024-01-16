package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.User;

//@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByUsername (String username);
	
	@Query("SELECT DISTINCT u FROM User u JOIN FETCH u.roles WHERE u.id = :userId")
    public User findByIdWithRoles(Long userId);
	//Su RoleRepository è possibile vedere la sintassi di un metodo con Query in SQL nativo
	
}
