package cityapp.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.cityapp.exceptions.DatabaseException;
import org.junit.Test;

import cityapp.dbmodel.Country;
import cityapp.dbmodel.dataaccess.EntityManagerUtil;

public class CountryTest {

	@Test
	public void getCountryByName() throws DatabaseException {
		
		String countryName = "Colombia";
		
		EntityManager manager = EntityManagerUtil.getEntityManager();
		Query query =  manager.createQuery("FROM Country c WHERE c.country = :countryName");
		query.setParameter("countryName", countryName);
		List<Country> countries = query.getResultList();
		assertTrue(!countries.isEmpty());
		System.out.println(countries.get(0));
		
	}
	
}
