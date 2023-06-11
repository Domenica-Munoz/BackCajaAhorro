package ec.fin.ups.modelo;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name ="cuenta_ahorro")
public class CuentaAhorro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private float monto;
	private Date fechaCreacion;
	
	@OneToOne
	@JoinColumn(name= "clienteId")
	private Cliente cliente;
	
	@OneToMany
	@JoinColumn(name="cuentaahorroid")
	private List<Movimiento> movimientos;

	public CuentaAhorro(int id, float monto, Date fechaCreacion, Cliente cliente, List<Movimiento> movimientos) {
		super();
		this.id = id;
		this.monto = monto;
		this.fechaCreacion = fechaCreacion;
		this.cliente = cliente;
		this.movimientos = movimientos;
	}
	
	public CuentaAhorro() {
		
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
}
