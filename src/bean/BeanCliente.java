package bean;

import java.io.Serializable;
import java.util.List;

import util.NumberException;
import util.ValidacionException;



public class BeanCliente implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer idcliente;

	private String nomCliente;
	
	private Integer dniCliente;
	
	private String dirCliente;

	private String razonSocial;

	private String rucCliente;

	private String emailCliente;

	private List<BeanOrden> ordens;

	public BeanCliente() {
	}

	
	
	
	
	public BeanCliente(Integer idcliente, String nomCliente, Integer dniCliente, String dirCliente, String razonSocial,
			String rucCliente, String emailCliente) {
		super();
		this.idcliente = idcliente;
		this.nomCliente = nomCliente;
		this.dniCliente = dniCliente;
		this.dirCliente = dirCliente;
		this.razonSocial = razonSocial;
		this.rucCliente = rucCliente;
		this.emailCliente = emailCliente;
	}


	public BeanCliente(Integer idcliente, String nomCliente, Integer dniCliente, String dirCliente, String razonSocial,
			String rucCliente, String emailCliente, List<BeanOrden> ordens) {
		super();
		this.idcliente = idcliente;
		this.nomCliente = nomCliente;
		this.dniCliente = dniCliente;
		this.dirCliente = dirCliente;
		this.razonSocial = razonSocial;
		this.rucCliente = rucCliente;
		this.emailCliente = emailCliente;
		this.ordens = ordens;
	}

	public void valida() throws  ValidacionException,NumberException{
		
		if(nomCliente==null || nomCliente.equals("")) {
			throw new ValidacionException("Campo nombre de cliente obligatorio");
		}
		if(dirCliente==null || dirCliente.equals("")) {
			throw new ValidacionException("Campo de direccion de cliente obligatorio");
		}
		if(razonSocial==null || razonSocial.equals("")) {
			throw new ValidacionException("Campo de razon social de cliente obligatorio");
		}
		if(rucCliente==null || rucCliente.equals("")) {
			throw new ValidacionException("Campo de RUC de cliente obligatorio");
		}
		if(emailCliente==null || emailCliente.equals("")) {
			throw new ValidacionException("Campo de email de cliente obligatorio");
		}
		if (dniCliente==null || dniCliente.equals(0)) {
			throw new NumberException("Campo DNI de cliente obligatorio");
		}
		
	}

	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getDirCliente() {
		return this.dirCliente;
	}

	public void setDirCliente(String dirCliente) {
		this.dirCliente = dirCliente;
	}

	public Integer getDniCliente() {
		return this.dniCliente;
	}

	public void setDniCliente(Integer dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNomCliente() {
		return this.nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRucCliente() {
		return this.rucCliente;
	}

	public void setRucCliente(String rucCliente) {
		this.rucCliente = rucCliente;
	}

	public List<BeanOrden> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(List<BeanOrden> ordens) {
		this.ordens = ordens;
	}

	public BeanOrden addOrden(BeanOrden orden) {
		getOrdens().add(orden);
		orden.setCliente(this);

		return orden;
	}

	public BeanOrden removeOrden(BeanOrden orden) {
		getOrdens().remove(orden);
		orden.setCliente(null);

		return orden;
	}

}