package ec.fin.ups.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name ="creditos")
public class Creditos {
 //wksdaklsdj
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name= "solicitudCredito")
	private SolicitudCredito solicitudCredito;
	@OneToOne
	@JoinColumn(name= "usuarioid")
	private Usuario usuario;
	private char estado;
	private float montoAdeudato;
	public Creditos(int id, SolicitudCredito solicitudCredito, Usuario usuario, char estado, float montoAdeudato) {
		super();
		this.id = id;
		this.solicitudCredito = solicitudCredito;
		this.usuario = usuario;
		this.estado = estado;
		this.montoAdeudato = montoAdeudato;
	}
	public Creditos() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SolicitudCredito getSolicitudCredito() {
		return solicitudCredito;
	}
	public void setSolicitudCredito(SolicitudCredito solicitudCredito) {
		this.solicitudCredito = solicitudCredito;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public float getMontoAdeudato() {
		return montoAdeudato;
	}
	public void setMontoAdeudato(float montoAdeudato) {
		this.montoAdeudato = montoAdeudato;
	}
	
}
