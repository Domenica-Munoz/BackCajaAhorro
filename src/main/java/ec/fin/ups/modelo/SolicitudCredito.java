package ec.fin.ups.modelo;

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
@Table (name ="solicitudcredito")
public class SolicitudCredito {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String monto;
	
	@OneToOne
	@JoinColumn(name= "clienteId")
	private CuentaAhorro cuenta;
	
	@OneToOne
	@JoinColumn(name= "estadoSolicitudId")
	private EstadoSolicitud estadoSolicitud;
	
	@OneToMany
	@JoinColumn(name="solicitudId")
	private List<Garantia> garantias;
	
	@OneToOne
	@JoinColumn(name= "usuarioId")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name= "tprestamoId")
	private Tprestamo tprestamo;

	public SolicitudCredito(int id, String monto, CuentaAhorro cuenta, EstadoSolicitud estadoSolicitud, Usuario usuario,
			Tprestamo tprestamo) {
		super();
		this.id = id;
		this.monto = monto;
		this.cuenta = cuenta;
		this.estadoSolicitud = estadoSolicitud;
		this.usuario = usuario;
		this.tprestamo = tprestamo;
	}
	
	public SolicitudCredito() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public CuentaAhorro getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaAhorro cuenta) {
		this.cuenta = cuenta;
	}

	public EstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public List<Garantia> getGarantias() {
		return garantias;
	}

	
	public void setGarantias(List<Garantia> garantias) {
		this.garantias = garantias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tprestamo getTprestamo() {
		return tprestamo;
	}

	public void setTprestamo(Tprestamo tprestamo) {
		this.tprestamo = tprestamo;
	}
}
