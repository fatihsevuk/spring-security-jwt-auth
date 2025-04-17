package com.fatihsevuk.springsecurityjwtauth.service;


import com.fatihsevuk.springsecurityjwtauth.entity.Role;
import com.fatihsevuk.springsecurityjwtauth.entity.RoleName;

public interface RoleService {
    Role findByName(RoleName name);
    Role save(Role role);
}
