package ec.fin.ups.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name ="garantia")
public class Garantia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String direccion;
	private float valorAdmisible;
	
	@ManyToOne()
	@JoinColumn(name="solicitudId")
	private SolicitudCredito solicitudCredito;
	
	public Garantia(int id, String nombre, String direccion, float valorAdmisible, SolicitudCredito solicitudCredito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.valorAdmisible = valorAdmisible;
		this.solicitudCredito = solicitudCredito;
	}
	
	public Garantia() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getValorAdmisible() {
		return valorAdmisible;
	}

	public void setValorAdmisible(float valorAdmisible) {
		this.valorAdmisible = valorAdmisible;
	}

	public SolicitudCredito getSolicitudCredito() {
		return solicitudCredito;
	}

	public void setSolicitudCredito(SolicitudCredito solicitudCredito) {
		this.solicitudCredito = solicitudCredito;
	}
	
	
	
	
}
