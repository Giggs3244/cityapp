package cityapp.dbmodel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cityapp.dbmodel.Country;
import cityapp.dbmodel.dataaccess.EntityManagerUtil;

public class CountryDao {

	public Country saveCountryAndIP(String _country, String _ip) {
		EntityManager manager = null;
		Country country = new Country(_country, _ip);
		try {
			manager = EntityManagerUtil.getEntityManager();
			manager.getTransaction().begin();
			if (isRegisteredCountry(manager, country)) {
				System.out.println("CountryDao merge country");
				manager.merge(country);
			} else {
				System.out.println("CountryDao save country");
				manager.persist(country);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			return null;
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return country;
	}

	private boolean isRegisteredCountry(EntityManager manager, Country country) {
		Query query = manager.createQuery("FROM Country c WHERE c.country = :country");
		query.setParameter("country", country.getCountry());
		List<Country> countries = query.getResultList();
		return !countries.isEmpty();
	}

}
