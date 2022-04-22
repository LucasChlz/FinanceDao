package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.UserDao;
import model.entities.User;

public class UserDaoJBDC implements UserDao {
	
	private Connection conn;
	
	public UserDaoJBDC(Connection conn)
	{
		this.conn = conn;
	}

	@Override
	public void insert(User obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
