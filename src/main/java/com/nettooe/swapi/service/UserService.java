package com.nettooe.swapi.service;

import java.util.List;

import com.nettooe.swapi.model.User;
import com.nettooe.swapi.model.UserDto;

public interface UserService {

	User save(UserDto user);

	List<User> findAll();

	void delete(long id);

	User findOne(String username);

	User findById(Long id);
}
