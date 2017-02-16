package cityapp.webservices.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import cityapp.webservices.CountryResource;
import cityapp.webservices.MyResource;
import cityapp.webservices.filter.AuthenticationFilter;
import cityapp.webservices.validation.BeanConstraintViolationExceptionMapper;

@ApplicationPath("resources")
public class App extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		resources.add(CountryResource.class);
		resources.add(BeanConstraintViolationExceptionMapper.class);
		resources.add(AuthenticationFilter.class);
		resources.add(MyResource.class);
		return resources;
	}

}
