package com.fatihsevuk.springsecurityjwtauth.service;



import com.fatihsevuk.springsecurityjwtauth.entity.User;
import com.fatihsevuk.springsecurityjwtauth.entity.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {

	User createUser(User user, Set<UserRole> userRole);

}
