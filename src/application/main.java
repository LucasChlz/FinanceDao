package application;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class main {

	public static void main(String[] args) {
		
		UserDao userDao = DaoFactory.createUserDao();
		
		User user1 = new User(null, "Lontra","lontra@gmail.com", "123", 3000.0);
		userDao.insert(user1);
		System.out.println("New user created, id = " + user1.getId());
	}

}
