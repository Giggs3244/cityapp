package cityapp.business.businessobject;

import cityapp.dbmodel.User;
import cityapp.dbmodel.dao.UserDao;

public class UserController {

	private boolean validateUser(String userName, String password) {
		UserDao userDao = new UserDao();
		User user = userDao.getUserByUserName(userName, password);
		return user != null ? false : true;
	}
	
}
