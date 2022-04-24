package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.entities.User;

public interface UserDao {
	
	void insert(User obj);
	void update(User obj);
	void deleteById(Integer id);
	User findById(Integer id);
	void depositTo(Integer toUser, Integer myUser, Double amount) throws SQLException;
	void verifyByEmail(String email);
	List<User> findAll();
	
}
