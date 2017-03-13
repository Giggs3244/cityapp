package cityapp.dbmodel.dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cityapp.exceptions.DatabaseException;

public class EntityManagerUtil {

	private static EntityManagerFactory entityManagerFactory;

	private EntityManagerUtil() {
	}

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("cityapp");
		} catch (Exception e) {
			throw new ExceptionInInitializerError("Initial EntityManagerFactory creation failed.");
		}
	}

	public static EntityManager getEntityManager() throws DatabaseException {
		EntityManager manager = null;
		try {
			manager = entityManagerFactory.createEntityManager();
		} catch (Exception ex) {
			throw new DatabaseException("Initial EntityManager creation failed.", ex);
		}
		return manager;
	}

}
