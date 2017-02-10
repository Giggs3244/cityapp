package cityapp.dbmodel.dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static final EntityManagerFactory entityManagerFactory;

	private EntityManagerUtil() {
	}

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("cityapp");
		} catch (Exception ex) {
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		EntityManager manager = null;
		try {
			manager = entityManagerFactory.createEntityManager();
		} catch (Exception ex) {
			System.err.println("Initial EntityManager creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return manager;
	}

}
