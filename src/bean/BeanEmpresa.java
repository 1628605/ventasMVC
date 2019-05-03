package bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
@NamedQuery(name="BeanEmpresa.findAll", query="SELECT b FROM BeanEmpresa b")
public class BeanEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ruc_empresa")
	private String rucEmpresa;

	@Column(name="dir_empresa")
	private String dirEmpresa;

	@Column(name="email_empresa")
	private String emailEmpresa;

	@Column(name="rs_empresa")
	private String rsEmpresa;

	public BeanEmpresa() {
	}

	public String getRucEmpresa() {
		return this.rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public String getDirEmpresa() {
		return this.dirEmpresa;
	}

	public void setDirEmpresa(String dirEmpresa) {
		this.dirEmpresa = dirEmpresa;
	}

	public String getEmailEmpresa() {
		return this.emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public String getRsEmpresa() {
		return this.rsEmpresa;
	}

	public void setRsEmpresa(String rsEmpresa) {
		this.rsEmpresa = rsEmpresa;
	}

}