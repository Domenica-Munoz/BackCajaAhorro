package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.fin.ups.modelo.SolicitudCredito;

public interface ISolicitudCredito extends JpaRepository<SolicitudCredito,Integer> {
	

}
