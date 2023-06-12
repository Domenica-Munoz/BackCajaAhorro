package ec.fin.ups.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name ="estadocuenta")
public class EstadoCuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descripcion;
	
	
	public EstadoCuenta() {
		
	}
	
	public EstadoCuenta(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
