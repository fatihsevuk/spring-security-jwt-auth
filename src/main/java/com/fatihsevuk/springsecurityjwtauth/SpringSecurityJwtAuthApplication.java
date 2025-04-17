package com.fatihsevuk.springsecurityjwtauth;

import com.fatihsevuk.springsecurityjwtauth.entity.Role;
import com.fatihsevuk.springsecurityjwtauth.entity.RoleName;
import com.fatihsevuk.springsecurityjwtauth.entity.User;
import com.fatihsevuk.springsecurityjwtauth.entity.UserRole;
import com.fatihsevuk.springsecurityjwtauth.security.SecurityConfig;
import com.fatihsevuk.springsecurityjwtauth.service.RoleService;
import com.fatihsevuk.springsecurityjwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityJwtAuthApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtAuthApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Override
    public void run(String... arg0) {

        User super_user = new User();
        super_user.setEmail("super@super.com");
        super_user.setPassword(SecurityConfig.passwordEncoder().encode("super"));
        super_user.setUsername("super_user");

        Set<UserRole> roles = new HashSet<>();
        Role roleSuperAdmin = new Role();
        roleSuperAdmin.setName(RoleName.ROLE_SUPER_ADMIN);
        roleSuperAdmin=roleService.save(roleSuperAdmin);
        roles.add(new UserRole(super_user, roleSuperAdmin));
        userService.createUser(super_user,roles);


    }

}
