package com.fatihsevuk.springsecurityjwtauth.repository;


import com.fatihsevuk.springsecurityjwtauth.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);

	User findByUsername(String username);



}
