package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	public User findUserByName(String email);
	public void saveUser(User user);
	public List<User> getAll();
}
