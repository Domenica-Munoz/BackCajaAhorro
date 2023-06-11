package ec.fin.ups.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="tprestamo")
public class Tprestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float monto;
	private float tasainteres;
	private int plazo;
	public Tprestamo(int id, float monto, float tasainteres, int plazo) {
		super();
		this.id = id;
		this.monto = monto;
		this.tasainteres = tasainteres;
		this.plazo = plazo;
	}
	public Tprestamo() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public float getTasainteres() {
		return tasainteres;
	}
	public void setTasainteres(float tasainteres) {
		this.tasainteres = tasainteres;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	
}
