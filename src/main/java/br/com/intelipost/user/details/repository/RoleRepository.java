package br.com.intelipost.user.details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import br.com.intelipost.user.details.document.Role;
import br.com.intelipost.user.details.document.RoleType;

public interface RoleRepository extends MongoRepository<Role, Integer>{
	
	Role findByName(@Param("roleName")RoleType roleName);
}
