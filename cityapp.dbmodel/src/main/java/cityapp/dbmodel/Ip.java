package cityapp.dbmodel;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ip database table.
 * 
 */
@Entity
@Table(name = "ip")
@NamedQuery(name = "Ip.findAll", query = "SELECT i FROM Ip i")
public class Ip implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(nullable = false, columnDefinition = "tinyint(4) default '1'")
	private byte estado;

	@Column(nullable = false, length = 255)
	private String ip;

	// bi-directional many-to-one association to Country
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	public Ip() {
	}

	public Ip(String _ip) {
		this.ip = _ip;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
		country.getIps().add(this);
	}

}