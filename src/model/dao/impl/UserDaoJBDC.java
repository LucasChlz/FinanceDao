package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Excepts.AuthException;
import db.DB;
import db.DbException;
import model.dao.UserDao;
import model.entities.User;

public class UserDaoJBDC implements UserDao {
	
	private Connection conn;
	
	public UserDaoJBDC(Connection conn)
	{
		this.conn = conn;
	}
	
	private User instantiateUser(ResultSet rs) throws SQLException 
	{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(null);
		user.setAmount(rs.getDouble("amount"));
		return user;
	}
	
	public void verifyByEmail(String email)
	{
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try
		{
			st = conn.prepareStatement(
					"SELECT email FROM users "
					+ "WHERE email = ?");
			st.setString(1, email);
			rs = st.executeQuery();
			
			if (rs.next())
			{
				throw new AuthException("This email already exist");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void insert(User obj) {
	
		PreparedStatement st = null;
		ResultSet rs = null;
		
		if (!User.isValidEmail(obj.getEmail()))
		{
			throw new AuthException("Invalid email");
		}
		else
		{
			this.verifyByEmail(obj.getEmail());
		}
		
		try
		{
			st = conn.prepareStatement(
					"INSERT INTO users "
					+ "(name, email, password, amount) "
					+ "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setString(3, obj.getPassword());
			st.setDouble(4, obj.getAmount());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0)
			{
				rs = st.getGeneratedKeys();
				if (rs.next())
				{
					int id = rs.getInt(1);
					obj.setId(id);
				}
			} else
			{
				throw new DbException("Unexpected error, user can't be created");
			}
		}
		catch(SQLException e)
		{
			throw new DbException(e.getMessage());
		}
		finally
		{
			DB.closeStatment(st);
			DB.closeResultSet(rs);
		}
		
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
	public User findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try
		{
			st = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next())
			{
				User user = instantiateUser(rs);
				
				return user;
			}
			return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
