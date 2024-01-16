package com.example.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.example.models.Role;
import com.example.repositories.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	
	public Set<Role> getRolesById(List<Long> id){
		Set<Role> set =  new HashSet<Role>(roleRepository.findAllById(id)); //findAllById ritorna una List<Role>
		return set;
	}
	
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
}
