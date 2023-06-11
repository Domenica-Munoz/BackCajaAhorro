package ec.fin.ups.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="pagos")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private char estado;
	private Date fecha;
	public Pago(int id, char estado, Date fecha) {
		super();
		this.id = id;
		this.estado = estado;
		this.fecha = fecha;
	}
	public Pago() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
