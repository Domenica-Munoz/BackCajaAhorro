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
@Table (name ="tablaAmortizacion")
public class TablaAmortizacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name= "creditoId")
	private Creditos credito;
	
	@OneToMany
	@JoinColumn(name="pagosId")
	private List<Pago> pagos;

	public TablaAmortizacion(int id, Creditos credito) {
		super();
		this.id = id;
		this.credito = credito;
	}
	
	public TablaAmortizacion() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Creditos getCredito() {
		return credito;
	}

	public void setCredito(Creditos credito) {
		this.credito = credito;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
}
