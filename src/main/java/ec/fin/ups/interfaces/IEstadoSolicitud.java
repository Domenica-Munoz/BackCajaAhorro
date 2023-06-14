package ec.fin.ups.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.fin.ups.modelo.EstadoSolicitud;

public interface IEstadoSolicitud  extends JpaRepository<EstadoSolicitud,Integer> {

}
