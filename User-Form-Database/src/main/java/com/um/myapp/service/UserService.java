package com.um.myapp.service;

import java.util.List;

import com.um.myapp.model.User;

public interface UserService {
	public User findById(Integer id);
	public List<User> findAll();
	public void saveOrUpdate(User user);
	public void delete(Integer id);
}
