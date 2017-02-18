package com.um.myapp.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import com.um.myapp.model.User;

public class UserDaoImp extends AbstractDao<Integer,User> implements UserDao {

	public User findById(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<User>)criteria.list();
	}

	public void save(User user) {
		persist(user);	
	}

	public void update(User user) {
		persist(user);	
	}

	public void delete(Integer id) {
		Query query = getSession().createQuery("delete from User where id = ?");
		query.setInteger("id", id);
		query.executeUpdate();	
	}
}
