package cityapp.dbmodel;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@Table(name = "country")
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(nullable = false, length = 255)
	private String country;

	@Column(nullable = false, columnDefinition = "tinyint(4) default '1'")
	private byte estado;

	// bi-directional many-to-one association to Ip
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<Ip> ips = new ArrayList<>();

	public Country() {
	}

	public Country(String _country) {
		this.country = _country;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public List<Ip> getIps() {
		return this.ips;
	}

	public void setIps(List<Ip> ips) {
		this.ips = ips;
	}

	public Ip addIp(Ip ip) {
		this.ips.add(ip);
		ip.setCountry(this);
		return ip;
	}

	public Ip removeIp(Ip ip) {
		getIps().remove(ip);
		ip.setCountry(null);

		return ip;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + ", estado=" + estado + "]";
	}

}