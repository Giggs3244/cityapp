package cityapp.dbmodel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cityapp.dbmodel.Country;
import cityapp.dbmodel.Ip;
import cityapp.dbmodel.dataaccess.EntityManagerUtil;

public class CountryDao {

	public Country saveCountryAndIP(String _country, String _ip) {
		EntityManager manager = null;
		Country country = new Country(_country);
		Ip ip = new Ip(_ip);
		try {
			manager = EntityManagerUtil.getEntityManager();
			manager.getTransaction().begin();
			Country registeredCountry = registeredCountry(manager, country);
			if (registeredCountry != null) {
				System.out.println("CountryDao merge country");
				ip.setCountry(registeredCountry);
				manager.persist(registeredCountry);
			} else {
				System.out.println("CountryDao save country");
				country.addIp(ip);
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

	private Country registeredCountry(EntityManager manager, Country country) {
		TypedQuery<Country> query = manager.createQuery("FROM Country c WHERE c.country = :country", Country.class);
		query.setParameter("country", country.getCountry());
		query.setMaxResults(1);
		List<Country> countries = query.getResultList();
		return countries.isEmpty() ? null : countries.get(0);
	}

}
