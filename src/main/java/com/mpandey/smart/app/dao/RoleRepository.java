package com.mpandey.smart.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpandey.smart.app.objects.Role;


@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Integer>{
	Role findByRole(String role);

}
