package bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@Table(name="factura")
@NamedQuery(name="BeanFactura.findAll", query="SELECT b FROM BeanFactura b")
public class BeanFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfactura;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_factura")
	private Date fechaFactura;

	private double igv;

	private double total;

	//bi-directional many-to-one association to BeanOrden
	@ManyToOne
	@JoinColumn(name="idorden")
	private BeanOrden orden;

	//bi-directional many-to-one association to BeanPersonal
	@ManyToOne
	@JoinColumn(name="idpersonal")
	private BeanPersonal personal;

	public BeanFactura() {
	}

	public int getIdfactura() {
		return this.idfactura;
	}

	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}

	public Date getFechaFactura() {
		return this.fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public double getIgv() {
		return this.igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public BeanOrden getOrden() {
		return this.orden;
	}

	public void setOrden(BeanOrden orden) {
		this.orden = orden;
	}

	public BeanPersonal getPersonal() {
		return this.personal;
	}

	public void setPersonal(BeanPersonal personal) {
		this.personal = personal;
	}

}