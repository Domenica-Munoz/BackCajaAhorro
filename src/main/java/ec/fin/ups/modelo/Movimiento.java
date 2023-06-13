package ec.fin.ups.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name ="movimiento")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date fecha;
	private float monto;
	@OneToOne
	@JoinColumn(name= "tmovimientoId")
	private Tmovimiento tmovimiento;
	
	@ManyToOne()
	@JoinColumn(name="cuentaahorroid")
	private CuentaAhorro cuentaAhorro;
	
	@ManyToOne
	@JoinColumn (name="BancoIdMovimiento")
	private Banco banco;
	
	public Movimiento(int id, Date fecha, float monto, Tmovimiento tmovimiento) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
		this.tmovimiento = tmovimiento;
	}
	
	public Movimiento() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Tmovimiento getTmovimiento() {
		return tmovimiento;
	}

	public void setTmovimiento(Tmovimiento tmovimiento) {
		this.tmovimiento = tmovimiento;
	}

	public CuentaAhorro getCuentaAhorro() {
		return cuentaAhorro;
	}

	public void setCuentaAhorro(CuentaAhorro cuentaAhorro) {
		this.cuentaAhorro = cuentaAhorro;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	
}
