package com.um.myapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.um.myapp.Dao.UserDao;
import com.um.myapp.model.User;

@Service ("userService")
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findById(Integer id) {
		return this.userDao.findById(id);
	}
	
	public List<User> findAll() {
		return this.userDao.findAll();
	}
	
	public void delete(Integer id) {
		this.userDao.delete(id);	
	}

	public void saveOrUpdate(User user) {
		if(user.getId() == null){
			this.userDao.save(user);
		}
		else{
			this.userDao.update(user);
		}	
	}
}
