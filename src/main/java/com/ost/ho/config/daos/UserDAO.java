package com.ost.ho.config.daos;

import org.springframework.stereotype.Repository;

import com.ost.ho.pojo.User;

@Repository
public interface UserDAO {
	public void addUser(User user); 
	public User authenticate(User user);
}
