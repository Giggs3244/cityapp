package cityapp.business.businessmodel;

import java.util.ArrayList;
import java.util.List;

public class CountryRp {

	private String country;
	private List<IpRp> ips = new ArrayList<>();

	public CountryRp() {

	}

//	public CountryRp(Country country) {
//		this.country = country.getCountry();
//		this.ips = country.getIps();
//	}

	public CountryRp(String country, String ip) {
		this.country = country;
		this.ips.add(new IpRp(ip));
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<IpRp> getIps() {
		return ips;
	}

	public void setIps(List<IpRp> ips) {
		this.ips = ips;
	}

}
