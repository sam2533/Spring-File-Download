package com.um.myapp.Dao;

import java.util.List;

import com.um.myapp.model.User;

public interface UserDao {
	public User findById(Integer id);
	public List<User> findAll();
	public void save(User user);
	public void update(User user);
	public void delete(Integer id);
}
