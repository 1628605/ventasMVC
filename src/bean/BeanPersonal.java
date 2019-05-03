package bean;

import java.io.Serializable;

import util.NumberException;
import util.ValidacionException;

import java.util.List;



public class BeanPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idpersonal;
	
	private String nomPersonal;

	private String apePersonal;

	private String cargoPersonal;

	private String clavePersonal;



	private List<BeanFactura> facturas;

	public BeanPersonal() {
	}

	public BeanPersonal(Integer idpersonal, String nomPersonal, String apePersonal, String cargoPersonal,
			String clavePersonal) {
		super();
		this.idpersonal = idpersonal;
		this.nomPersonal = nomPersonal;
		this.apePersonal = apePersonal;
		this.cargoPersonal = cargoPersonal;
		this.clavePersonal = clavePersonal;
	}


	public BeanPersonal(Integer idpersonal, String nomPersonal, String apePersonal, String cargoPersonal,
			String clavePersonal, List<BeanFactura> facturas) {
		super();
		this.idpersonal = idpersonal;
		this.nomPersonal = nomPersonal;
		this.apePersonal = apePersonal;
		this.cargoPersonal = cargoPersonal;
		this.clavePersonal = clavePersonal;
		this.facturas = facturas;
	}
public void valida() throws  ValidacionException,NumberException{
		
		if(nomPersonal==null || nomPersonal.equals("")) {
			throw new ValidacionException("Campo nombre de Personal obligatorio");
		}
		if(apePersonal==null || apePersonal.equals("")) {
			throw new ValidacionException("Campo Apellido de Personal obligatorio");
		}
		if(cargoPersonal==null || cargoPersonal.equals("")) {
			throw new ValidacionException("Campo Cargo de Personal obligatorio");
		}
		if(clavePersonal==null || clavePersonal.equals("")) {
			throw new ValidacionException("Campo Clave de Personal obligatorio");
		}
		
	}
	public Integer getIdpersonal() {
		return this.idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getApePersonal() {
		return this.apePersonal;
	}

	public void setApePersonal(String apePersonal) {
		this.apePersonal = apePersonal;
	}

	public String getCargoPersonal() {
		return this.cargoPersonal;
	}

	public void setCargoPersonal(String cargoPersonal) {
		this.cargoPersonal = cargoPersonal;
	}

	public String getClavePersonal() {
		return this.clavePersonal;
	}

	public void setClavePersonal(String clavePersonal) {
		this.clavePersonal = clavePersonal;
	}

	public String getNomPersonal() {
		return this.nomPersonal;
	}

	public void setNomPersonal(String nomPersonal) {
		this.nomPersonal = nomPersonal;
	}

	public List<BeanFactura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<BeanFactura> facturas) {
		this.facturas = facturas;
	}

	public BeanFactura addFactura(BeanFactura factura) {
		getFacturas().add(factura);
		factura.setPersonal(this);

		return factura;
	}

	public BeanFactura removeFactura(BeanFactura factura) {
		getFacturas().remove(factura);
		factura.setPersonal(null);

		return factura;
	}

}