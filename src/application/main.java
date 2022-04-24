package application;

import java.sql.SQLException;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class main {

	public static void main(String[] args) throws SQLException {
		
		UserDao userDao = DaoFactory.createUserDao();
		
		userDao.depositTo(7, 8, 1000.0);
		System.out.println("Deposited");
	}

}
