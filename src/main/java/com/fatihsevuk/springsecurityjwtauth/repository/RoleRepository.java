package com.fatihsevuk.springsecurityjwtauth.repository;


import com.fatihsevuk.springsecurityjwtauth.entity.Role;
import com.fatihsevuk.springsecurityjwtauth.entity.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(RoleName name);
}