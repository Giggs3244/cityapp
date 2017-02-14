package cityapp.business;

import javax.ws.rs.core.Response;

import cityapp.business.businessmodel.CountryRp;
import cityapp.business.businessmodel.IpRq;
import cityapp.business.businessmodel.RespuestaGeneral;
import cityapp.dbmodel.Country;
import cityapp.dbmodel.dao.CountryDao;
import cityapp.wsclient.geoipservice.GeoIpController;
import net.webservicex.GeoIP;

public class GeoIPVo {

	public Response getGeoIPByIP(IpRq ipRq) {
		GeoIP geoIp = GeoIpController.getGeoIP(ipRq.getIp());
		if (geoIp != null && geoIp.getReturnCode() != 0) {
			CountryDao countryDao = new CountryDao();
			Country country = countryDao.saveCountryAndIP(geoIp.getCountryName(), geoIp.getIP());
			if (getCountryRp(country, ipRq.getIp()) == null) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(new RespuestaGeneral(500, "Error Interno")).build();
			}
			return Response.status(Response.Status.CREATED).entity(getCountryRp(country, ipRq.getIp())).build();
		}
		return Response.status(Response.Status.NOT_FOUND)
				.entity(new RespuestaGeneral(404, "Not found ip " + ipRq.getIp())).build();
	}

	private CountryRp getCountryRp(Country country, String ip) {
		if (country != null) {
			CountryRp countryRp = new CountryRp(country.getCountry(), ip);
			return countryRp;
		}
		return null;
	}

}
