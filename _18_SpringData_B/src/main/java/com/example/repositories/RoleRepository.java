package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Role;

@Repository
public interface RoleRepository extends ListCrudRepository<Role, Long> {

	
//  @Query(value = "SELECT role_id FROM users_roles WHERE user_id = ?1", nativeQuery = true)
//	public List<Long> findIdRolesByUserId(Long user_id);
	
	
}
