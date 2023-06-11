package ec.fin.ups.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="estadosolicitud")
public class EstadoSolicitud {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descripcion;
	public EstadoSolicitud(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public EstadoSolicitud() {
		
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
