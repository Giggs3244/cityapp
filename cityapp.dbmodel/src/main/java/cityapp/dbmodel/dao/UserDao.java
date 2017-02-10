package cityapp.dbmodel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import cityapp.dbmodel.User;
import cityapp.dbmodel.dataaccess.EntityManagerUtil;

public class UserDao {

	public User getUserByUserName(String userName, String password) {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		List<User> users = null;
		try {
			users = manager.createQuery("FROM User u WHERE u.user = :user AND u.password = :password", User.class)
					.setParameter("user", userName)
					.setParameter("password", password)
					.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return users.isEmpty() ? null : users.get(0);
	}

}
