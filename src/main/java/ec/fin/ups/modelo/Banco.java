package ec.fin.ups.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="Banco")
public class Banco {
	
	private int id;
	private String nombre;
	private String direccion;
	
	@OneToMany
	@JoinColumn(name="clienteid")
	private List<Cliente> cliente;
	
	@OneToMany
	@JoinColumn(name="bancoid")
	private List<Movimiento> movimientos;

	public Banco(int id, String nombre, String direccion, List<Cliente> cliente, List<Movimiento> movimientos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cliente = cliente;
		this.movimientos = movimientos;
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

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	
	

}
