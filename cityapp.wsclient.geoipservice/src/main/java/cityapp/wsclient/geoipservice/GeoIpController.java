package cityapp.wsclient.geoipservice;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class GeoIpController {

	public static GeoIP getGeoIP(String ip) {

		System.setProperty("http.proxyHost", "hermes.pragma.com.co");
		System.setProperty("http.proxyPort", "8080");

		GeoIP geoIP = null;

		try {
			GeoIPService service = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = service.getGeoIPServiceSoap();
			geoIP = geoIPServiceSoap.getGeoIP(ip);
			System.out.println(geoIP);
		} catch (Exception e) {
			return null;
		}
		return geoIP;
	}

}
