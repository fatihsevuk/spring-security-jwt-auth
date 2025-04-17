package com.fatihsevuk.springsecurityjwtauth.service.impl;


import com.fatihsevuk.springsecurityjwtauth.entity.User;
import com.fatihsevuk.springsecurityjwtauth.entity.UserRole;
import com.fatihsevuk.springsecurityjwtauth.repository.RoleRepository;
import com.fatihsevuk.springsecurityjwtauth.repository.UserRepository;
import com.fatihsevuk.springsecurityjwtauth.service.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;


	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {

		for (UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}

		user.getUserRoles().addAll(userRoles);

		return userRepository.save(user);
	}


}
