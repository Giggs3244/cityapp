package cityapp.wsclient.geoipservice;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class App {
	
	public static void main(String[] args) {
		
		System.setProperty("http.proxyHost", "hermes.pragma.com.co");
		System.setProperty("http.proxyPort", "8080");
		
		try {
			GeoIPService service = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = service.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoap.getGeoIP("201.184.247.242");
			System.out.println(geoIP);			
		} catch (Exception e) {
			System.out.println("Error en la ip");
		}
		
		
	}

}
