package com.fatihsevuk.springsecurityjwtauth.service.impl;


import com.fatihsevuk.springsecurityjwtauth.entity.Role;
import com.fatihsevuk.springsecurityjwtauth.entity.RoleName;
import com.fatihsevuk.springsecurityjwtauth.repository.RoleRepository;
import com.fatihsevuk.springsecurityjwtauth.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(RoleName name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(Role role) {
        Role newRole=findByName(role.getName());
        if(newRole!=null){
            LOG.warn("Bu role daha önceden kayıt edilmiş {} ",role.getName());
            return newRole;
        }else{
            return roleRepository.save(role);
        }

    }
}
