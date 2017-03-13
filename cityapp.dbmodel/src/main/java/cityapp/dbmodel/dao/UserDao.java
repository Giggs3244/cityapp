package cityapp.dbmodel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.cityapp.exceptions.DatabaseException;

import cityapp.dbmodel.User;
import cityapp.dbmodel.dataaccess.EntityManagerUtil;
import cityapp.logger.LoggerUtil;

public class UserDao {

	public User getUserByUserName(String userName, String password) throws DatabaseException {
		LoggerUtil.info(UserDao.class, "Obtener usuario por username: " + userName);
		EntityManager manager = EntityManagerUtil.getEntityManager();
		List<User> users = null;
		try {
			users = manager.createQuery("FROM User u WHERE u.user = :user AND u.password = :password", User.class)
					.setParameter("user", userName).setParameter("password", password).getResultList();
		} catch (Exception ex) {
			LoggerUtil.error(UserDao.class, "No se pudo obtener el usuario con username: " + userName, ex);
			throw new DatabaseException("No se pudo obtener el usuario con username: " + userName, ex);
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return users.isEmpty() ? null : users.get(0);
	}

}
