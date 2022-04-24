package application;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class main {

	public static void main(String[] args) {
		
		UserDao userDao = DaoFactory.createUserDao();
		
		User myuser = userDao.findById(6);
		System.out.println(myuser);
	}

}
