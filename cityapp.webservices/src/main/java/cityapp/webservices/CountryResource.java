package cityapp.webservices;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cityapp.business.GeoIPVo;
import cityapp.business.businessmodel.IpRq;

@Path("countries")
public class CountryResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCountry(@Valid IpRq ipRq) {
		System.out.println(ipRq.getIp());
		GeoIPVo geoIPVo = new GeoIPVo();
		return geoIPVo.getGeoIPByIP(ipRq);
	}

}
