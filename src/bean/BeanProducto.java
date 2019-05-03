package bean;

import util.NumberException;
import util.ValidacionException;

public class BeanProducto{

	private Integer idproducto;
	
	private String nomProducto;

	private String descProducto;

	private Double preciovProducto;

	private Integer stockProducto;

	public BeanProducto() {
	}
	
	public BeanProducto(Integer idproducto, String nomProducto, String descProducto, Double preciovProducto,
			Integer stockProducto) {
		super();
		this.idproducto = idproducto;
		this.nomProducto = nomProducto;
		this.descProducto = descProducto;
		this.preciovProducto = preciovProducto;
		this.stockProducto = stockProducto;
	}

	public BeanProducto(String nomProducto, String descProducto, Double preciovProducto, Integer stockProducto) {
		super();
		this.nomProducto = nomProducto;
		this.descProducto = descProducto;
		this.preciovProducto = preciovProducto;
		this.stockProducto = stockProducto;
	}



	public void valida() throws  ValidacionException,NumberException{
		
		if(nomProducto==null || nomProducto.equals("")) {
			throw new ValidacionException("Campo nombre de producto obligatorio");
		}
		if(descProducto==null || descProducto.equals("")) {
			throw new ValidacionException("Campo de descripcion de producto obligatorio");
		}
		if(preciovProducto==null || preciovProducto.equals(0.0)) {
			throw new NumberException("Campo de precio de venta de producto obligatorio");
		}
		if (stockProducto==null || stockProducto.equals(0)) {
			throw new NumberException("Campo de stock de producto obligatorio");
		}
		
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getDescProducto() {
		return descProducto;
	}

	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}

	public Double getPreciovProducto() {
		return preciovProducto;
	}

	public void setPreciovProducto(Double preciovProducto) {
		this.preciovProducto = preciovProducto;
	}

	public Integer getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(Integer stockProducto) {
		this.stockProducto = stockProducto;
	}

	@Override
	public String toString() {
		return "BeanProducto [idproducto=" + idproducto + ", nomProducto=" + nomProducto + ", descProducto="
				+ descProducto + ", preciovProducto=" + preciovProducto + ", stockProducto=" + stockProducto + "]";
	}



	
	
	

}
