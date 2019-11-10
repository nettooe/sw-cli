package com.nettooe.swapi.service;

import java.util.List;

import com.nettooe.swapi.model.LoginUser;
import com.nettooe.swapi.model.User;

public interface UserService {

	User save(LoginUser user);

	List<User> findAll();

	void delete(long id);

	User findOne(String username);

	User findById(Long id);
}
