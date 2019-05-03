package bean;

import java.io.Serializable;


/**
 * The persistent class for the detalle_orden database table.
 * 
 */

public class BeanDetalleOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer item;

	private double cantidad;

	private double preciov;

	private double subtotal;


	private BeanOrden orden;

	private BeanProducto producto;

	public BeanDetalleOrden() {
	}
	
	

	public BeanDetalleOrden(Integer item, double cantidad, double preciov, double subtotal) {
		super();
		this.item = item;
		this.cantidad = cantidad;
		this.preciov = preciov;
		this.subtotal = subtotal;
	}
	
	



	public BeanDetalleOrden(Integer item, double cantidad, double preciov, double subtotal, BeanProducto producto) {
		super();
		this.item = item;
		this.cantidad = cantidad;
		this.preciov = preciov;
		this.subtotal = subtotal;
		this.producto = producto;
	}



	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPreciov() {
		return this.preciov;
	}

	public void setPreciov(double preciov) {
		this.preciov = preciov;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public BeanOrden getOrden() {
		return this.orden;
	}

	public void setOrden(BeanOrden orden) {
		this.orden = orden;
	}

	public BeanProducto getProducto() {
		return this.producto;
	}

	public void setProducto(BeanProducto producto) {
		this.producto = producto;
	}

}