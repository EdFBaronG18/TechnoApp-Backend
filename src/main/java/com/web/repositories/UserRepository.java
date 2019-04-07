package com.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findById(long id);
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username, String password);
}
