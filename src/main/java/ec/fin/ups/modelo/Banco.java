package ec.fin.ups.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="Banco")
public class Banco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String direccion;
	
	@OneToMany
	@JoinColumn(name="BancoId")
	private List<Cliente> clientes;
	
	
	@OneToMany
	@JoinColumn(name="BancoIdMovimiento")
	private List<Movimiento> movimientos; 


	
	public Banco(int id, String nombre, String direccion, List<Cliente> clientes, List<Movimiento> movimientos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.clientes = clientes;
		this.movimientos = movimientos;
	}

	public Banco() {

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



	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}



	public List<Movimiento> getMovimientos() {
		return movimientos;
	}



	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	
	
	

}
