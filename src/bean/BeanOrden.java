package bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orden database table.
 * 
 */
@Entity
@Table(name="orden")
@NamedQuery(name="BeanOrden.findAll", query="SELECT b FROM BeanOrden b")
public class BeanOrden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idorden;

	@Column(name="detalle_orden")
	private String detalleOrden;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_orden")
	private Date fechaOrden;

	//bi-directional many-to-one association to BeanDetalleOrden
	@OneToMany(mappedBy="orden")
	private List<BeanDetalleOrden> detalleOrdens;

	//bi-directional many-to-one association to BeanFactura
	@OneToMany(mappedBy="orden")
	private List<BeanFactura> facturas;

	//bi-directional many-to-one association to BeanCliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private BeanCliente cliente;

	public BeanOrden() {
	}

	public int getIdorden() {
		return this.idorden;
	}

	public void setIdorden(int idorden) {
		this.idorden = idorden;
	}

	public String getDetalleOrden() {
		return this.detalleOrden;
	}

	public void setDetalleOrden(String detalleOrden) {
		this.detalleOrden = detalleOrden;
	}

	public Date getFechaOrden() {
		return this.fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public List<BeanDetalleOrden> getDetalleOrdens() {
		return this.detalleOrdens;
	}

	public void setDetalleOrdens(List<BeanDetalleOrden> detalleOrdens) {
		this.detalleOrdens = detalleOrdens;
	}

	public BeanDetalleOrden addDetalleOrden(BeanDetalleOrden detalleOrden) {
		getDetalleOrdens().add(detalleOrden);
		detalleOrden.setOrden(this);

		return detalleOrden;
	}

	public BeanDetalleOrden removeDetalleOrden(BeanDetalleOrden detalleOrden) {
		getDetalleOrdens().remove(detalleOrden);
		detalleOrden.setOrden(null);

		return detalleOrden;
	}

	public List<BeanFactura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<BeanFactura> facturas) {
		this.facturas = facturas;
	}

	public BeanFactura addFactura(BeanFactura factura) {
		getFacturas().add(factura);
		factura.setOrden(this);

		return factura;
	}

	public BeanFactura removeFactura(BeanFactura factura) {
		getFacturas().remove(factura);
		factura.setOrden(null);

		return factura;
	}

	public BeanCliente getCliente() {
		return this.cliente;
	}

	public void setCliente(BeanCliente cliente) {
		this.cliente = cliente;
	}

}