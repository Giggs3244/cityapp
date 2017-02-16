package cityapp.business.businessmodel;

import javax.validation.constraints.Pattern;

public class IpRq {

	@Pattern(regexp = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", message = "IP is not valid.")
	private String ip;

	public IpRq() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
