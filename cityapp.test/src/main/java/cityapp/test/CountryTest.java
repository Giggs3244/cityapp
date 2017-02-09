package cityapp.test;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cityapp.dbmodel.Country;
import cityapp.dbmodel.dataaccess.EntityManagerUtil;

public class CountryTest {

	private EntityManagerFactory emf;
	private EntityManager manager;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("cityapp");
		manager = emf.createEntityManager();
	}

	@Test
	public void getCountryByName() {

		String countryName = "Colombia";

		// EntityTransaction tx TypedQuery<X>getTransaction();

		TypedQuery<Country> query = manager.createQuery("FROM Country c WHERE c.country = :country", Country.class);
		query.setParameter("country", countryName);
		Country country = null;

		try {
			country = query.getSingleResult();
		} catch (NoResultException nre) {
			country = new Country();
		}

		System.out.println(country);

		assertTrue(country != null);

	}
	
	@Test
	public void testEntityManagerUtil() {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		assertTrue(manager != null);
	}

	@After
	public void tearDown() {
		if (emf != null) {
			emf.close();
		}
	}

}
