package cityapp.business;

import org.cityapp.exceptions.DatabaseException;

import cityapp.dbmodel.User;
import cityapp.dbmodel.dao.UserDao;

public class UserController {

	private static UserDao userDao = new UserDao();

	private UserController() {
	}

	public static boolean isValidoUser(String userName, String password) throws DatabaseException {
		String sha1Password = HashText.sha1(password);
		User user = userDao.getUserByUserName(userName, sha1Password);
		return user != null;
	}

}
