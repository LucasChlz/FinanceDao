package model.dao;

import db.DB;
import model.dao.impl.UserDaoJBDC;

public class DaoFactory {
	
	public static UserDao createUserDao()
	{
		return new UserDaoJBDC(DB.getConnection());
	}
}
